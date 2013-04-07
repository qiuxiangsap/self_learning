/**
 * @author I075926 Wang, David
 * @date Mar 28, 2013
 */
package com.sap.nic.mytaxi.model.response;

import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.ErrorType;

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
