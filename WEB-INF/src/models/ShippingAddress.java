package models;
import java.util.*;
import java.io.*;
import java.sql.*;
import models.*;
public class ShippingAddress{
	private Integer shippindAddressId;
	private User user;
	private String name;
	private Integer housePlotFlatNumber;
	private String streetLane;
	private String landmark;
	private City city;
	private Integer pinCode;
	private Commodity commodity;
	private User seller;
	private Integer quantity;
	private Integer mrp;

	public ShippingAddress(){}

	public ShippingAddress(User user,Integer housePlotFlatNumber,String streetLane,City city,Integer pinCode,Commodity commodity,Integer quantity,Integer mrp){
				
				this.user = user;
				this.housePlotFlatNumber=housePlotFlatNumber;
				this.streetLane = streetLane;
				this.city = city;
				this.pinCode = pinCode;
				this.commodity = commodity;
				this.quantity = quantity;
				this.mrp = mrp;
			}
			

	public static boolean placeOrder(Integer commodityId,Integer mrp,Integer quantity,Integer pincode,Integer houseNo,Integer cityId,Integer sellerId,String street,Integer userId){

		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			
			String query = "insert into shipping_addresses (user_id,house_plot_flat_no,street_lane,city_id,pincode,seller_id,commodity_id,quantity,mrp) value (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,houseNo);
			pst.setString(3,street);
			pst.setInt(4,cityId);
			pst.setInt(5,pincode);
			pst.setInt(6,sellerId);
			pst.setInt(7,commodityId);
			pst.setInt(8,quantity);
			pst.setInt(9,mrp);
			int x = pst.executeUpdate();
			if(x==1){
				flag=true;
			}
		con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return flag;
	
	} 

public static ArrayList<ShippingAddress> getFarmerOrders(Integer sellerId){

	ArrayList<ShippingAddress> shippingAddress = new ArrayList<ShippingAddress>(); 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			
			String query = "select user_id,house_plot_flat_no,street_lane,city_id,pincode,commodity_id,quantity,mrp from shipping_addresses where seller_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,sellerId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
			
			User user = User.getUserInfo(rs.getInt(1));
			City city = City.getCityById(rs.getInt(4));
			
			Commodity commodity = Commodity.getCommodityInfoById(rs.getInt(6));

			
			System.out.println(user.getUserName()+ "$$$$$1");
			System.out.println(rs.getInt(2)+ "^&^^&2");
			System.out.println(rs.getString(3)+ "&&&3");
			System.out.println(city.getCity()+ "&&&4");
			System.out.println(rs.getInt(5)+ "***5");
			System.out.println(commodity.getCommodity()+ "***6");
			System.out.println(rs.getInt(7)+ "****7");
			System.out.println(rs.getInt(8)+ "****8");
						
			
			shippingAddress.add(new ShippingAddress(user,rs.getInt(2),rs.getString(3),city,rs.getInt(5),commodity,rs.getInt(7),rs.getInt(8)));
			
			}

			
			
		con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return shippingAddress;
	
	} 

	public static ArrayList<ShippingAddress> getUserOrders(Integer userId){

	ArrayList<ShippingAddress> shippingAddress = new ArrayList<ShippingAddress>(); 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			
			String query = "select seller_id,house_plot_flat_no,street_lane,city_id,pincode,commodity_id,quantity,mrp from shipping_addresses where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
			
			User user = User.getUserInfo(rs.getInt(1));
			City city = City.getCityById(rs.getInt(4));
			
			Commodity commodity = Commodity.getCommodityInfoById(rs.getInt(6));

			
			System.out.println(user.getUserName()+ "1");
			System.out.println(rs.getInt(2)+ "2");
			System.out.println(rs.getString(3)+ "3");
			System.out.println(city.getCity()+ "4");
			System.out.println(rs.getInt(5)+ "5");
			System.out.println(commodity.getCommodity()+ "6");
			System.out.println(rs.getInt(7)+ "7");
			System.out.println(rs.getInt(8)+ "8");
						
			
			shippingAddress.add(new ShippingAddress(user,rs.getInt(2),rs.getString(3),city,rs.getInt(5),commodity,rs.getInt(7),rs.getInt(8)));
			
			}

			
			
		con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return shippingAddress;
	
	} 



	public void setShippindAddressId(Integer shippindAddressId){
		this.shippindAddressId = shippindAddressId;
	}


	public Integer getShippindAddressId(){
		return shippindAddressId;
	}
	
	public void setUser(User user){
		this.user = user;
	}


	public User getUser(){
		return user;
	}
	
	public void setName(String name){
		this.name = name;
	}


	public String getName(){
		return name;
	}
	
	public void setHousePlotFlatNumber(Integer housePlotFlatNumber){
		this.housePlotFlatNumber = housePlotFlatNumber;
	}


	public Integer getHousePlotFlatNumber(){
		return housePlotFlatNumber;
	}
	
	public void setStreetLane(String streetLane){
		this.streetLane = streetLane;
	}


	public String getStreetLane(){
		return streetLane;
	}
	
	public void setLandmark(String landmark){
		this.landmark = landmark;
	}


	public String getLandmark(){
		return landmark;
	}
	
	public void setCity(City city){
		this.city = city;
	}


	public City getCity(){
		return city;
	}
	
	public void setPinCode(Integer pinCode){
		this.pinCode = pinCode;
	}


	public Integer getPinCode(){
		return pinCode;
	}
	
	public void setCommodity(Commodity commodity){
		this.commodity = commodity;
	}

	public Commodity getCommodity(){
		return commodity;
	}

	/*public void setUser(User seller){
		this.seller = seller;
	}


	public User getUser(){
		return seller;
	}*/

	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}
	
	public Integer getQuantity(){
		return quantity;
	}

	public void setMrp(Integer mrp){
		this.mrp = mrp;
	}

	public Integer getMrp(){
		return mrp;
	}
}