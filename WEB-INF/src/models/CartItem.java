package models;
import java.sql.*;
import models.*;

public class CartItem{
	private Integer cartItemId;
	private Cart cart;
	private Commodity commodity;
	private Integer qaunity;

	public CartItem(){}

public CartItem(Integer cartItemId,Commodity commodity){
	this.cartItemId=cartItemId;
	this.commodity = commodity;

}
	

	public static boolean addDetail(Cart cart,Commodity commodity){
			boolean flag = false;

			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "insert into cart_items (cart_id,commodity_id) value(?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,cart.getCartId());
				ps.setInt(2,commodity.getCommodityId());

				int x = ps.executeUpdate();
				if(x==1){
							

					flag = true;
				}

			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			return flag;
		}


public static CartItem getCommodityByCartId(Cart cart){
		CartItem cartItem = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select cart_item_id,commodity_id from cart_items where cart_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,cart.getCartId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				 Integer cartItemId = rs.getInt(1);
				 Commodity commodity = new Commodity(rs.getInt(2));
				 Commodity commodities = Commodity.getCommodityInfoById(commodity.getCommodityId());

				 cartItem = new CartItem(cartItemId,commodities);


				 
				
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return cartItem;	
	}

public boolean deleteCartItem(Integer cartId,Integer commodityId){
			boolean flag=false;
try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "delete from cart_items where cart_id=?&&commodity_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,cartId);
			ps.setInt(2,commodityId);
			int x = ps.executeUpdate();
			if(x==1){
				 flag=true;
				 
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;

}

	

	public void setCartItemId(Integer cartItemId){
		this.cartItemId = cartItemId;
	}


	public Integer getCartItemId(){
		return cartItemId;
	}
	
	
	public void setCart(Cart cart){
		this.cart = cart;
	}


	public Cart getCart(){
		return cart;
	}
	
	public void setCommodity(Commodity commodity){
		this.commodity = commodity;
	}


	public Commodity getCommodity(){
		return commodity;
	}
	
	public void setQaunity(Integer qaunity){
		this.qaunity = qaunity;
	}


	public Integer etQaunity(){
		return qaunity;
	}
	
}