package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.*;
import java.util.*;
public class CommodityPicUploadServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
			//String propic = "";
		
		
		
		
		User user = (User)session.getAttribute("user");
		//CommodityPics commpic = (CommodityPics)session.getAttribute("compics");
		String picPath = request.getParameter("picPath");
		String path = picPath.substring(35);
		//System.out.println(path);
		ServletOutputStream os = response.getOutputStream();
		//System.out.println("inside CommodityUpload");
		//System.out.println(commpic.getPicPath());
		
		InputStream is = getServletContext().getResourceAsStream(path);
		
		int x = 0;
		byte[] arr = new byte[1024];

		while((x=is.read(arr))!=-1){
			os.write(arr);
		}
			
		os.flush();
		os.close();
		
	}
}