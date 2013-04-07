package com.sap.nic.mytaxi.servlet;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sap.nic.mytaxi.common.ErrorCode;
import com.sap.nic.mytaxi.common.RequestSender;
import com.sap.nic.mytaxi.model.ConfirmOrderRequest;
import com.sap.nic.mytaxi.response.ConfirmOrderRequestResponse;

/**
 * Servlet implementation class DriverActionServlet
 */
@WebServlet("/order")
public class DriverActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverActionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	//TODO: add driver confirm servlet
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city_order_id = request.getParameter("city_order_id");
		ConfirmOrderRequest co = new ConfirmOrderRequest();
		System.out.println(city_order_id);
		System.out.println(new BigInteger(city_order_id));
		co.setCity_order_id(new BigInteger(city_order_id));
		co.setTaxiUrl(request.getRequestURL().toString());
		
		String cor = new RequestSender<ConfirmOrderRequest>().sendRequest(co);
		
//		ConfirmOrderRequestResponse corr = new Gson().fromJson(cor, ConfirmOrderRequestResponse.class);
//		if(corr.getErrorType().getErrorCode() == ErrorCode.OK) {
//			request.setAttribute("errorcode", "OK");
//			request.setAttribute("city_order_id", corr.getCity_order_id());
//		} else {
//			request.setAttribute("errorcode", corr.getErrorType().getErrorCode());
//		}
		request.setAttribute("result", cor);
		request.getRequestDispatcher("confirm_order.jsp").forward(request, response);
	}

}
