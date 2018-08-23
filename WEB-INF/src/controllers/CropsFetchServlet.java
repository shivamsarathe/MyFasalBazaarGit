package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class CropsFetchServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String nextPage ="farmerProfile.jsp";		
		if(user==null){
			String contact = request.getParameter("contact");
			String password = request.getParameter("password");
			user = new User(contact,password);			
			if(user.userLogin()){
				session.setAttribute("user",user);
			}else{
				nextPage = "index.jsp";
			}
		}
			HashMap map= new HashMap(); 		
			Commodity comm = new Commodity(new User(user.getUserId()));
			ArrayList<Commodity> arr = comm.getCommoditiesByUserId();
			System.out.println(arr.size()+" are number of commodities of the user = "+user.getUserId());
			Iterator<Commodity> itr = arr.iterator();
			while(itr.hasNext()){
				Commodity comm1 = itr.next();
				CommodityPics commPic = new CommodityPics(comm1);
				String picPath = commPic.getCommodityPicByCommodity();
				map.put(comm1,picPath);
			}
			if(session.getAttribute("map")!=null){
				session.removeAttribute("map");			
				session.setAttribute("map",map);
			}
			else{
			session.setAttribute("map",map);
			}
			Set keys = map.keySet();
		request.getRequestDispatcher(nextPage).forward(request,response);	
	}
}