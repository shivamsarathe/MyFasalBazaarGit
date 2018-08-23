package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class UserOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextpage = "userOrder.jsp";
		User user = (User)session.getAttribute("user");
		System.out.println(user.getUserId()+"~~~~~");
		
		ShippingAddress shippingAddress = new ShippingAddress();
		ArrayList<ShippingAddress> sa = ShippingAddress.getUserOrders(user.getUserId());
		if(sa==null){
			System.out.println("yes");
		}
		session.setAttribute("shippingAdd",sa);

		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}