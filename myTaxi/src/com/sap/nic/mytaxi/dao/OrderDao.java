package com.sap.nic.mytaxi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sap.nic.mytaxi.dbConnection.ConnectionPool;
import com.sap.nic.mytaxi.model.Order;
import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.ErrorType;


/**
 *@author I075926
 *@author modified by:I076746
 *@date April 4, 2013
 *
 */
public class OrderDao {
	
	public ErrorType addOrder(Order order){
		ErrorType resultErrorType = new ErrorType();
		
		resultErrorType.setErrorCode(ErrorCode.DB_CONNECTION_ERROR);
		
		String sql="CALL MT_PROC_SQL_BACKBONE_CREATE_ORDER_REQ('" 
						+ order.getCityId() + "','"
						+ order.getCityOrderId() + "','"
						+ order.getCentralOrderId() + "','"
						+ order.getOrder_creation_time() +"','" 
						+ order.getUserId() + "','"
						+ order.getOrigin_lat() + "','"
						+ order.getOrigin_lng() + "','"
						+ order.getOrigin_addrdesc() + "','"
						+ order.getDest_lat() + "','"
						+ order.getDest_lng() + "','"
						+ order.getDest_desc() + "','"
						+ order.getOrder_car_type() + "','"
						+ order.getReqMobileNum()  + "',?,?)"
					  ;

		System.out.println(sql);
		Connection conn=null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
			CallableStatement cst = (CallableStatement) conn.prepareCall(sql);
			cst.execute();
			ResultSet rs = cst.getResultSet();
	
 			while(rs.next()) {
				int res = Integer.valueOf(rs.getString(1));

				if(res == 0){
					resultErrorType.setErrorCode(ErrorCode.OK);
				} else {
					resultErrorType.setErrorCode(ErrorCode.DB_SYSTEM_ERROR);
				}
			}
			
			if(cst.getMoreResults()) {
				rs = cst.getResultSet();
				while(rs.next()) {
					resultErrorType.setErrorDesc(rs.getString(1));
				}
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			ConnectionPool.getInstance().putbackConnection(conn);
		}
		return resultErrorType;
	}
}
