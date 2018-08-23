package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import models.User;

public class CommodityFormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session  = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage = "";
		if(user!=null){
			nextPage = "product.jsp";
		}else{
			nextPage = "sessionOut.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}

