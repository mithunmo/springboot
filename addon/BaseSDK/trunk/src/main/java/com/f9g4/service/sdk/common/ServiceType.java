package com.f9g4.service.sdk.common;
/**
 * An enumeration to define all possible call types supported by an SDK.
 */
public enum ServiceType 
{
	/** This is to specify that the service call is pojo (local) meaning in same jvm */
	Local,
	/** This is to specify that the service call is remote and is using REST protocol */
	REST,
	/** This is to specify that the service call is a mock one */
	Mock;
}
