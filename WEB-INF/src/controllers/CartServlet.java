package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class CartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextpage ="";
		if(user!=null){
			
				ArrayList<Cart> cart = Cart.collectCartInfoByUserId(new User(user.getUserId()));

				session.setAttribute("carts",cart);
				Integer items = Cart.getItemByUserId(user.getUserId());
		session.setAttribute("items",items);
		

		nextpage = "cart.jsp";
		}else{
			nextpage = "sessionOut.jsp";
		}
		
		request.getRequestDispatcher(nextpage).forward(request,response);	
		
		
	}
}