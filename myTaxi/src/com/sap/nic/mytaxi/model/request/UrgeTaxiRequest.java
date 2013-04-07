package com.sap.nic.mytaxi.model.request;

import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.ErrorType;



public class UrgeTaxiRequest implements Validator{


	//TODO:add validate check
	public ErrorType validate() {
		ErrorType et = new ErrorType();
		et.setErrorCode(ErrorCode.OK);
		et.setErrorDesc("");
		
		return et;
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


	String central_order_id;
	public String getCityorderid() {
		return cityorderid;
	}

	public void setCityorderid(String cityorderid) {
		this.cityorderid = cityorderid;
	}



	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	String cityorderid;
	String userid;
	String vehicleid;
	String status_update_time;
	int user_action;
}
