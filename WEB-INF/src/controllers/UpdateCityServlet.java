package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import models.*;
import java.io.*;

public class UpdateCityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String result = "no";
		if(user!=null){
		int cityId = Integer.parseInt(request.getParameter("city_id"));
		
		if(user.updateCity(cityId)){
			result = "yes";
			response.getWriter().write(result);
		}
		}
		
		
		}
}