package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import javax.servlet.ServletException;
import models.*;
 
 
 class ChangeUserNameServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
				System.out.println("#$%$&");

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null){
		String userName = request.getParameter("userName");
		String email = user.getEmail();
		user.changeUserName(userName,email);
		}
		response.getWriter().write("yes");
	}
}