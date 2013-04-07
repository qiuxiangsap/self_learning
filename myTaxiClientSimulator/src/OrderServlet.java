

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		
		CreateOrderRequest req = new CreateOrderRequest();
		req.setUser_id(request.getParameter("user_id"));
		req.setCity_id(Integer.parseInt(request.getParameter("city_id")));
		req.setOrigin_lat(Double.parseDouble(request.getParameter("origin_lat")));
		req.setOrigin_lng(Double.parseDouble(request.getParameter("origin_lng")));
		req.setOrigin_addrdesc(request.getParameter("origin_addrdesc"));
		req.setDest_lng(Double.parseDouble(request.getParameter("dest_lng")));
		req.setDest_lat(Double.parseDouble(request.getParameter("dest_lat")));
		req.setDest_desc(request.getParameter("dest_desc"));
		req.setOrder_car_type(request.getParameter("order_car_type"));
		req.setReq_phone_number(request.getParameter("req_phone_number"));
		System.out.println(Integer.parseInt(request.getParameter("city_id")));
		
		if(request.getParameter("check")==null){
			result = new RequestSender().sendRequest(req);
		}
		else{
			
			if(req.validate().getErrorCode() == ErrorCode.OK)
				result = new RequestSender().sendRequest(req);
			else
				result = "Client Check Result: " + new Gson().toJson(req.validate());
			
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

}
