/**
 * @author I075926
 * @author modified by I076746
 */
package com.sap.nic.mytaxi.model;

import java.math.BigInteger;

import com.sap.nic.mytaxi.model.request.CreateOrderRequest;
import com.sap.nic.mytaxi.model.response.CreateOrderResponse;

public class Order {


	BigInteger centralOrderId;
	BigInteger cityOrderId;
	String userId;
	String order_creation_time;
	double origin_lat;
	double origin_lng;
	String origin_addrdesc;
	double dest_lat;
	double dest_lng;
	String dest_desc;
	String order_car_type;
	String reqMobileNum;
	int cityId;
	
	public void setOrderFromCreateOrderRequest(CreateOrderRequest request, BigInteger central_order_id, String order_creation_time, BigInteger cityOrderId) {
		this.centralOrderId = central_order_id;
		this.cityOrderId = cityOrderId;
		this.userId = request.getUser_id();
		this.order_creation_time = order_creation_time;
		this.origin_lat = request.getOrigin_lat();
		this.origin_lng = request.getOrigin_lng();
		this.origin_addrdesc = request.getOrigin_addrdesc();
		this.dest_lat = request.getDest_lat();
		this.dest_lng = request.getDest_lng();
		this.dest_desc = request.getDest_desc();
		this.order_car_type = request.getOrder_car_type();
		this.reqMobileNum = request.getReq_phone_number();
		this.cityId = request.getCity_id();
	}

	
	public BigInteger getCentralOrderId() {
		return centralOrderId;
	}

	public void setCentralOrderId(BigInteger centralOrderId) {
		this.centralOrderId = centralOrderId;
	}

	public BigInteger getCityOrderId() {
		return cityOrderId;
	}

	public void setCityOrderId(BigInteger cityOrderId) {
		this.cityOrderId = cityOrderId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrder_creation_time() {
		return order_creation_time;
	}
	public void setOrder_creation_time(String order_creation_time) {
		this.order_creation_time = order_creation_time;
	}
	public double getOrigin_lat() {
		return origin_lat;
	}
	public void setOrigin_lat(double origin_lat) {
		this.origin_lat = origin_lat;
	}
	public double getOrigin_lng() {
		return origin_lng;
	}
	public void setOrigin_lng(double origin_lng) {
		this.origin_lng = origin_lng;
	}
	public String getOrigin_addrdesc() {
		return origin_addrdesc;
	}
	public void setOrigin_addrdesc(String origin_addrdesc) {
		this.origin_addrdesc = origin_addrdesc;
	}
	public double getDest_lat() {
		return dest_lat;
	}
	public void setDest_lat(double dest_lat) {
		this.dest_lat = dest_lat;
	}
	public double getDest_lng() {
		return dest_lng;
	}
	public void setDest_lng(double dest_lng) {
		this.dest_lng = dest_lng;
	}
	public String getDest_desc() {
		return dest_desc;
	}
	public void setDest_desc(String dest_desc) {
		this.dest_desc = dest_desc;
	}
	public String getOrder_car_type() {
		return order_car_type;
	}
	public void setOrder_car_type(String order_car_type) {
		this.order_car_type = order_car_type;
	}
	public String getReqMobileNum() {
		return reqMobileNum;
	}
	public void setReqMobileNum(String reqMobileNum) {
		this.reqMobileNum = reqMobileNum;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


}
