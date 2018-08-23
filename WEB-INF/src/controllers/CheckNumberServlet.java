package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import models.User;

public class CheckNumberServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String contact = request.getParameter("contact");
		String result = "no";

		if(User.checkNumber(contact)){
			result = "yes";
		}
		response.getWriter().write(result);
	}
}

