package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class ComplaintServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String nextpage = ""; 
		
		if(user!=null){
		nextpage = "complaints.jsp";
		}else{
			nextpage = "sessionOut.jsp";
		}
		//System.out.println(nextpage);
		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}