package com.f9g4.businesscore.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;
import net.sf.ehcache.event.CacheEventListener;

import org.apache.commons.lang.StringUtils;

import com.f9g4.businessobjects.common.AbstractCTRequest;
import com.f9g4.businessobjects.common.AbstractCTResponse;
import com.f9g4.common.util.SpringContextAware;

public class CoreCache
{
	private String cacheName;
	
    private CacheEventListener cacheEventListener;
    
    private Cache getCache(){
		return ((CacheManager)SpringContextAware.getBean("cacheManager")).getCache(cacheName);
	}
    
    public void put(String cacheKey, Object response) {
		remove(cacheKey);
		getCache().put(new Element(cacheKey,response));
		Statistics stats = getCache().getStatistics();
		System.out.println("CoreCache.put-->cacheKey,response :: "+ cacheName + " :: " + cacheKey + " :: "+ stats.getObjectCount());
	}
	
	public void put(AbstractCTRequest request, AbstractCTResponse response) {
		remove(request);
		getCache().put(new Element(request.getHeader().getCorelationId(),response));
	}
	
	public AbstractCTResponse get(AbstractCTRequest request) {
		return get(request.getHeader().getCorelationId());
	}
	
	public AbstractCTResponse get(String corelationId) {
		System.out.println("CoreCache.get-->corelationId :: "+ corelationId);
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

    public void setCacheEventListener(CacheEventListener cacheEventListener){
        this.cacheEventListener = cacheEventListener;
    }

    public CacheEventListener getCacheEventListener(){
        return cacheEventListener;
    }

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}


	
}

