package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;

public class HomePageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage="";
		
		nextPage = "index.jsp";
		
		/*if(user!=null){
			nextPage = "profile.jsp";

		}*/

		if(user!=null){
		Integer items = Cart.getItemByUserId(user.getUserId());
				session.setAttribute("items",items);
		}
		
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}