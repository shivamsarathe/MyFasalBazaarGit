package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import models.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;


public class AddCartServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		
		float sum = 0.0f;
		int items = 0;
		
		User user = (User)session.getAttribute("user");

		Cart cart = new Cart();

		Integer commodityId = Integer.parseInt(request.getParameter("commodity_id"));
		Integer userId = user.getUserId();
		items = Cart.getItemByUserId(userId);
		session.setAttribute("items",items);
		Float cart_amount = Cart.getMaximumCartAmount(userId);


		Integer amount = Commodity.collectMrp(commodityId);

		Integer crop = cart.checkCommodity(userId,commodityId);
		
		if(crop==0){
		Date date = new Date();
		
		Long time  = date.getTime();
		
		Timestamp ts = new Timestamp(time);

		LocalDateTime lt = ts.toLocalDateTime();
		
		Timestamp tp =  Timestamp.valueOf(lt);


		
		 sum = sum+amount+cart_amount;
		 System.out.println(sum);
		  items = ++items;
			
				Integer cart_id = Cart.addToCart(new User(userId),tp,items,sum,new Status(1));
		
				boolean flag = CartItem.addDetail(new Cart(cart_id),new Commodity(commodityId));

		}
	
		response.getWriter().print(items);
	}
}