package models;

public class Status{
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 2;
	public static final int BLOCKED = 3;
	public static final int UNPROCESSED = 4;
	public static final int PROCESSED = 5;
	public static final int SHIPPED = 6;
	public static final int PENDING = 7;
	public static final int DELETED = 8;

	private Integer statusId;
	private String status;

	public Status(Integer statusId){
		this.statusId = statusId;	
	}

	public void setStatusId(Integer statusId){
		this.statusId=statusId;
	}

	public Integer getStatusId(){
		return statusId;
	}

	public void setStatus(String status){
		this.status=status;
	}

	public String getStatus(){
		return status;
	}
}