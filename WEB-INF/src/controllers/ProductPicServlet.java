package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;
import java.util.*;
public class ProductPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
			//String propic = "";
		
		
		
		
		User user = (User)session.getAttribute("user");
		String commodityName = (String)session.getAttribute("commodityName");
		String picPath = request.getParameter("picPath");
		
		ServletOutputStream os = response.getOutputStream();
		
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+user.getEmail()+"/"+commodityName+"/"+picPath);
		
		int x = 0;
		byte[] arr = new byte[1024];

		while((x=is.read(arr))!=-1){
			os.write(arr);
		}
			
		os.flush();
		os.close();
		
	}
}