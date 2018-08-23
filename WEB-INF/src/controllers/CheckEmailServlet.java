package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import models.User;

public class CheckEmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String result = "no";
		String email = request.getParameter("email");
		
		// checkEmail returns true if email is registered before
		if(User.checkEmail(email)){
			result = "yes";
		}
		response.getWriter().write(result);
	}
}