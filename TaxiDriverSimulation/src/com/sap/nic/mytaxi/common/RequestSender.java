package com.sap.nic.mytaxi.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class RequestSender<Q> {

	public String sendRequest(Q request) {
		URL url;
		String result = "Operation Failed";
		
		try {
			url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
			connection.setDoOutput(true);
			connection.setDoInput(true);
			
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json"); 
			
			connection.connect();
			
			String content = new Gson().toJson(request);
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			
	        out.write(content.getBytes());   
	        out.flush();
	        out.close();
	        
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(   
	                (connection.getInputStream())));   
	  
	        String output;   
	        System.out.println("Output from Server .... \n");   
	        while ((output = br.readLine()) != null) {   
	        	
	        	result = output;
	            System.out.println(result);   
	        }   
	  
	        connection.disconnect();  
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public String getUrl() {
		return urlString;
	}

	public void setUrl(String urlString) {
		this.urlString = urlString;
	}
	
	 String urlString="http://localhost:8080/myTaxiAdaptorSimulator/order/confirmOrder";

}
