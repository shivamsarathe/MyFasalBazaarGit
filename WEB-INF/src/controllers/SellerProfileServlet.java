package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class SellerProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage="sellerProfile.jsp";

		Integer userId = Integer.parseInt(request.getParameter("user_id"));

			User seller = User.getUserInfo(userId);
			session.setAttribute("seller",seller);

					request.getRequestDispatcher(nextPage).forward(request,response);	
		
		}
		


}