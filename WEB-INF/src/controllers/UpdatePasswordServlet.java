package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import models.User;
import java.io.*;

public class UpdatePasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		String result = "no";

		String password = request.getParameter("pass");

		User user = (User)session.getAttribute("user");
		if(user.updatePassword(password)){
			result = "yes";
		}
		response.getWriter().write(result);
	}

}