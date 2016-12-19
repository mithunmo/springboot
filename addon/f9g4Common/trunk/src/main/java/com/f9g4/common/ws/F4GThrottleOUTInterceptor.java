package com.f9g4.common.ws;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({ "rawtypes" })
public class F4GThrottleOUTInterceptor extends AbstractPhaseInterceptor {

	private static Logger _logger = LoggerFactory.getLogger(F4GThrottleOUTInterceptor.class);

	private F4GThrottleSupport throttleSupport;

	public F4GThrottleSupport getThrottleSupport() {
		return throttleSupport;
	}

	public void setThrottleSupport(F4GThrottleSupport throttleSupport) {
		this.throttleSupport = throttleSupport;
	}

	public F4GThrottleOUTInterceptor(String phase) {
		super(Phase.SEND);
	}

	public F4GThrottleOUTInterceptor() {
		super(Phase.SEND);
	}

	public void handleMessage(Message message) throws Fault {
		_logger.info("Before afterAccess - count is " + throttleSupport.getConcurrencyCount()+", limit is "+throttleSupport.getConcurrencyLimit());
		throttleSupport.afterAccess();
		_logger.info("After afterAccess - count is " + throttleSupport.getConcurrencyCount()+", limit is "+throttleSupport.getConcurrencyLimit());
	}

}
