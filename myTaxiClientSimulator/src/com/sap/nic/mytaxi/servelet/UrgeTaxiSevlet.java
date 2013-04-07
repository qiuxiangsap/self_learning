package com.sap.nic.mytaxi.servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.nic.mytaxi.model.UrgeTaxiRequest;
import com.sap.nic.mytaxi.model.common.ErrorCode;
import com.sap.nic.mytaxi.model.common.RequestSender;

/**
 * Servlet implementation class UrgeTaxiSevlet
 */
@WebServlet("/urgetaxi")
public class UrgeTaxiSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrgeTaxiSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UrgeTaxiRequest utr = new UrgeTaxiRequest();
		utr.setCentral_order_id(request.getParameter("central_order_id"));
		utr.setUserid(request.getParameter("usrid"));
		utr.setStatus_update_time(request.getParameter("status_update_time"));
		utr.setVehicleid(request.getParameter("vehicleid"));
		utr.setCity_order_id(request.getParameter("city_order_id"));
		utr.setUser_action(Integer.valueOf(request.getParameter("useraction")));
		
		
		String result;
		
		//if(utr.validate().equals("100")) {
			result = new RequestSender().sendRequest(utr);
			System.out.println("I am in UrgeTaxiSevelet, I have received server's reponse: " + result);
		//}
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("urgetaxi.jsp").forward(request,response );
	}

}
