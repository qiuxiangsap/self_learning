package com.sap.nic.mytaxi.servlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sap.nic.mytaxi.model.request.ConfirmOrderRequest;
import com.sap.nic.mytaxi.model.request.CreateOrderRequest;
import com.sap.nic.mytaxi.model.request.QueryOrderStatusRequest;
import com.sap.nic.mytaxi.response.ConfirmOrderRequestResponse;
import com.sap.nic.mytaxi.response.CreateOrderRequestResponse;
import com.sap.nic.mytaxi.response.QueryOrderStatusRequestResponse;
import com.sap.nic.mytaxi.service.OrderService;

	
@Path("/order")
public class OrderServlet {
	//see http://www.iteye.com/problems/79991

		/**
		 * @return
		 */
		@POST
		@Path("/createPost")
		@Produces("application/json")
		@Consumes("application/json")
		public CreateOrderRequestResponse createOrderAction(CreateOrderRequest req) {
			OrderService orderService = new OrderService();
			CreateOrderRequestResponse response = orderService.createCityOrder(req);
//			CreateOrderRequestResponse response = new CreateOrderRequestResponse();

			return response;
		}
		
		@POST
		@Path("/confirmOrder")
		@Produces("application/json")
		@Consumes("application/json")
		public ConfirmOrderRequestResponse confirmOrderAction(ConfirmOrderRequest req) {
			System.out.println("i am herer");
			OrderService orderService = new OrderService();
			return orderService.confirmCityOrder(req);
		}
		
		
		@POST
		@Path("/queryOrder")
		@Produces("application/json")
		@Consumes("application/json")
		public QueryOrderStatusRequestResponse queryOrderStatus(QueryOrderStatusRequest req) {
			System.out.println("i am herer");
			OrderService orderService = new OrderService();
			return orderService.queryOrderStatus(req);
		}
}


