package com.sap.nic.mytaxi.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.sap.nic.mytaxi.model.request.CreateOrderRequest;
import com.sap.nic.mytaxi.model.request.UrgeTaxiRequest;
import com.sap.nic.mytaxi.model.response.CreateOrderResponse;
import com.sap.nic.mytaxi.model.response.Response;
import com.sap.nic.mytaxi.service.OrderService;
import com.sap.nic.mytaxi.service.UrgeTaxiService;



//see http://www.iteye.com/problems/79991
@Path("/order")
public class OrderServlet {
/*
	*//**
	 * see http://www.mastertheboss.com/resteasy/resteasy-tutorial-part-two-web-
	 * parameters
	 * 
	 * @param 
	 * @return
	 *//*
	@GET
	@Path("/createGet")
	@Produces("application/json")
	public CreateOrderResponse createOrderAction(
		@QueryParam("Lat") double lat, 
		@QueryParam("Lng") double lng,
		@QueryParam("UserId") String userId,
		@QueryParam("AddrDesc") String addrDesc,
		@QueryParam("ReqMobileNum") String reqMobileNum,
		@QueryParam("CityId") int cityId
	) {
		OrderService orderService = new OrderService();
		CreateOrderRequest orderRequest = new CreateOrderRequest();
		orderRequest.setLat(lat+"");
		orderRequest.setLng(lng+"");
		orderRequest.setUserId(userId);
		orderRequest.setAddrDesc(addrDesc);
		orderRequest.setReqMobileNum(reqMobileNum);
		orderRequest.setCityId(cityId+"");
		CreateOrderResponse response = orderService.createOrder(orderRequest);
		return response;
	}
*/
	/**
	 * @return
	 */
	@POST
	@Path("/createPost")
	@Produces("application/json")
	@Consumes("application/json")
	public CreateOrderResponse createOrderAction(CreateOrderRequest req) {
//		System.out.println("I am in createorder atcion");
//		String response = "hello world";
		OrderService orderService = new OrderService();
		CreateOrderResponse response = orderService.createOrder(req);
//		System.out.println("I am in createorder atcion");
		return response;
	}
	
	
	//TODO: add server response
	/**
	 * @return
	 */
	@POST
	@Path("/urge_taxi")
	@Produces("application/json")
	@Consumes("application/json")
	public Response UrgeTaxiAction(UrgeTaxiRequest req) {
//		String response = "I have accepte your urge taxi request";
		UrgeTaxiService urgeTaxi = new UrgeTaxiService();
		Response response = urgeTaxi.urgeTaxi(req);
		return response;
	}
}