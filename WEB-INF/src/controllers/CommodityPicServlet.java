package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;

public class CommodityPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
			
		String path = (String)request.getParameter("name");
		int index = path.lastIndexOf("\\");
		String name = path.substring(index++);
		ServletOutputStream os = response.getOutputStream();

		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+user.getEmail()+"/"+name);

		int x = 0;
		byte[] arr = new byte[1024];

		while((x=is.read(arr))!=-1){
			os.write(arr);
		}
		
		os.flush();
		os.close();
	}
}