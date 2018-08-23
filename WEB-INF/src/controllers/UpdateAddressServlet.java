package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import models.User;
import java.io.*;

public class UpdateAddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		String result = "no";

		String address = request.getParameter("address");

		User user = (User)session.getAttribute("user");
		if(user.updateAddress(address)){
			System.out.println(address);
			result = "yes";
		}
		response.getWriter().write(result);
	}

}