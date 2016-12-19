package com.f9g4.businesscore.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cacheable {
	
	/**
     * The name of the cache to use
     */
    CacheType cacheName();
    
    /**
     * The Spring Bean name of the {@link CacheKeyGenerator} to use.
     * If this and {@link #keyGenerator()} are not specified the default generator will be used.
     */
    String keyGeneratorName() default "defaultCacheKeyGenerator";

}