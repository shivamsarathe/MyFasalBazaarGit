package models;

import java.sql.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
import java.io.IOException;
import models.*;

public class User{

	//###########variables################
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private String contact;
	private String address;
	private City city;
	private State state;
	private String aadharNumber;
	private String profilePic;
	private Status status;
	private Mandi mandi;
	private UserType userType;

	//#########constructors################
	
	public User(){}
	public User(Integer userId){
		this.userId = userId;
	}
	public User(Integer userId,String userName){
		this.userId=userId;
		this.userName=userName;
	}


	public User(String fullName,String contact,String email,String password,String aadharNumber,Mandi mandi,UserType userType){
		this.userName = fullName;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.aadharNumber = aadharNumber;
		this.mandi = mandi;
		this.userType = userType;
		
	}

	public User(String fullName,String contact,String email,String password/*,String aadharNumber*/){
		this.userName = fullName;
		this.contact = contact;
		this.email = email;
		this.password = password;
		//this.aadharNumber = aadharNumber;
		
		
	}

public User(String userName,String password,String email){
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

public User(Integer userId,String userName,String contact,String address){
		this.userId= userId;
		this.userName = userName;
		this.contact = contact;
		this.address = address;
	}


	public User(String contact,String password){
		this.contact = contact;
		this.password = password;
	}

public User(String email,String password,Integer userId){
		this.email = email;
		this.password = password;
		this.userId = userId;
	}

	//#########other methods###############
	public static boolean checkNumber(String contact){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select user_name from users where contact=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,contact);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
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

	public boolean registerFarmer(){
			
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
		String encyPassword = spe.encryptPassword(password);
		boolean flag = false;
		try{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		
		String query = "insert into users(user_name,contact,email,password,aadhar_number,mandi_id,user_type_id) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,userName);
		pst.setString(2,contact);
		pst.setString(3,email);
		pst.setString(4,encyPassword);
		pst.setString(5,aadharNumber);
		pst.setInt(6,mandi.getMandiId());
		pst.setInt(7,userType.getUserTypeId());

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

	

	public boolean registerConsumer(){
			
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
		String encyPassword = spe.encryptPassword(password);
		boolean flag = false;
		try{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		
		String query = "insert into users(user_name,contact,email,password) values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,userName);
		pst.setString(2,contact);
		pst.setString(3,email);
		pst.setString(4,encyPassword);
		
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


public boolean registerAdmin(Integer userType){
			
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
		String encyPassword = spe.encryptPassword(password);
		boolean flag = false;
		try{
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		
		String query = "insert into users(user_name,email,password,user_type_id) values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,userName);
		pst.setString(2,email);
		pst.setString(3,encyPassword);
		pst.setInt(4,userType);
		

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


	public boolean userLogin(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select password,user_id,user_name,email,address,aadhar_number,profile_pic,user_type_id,city_id from users where contact=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,contact);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				String encPass = rs.getString(1);
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
				if(spe.checkPassword(password,encPass)){
					userId = rs.getInt(2);
					userName = rs.getString(3);
					email = rs.getString(4);
					address = rs.getString(5);
					aadharNumber = rs.getString(6);
					profilePic = rs.getString(7);
					userType = new UserType(rs.getInt(8));
					city = new City(rs.getInt(9));
					System.out.println(userType.getUserTypeId());
					
					flag = true;
				}
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
	
	}

public boolean adminLogin(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select password,user_id,user_name,email,address,aadhar_number,profile_pic,user_type_id from users where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				String encPass = rs.getString(1);
				StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
				if(spe.checkPassword(password,encPass)){
					userId = rs.getInt(2);
					userName = rs.getString(3);
					email = rs.getString(4);
					address = rs.getString(5);
					aadharNumber = rs.getString(6);
					profilePic = rs.getString(7);
					userType = new UserType(rs.getInt(8));
					System.out.println(userType.getUserTypeId());
					
					flag = true;
				}
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
	
	}


	public boolean updateProfilePic(String profilePic){
	boolean flag = false;
	try{ 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		String query = "update users set profile_pic=? where email=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,profilePic);
		ps.setString(2,email);
		int x = ps.executeUpdate();
		if(x==1){
			flag = true;
		}
		con.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return flag;
}


		public boolean updateUserName(String userName){
			boolean flag = false;

			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "update users set user_name=? where contact=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,userName);
				ps.setString(2,contact);

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
				

	public boolean updatePassword(String password){
			boolean flag = false;

			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "update users set password=? where contact=?";
				PreparedStatement ps = con.prepareStatement(query);
				
			StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
			String encyPassword = spe.encryptPassword(password);
			
				
				ps.setString(1,encyPassword);
				ps.setString(2,contact);
			

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

		public boolean updateCity(Integer cityId){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "update users set city_id=? where contact=?";
			PreparedStatement pp = con.prepareStatement(query);
			pp.setInt(1,cityId);
			pp.setString(2,contact);
			int x = pp.executeUpdate();
			if(x==1){
				flag=true;

			}

			con.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	
		public static boolean checkEmail(String email){
			boolean flag = false;
			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "select user_name from users where email=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1,email);

				ResultSet rs = pst.executeQuery();
				while(rs.next()){
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

		public boolean changeUserName(String userName,String email){
			boolean flag = false;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "update users set user_name=? where email=?";
				PreparedStatement prep = con.prepareStatement(query);
				prep.setString(1,userName);
				prep.setString(2,email);
				int x = prep.executeUpdate();
				if(x==1){
					flag = true;
				}


			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return flag;
		}

public boolean updateAddress(String address){
			boolean flag = false;

			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "update users set address=? where email=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,address);
				ps.setString(2,email);

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
		
public static User getUserNameById(Integer userId){
			User user = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "select user_name from users where user_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,userId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
							
				 user = new User(userId,rs.getString(1));
					
				}

			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			return user;
		}

		public static User getUserInfo(Integer userId){
			User user = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
				String query = "select user_name,contact,address from users where user_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,userId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
							
				 user = new User(userId,rs.getString(1),rs.getString(2),rs.getString(3));
					System.out.println(rs.getString(2));
				}

			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			return user;
		}



	//##########getterSetter#################

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	
	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
	
	public void setContact(String contact){
		this.contact = contact;
	}

	public String getContact(){
		return contact;
	}
	
	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}
	
	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}
	
	public void setAadharNumber(String aadharNumber){
		this.aadharNumber = aadharNumber;
	}

	public String getAadharNumber(){
		return aadharNumber;
	}
	
	public void setProfilePic(String profilePic){
		this.profilePic = profilePic;
	}

	public String getProfilePic(){
		return profilePic;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	public void setMandi(Mandi mandi){
		this.mandi = mandi;
	}

	public Mandi getMandi(){
		return mandi;
	}
	
	public void setUserType(UserType userType){
		this.userType = userType;
	}

	public UserType getUserType(){
		return userType;
	}
	
}