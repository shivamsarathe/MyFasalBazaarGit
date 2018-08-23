package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class AboutUsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextpage = "aboutUs.jsp";
			
		//nextpage = "profile.jsp";
		//System.out.println(nextpage);
		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}