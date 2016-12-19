package com.f9g4.businesscore.cache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


import com.f9g4.businessobjects.common.AbstractCTRequest;
import com.f9g4.businessobjects.common.AbstractCTResponse;
import com.f9g4.common.util.SpringContextAware;


@Service
public class CacheBusinessService {
	private CacheType typeT;
	
	private CacheBusinessService(){}
	
	private CacheBusinessService(CacheType T){
		typeT = T;
	}
	
	 /**
     * A factory method to create a CacheManager.
     */
    public static CacheBusinessService getInstance(CacheType T) {
    	return new CacheBusinessService(T);
    }
	
	private Cache getCache(){
		return ((CacheManager)SpringContextAware.getBean("cacheManager")).getCache(typeT.getValue());
	}
	
	public void put(AbstractCTRequest request, AbstractCTResponse response) {
		remove(request);
		getCache().put(new Element(request.getHeader().getCorelationId(),response));
		Statistics stats = getCache().getStatistics();
		System.out.println("Business Object in "+ typeT.getValue() + " :: "+ stats.getObjectCount());
	}
	
	public AbstractCTResponse get(AbstractCTRequest request) {
		return get(request.getHeader().getCorelationId());
	}
	
	public AbstractCTResponse get(String corelationId) {
		Element element = getCache().get(corelationId);
		AbstractCTResponse item = element == null ? null : (AbstractCTResponse)element.getValue();
		return item;
	}
	
	public AbstractCTResponse getAll(String corelationId) {
		return null;
	}
	
	public boolean remove(AbstractCTRequest request) {
		return remove(request.getHeader().getCorelationId());
	}
	
	public boolean remove(AbstractCTResponse response) {
		return remove(response.getHeader().getCorelationId());
	}

	public boolean remove(String key) {
		if(!StringUtils.isBlank(key)) return getCache().remove(key);
		return false;
	}

	
	
}
