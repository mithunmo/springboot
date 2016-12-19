package com.f9g4.businesscore.bobasket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

import org.apache.commons.lang.StringUtils;

import com.f9g4.businessobjects.common.AbstractCTResponse;
import com.f9g4.common.util.SpringContextAware;
import com.google.gson.Gson;



public class BOBasket implements Serializable
{
	private static final long serialVersionUID = -5393816081031688653L;

	private HashMap<BOType, AbstractCTResponse> basketItems ; 
	
	private String correlationId;
	
//	private static  ActivityLogSDK getActivityLogService() { 
//		return(ActivityLogSDK)SpringContextAware.getBean("activityLogSDK");
//	}
	
	private static Cache getCache(){
		return ((CacheManager)SpringContextAware.getBean("cacheManager")).getCache("boBasket");
	}
    
	private BOBasket(){}
	
	private BOBasket(String correlationId){
		this.basketItems = new HashMap<BOType,AbstractCTResponse>();
		this.correlationId = correlationId;
	}
	
//    public static BOBasket getBasket(String correlationId){
//    	if(StringUtils.isBlank(correlationId)) return null;
//    	BOBasket basket = getBasketFromCache(correlationId);
//    	if(basket == null){
//    		basket = getBasketFromDB(correlationId);
//    		if(basket == null) basket = new BOBasket(correlationId);
//    		getCache().put(new Element(correlationId,basket));
//    	}
//    	return basket;
//    }
    
//    public static BOBasket getBasket(AbstractCTRequest request){
//    	if(StringUtils.isBlank(request.getHeader().getCorelationId())){
//    		getBasket(UUID.randomUUID().toString());
//    	}
//    	return getBasket(request.getHeader().getCorelationId());
//    }
    
    private static BOBasket getBasketFromCache(String correlationId){
    	if(getCache().isKeyInCache(correlationId))
    		return (BOBasket)getCache().get(correlationId).getValue();
    	else return null;
    }
    
//    private static BOBasket getBasketFromDB(String correlationId){
       
//    	    String JSONString = getActivityLogService().getBOBasket(correlationId);
//        	Gson gson = new Gson();
//            return gson.fromJson(JSONString, BOBasket.class);
    
//  }
    
//    public void putItem(BOType boType , AbstractCTResponse response) {
//    	putItem(correlationId,boType,response);
//    }
    
//    private void putItem(String correlationId, BOType boType, AbstractCTResponse response) {
//    	this.basketItems.put(boType, response);
//    	persistBOBasket(this);
//		Statistics stats = getCache().getStatistics();
//		System.out.println("BOBasketCache.put-->correlationId,response :: "+ " :: " + correlationId + " :: "+ stats.getObjectCount());
//	}
    
    public AbstractCTResponse getItem(BOType boType){
    	System.out.println("BOBasketCache.get-->corelationId :: "+ correlationId);
    	return this.basketItems.get(boType);
    }
    
	public HashMap<BOType, AbstractCTResponse> getAll() {
		return basketItems;
	}
	
	public void removeItem(BOType boType) {
		this.basketItems.remove(boType);
	}
	
	public void emptyBasket() {
		//delete from db and cache.
	}
	
//	private void persistBOBasket(BOBasket boBasket){
//		Gson gson = new Gson();
//		
//		getActivityLogService().putBOBasket(this.correlationId, gson.toJson(boBasket),"BOBasket");
//    	cacheBOBasket(this);
//    }
	    
    private void cacheBOBasket(BOBasket boBasket){
    	getCache().put(new Element(boBasket.correlationId,boBasket));
    }


	public String getCorrelationId() {
		return correlationId;
	}


}

