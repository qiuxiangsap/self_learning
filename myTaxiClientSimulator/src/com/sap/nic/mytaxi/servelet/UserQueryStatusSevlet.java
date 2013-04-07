package com.sap.nic.mytaxi.servelet;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.nic.mytaxi.model.QueryOrderStatusRequest;
import com.sap.nic.mytaxi.model.common.RequestSender;

/**
 * Servlet implementation class UserQueryStatusSevlet
 */
@WebServlet("/form_query_status")
public class UserQueryStatusSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserQueryStatusSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city_order_id = request.getParameter("query_city_order_id");
		QueryOrderStatusRequest qosRequest = new QueryOrderStatusRequest();
		
		if(city_order_id == null) {
			request.setAttribute("query_result", "please write an valid city_order_id");
			request.getRequestDispatcher("order.jsp").forward(request,response);
		} else {
			qosRequest.setCity_order_id(new BigInteger(city_order_id));
		}
		
		String urlString = "http://localhost:8080/myTaxiAdaptorSimulator/order/queryOrder";
		RequestSender<QueryOrderStatusRequest> rs = new RequestSender<QueryOrderStatusRequest>();
		rs.setUrlString(urlString);
		String qosResponse = rs.sendRequest(qosRequest);
		request.setAttribute("query_result", qosResponse);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

}
