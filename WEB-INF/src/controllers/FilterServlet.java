package controllers;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import org.json.*;
import models.*;
public class FilterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Commodity commodities = new Commodity();
		String crop = request.getParameter("crop");
		String verity = request.getParameter("verity");
		String quality = request.getParameter("quality");
		Integer mrp = Integer.parseInt(request.getParameter("mrp"));
		//System.out.println(crop+"&&&&"+verity+"******"+mrp+"!!!!!!!"+quality+"@@@@");
		ArrayList<Commodity> filters = commodities.buyCommodity(crop,verity,quality,mrp);
		session.setAttribute("filters",filters);
		request.getRequestDispatcher("filterfill.jsp").forward(request,response);

	}
	
}