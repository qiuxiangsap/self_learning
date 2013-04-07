package com.sap.nic.mytaxi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.sap.nic.mytaxi.dbConnection.ConnectionPool;
import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.ErrorType;
import com.sap.nic.mytaxi.model.request.UrgeTaxiRequest;

public class UrgeTaxiDao {

	
	public ErrorType urgeTaxi(UrgeTaxiRequest utr) {
		ErrorType et = new ErrorType();
		et.setErrorCode(ErrorCode.OK);
			
		String sql="CALL I075926.MT_PROC_SQL_BACKBONE_URGE_TAXI('" +
					utr.getUserid() + "','" + 
					utr.getCentral_order_id() + "','" + 
					utr.getVehicleid() + "','" + 
					utr.getCityorderid() + "','" +
					utr.getStatus_update_time() +"'" +		
				")";
		
		System.out.println(sql);
		Connection cn;
		
		try {
			cn = (Connection)ConnectionPool.getInstance().getConnection();
			CallableStatement cst = (CallableStatement) cn.prepareCall(sql);
			cst.execute();
	
			ResultSet rs = cst.getResultSet();
			int errorCode = Integer.valueOf(rs.getString(1));
			cst.getMoreResults();
			rs = cst.getResultSet();
			String errorDesc = rs.getString(1);
			
			if(errorCode == 1) {
				et.setErrorCode(ErrorCode.NOT_ENOUGH_CREDITS);
				et.setErrorDesc(errorDesc);
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		return et;
	}
	

}
