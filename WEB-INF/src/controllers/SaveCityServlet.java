package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import models.*;
import java.io.*;


public class SaveCityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();

		String city = request.getParameter("city");
		
		City cities = new City(city);

		
		response.getWriter().write("y");
	}
}