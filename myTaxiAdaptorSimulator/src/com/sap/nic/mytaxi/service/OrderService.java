/**
 * @author I076746
 */

package com.sap.nic.mytaxi.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sap.nic.mytaxi.common.util.CityOrderIDGenerator;
import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.model.Taxi;
import com.sap.nic.mytaxi.model.request.ConfirmOrderRequest;
import com.sap.nic.mytaxi.model.request.CreateOrderRequest;
import com.sap.nic.mytaxi.model.request.QueryOrderStatusRequest;
import com.sap.nic.mytaxi.response.ConfirmOrderRequestResponse;
import com.sap.nic.mytaxi.response.CreateOrderRequestResponse;
import com.sap.nic.mytaxi.response.QueryOrderStatusRequestResponse;

public class OrderService {
	
	//TODO: add possible ERROR CODE
	public CreateOrderRequestResponse createCityOrder(CreateOrderRequest request) {
		CreateOrderRequestResponse response = new CreateOrderRequestResponse();
		response.setErrorType(ErrorCode.ADAPTOR_ERROR,"error happens at adaptor server side,when creating city order");
		
		BigInteger city_order_id = CityOrderIDGenerator.getInstance().getAnCityOrderId();
		// assume city server return city_order_id sucessfully
		response.setCity_order_id(city_order_id);
		response.setErrorType(ErrorCode.OK, "");
		response.setCity_order_create_time(getCurrentTime());
		putOrderToStore(city_order_id);

		return response;
	}
	
	/**
	 * a taxi driver send his request of confirming an order,
	 * this function determines whether such an request is successed or not.
	 * 
	 * @return whether the requested order can be distributed to the taxi driver
	 */
	public ConfirmOrderRequestResponse confirmCityOrder(ConfirmOrderRequest request) {
		ConfirmOrderRequestResponse response = new ConfirmOrderRequestResponse();

		BigInteger city_order_id = request.getCity_order_id();
		if(orders.isEmpty()) {
			response.setErrorType(ErrorCode.NO_ORDER_ERROR, "NO ORDER ERROR");
		} else {
			if(orders.containsKey(city_order_id)){
				Taxi taxi = new Taxi();
				taxi.setTaxiUrl(request.getTaxiUrl());
				putDriverAcceptAnOrder(taxi, city_order_id);
				
				response.setErrorType(ErrorCode.OK, "");
				response.setCity_order_id(city_order_id);
			} 
		}

		return response;
	}
	
	/**
	 * query the specified order's status, i.e: 
	 * 1. confirmed by taxi driver
	 * 2. doesn't exist
	 * 3. not confirmed by any taxi driver
	 * @param request
	 * @return
	 */
	public QueryOrderStatusRequestResponse queryOrderStatus(QueryOrderStatusRequest request) {
		QueryOrderStatusRequestResponse response = new QueryOrderStatusRequestResponse();
		response.setResponse("no such city_order_id");
		
		if(containsOrder(request.getCity_order_id()) ) {
			if(orders.get(request.getCity_order_id()) == null) {
				response.setResponse("not confirmed by any taxi driver");
			} else {
				response.setResponse("order has been confirmed by taxi driver" );
			}
		}
		
		return response;
	}
	
	
	
	/*
	 * determing whether an order is existed or not
	 */
	private boolean containsOrder(BigInteger city_order_id) {
		boolean isExisted = false;
		if(!orders.isEmpty()){
			isExisted = orders.containsKey(city_order_id);
		}
		return isExisted;
	}
	
	/*
	 * add a new order 
	 */
	private static synchronized void putOrderToStore(BigInteger city_order_id) {
		orders.put(city_order_id, null);
	}
	
	private static synchronized void putDriverAcceptAnOrder(Taxi taxi, BigInteger city_order_id) {
		orders.put(city_order_id, taxi);

	}
	private static synchronized BigInteger getVacantOrder() {
		if(orders.isEmpty()) {
			return new BigInteger("-1");
		}
	
		
		Iterator itr = orders.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<BigInteger,Taxi> entry = (Map.Entry<BigInteger, Taxi>)itr.next();
			if(entry.getValue() ==  null)
				return entry.getKey();
			
		}

		return new BigInteger("-2");
	}
	
	
	/*
	 * return current timestamp as String
	 */
	private String getCurrentTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		return df.format(now);
	}
	
	private static HashMap<BigInteger, Taxi> orders = new HashMap<BigInteger,Taxi>();
}
