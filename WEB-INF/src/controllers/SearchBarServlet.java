package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.json.*;
import models.*;
public class SearchBarServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String cat = request.getParameter("search");
		System.out.println(cat);
		Commodity commodity = new Commodity();
		ArrayList<Commodity> commodities = commodity.collectInfoForUser(cat);
		session.setAttribute("commodities",commodities);
		request.getRequestDispatcher("search.jsp").forward(request,response);
	}
	
}