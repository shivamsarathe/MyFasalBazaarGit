package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.*;
import java.util.regex.*;

public class UserRegistrationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		///session maintenance/////////////////////////////////////////
		
		HttpSession session = request.getSession();


		//getting paramerter/////////////////////////////////////////////

		String fullName = request.getParameter("txt_fn1")+" "+request.getParameter("txt_ln1");
		String contact = request.getParameter("txt_mn1");
		//String aadharNumber = request.getParameter("txt_an1");
		String email = request.getParameter("txt_ea1");
		String password = request.getParameter("txt_p1");
		String confirmPassword = request.getParameter("txt_cp1");

		//validation/////////////////////////////////////////////////////
		//boolean flag = true;
		String msg = "";
		
		//userName validation/////////////////////////////////////////////
		/*
		String unm = fullName.trim();
		Pattern p = Pattern.compile("a-zA-Z")
		if(!Pattern.matches("",unm)){
			flag = false;
			msg = "<div>UserName should contain</div>";
		}*/
			
			String error_msg = "Registration Failed! Register Again With Appropriate Nic Id";
			//System.out.println(userType);
			if(password.equals(confirmPassword)){
				System.out.println("inside This");
				User user = new User(fullName,contact,email,password);
				if(user.registerConsumer()){
				/*String realPath = getServletContext().getRealPath("Uploads");
				System.out.println(realPath);
				System.out.println(email);
				File file = new File(realPath,email);
				file.mkdir();*/
					String realPath = getServletContext().getRealPath("/WEB-INF/uploads");
					System.out.println("#########"+realPath);
					File file = new File(realPath,email);
					

					boolean var = file.mkdirs();
				}else{
					msg = "not register....";
				}
			}else{
				msg = "password not match..."; 
			}
			
		response.getWriter().write(msg);
			
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}