package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;

public class SearchPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String picPath = request.getParameter("searchPic");
		System.out.println(picPath);
			

		picPath = picPath.substring(36);

		
		System.out.print(picPath+"$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%23");
		ServletOutputStream os = response.getOutputStream();
		System.out.print(picPath+"$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%23");
		InputStream is = getServletContext().getResourceAsStream(picPath);
		//System.out.print(is);
		//System.out.print("$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%34");
		int x = 0;
		byte[] arr = new byte[1024];

		while((x=is.read(arr))!=-1){
			os.write(arr);
		}
		
		os.flush();
		os.close();
	}
}