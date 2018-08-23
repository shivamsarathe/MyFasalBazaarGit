package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class Category{
	private Integer categoryId;
	private String category;
	private Integer commodities;
	
	/** ########## Constructer ######### **/
	public Category(Integer categoryId){
		this.categoryId = categoryId;		
	}

public Category(String category){
		this.category = category;		
	}

	public Category(){
		
	}

	


	public Category(Integer categoryId , String category){
		this.categoryId = categoryId;
		this.category = category;
	}


	/** ########## Methods ######### **/
	public static Category getCategoryById(Integer categoryId){
			Category cat = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category_id,category from categories where category_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,categoryId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				System.out.println("Inside result set");
				 cat = new Category(rs.getInt(1) , rs.getString(2));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();			
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}
		return cat;
	}


	public static ArrayList<Category> collectCategories(){
		ArrayList<Category> category = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category_id,category from categories";
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				category.add(new Category(rs.getInt(1) , rs.getString(2)));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();			
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}
		return category;
	}

	public static ArrayList<Category> collectCategories(String search){
		ArrayList<Category> category = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select category_id,category from categories where category like '"+search+"%'"; 
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				category.add(new Category(rs.getInt(1) , rs.getString(2)));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();			
		}catch(ClassNotFoundException e){
			e.printStackTrace();			
		}
		return category;
	}

	/** ########## getter setter ######### **/
	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}


	public Integer getCategoryId(){
		return categoryId;
	}

	
	public void setCategory(String category){
		this.category = category;
	}


	public String getCategory(){
		return category;
	}

	
	public void setCommodities(Integer commodities){
		this.commodities = commodities;
	}


	public Integer getCommodities(){
		return commodities;
	}
}