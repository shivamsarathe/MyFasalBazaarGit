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

public class CropUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String[] arr = new String[7];
		int i=0;
		
		
		User user = (User)session.getAttribute("user");
		String nextPage = "";
		if(user!=null){
			
		
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

					if(fileItem.isFormField()){
						arr[i] = fileItem.getString();
						i++;
					}
					else {
						// add commodity in db //////////
						Commodity comm = new Commodity();
						comm.addCommodity(arr[1],new Category(Integer.parseInt(arr[0])),Integer.parseInt(arr[5]),Integer.parseInt(arr[3]),0,Integer.parseInt(arr[4]),arr[6],user);
						
						// add commodity pic in db ////////////
						String picFolder = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());
						session.setAttribute("picFolder",picFolder);
						Commodity commId = comm.getCommodityByUserId(user.getUserId());
						CommodityPics.add(commId,picFolder+"\\"+fileItem.getName(),1);
						File file = new File(picFolder,fileItem.getName());
						try{
							fileItem.write(file);
							
							
						}catch (Exception e){
							e.printStackTrace();
						}					
					}
				}
				
			}else{
			
			}
			nextPage="crop_fetch.do";	
		}else{
			nextPage = "sessionOut.jsp";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}