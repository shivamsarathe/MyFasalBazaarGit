package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class PlaceOrderServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Integer totalMrp=0;
		String nextPage="buycrop.jsp";
		User user = (User)session.getAttribute("user");

		Integer commodityId = Integer.parseInt(request.getParameter("commodity_id"));
		Integer mrp = Integer.parseInt(request.getParameter("mrp"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer pincode = Integer.parseInt(request.getParameter("pincode"));
		Integer houseNo = Integer.parseInt(request.getParameter("house_no"));
		Integer cityId= user.getCity().getCityId();
		System.out.println(cityId);
		Integer sellerId = Integer.parseInt(request.getParameter("seller_id"));
		String street = request.getParameter("street");
		Integer userId = user.getUserId();
		totalMrp = mrp*quantity;

		boolean flag = ShippingAddress.placeOrder(commodityId,totalMrp,quantity,pincode,houseNo,cityId,sellerId,street,userId);

		if(flag!=false){
			nextPage = "orderplacedsuccessfull.jsp";
		}
		
			
		request.getRequestDispatcher(nextPage).forward(request,response);	
		
		}
		


}