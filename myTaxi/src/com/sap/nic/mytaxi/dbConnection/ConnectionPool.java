package com.sap.nic.mytaxi.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author I075926 Wang, David
 * @date Mar 27, 2013
 */
public class ConnectionPool {
	
	static int POOL_SIZE = 100;
/*	String hanaUrl = "jdbc:sap://192.168.1.105:30015/";
	String user = "I075926";
	String password = "Hana12345";*/
	String hanaUrl = "jdbc:sap://192.168.1.126:30215";
	String user="SYSTEM";
	String password ="Sap12345";
	
	
	private static ConnectionPool instance = null;
	private static ArrayList<Connection> conns = new ArrayList<Connection>();
	
	/**
	 * Init connection pool
	 */
	private ConnectionPool(){
		try {
			Class.forName("com.sap.db.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < POOL_SIZE; i++){
			try {
				Connection conn= DriverManager.getConnection(hanaUrl,user,password);
				conns.add(conn);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}  
		}
	}
	
	public static ConnectionPool getInstance(){
		if(instance == null)
			instance = new ConnectionPool();
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	public synchronized Connection getConnection(){
		Connection conn = null;
		while(conns.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		conn = conns.get(0);
		conns.remove(0);
		return conn;
	}
	
	/**
	 * 
	 * @param conn
	 */
	public synchronized void putbackConnection(Connection conn){
		if(conn != null) {
			conns.add(conn);
			notifyAll();
		}
	}

}

