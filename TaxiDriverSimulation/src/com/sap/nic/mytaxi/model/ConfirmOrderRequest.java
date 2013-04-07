package com.sap.nic.mytaxi.model;

import java.math.BigInteger;

public class ConfirmOrderRequest {

	public BigInteger getCity_order_id() {
		return city_order_id;
	}

	public void setCity_order_id(BigInteger city_order_id) {
		this.city_order_id = city_order_id;
	}
	
	public String getTaxiUrl() {
		return taxiUrl;
	}

	public void setTaxiUrl(String taxiUrl) {
		this.taxiUrl = taxiUrl;
	}
	

	BigInteger city_order_id;
	String taxiUrl; 

}
