/**
 * @author I076746
 */
package com.sap.nic.mytaxi.response;

import java.math.BigInteger;

public class CreateOrderRequestResponse extends Response{
	
	public CreateOrderRequestResponse() {
		super();
	}

	public BigInteger getCity_order_id() {
		return city_order_id;
	}
	public void setCity_order_id(BigInteger city_order_id) {
		this.city_order_id = city_order_id;
	}
	public String getCity_order_create_time() {
		return city_order_create_time;
	}
	public void setCity_order_create_time(String city_order_create_time) {
		this.city_order_create_time = city_order_create_time;
	}
	
	BigInteger city_order_id;
	String city_order_create_time;

}
