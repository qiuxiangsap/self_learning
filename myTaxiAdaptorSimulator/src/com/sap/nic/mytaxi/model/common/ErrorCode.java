package com.sap.nic.mytaxi.model.common;

public enum ErrorCode {
	OK("100"),
	PARAMETER_ERROR("2000"),
	DB_CONNECTION_ERROR("3000"),
	DB_SYSTEM_ERROR("4000"),
	NOT_ENOUGH_CREDITS("5000"),
	ADAPTOR_ERROR("6000"),
	NO_ORDER_ERROR("7000"),
	NO_VACANT_ORDER_ERROR("7001");
	
	String code;
	private ErrorCode(String code){
		this.code = code;
	}

}
