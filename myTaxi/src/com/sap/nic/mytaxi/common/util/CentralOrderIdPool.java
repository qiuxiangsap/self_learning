/**
 * @author: i076746
 */
package com.sap.nic.mytaxi.common.util;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Queue;

import com.sap.nic.mytaxi.dbConnection.ConnectionPool;

public class CentralOrderIdPool {
	
	private CentralOrderIdPool() {
		
	}
	
	public static CentralOrderIdPool getAnInstance() {
		if(null == instance) 
			instance = new CentralOrderIdPool();
		
		return instance;
	}
	
	
	public synchronized BigInteger getAnCentralOrderId() {
		if(centralorderid_pool.isEmpty()) {
			getCentralOrderIds();
		}
		
		return centralorderid_pool.poll();
	}
	

	private void getCentralOrderIds() {
		String sql = "CALL MT_PROC_SQL_BACKBONE_CLAIM_CENTERORDERIDS(" +
					pool_size + ",?)";

		Connection ct = null;
		try {
			ct = ConnectionPool.getInstance().getConnection();
			CallableStatement st = (CallableStatement)ct.prepareCall(sql);
			st.execute();
			
			do{
				ResultSet rs = st.getResultSet();
				while(rs.next()){
					centralorderid_pool.offer(new BigInteger(rs.getString(1)));
				}
 			}while(st.getMoreResults());
	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ct !=null) {
				try {
					ct.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			ConnectionPool.getInstance().putbackConnection(ct);
		}
	}
	private static CentralOrderIdPool instance = null;
	private int pool_size = 1000;
	private Queue<BigInteger> centralorderid_pool = new LinkedList<BigInteger>();
	
}
