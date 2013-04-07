/**
 * @author I075926 Wang, David
 * @date Mar 27, 2013
 */
package com.sap.nic.mytaxi.model.response;

public class CreateOrderResponse extends Response{
	String centralOrderId;
	String cityOrderId;
	public String getCentralOrderId() {
		return centralOrderId;
	}
	public void setCentralOrderId(String centralOrderId) {
		this.centralOrderId = centralOrderId;
	}
	public String getCityOrderId() {
		return cityOrderId;
	}
	public void setCityOrderId(String cityOrderId) {
		this.cityOrderId = cityOrderId;
	}
}
