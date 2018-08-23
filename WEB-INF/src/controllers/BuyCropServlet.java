package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class BuyCropServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextpage = "loginModal.jsp";

		if(session.getAttribute("commodities")!=null){
			session.removeAttribute("commodities");
		}
		User user = (User)session.getAttribute("user");
		if(user!=null){
		Integer commodityId = Integer.parseInt(request.getParameter("commodityId"));
		System.out.println(commodityId+"inside buycropservlet");
		ArrayList<Commodity> commodity = Commodity.buyCommodity(commodityId);
		session.setAttribute("commodities",commodity);
			
		nextpage = "buycrop.jsp";
		}
		//System.out.println(nextpage);
		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}