package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class UserProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextpage = "userProfile.jsp";
		User user = (User)session.getAttribute("user");
		Commodity commodity = new Commodity();
		Integer items = Cart.getItemByUserId(user.getUserId());
		session.setAttribute("items",items);
		ArrayList<Commodity> commodities = commodity.collectInfoForUser();
		session.setAttribute("commodities",commodities);

		

		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}