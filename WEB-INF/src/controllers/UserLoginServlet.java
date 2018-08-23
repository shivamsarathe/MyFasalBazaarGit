package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
public class UserLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextpage = "index.jsp";
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		//System.out.println(contact+"  "+password);
		User user = new User(contact,password);
		Boolean flag = user.userLogin();
		if(session.getAttribute("valid_login")!=null){
			session.removeAttribute("valid_login");
			session.setAttribute("valid_login",flag);
		
		}else{
			session.setAttribute("valid_login",flag);
		}
		if(user.userLogin()){
			
			Commodity commodity = new Commodity();
			session.setAttribute("user",user);
				UserType userType = user.getUserType();

			if(userType.getUserTypeId()==2){

			
			///////////////////////////////////Notification/////////////////////////
			ShippingAddress shippingAddress = new ShippingAddress();
			ArrayList sia =  shippingAddress.getFarmerOrders(user.getUserId());
					if(session.getAttribute("notification")!=null){
						session.removeAttribute("notification");			
						session.setAttribute("notification",sia);
					}else{
						session.setAttribute("notification",sia);
					}				
			////////////////////////////////////////////////////////////////////////


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
			nextpage = "farmerProfile.jsp";
			}
			else{
				nextpage = "index.jsp";
				Integer items = Cart.getItemByUserId(user.getUserId());
				session.setAttribute("items",items);
			ArrayList<Commodity> commodities = commodity.collectInfoForUser();
			session.setAttribute("commodities",commodities);
			
		}
		
		request.getRequestDispatcher(nextpage).forward(request,response);
	}
}
}