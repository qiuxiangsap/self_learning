package com.sap.nic.mytaxi.model;

import com.sap.nic.mytaxi.model.common.ErrorCode;



public class UrgeTaxiRequest {


	//TODO:add validate check
	public ErrorCode validate() {
		return ErrorCode.OK;
	}
	
	public String getCentral_order_id() {
		return central_order_id;
	}
	public void setCentral_order_id(String central_order_id) {
		this.central_order_id = central_order_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getUser_action() {
		return user_action;
	}
	public void setUser_action(int user_action) {
		this.user_action = user_action;
	}
	public String getStatus_update_time() {
		return status_update_time;
	}
	public void setStatus_update_time(String status_update_time) {
		this.status_update_time = status_update_time;
	}


	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getCity_order_id() {
		return city_order_id;
	}

	public void setCity_order_id(String city_order_id) {
		this.city_order_id = city_order_id;
	}



	String central_order_id;
	String userid;
	String city_order_id;
	String vehicleid;
	String status_update_time;
	int user_action;
}
