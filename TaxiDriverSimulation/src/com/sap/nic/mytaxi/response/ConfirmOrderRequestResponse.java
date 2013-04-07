package com.sap.nic.mytaxi.response;

import java.math.BigInteger;

public class ConfirmOrderRequestResponse extends Response{


	public BigInteger getCity_order_id() {
		return city_order_id;
	}
	public void setCity_order_id(BigInteger city_order_id) {
		this.city_order_id = city_order_id;
	}
	
	BigInteger city_order_id;
}