package models;

public class Farmer{
	private Integer farmerId;
	private String farmerName;
	private String password;
	private String contact;
	private  String address;
	private City city;
	private String aadharNumber;
	private String profilePic;
	private Status status;
	private Mandi mandi;
	private UserType userType;

	
	public void setFarmerId(Integer farmerId){
		this.farmerId = farmerId;
	}


	public Integer getFarmerId(){
		return farmerId;
	}

	
	public void setFarmerName(String farmerName){
		this.farmerName = farmerName;
	}


	public String getFarmerName(){
		return farmerName;
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