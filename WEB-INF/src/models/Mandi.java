package models;
import java.sql.*;

public class Mandi{
	private Integer mandiId;

	public Mandi(Integer mandiId){
		this.mandiId = mandiId;
	} 

	public void setMandiId(Integer mandiId){
		this.mandiId = mandiId;
	}
	
	
	public Integer getMandiId(){
		return this.mandiId;
	}

	public static boolean checkNicId(Integer mandiId){
		System.out.println(mandiId);
		boolean flag = false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fasalbazar?user=root&password=1184");
			String query = "select mandi_id from mandies where mandi_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,mandiId);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Integer x = rs.getInt(1);
						
				Integer y = Integer.compare(x,mandiId);
				if(y==0){
					
				flag = true;
				}

				
			}
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}
}