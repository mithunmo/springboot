package com.f9g4.businesscore.cache;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.f9g4.common.util.SpringContextAware;


/**
 * Intercepts method calls for the purpose of caching. 
 * The cacheKeyGenerator generates the key used to cache data.
 */
@Aspect
public class CoreCacheInterceptor implements MethodInterceptor
{
    private static final Logger log = Logger.getLogger(CoreCacheInterceptor.class);

     /**
     * For Spring 2.x style AOP interception.
     */
    @Around("execution (* * (..) ) and @annotation(cacheable)")
    public Object cacheMethod(ProceedingJoinPoint call, Cacheable cacheable) throws Throwable
    {
        MethodSignature signature = (MethodSignature) call.getSignature();

        Method method = signature.getMethod();

        return process(call, method, call.getArgs(), cacheable);
    }

    private Object process(Object call, Method method, Object[] args, Cacheable cacheable) throws Throwable
    {
    	
        String cacheName = cacheable.cacheName().getValue();
        String cacheKeyGeneratorName = cacheable.keyGeneratorName();
        CoreCache coreCache = (CoreCache)SpringContextAware.getBean(cacheName);
        CacheKeyGenerator cacheKeyGenerator = (CacheKeyGenerator)SpringContextAware.getBean(cacheKeyGeneratorName);

        String methodName = method.getName();

        String cacheKey = getCacheKey(cacheKeyGenerator,args);

        Object result = null;
        // clear this entry from the cache if the original method started
        // get from cache...
        result = coreCache.get(cacheKey);
        if (result == null) {
            log.debug("cache miss!");
             result = proceed(call);
             // add object to cache
            if (result != null ) {
                log.debug("adding results to cache.");
                cacheKey = getCacheKey(cacheKeyGenerator, new Object[]{args,result});
                coreCache.put(cacheKey, result);
            }
            else {
                log.info("cache hit! - returning results from cache for " + methodName);
            }
        }

        return result;
    }
    
    private Object process(Object call, Method method, Object[] args) throws Throwable{
    	Class cacheClass = Class.forName("com.f4g.businesscore.cache.Cacheable");
        Cacheable cacheable = (Cacheable)getClass().getAnnotation(cacheClass);
    	return process(call, method, args, cacheable);
    }

   
    private String getCacheKey(CacheKeyGenerator cacheKeyGenerator, Object[] args)
    {
        String key = null;

        if (log.isDebugEnabled()) {
            log.debug("cache key = " + key);
        }
        return (String)cacheKeyGenerator.generateKey(args);
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
