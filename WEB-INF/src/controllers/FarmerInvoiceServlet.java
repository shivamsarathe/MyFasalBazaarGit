package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class FarmerInvoiceServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextpage = "cropsInvoices.jsp";
		User user = (User)session.getAttribute("user");
		
		
		ShippingAddress shippingAddress = new ShippingAddress();
		ArrayList<ShippingAddress> sa = ShippingAddress.getFarmerOrders(user.getUserId());
		if(sa==null){
			System.out.println("yes");
		}
		session.setAttribute("shippingAddress",sa);

		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}