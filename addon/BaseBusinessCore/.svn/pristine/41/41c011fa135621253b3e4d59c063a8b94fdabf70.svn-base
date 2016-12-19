package com.f9g4.businesscore.bobasket;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;



/**
 * Intercepts method calls for the purpose of caching. 
 * The cacheKeyGenerator generates the key used to cache data.
 */
@Aspect
public class BOBasketAspect implements MethodInterceptor
{
   @Pointcut("execution(@AddToBOBasket * *(..)) && @annotation(addToBasket)")
   public void addToBasket(AddToBOBasket addToBasket) {
   }

     /**
     * For Spring 2.x style AOP interception.
     */
    @Around(value="com.f9g4.businesscore.bobasket.BOBasketAspect.addToBasket(addToBasket)", argNames="addToBasket")
//   @Around("execution (@AddToBOBasket * * (..) ) and @annotation(addToBasket)")
    public Object process(ProceedingJoinPoint call, AddToBOBasket addToBasket) throws Throwable
    {
        MethodSignature signature = (MethodSignature) call.getSignature();

        Method method = signature.getMethod();

        return null;  //        process(call, method, call.getArgs(), addToBasket);
    }
    
//    private Object process(Object call, Method method, Object[] args, AddToBOBasket basketItem) throws Throwable{
//        String correlationId = "";
//        if(args[0] instanceof AbstractCTRequest){
//        	AbstractCTRequest request = (AbstractCTRequest)args[0];
//        	correlationId = request.getHeader().getCorelationId();
//        }
//        BOBasket boBasket = BOBasket.getBasket(correlationId);
//        Object result = null;
//        // clear this entry from the cache if the original method started
//        // get from cache...
//        if(boBasket != null) result = boBasket.getItem(basketItem.value());
//        if (result == null) {
//        	System.out.println("cache miss! "+correlationId);
//	        result = proceed(call);
//	        // add object to cache
//	        if (result != null ) {
//	        	System.out.println("adding results to cache.");
//	        	if(boBasket == null) boBasket = BOBasket.getBasket(((AbstractCTResponse)result).getHeader().getCorelationId());
//	            boBasket.putItem(basketItem.value(),(AbstractCTResponse)result);
//	        }
//        }
//        else {
//        	System.out.println("cache hit! - returning results from cache for " + correlationId);
//        }
//        return result;
//    }
    
    private Object process(Object call, Method method, Object[] args) throws Throwable{
    	return null;
    }

    private Object proceed(Object call) throws Throwable
    {
        if (call instanceof MethodInvocation) {
            return ((MethodInvocation) call).proceed();
        }
        else if (call instanceof ProceedingJoinPoint) {
            return ((ProceedingJoinPoint) call).proceed();
        }
        else {
            throw new IllegalArgumentException("unsupported call type: " + call.getClass());
        }
    }

    /**
     * For Spring 1.x style interception. 
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     * @param methodInvocation
     *            method
     * @return Object
     * @throws Throwable
     */
   public Object invoke(MethodInvocation methodInvocation) throws Throwable
    {
        Method method = methodInvocation.getMethod();

        return process(methodInvocation, method, methodInvocation.getArguments());
    }

 
    public void clearCacheByUser(){
    }

    public void clearCacheEntry(Method method, Object[] args){
//        coreCache.remove(getCacheKey(args));
    }
    
}
