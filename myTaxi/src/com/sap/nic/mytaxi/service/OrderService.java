package com.sap.nic.mytaxi.service;

import java.math.BigInteger;

import com.google.gson.Gson;
import com.sap.nic.mytaxi.common.util.CentralOrderIdPool;
import com.sap.nic.mytaxi.common.util.OrderIdGenerator;
import com.sap.nic.mytaxi.dao.OrderDao;
import com.sap.nic.mytaxi.model.Order;
import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.ErrorType;
import com.sap.nic.mytaxi.model.common.RequestSender;
import com.sap.nic.mytaxi.model.request.CreateOrderRequest;
import com.sap.nic.mytaxi.model.response.CreateOrderResponse;
import com.sap.nic.mytaxi.model.response.CreateOrderResponseFromAdaptor;

/**
 * @author I075926 Wang, David
 * @date Mar 27, 2013
 * 
 * @author modified by I076746
 * @date April 3
 */
public class OrderService {

	OrderDao orderDao = new OrderDao();
	
	public CreateOrderResponse createOrder(CreateOrderRequest orderRequest){
		CreateOrderResponse response = new CreateOrderResponse();
		
		ErrorType errorType = orderRequest.validate();
		response.setErrorType(errorType);
		
		if(errorType.getErrorCode() == ErrorCode.OK){
			
			//transfer request to adaptor server to get city order id
			String resFromAdaptor = new RequestSender<CreateOrderRequest>().sendRequest(orderRequest);
			
			CreateOrderResponseFromAdaptor coresResponse = jsonToCreateOrderResponse(resFromAdaptor);

			 
			if(coresResponse.getErrorType().getErrorCode() == ErrorCode.OK) {
				System.out.println("convertion from json sucessfully");
				//get an central_order_id
				BigInteger v_central_order_id =null;
				v_central_order_id = CentralOrderIdPool.getAnInstance().getAnCentralOrderId();
				
				System.out.println("central_order_id:" + v_central_order_id);
				if(v_central_order_id == null) {
					errorType.setErrorCode(ErrorCode.GET_CENTRAL_ORDER_ID_FAILURE);
					errorType.setErrorDesc("get central order id failure");
				} else {
					Order order = new Order();
					order.setOrderFromCreateOrderRequest(orderRequest,v_central_order_id,coresResponse.getCity_order_create_time(),coresResponse.getCity_order_id());
					ErrorType addorderErrorType = orderDao.addOrder(order);
					response.setErrorType(addorderErrorType);
					if(addorderErrorType.getErrorCode() == ErrorCode.OK) {
						response.setCentralOrderId(v_central_order_id.toString());
						response.setCityOrderId(coresResponse.getCity_order_id().toString());
					}
				}
			} else {
				response.setErrorType(coresResponse.getErrorType());
			}
					
		}
			
		return response;
	}
	

	//TODO: may convertion error from adaptor, so shoud add check functionality
	// consider the case when the structure changes
	public CreateOrderResponseFromAdaptor jsonToCreateOrderResponse(String rpString) {
		Gson json = new Gson();
		return json.fromJson(rpString, CreateOrderResponseFromAdaptor.class);

	}
}
