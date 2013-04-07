/**
 * @author I075926 Wang, David
 * @date Mar 28, 2013
 */
package com.sap.nic.mytaxi.model.common;

public class ErrorType {
	ErrorCode errorCode;
	String errorDesc;
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
}
