package com.sap.nic.mytaxi.model.request;

import com.sap.nic.mytaxi.model.common.ErrorType;

/**
 * @author I075926 Wang, David
 * @date Mar 28, 2013
 */



public interface Validator {
	
	public ErrorType validate();
}
