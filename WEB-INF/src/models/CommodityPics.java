package models;

import java.sql.*;

import models.*;
import java.util.*;
import java.util.Date;
import org.jasypt.util.password.StrongPasswordEncryptor;
import java.io.*;


public class CommodityPics{
	private Integer commodityPicId;
	private Commodity commodity;
	private String picPath;
	private Status status;

	public CommodityPics(){
	
	}
	public CommodityPics(Commodity commodity){
		this.commodity = commodity;
	}
	public CommodityPics(String picPath){
		this.picPath = picPath;
	}
	

	//*************************** *********************/
	public static boolean add(Commodity commodity,String picPath,int status){
		boolean flag = false;
		try{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		
		String query = "insert into commodity_pics(commodity_id,pic_path,status_id) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,(int)commodity.getCommodityId());
		pst.setString(2,picPath);
		pst.setInt(3,status);
		int x = pst.executeUpdate();
		if(x==1){
			flag = true;
		}
		con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return flag;
	}

	public String getCommodityPicByCommodity(){
		String path = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			
			String query = "select pic_path from commodity_pics where commodity_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,(int)commodity.getCommodityId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				path = rs.getString(1);
			}	
		con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return path;
	}

	public String getCommodityPicByCommodity(Integer commodityId){
		String path = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			
			String query = "select pic_path from commodity_pics where commodity_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,commodityId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				path = rs.getString(1);
			}	
		con.close();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return path;
	}


	//*************************** *********************/
	public void setCommodityPicId(Integer commodityPicId){
		this.commodityPicId = commodityPicId;
	}


	public Integer getCommodityPicId(){
		return commodityPicId;
	}
	
	public void setCommodity(Commodity commodity){
		this.commodity = commodity;
	}


	public Commodity getCommodity(){
		return commodity;
	}
	
	public void setPicPath(String picPath){
		this.picPath = picPath;
	}


	public String getPicPath(){
		return picPath;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}


	public Status getStatus(){
		return status;
	}
	
}