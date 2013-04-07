package com.sap.nic.mytaxi.service;

import com.sap.nic.mytaxi.dao.UrgeTaxiDao;
import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.ErrorType;
import com.sap.nic.mytaxi.model.request.UrgeTaxiRequest;
import com.sap.nic.mytaxi.model.response.Response;
import com.sap.nic.mytaxi.model.response.UrgeTaxiResponse;

public class UrgeTaxiService {
	
	//TODO
	UrgeTaxiDao utd = new UrgeTaxiDao();
	public Response urgeTaxi(UrgeTaxiRequest utr) {
		UrgeTaxiResponse utr_response = new UrgeTaxiResponse();
		
		ErrorType errorType = utr.validate();
		
		utr_response.setErrorType(errorType);

		UrgeTaxiDao utd = new UrgeTaxiDao();
		
		if(errorType.getErrorCode() == ErrorCode.OK) {
			utr_response.setErrorType(utd.urgeTaxi(utr));
		}
		return utr_response;
	}

}
