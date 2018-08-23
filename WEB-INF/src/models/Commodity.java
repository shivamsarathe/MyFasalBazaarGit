package models;

import java.sql.*;

import models.*;
import java.util.*;
import java.util.Date;
import java.io.*;

public class Commodity{
	private Integer commodityId;
	private String commodity;
	private User farmer;
	private User user;
	private Date addedOn;
	private Integer quantity;
	private Integer mrp;
	private Integer gst;
	private Integer discount;
	private Category category;
	private String description;
	private Integer rating;
	private Integer qtLeft;
	private CommodityPics commodityPics;

	/*############# contructor #############*/

	public Commodity(){
		
	}

	public Commodity(User farmer){
		this.farmer = farmer;
	}
	
	public Commodity(Integer commodityId){
		this.commodityId = commodityId;
	}

	public Commodity(Category category,String commodity,Integer quantity,Integer mrp){
		this.category = category;
		this.commodity = commodity;
		this.quantity = quantity;
		this.mrp = mrp;
	}

	public Commodity(Category category,Integer commodity_id,String commodity,Integer quantity,Integer mrp,String description){
		this.category = category;
		this.commodityId = commodity_id;
		this.commodity = commodity;
		this.quantity = quantity;
		this.mrp = mrp;
		this.description = description;
	}

	public Commodity(Category category,String commodity,Integer quantity,Integer mrp,User farmer,String description,Integer rating,Integer qtLeft,Integer commodity_id){
		this.category = category;
		this.commodity = commodity;
		this.quantity = quantity;
		this.mrp = mrp;
		this.farmer = farmer;
		this.description = description;
		this.rating = rating;
		this.qtLeft = qtLeft;
		this.commodityId = commodity_id;
	}

	public Commodity(String commodity,Integer quantity,Integer mrp,User farmer,String description,Integer rating,Integer qtLeft){
		this.commodity = commodity;
		this.quantity = quantity;
		this.mrp = mrp;
		this.farmer = farmer;
		this.description = description;
		this.rating = rating;
		this.qtLeft = qtLeft;
	}
	public Commodity(Category category,String commodity,Integer quantity,Integer mrp,CommodityPics commodityPics,User user,Integer commodityId){
		this.category = category;
		this.commodity = commodity;
		this.quantity = quantity;
		this.mrp = mrp;
		this.commodityPics = commodityPics;
		this.user = user;
		this.commodityId=commodityId;
	}

	public Commodity(Category category,String commodity,Integer quantity,Integer mrp,CommodityPics commodityPics,User user,Integer commodityId,String description,Integer qtLeft){
		this.category = category;
		this.commodity = commodity;
		this.quantity = quantity;
		this.mrp = mrp;
		this.commodityPics = commodityPics;
		this.user = user;
		this.commodityId=commodityId;
		this.description = description;
		this.qtLeft = qtLeft;
	}

		public Commodity(Category category,String commodity,Integer quantity,Integer mrp,CommodityPics commodityPics,User user,Integer commodityId,String description){
			this.category = category;
			this.commodity = commodity;
			this.quantity = quantity;
			this.mrp = mrp;
			this.commodityPics = commodityPics;
			this.user = user;
			this.commodityId=commodityId;
			this.description = description;
		}


	/*############# methods #############*/
	
	public boolean addCommodity(String commodity,Category category,Integer quantity,Integer mrp,Integer gst,Integer discount,String discription,User farmer){
		boolean flag  = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "insert into commodities(commodity,user_id,quantity,mrp,gst,discount,category_id,description,qt_left) value(?,?,?,?,?,?,?,?,?)";


			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,commodity);
			pst.setInt(2,farmer.getUserId());
			pst.setInt(3,quantity);
			pst.setInt(4,mrp);
			pst.setInt(5,gst);
			pst.setInt(6,discount);
			pst.setInt(7,category.getCategoryId());
			pst.setString(8,discription);
			pst.setInt(9,quantity);


			int result = pst.executeUpdate();
			if(result==1){
				ResultSet rs = pst.getGeneratedKeys();

				if(rs.next()){
					commodityId = rs.getInt(1);
				}
				flag = true;
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();			
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}

		return flag;
	}

	
	public ArrayList<Commodity>collectInfo(){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category,commodity,quantity,mrp,user_id,description,rating,qt_left,commodity_id from commodities inner join categories where commodities.category_id=categories.category_id";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category cat = new Category(rs.getString(1));
				User user = new User(rs.getInt(5));
				commodities.add(new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),user,rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}

	public ArrayList<Commodity>collectInfo(Integer commoditiesId){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select commodity,quantity,mrp,user_id,description,rating,qt_left from commodities where commodity_id=?"; 
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,commoditiesId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt(4));
				commodities.add(new Commodity(rs.getString(1),rs.getInt(2),rs.getInt(3),user,rs.getString(5),rs.getInt(6),rs.getInt(7)));
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}
	public static Integer collectMrp(Integer commodityId){
		Integer mrp=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select mrp from commodities where commodity_id=?"; 
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,commodityId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				mrp = rs.getInt(1);
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return mrp;	
	}


public ArrayList<Commodity>getCommoditiesByUserId(){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category_id,commodity_id,commodity,quantity,mrp,description from commodities where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,farmer.getUserId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category cat = new Category(rs.getInt(1));

				commodities.add(new Commodity(cat,rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}


	public Commodity getCommodityByUserId(Integer userId){
		Commodity comm=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select commodity_id from commodities where user_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				comm = new Commodity(rs.getInt(1));
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return comm;	
	}
	public ArrayList<Commodity>collectInfoForUser(){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		CommodityPics compics=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category,commodity,quantity,mrp,pic_path,user_id,commodities.commodity_id from categories inner join commodities inner join commodity_pics where commodities.category_id=categories.category_id&&commodities.commodity_id=commodity_pics.commodity_id";
			PreparedStatement ps = con.prepareStatement(query);


			ResultSet rs = ps.executeQuery();
			while(rs.next()){

				Category cat = new Category(rs.getString(1));
				
				 compics= new CommodityPics(rs.getString(5));
				 User user =  User.getUserNameById(rs.getInt(6));
				 commodityId= rs.getInt(7);
				 commodities.add(new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),compics,user,commodityId));
				

				
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}

	public ArrayList<Commodity>collectInfoForUser(String category){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		CommodityPics compics=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category,commodity,quantity,mrp,pic_path,user_id,commodities.commodity_id from categories inner join commodities inner join commodity_pics where commodities.category_id=categories.category_id && commodities.commodity_id=commodity_pics.commodity_id && category like '"+category+"%'";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){

				Category cat = new Category(rs.getString(1));
				
				 compics= new CommodityPics(rs.getString(5));
				 User user =  User.getUserNameById(rs.getInt(6));
				 commodityId= rs.getInt(7);
				 commodities.add(new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),compics,user,commodityId));
				
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}

		public ArrayList<Commodity>collectInfoForFarmer(){
			ArrayList<Commodity> commodities = new ArrayList<Commodity>();
			CommodityPics compics=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "select category,commodity,quantity,mrp,pic_path,user_id,commodities.commodity_id,description,qt_left from categories inner join commodities inner join commodity_pics where commodities.category_id=categories.category_id && commodities.commodity_id=commodity_pics.commodity_id";
				PreparedStatement ps = con.prepareStatement(query);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()){

					Category cat = new Category(rs.getString(1));
					
					 compics= new CommodityPics(rs.getString(5));
					 User user =  User.getUserNameById(rs.getInt(6));
					 commodityId= rs.getInt(7);
					 commodities.add(new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),compics,user,commodityId,rs.getString(8),rs.getInt(9)));
					
				}
				con.close();
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			}
			return commodities;	
		}



	public static ArrayList<Commodity>buyCommodity(Integer commodityId){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		CommodityPics compics=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category,commodity,quantity,mrp,pic_path,user_id,commodities.commodity_id from categories inner join commodities inner join commodity_pics where commodities.category_id=categories.category_id&&commodities.commodity_id=commodity_pics.commodity_id";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(7)==commodityId){
				Category cat = new Category(rs.getString(1));
				
				 compics= new CommodityPics(rs.getString(5));
				 User user =  User.getUserNameById(rs.getInt(6));
				 commodityId=rs.getInt(7) ;
				 commodities.add(new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),compics,user,commodityId));
				}

				
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}

	public ArrayList<Commodity>buyCommodity(String category,String commodity,String description,Integer mrp){
		ArrayList<Commodity> commodities = new ArrayList<Commodity>();
		CommodityPics compics=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category,commodity,quantity,mrp,pic_path,user_id,commodities.commodity_id,description from categories inner join commodities inner join commodity_pics where commodities.category_id=categories.category_id&&commodities.commodity_id=commodity_pics.commodity_id and category like '"+category+"' and description like '"+description+"' and mrp>= '"+mrp+"' and commodity like '"+commodity+"%'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category cat = new Category(rs.getString(1));
				
				 compics= new CommodityPics(rs.getString(5));
				 User user =  User.getUserNameById(rs.getInt(6));
				 commodityId=rs.getInt(7) ;
				 commodities.add(new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),compics,user,commodityId,rs.getString(8)));	
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}

	public static Commodity getCommodityInfoById(Integer commodityId){
		 Commodity commodities=null; 
		CommodityPics compics=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category,commodity,quantity,mrp,pic_path,user_id,commodities.commodity_id from categories inner join commodities inner join commodity_pics where commodities.category_id=categories.category_id&&commodities.commodity_id=commodity_pics.commodity_id";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(7)==commodityId){
				Category cat = new Category(rs.getString(1));
				
				 compics= new CommodityPics(rs.getString(5));
				 User user =  User.getUserNameById(rs.getInt(6));
				 commodityId=rs.getInt(7) ;
				 commodities = new Commodity(cat,rs.getString(2),rs.getInt(3),rs.getInt(4),compics,user,commodityId);
				}

				
			}
			con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return commodities;	
	}


	/*############# getter setter #############*/
	public void setCommodityId(Integer commodityId){
		this.commodityId = commodityId;
	}


	public Integer getCommodityId(){
		return commodityId;
	}

	
	public void setCommodity(String commodity){
		this.commodity = commodity;
	}


	public String getCommodity(){
		return commodity;
	}

	
	public void setFarmer(User farmer){
		this.farmer = farmer;
	}


	public User getFarmer(){
		return farmer;
	}

	
	public void setAddedOn(Date addedOn){
		this.addedOn = addedOn;
	}


	public Date getAddedOn(){
		return addedOn;
	}

	
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

	
	public void setGst(Integer gst){
		this.gst = gst;
	}


	public Integer getGst(){
		return gst;
	}

	
	public void setDiscount(Integer discount){
		this.discount = discount;
	}


	public Integer getDiscount(){
		return discount;
	}

	
	public void setCategory(Category category){
		this.category = category;
	}


	public Category getCategory(){
		return category;
	}

	
	public void setDescription(String description){
		this.description = description;
	}


	public String getDescription(){
		return description;
	}

	public void setRating(Integer rating){
		this.rating = rating;
	}


	public Integer getRating(){
		return rating;
	}
	
	public void setQtLeft(Integer qtLeft){
		this.qtLeft = qtLeft;
	}


	public Integer getQtLeft(){
		return qtLeft;
	}
	public void setCommodityPics(CommodityPics commodityPics){
		this.commodityPics=commodityPics;
	}

	public CommodityPics getCommodityPics(){
		return commodityPics;
	}

	public void setUser(User user){
		this.user = user;
	}


	public User getUser(){
		return user;
	}


}