package models;

import java.sql.*;
import models.*;
import java.util.*;

public class Cart{
	private Integer cartId;
	private User user;
	private Timestamp cartDate;
	private Integer items;
	private Float cartAmount;
	private Status status;
	private CartItem cartItem;

	public Cart(){}
	
	public Cart(Integer cartId,Timestamp cartDate,Float cartAmount,CartItem cartItem){
		this.cartId=cartId;
		this.cartDate=cartDate;
		this.cartAmount = cartAmount;
		this.cartItem = cartItem;
	}
	
	public Cart(Integer cartId){
		this.cartId = cartId;	
	}

	public void seCartId(Integer cartId){
		this.cartId = cartId;
	}


public static Integer addToCart(User user,Timestamp cartDate,Integer items,Float cartAmount,Status status){
		Integer val  = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "insert into carts(user_id,cart_date,items,cart_amount,status_id) value(?,?,?,?,?)";


			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,user.getUserId());
			pst.setTimestamp(2,cartDate);
			pst.setInt(3,items);
			pst.setFloat(4,cartAmount);
			pst.setInt(5,status.getStatusId());
			

			int result = pst.executeUpdate();
			if(result==1){
				ResultSet rs = pst.getGeneratedKeys();

				if(rs.next()){
					val = rs.getInt(1);
				}
				
				}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();			
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}

		return val;
	}


public static ArrayList<Cart>collectCartInfoByUserId(User user){
	Float cartAmount=null;
		ArrayList<Cart> carts = new ArrayList<Cart>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select cart_id,cart_date from carts where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,user.getUserId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				 Integer cartId = rs.getInt(1);
				 Timestamp cartDate = rs.getTimestamp(2);
				if(cartAmount==null){
				cartAmount = Cart.getMaximumCartAmount(user.getUserId());
				}
				CartItem cartItem = CartItem.getCommodityByCartId(new Cart(cartId));

				carts.add(new Cart(cartId,cartDate,cartAmount,cartItem));
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return carts;	
	}

public static Float getMaximumCartAmount(Integer userId){
			Float temp =null;
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select max(cart_amount) from carts where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				 temp = rs.getFloat(1);
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return temp ;

}

public static Integer getItemByUserId(Integer userId){
			Integer items =null;
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select max(items) from carts where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				 items = rs.getInt(1);
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return items ;

}

public Integer searchCommodity(Integer cartId){
			Integer commodityId =null;
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select commodity_id from cart_items where cart_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,cartId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				 commodityId = rs.getInt(1);
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodityId ;

}



	public void deleteCarts(Integer cartId,Integer userId,Integer finalItems,Float finalAmount){
			
			Cart cart = new Cart();
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "delete from carts where cart_id=?&&user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,cartId);
			ps.setInt(2,userId);
			int x = ps.executeUpdate();
			if(x==1){
			 cart.updateCart(finalItems,finalAmount,userId);
			 
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		
}

public void updateCart(Integer finalItems,Float finalAmount,Integer userId){
			
			Cart cart = new Cart();
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "update carts set cart_amount=?,items=? where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setFloat(1,finalAmount);
			ps.setInt(2,finalItems);
			ps.setInt(3,userId);
			int x = ps.executeUpdate();
			if(x==1){
				 
				System.out.println("Cart Updated"); 
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		

}

public Integer checkCommodity(Integer userId,Integer commodityId){
			Integer check = 0;
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select carts.cart_id,user_id,commodity_id from carts inner join cart_items where carts.cart_id=cart_items.cart_id&&user_id=?&&commodity_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,userId);
			ps.setInt(2,commodityId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				 check = 1;
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return check;

}







	public Integer getCartId(){
		return cartId;
	}
	
	public void setUser(User user){
		this.user = user;
	}


	public User getUser(){
		return user;
	}
	
	public void setCartDate(Timestamp cartDate){
		this.cartDate = cartDate;
	}


	public Timestamp getCartDate(){
		return cartDate;
	}
	
	public void setItems(Integer items){
		this.items = items;
	}


	public Integer getItems(){
		return items;
	}

	
	public void setCartAmount(Float cartAmount){
		this.cartAmount = cartAmount;
	}


	public Float getCartAmount(){
		return cartAmount;
	}
	
	public void setStatus(){
		this.status = status;
	}


	public Status getStatus(){
		return status;
	}
	
	public void setCartItem(CartItem cartItem){
		this.cartItem=cartItem;
	}

	public CartItem getCartItem(){
		return cartItem;
	}
	
}