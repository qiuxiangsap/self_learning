package com.sap.nic.mytaxi.model.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.sap.nic.mytaxi.model.UrgeTaxiRequest;

public class RequestSender<Q> {

	String urlString="http://localhost:8080/myTaxi/order/createPost";
	
	public String getUrlString() {
		return urlString;
	}


	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}



	public  String sendRequest(Q request) {
		URL url;
		String result="Operation Failed!";
		try{
			//url = new URL("http://localhost:8080/myTaxiAdaptorSimulator/order/createPost");
			//url= new URL("http://localhost:8080/myTaxi/order/urge_taxi");
			url= new URL(urlString);
			
			
			HttpURLConnection connection =(HttpURLConnection)url.openConnection();
			
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
	        
	        System.out.println("i have send mesge");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        while((line = reader.readLine()) != null) {
	        	System.out.println(line);
	        	result = line;
	        }
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
