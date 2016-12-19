package com.f9g4.businesscore.cache;

public enum CacheType {

	
	Design("designCache");
	
	private final String cacheType;
	
	CacheType(String cacheType){ this.cacheType = cacheType; }
	
	public String getValue() { return cacheType; }
		
	
}
