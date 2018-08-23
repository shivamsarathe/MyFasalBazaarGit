package controllers;
import javax.servlet.*;
import javax.servlet.http.*;
import models.User;
import java.io.*;

public class UpdateUserNameServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		String result = "no";

		String userName = request.getParameter("unm");

		User user = (User)session.getAttribute("user");
		if(user.updateUserName(userName)){
			System.out.println(userName);
			result = "yes";
		}
		response.getWriter().write(result);
	}

}