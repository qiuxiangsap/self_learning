package com.sap.nic.mytaxi.response;

import com.sap.nic.mytaxi.common.ErrorCode;
import com.sap.nic.mytaxi.common.ErrorType;

public class Response {


	ErrorType errorType = new ErrorType();
	
	public ErrorType getErrorType(){
		return this.errorType;
	}
	
	public void setErrorType(ErrorType errorType){
		this.errorType = errorType;
	}
	public void setErrorType(ErrorCode errorCode, String errorDesc){
		errorType.setErrorCode(errorCode);
		errorType.setErrorDesc(errorDesc);
	}

}
