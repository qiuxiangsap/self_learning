package com.sap.nic.mytaxi.model.request;

import java.math.BigInteger;

public class QueryOrderStatusRequest {

	public BigInteger getCity_order_id() {
		return city_order_id;
	}

	public void setCity_order_id(BigInteger city_order_id) {
		this.city_order_id = city_order_id;
	}

	BigInteger city_order_id;

}
