package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import models.*;
import java.util.regex.*;

public class FarmerRegistrationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		///session maintenance/////////////////////////////////////////
		
		HttpSession session = request.getSession();


		//getting paramerter/////////////////////////////////////////////

		String fullName = request.getParameter("txt_fn")+" "+request.getParameter("txt_ln");
		String contact = request.getParameter("txt_mn");
		String aadharNumber = request.getParameter("txt_an");
		String email = request.getParameter("txt_ea");
		//String state = request.getParameter("txt_s");
		//String city = request.getParameter("txt_c");
		String password = request.getParameter("txt_p");
		//Integer nicNumber = Integer.parseInt(request.getParameter("txt_num"));
		String confirmPassword = request.getParameter("txt_cp");
		
		UserType userType = new UserType(2);
		//Integer userType =	Integer.parseInt(request.getParameter("optradio"));
		System.out.println("farmer bhai...");
		//validation/////////////////////////////////////////////////////
		//boolean flag = true;
		//String msg = "";
		
		//userName validation/////////////////////////////////////////////

		/*String unm = fullName.trim();
		if(!Pattern.matches("",unm)){
			flag = false;
			msg = "<div>UserName should contain</div>";
		}*/
			
			String error_msg = "Registration Failed! Register Again With Appropriate Nic Id";
			//System.out.println(userType);
			
		if(password.equals(confirmPassword)){
			System.out.println("#########");
			Integer nicNumber = Integer.parseInt(request.getParameter("txt_num"));
			if(Mandi.checkNicId(nicNumber)){
				System.out.println("@@@@@@@@");
					 error_msg = "";
					request.setAttribute("msg",error_msg);
					Mandi mandi = new Mandi(nicNumber);
				User user = new User(fullName,contact,email,password,aadharNumber,mandi,userType);
				

				/////////////////////////validation/////////////////////
					Boolean val = user.registerFarmer();
					System.out.println(val);
					if(session.getAttribute("valid_registration")!=null){
						session.removeAttribute("valid_registration");
						session.setAttribute("valid_registration",val);
					
					}else{
						session.setAttribute("valid_registration",val);
					}
				/////////////////////////////////////////////////////


				if(user.registerFarmer()){
	
					String realPath = getServletContext().getRealPath("/WEB-INF/uploads");
				System.out.println("#########"+realPath);
				File file = new File(realPath,email);
				
				
				boolean var = file.mkdirs();
				

				}else{
					error_msg = "not register...";
				}

			}
			else{
				//request.setAttribute("msg",error_msg);
				error_msg = "wrong mandi id....";
			}

		}else{
			error_msg = "password not match...";
		}
		//response.getWriter().write(flag);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}