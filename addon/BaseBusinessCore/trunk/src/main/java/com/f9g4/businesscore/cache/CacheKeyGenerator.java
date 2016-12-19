package com.f9g4.businesscore.cache;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.f9g4.businessobjects.common.AbstractCTRequest;
import com.f9g4.businessobjects.common.AbstractCTResponse;


public class CacheKeyGenerator{
	
	public String generateKey(Object... data) {
		if(data[0] instanceof AbstractCTRequest) return getKey((AbstractCTRequest)data[0]);
		else if(data.length > 1 
				&& data[1] instanceof AbstractCTResponse) return getKey((AbstractCTResponse)data[1]);
		else return UUID.randomUUID().toString(); 
	}
	
	private String getKey(AbstractCTRequest request){
		if(request.getHeader() != null && !StringUtils.isBlank(request.getHeader().getCorelationId())) return request.getHeader().getCorelationId();
		return UUID.randomUUID().toString();
		
	}
	
	private String getKey(AbstractCTResponse response){
		if(response.getHeader() != null && !StringUtils.isBlank(response.getHeader().getCorelationId())) return response.getHeader().getCorelationId();
		return UUID.randomUUID().toString();
		
	}
	
	
}