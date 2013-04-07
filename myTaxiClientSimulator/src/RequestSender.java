import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

/**
 * @author I075926 Wang, David
 * @date Mar 27, 2013
 */

public class RequestSender {
	public String sendRequest(CreateOrderRequest req){
		String out = "Operation Failed!";
		URL url;
		try {
//			url = new URL("http://192.168.1.112:8080/myTaxi/order/createPost");
			url = new URL("http://localhost:8080/myTaxi/order/createPost");
			//url = new URL("http://localhost:8080/myTaxiAdaptorSimulator/order/createPost");
			
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();   
	        conn.setDoOutput(true);   
	        conn.setRequestMethod("POST");  
	        conn.setRequestProperty("Content-Type", "application/json");   
	        
	        String input = new Gson().toJson(req);   
	  
	        OutputStream os = conn.getOutputStream();   
	        os.write(input.getBytes());   
	        os.flush();   
	  
	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {   
	            //throw new RuntimeException("Failed : HTTP error code : "  + conn.getResponseCode());   
	        }   
	  
	        BufferedReader br = new BufferedReader(new InputStreamReader(   
	                (conn.getInputStream())));   
	  
	        String output;   
	        System.out.println("Output from Server .... \n");   
	        while ((output = br.readLine()) != null) {   
	        	
	        	out = output;
	            System.out.println(output);   
	        }   
	  
	        conn.disconnect();   
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return out;
	}
	

}
