package com.f9g4.common.util;

public enum ContestStatusEnum {
	//project status
	STATUS_SUSPENDED(0,"Suspended"), 
	STATUS_PUBLISHED(1,"Published"), 
	STATUS_CANCEL(2,"Cancelled"), 
	STATUS_COMPLETED(3,"Completed"),
	STATUS_RUNNING(4,"Running"), 
	STATUS_PENDING(5,"Pending"),
	STATUS_DEFAULT(6,"Default");
	
	private final int id;
	private final String code;
	
	ContestStatusEnum(int id, String code){
		this.id = id;
		this.code = code;
	}

	public int getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	
}
