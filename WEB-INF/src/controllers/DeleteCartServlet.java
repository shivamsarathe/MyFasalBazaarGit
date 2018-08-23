package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import models.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;


public class DeleteCartServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();
				
		User user = (User)session.getAttribute("user");
		
		
		Integer cartId = Integer.parseInt(request.getParameter("cart_id"));
		Integer userId = user.getUserId();
		Integer items = Cart.getItemByUserId(userId);
		Float cart_amount = Cart.getMaximumCartAmount(userId);

		Cart cart = new Cart();
				Integer commodityId = cart.searchCommodity(cartId);
				Integer mrp = Commodity.collectMrp(commodityId);
				Float finalAmount = cart_amount-mrp;
				Integer finalItem = items-1;
				
				if(finalAmount>=0.0f&&finalItem>=0){
					
				CartItem cartItem = new CartItem();
				boolean find = cartItem.deleteCartItem(cartId,commodityId);

				
					cart.deleteCarts(cartId,userId,finalItem,finalAmount);
					

				

				}else{
					finalAmount=0.0f;
				}

		
		response.getWriter().print(finalAmount);
	}
}