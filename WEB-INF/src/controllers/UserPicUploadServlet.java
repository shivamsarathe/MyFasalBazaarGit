package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import models.User;
import java.util.*;

public class UserPicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage = "";
		if(user!=null){
		
		if(ServletFileUpload.isMultipartContent(request)){
			
			DiskFileItemFactory diff = new DiskFileItemFactory();
			ServletFileUpload siff = new ServletFileUpload(diff);
			List<FileItem> list = null;
			try{
				list = siff.parseRequest(request);
			System.out.println(list);
			}catch(FileUploadException e){
				e.printStackTrace();
			}
			FileItem fi = list.get(0);
			System.out.println(fi+"$$$$$");

			String fileName = fi.getName();
			String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());
			System.out.println(realPath);
			File file = new File(realPath,fileName);
			
			try{
				fi.write(file);
				System.out.println("#####");
				if(user.updateProfilePic(fileName)){
					System.out.println("After File");

					user.setProfilePic(fileName);
				
				}
				nextPage = "profiledetail.jsp";
			}catch(Exception e){
				e.printStackTrace();
			}


		}
	}else{
		nextPage = "sessionOut.jsp";
	}
	

			request.getRequestDispatcher(nextPage).forward(request,response);
		
	}
}