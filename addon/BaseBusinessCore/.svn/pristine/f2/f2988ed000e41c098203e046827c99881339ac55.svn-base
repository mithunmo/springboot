package com.f9g4.businesscore.bobasket;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.f9g4.businesscore.cache.CacheKeyGenerator;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented

/*
 * Annotation which indicates that a method return value should be bound to basket.
 */
public @interface AddToBOBasket {
	
	/**
     * The name of the item to use
     */
    BOType value();
    
    /**
     * The name of the item to use
     */
    BOType boType() default BOType.COMMON;
    
    /**
     * The Spring Bean name of the {@link CacheKeyGenerator} to use.
     * If this and {@link #keyGenerator()} are not specified the default generator will be used.
     */
    String keyGeneratorName() default "defaultKeyGenerator";

}