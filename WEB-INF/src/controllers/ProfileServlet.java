package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class ProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextpage="";
		if(user!=null){
		nextpage = "profiledetail.jsp";
		}else{
			nextpage = "sessionOut.jsp";
		}	
		//nextpage = "profile.jsp";
		//System.out.println(nextpage);
		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}