package com.f9g4.web.utils;

public enum ErrorsCodeEnum {
	
	SERVICE_UNAVAILABLE("service.unavailable","Sorry, our service is unavailable. Please contact us. Thank you.",10000),
	INVALID_INPUT("invalid.input", "Invalid input",10001), 
	USER_AUTH_FAILED("validateUser.auth.failed", "Your Username / Password combination is wrong. Please try again. ",10002),
	USER_AUTH_FAILED_VETTING("validateUser.auth.failed", "Your application is being processed. Please log-in after receiving your membership confirmation email.",10003),
	USER_AUTH_FAILED_VETTING_FAILED("validateUser.auth.failed", "Login failed. Authorization denied. ",10004),
	USER_AUTH_FAILED_INACTIVE("validateUser.auth.failed","You are not authorized to login to the system, please contact help desk if you have any questions. Thank you.",10005),
	RECORD_EXPIRED("record.expired","The authorization code that was used has expired. Please contact us at support@fashionforglobe.com.",10006),
	REFERRAL_AUTH_CODE_USED("referral.authcode.used","Sorry, the authorization code has already been used. Please contact us at support@fashionforglobe.com.",10007),
	REFERRAL_AUTH_CODE_INVALID("referral.authcode.invalid","Sorry, this authorization code is invalid. Please try again. Thank you.",10008),
	
	SAMPLES_USER_NOT_EXISTS("samples.user.notexists","The user is not exists.",10009),
	SAMPLES_SAMPLE_NOT_EXISTS("samples.samples.notexists","We could not retrieve the examples you submitted. Please try again. Thank you.",10010),
	SAMPLES_SUBMIT_ERROR("samples.submit.error","The service is unavilable. Please submit again or contact us. Thank you.",10011),
	SAMPLES_ALREADY_SUBMIT("samples.submit.success","You have submitted examples successfully. Please wait for our administrator to review your examples. Thank you.",10012),
	
	//project related error 11***
	PROJECT_INVALID_DUEDATE("project.duedate.invalid","Invalid due date to perform this action. Please update due date before performing this action.",11000),
	
	BOARD_NOT_EXISTED("rating.board.notExisted","This board does not exist in our system. Please contact us. Thank You",20001),
	BOARD_AVAILABLE("rating.board.isAvailable","The board can not be rated. Thank You.",20002),
	USER_NOT_RELATED("rating.user.notRelated","You are not authorized to rate this board. Thank You.",20003),
	RATING_EXISTED("rating.record.existed","You have already finished rating this transaction. Thank You.",20004),
	
	PORTFOLIO_IMAGES_SUBMIT_FAILED("portfolio.images.submit.failed","Submit error. Please try again. Thank you.",20005),
	
	RATING_SUBMIT_FAILED("rating.submit.failed","Rating Submit Failed",30001),
	RATING_UNRELATED_MESSAGE("rating.message.unrelated","We detected that this request is invalid. Please contact us. Thank You.",30002),
	RATING_DELETE_ALERT_ERROR("rating.delete.alert","Error occurred. Please contact us. Thank You.",30003),
	MAX_SEARCH_RESULT_REACHED("search.result.maxrecords","Maximum results reached. Please redefine your search criteria. Thank You.",40000),
	INVITATION_SUBMIT_FAILED("invitation.submit.failed","Error occurred. Please submit again. Thank you.",50001),
	FEEDBACK_SUBMIT_FAILED("feedback.submit.failed","Error occurred. Please submit again. Thank you.",60001),
	RECAPTCHA_AUTHENTICATION_FAILED("recaptcha.uthentication.failed","The reCAPTCHA field is wrong. Please enter again. Thank you.",70001),
	SETUP_SEQ_PASSWORD_FAILED("setup.seqandpassword.failed","Sumbit failed. Please try again. Thanks",80001),
	SETUP_USING_PREVIOUS_PASSWORD("setup.seqandpassword.previouspassword","The password you have selected is similar to your old password, please provide a new password. Thank You",80002),
	CURRENT_PASSWORD_NOT_MATCH("currentpassword_not_match","Sorry, the current password you have entered does not match our system. Please try again.",80003),
	UNAUTHORIZED_USER("user.unahthorized","Only administrator can access this operation.",80004),
	MEMBERSHIP_FEE_FREE("membership.error.freefee","Please contact us.",80005),
	SINGLE_TRANSACTION_LIMIT("membership.error.single_transaction_limit","The amount exceeds the single transaction amount. Please contact us. Thanks.",88888),
	ADMIN_SEND_EMAIL_FAILED("admin.send.email.failed","Send email failed.",90001),
	ADMIN_RESET_PASSWORD_FAILED("admin.reset.password.failed","Reset password failed, please try again",90002),
	;
	
	private final String code;
	private final String defaultMessage;
	private final int errorId;
	
	ErrorsCodeEnum(String code, String defaultMessage, int errorId){
		this.code = code;
		this.defaultMessage= defaultMessage;
		this.errorId = errorId;
	}
	public String getCode() {
		return code;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
	
	public int getErrorId()
	{
		return errorId;
	}
	
}
