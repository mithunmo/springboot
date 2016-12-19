package com.f9g4.common.errors;

public enum StatusCodesEnum {
	
	STATUS_SUCCESS("0"),
	//Common/Generic errors for all services/operations...
	STATUS_ERR_INVALID_INPUT("00001"),
	STATUS_ERR_UNKNOWN("00002"),
	STATUS_REQUEST_REJECTED("00006"),
	
	//Validate User -- 17001 to 17004  intentionally left for future.. 
	STATUS_ERR_USER_NOT_FOUND("17005"),
	STATUS_ERR_AUTH_FAILED("17006"),
	STATUS_ERR_MEMBERSHIP_EXPIRED("17007"),
	STATUS_ERR_REGISTRATION_DENIED("17008"),
	STATUS_ERR_REGISTRATION_VETTING_PROCESS("17009"),
	STATUS_ERR_NO_ACTIVE_TERMS("17010"),
	
	//
	STATUS_ERR_LOGIN_INVALID_INPUT("1"), 
	
	
	//Boards Services Status Codes
	//"Request object cannot be null"
	STATUS_BRD_INVALID_INPUT("31001"), 
	
	//Paypal Service Errors
	STATUS_PAYPAL_ERR_RESPONSE("71001"),
	
	//The board is locked
	STATUS_BOARD_UNDER_PROCESSED("80001"),
	
	//unauthorized user
	STATUS_UNAUTHORIZED_USER("00003"),
	
	//record existed
	STATUS_RECORD_EXISTED("00004"),
	
	//record existed
	STATUS_RECORD_NOT_EXISTED("00005"),
	
	//Maximum search result reached
	MAXIMUM_RECORDS_REACHED("40000"),
	;
	
	
	
	
	private final String code;
	public String getCode(){
		return this.code;
	}
	StatusCodesEnum(String code){
		this.code = code; 
	}	
}
