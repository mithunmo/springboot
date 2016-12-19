package com.f9g4.common.ws;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class F4GThrottleINInterceptor extends AbstractPhaseInterceptor {

	private static Logger _logger = LoggerFactory.getLogger(F4GThrottleINInterceptor.class);

	private F4GThrottleSupport throttleSupport;

	public F4GThrottleSupport getThrottleSupport() {
		return throttleSupport;
	}

	public void setThrottleSupport(F4GThrottleSupport throttleSupport) {
		this.throttleSupport = throttleSupport;
	}

	public F4GThrottleINInterceptor(String phase) {
		super(Phase.RECEIVE);
	}

	public F4GThrottleINInterceptor() {
		super(Phase.RECEIVE);
	}

	public void handleMessage(Message message) throws Fault {
		_logger.info("Before beforeAccess- count is " + throttleSupport.getConcurrencyCount()+", limit is "+throttleSupport.getConcurrencyLimit());
		throttleSupport.beforeAccess();
		_logger.info("After beforeAccess- count is " + throttleSupport.getConcurrencyCount()+", limit is "+throttleSupport.getConcurrencyLimit());
	}

}
