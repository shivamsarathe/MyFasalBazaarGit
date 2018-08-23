package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;
import models.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ProductPicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		
		
		User user = (User)session.getAttribute("user");
		String nextPage = "";
		if(user!=null){
			String commodityName = (String)session.getAttribute("commodityName");
			ArrayList<String> commodityPics = (ArrayList)session.getAttribute("commodityPics");
			nextPage = "product_pic_upload.jsp";
			
		
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory	factory = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(factory);

				List<FileItem> fileItems = null;
				try{
					fileItems = sfu.parseRequest(request);
					
				}catch(FileUploadException e){
					e.printStackTrace();
				}
				
				Iterator<FileItem> itr = fileItems.iterator();
				while(itr.hasNext()){
					FileItem fileItem = itr.next();

					if(!fileItem.isFormField()){
						String picFolder = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail()+"/"+commodityName);
						File file = new File(picFolder,fileItem.getName());
									commodityPics.add(fileItem.getName());
						

						try{
							fileItem.write(file);
							
							
						}catch (Exception e){
							e.printStackTrace();
						}					
					}
				}

			}else{
				
			}	
		}else{
			nextPage = "sessionOut.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}