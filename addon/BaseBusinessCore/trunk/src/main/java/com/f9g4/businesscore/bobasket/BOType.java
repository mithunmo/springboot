package com.f9g4.businesscore.bobasket;

public enum BOType {

	
	COMMON("common");
	
	
	private final String boType;
	
	BOType(String boType){ this.boType = boType; }
	
	public String getValue() { return boType; }
		
	
}
