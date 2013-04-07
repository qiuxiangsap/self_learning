package com.sap.nic.mytaxi.common.util;

import java.math.BigInteger;

public class CityOrderIDGenerator {

	//TODO:
	// make city_id still work even this class rewriting
	private CityOrderIDGenerator() {
		
	}
	
	//TODO: to be deleted
	public static void main(String[] args) {
		System.out.println(CityOrderIDGenerator.getInstance().getAnCityOrderId());
		System.out.println(CityOrderIDGenerator.getInstance().getAnCityOrderId());

	}
	
	public static CityOrderIDGenerator getInstance() {
		if(null == instance) {
			instance = new CityOrderIDGenerator();
		}
		return instance;
	}
		
	public  BigInteger getAnCityOrderId() {
		BigInteger result = city_id;
		city_id = city_id.add(BigInteger.valueOf(1));
		return result;
	}
	private static CityOrderIDGenerator instance;
	private static BigInteger city_id= new BigInteger("1000");
}
