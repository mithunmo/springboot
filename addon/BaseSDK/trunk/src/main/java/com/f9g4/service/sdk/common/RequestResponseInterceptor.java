package com.f9g4.service.sdk.common;

import org.apache.commons.lang.StringUtils;

import com.f9g4.businessobjects.common.AbstractCTRequest;
import com.f9g4.businessobjects.common.AbstractCTResponse;
import com.f9g4.businessobjects.common.ContentType;
import com.f9g4.businessobjects.common.Header;
import com.f9g4.common.util.SpringContextAware;


public class RequestResponseInterceptor  {
	
	public static AbstractCTRequest preProcess(AbstractCTRequest request){
		return createRequestHeader(request);
	}
	
	public static AbstractCTResponse postProcess(AbstractCTResponse response){
		if(response.getHeader() == null){
			response.setHeader(new Header());
			response.getHeader().setCorelationId(getCorelationId());
			response.getHeader().setActiveMemberId(getActiveMemberId());
		}
		else{
			setCorelationId(response.getHeader().getCorelationId());
		
			//if activeMemberId is already available in UserContext , then don't use response object.
			if(StringUtils.isBlank(getActiveMemberId()))
				setActiveMemberId(response.getHeader().getActiveMemberId());
		}
		return response;
	}
	
	private static AbstractCTRequest createRequestHeader(AbstractCTRequest request){
		if(request.getHeader() == null) request.setHeader(new Header());
		request.getHeader().setContentType(ContentType.APPLICATION_XML);
		request.getHeader().setCorelationId(getCorelationId());
		request.getHeader().setActiveMemberId(getActiveMemberId());
		return request;
	}
	
	private static void setCorelationId(String corelationId){
		if(!StringUtils.isBlank(corelationId)) ((UserContext)SpringContextAware.getBean("userContext")).setCorelationId(corelationId); 
	}
	
	private static String getCorelationId(){
		return ((UserContext)SpringContextAware.getBean("userContext")).getCorelationId();
	}
	
	private static String getCorelationId(AbstractCTRequest request){
		return request.getHeader().getCorelationId();
	}
	
	private static void setActiveMemberId(String memberId){
		if(!StringUtils.isBlank(memberId)) ((UserContext)SpringContextAware.getBean("userContext")).setMemberIdNSession(memberId);
	}
	
	private static String getActiveMemberId(){
		return ((UserContext)SpringContextAware.getBean("userContext")).getMemberIdNSession();
	}
	
	private static String getActiveMemberId(AbstractCTRequest request){
		return request.getHeader().getActiveMemberId();
	}
}
