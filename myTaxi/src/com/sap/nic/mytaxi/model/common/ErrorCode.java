/**
 * @author I075926 Wang, David
 * @date Mar 28, 2013
 * @author modified by I076746
 * @date April 4 
 */
package com.sap.nic.mytaxi.model.common;

public enum ErrorCode {
	OK("100"),
	PARAMETER_ERROR("2000"),
	DB_CONNECTION_ERROR("3000"),
	DB_SYSTEM_ERROR("4000"),
	NOT_ENOUGH_CREDITS("5000"),
	GET_CENTRAL_ORDER_ID_FAILURE("5001");
	
	
	String code;
	private ErrorCode(String code){
		this.code = code;
	}
}
