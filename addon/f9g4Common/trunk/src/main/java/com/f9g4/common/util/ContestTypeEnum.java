package com.f9g4.common.util;

public enum ContestTypeEnum {
	//project type
	TYPE_DEFAULT(0,"Default"),
	TYPE_COMMISSIONED(1,"Commissioned"), 
	TYPE_INNER_CIRCLE(2,"Inner Circle"),
	TYPE_MEMBERS_ONLY(3,"Members Only"),
	TYPE_PUBLIC_CONTEST(4,"Public Contest");
	
	private final int id;
	private final String code;
	
	ContestTypeEnum(int id, String code){
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
