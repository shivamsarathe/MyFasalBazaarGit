package models;
import java.util.*;
import java.sql.*;


public class City{
	private Integer cityId;
	private String city;
	private String state;
	//private State state;

	public City(Integer cityId,String city,String state){
	this.cityId = cityId;
	this.city = city;
	this.state = state;
}

public City(String city){
	this.city = city;
}

public City(Integer cityId){
	this.cityId = cityId;
}

	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}


	public Integer getCityId(){
		return cityId;
	}

	
	public void setCity(String city){
		this.city = city;
	}


	public String getCity(){
		return city;
	}

	
	/*public void setState(State state){
		this.state = state;
	}


	public State getState(){
		return state;
	} */

public void setState(String state){
	this.state = state;
}
public String getState(){
	return state;
} 


	public static ArrayList<City> collectCities(String cities){
	ArrayList<City> city = new ArrayList<City>();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		String query = "select city_id,city,state from cities inner join states where city like '"+cities+"%'&&states.state_id=cities.state_id";
		PreparedStatement pp = con.prepareStatement(query);
		ResultSet rs = pp.executeQuery();
		while(rs.next()){
			city.add(new City(rs.getInt(1),rs.getString(2),rs.getString(3)));
			
		}
	
		con.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}

	return city;
} 

	public static City getCityById(Integer cityId){
		City city = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
		String query = "select city_id,city from cities where city_id=?";
		PreparedStatement pp = con.prepareStatement(query);
		pp.setInt(1,cityId);
		ResultSet rs = pp.executeQuery();
		if(rs.next()){
			city = new City(rs.getString(2));			
		}
	
		con.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return city;
	}
		
}