package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import models.*;
import java.io.*;
import java.util.*;

public class CommodityUploadServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String nextPage = "";
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if(user!=null){
			nextPage = "product.jsp";
			String commodityName = request.getParameter("commodity_name");
			Integer categoryId = Integer.parseInt(request.getParameter("category_id"));
			Category category = new Category(categoryId);

			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			Integer price = Integer.parseInt(request.getParameter("price"));
			Integer gst = Integer.parseInt(request.getParameter("gst"));
			Integer discount = Integer.parseInt(request.getParameter("discount"));
			String discription = request.getParameter("discription");
			
			String result = "no";
			Commodity commodity = new Commodity();
			
			if(commodity.addCommodity(commodityName,category,quantity,price,gst,discount,discription,user)){
				nextPage = "product_pic_upload.jsp";
				String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getEmail());
					File file = new File(realPath,commodityName);
					file.mkdir();
					session.setAttribute("commodity",commodity);
					ArrayList<String> commodityPics = new ArrayList<String>();
					session.setAttribute("commodityPics",commodityPics);
					session.setAttribute("commodityName",commodityName);
					ArrayList<Commodity> commodities = commodity.collectInfo();
					session.setAttribute("commodities",commodities);
				

				Category cat = Category.getCategoryById(categoryId);
				session.setAttribute("category",cat);
				System.out.println(cat.getCategory());
			}
		}else{
			nextPage = "sessionOut.jsp";
		}
			//response.getWriter().write(result);
			request.getRequestDispatcher(nextPage).forward(request,response);
	}
}

