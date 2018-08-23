package models;

import java.sql.*;
import java.util.ArrayList;

public class State{
	private Integer stateId;
	private String state;

	///////////// contructors ///////////////////
	State(){
	
	}

	State(Integer stateId,String state){
		this.stateId = stateId;
		this.state = state;
	}

	/////////// methods ///////////////
	public static ArrayList<State> collectStates(){
		ArrayList<State> states = new ArrayList<State>(); 
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select state_id,state from states  ";
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				states.add(new State(rs.getInt(1),rs.getString(2)));
			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return states;
	}
	

	///////////////// getter setter //////////////
	public void setStateId(Integer stateId){
		this.stateId = stateId;
	}


	public Integer getStateId(){
		return stateId;
	}

	
	public void setState(String state){
		this.state = state;
	}


	public String getState(){
		return state;
	}
}