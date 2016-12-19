package com.f9g4.common.ws;

import org.slf4j.Logger;

public class F4GThrottleSupport {

	/**
	 * Permit any number of concurrent invocations: that is, don't throttle concurrency.
	 */
	public static final int UNBOUNDED_CONCURRENCY = -1;

	/**
	 * Switch concurrency 'off': that is, don't allow any concurrent invocations.
	 */
	public static final int NO_CONCURRENCY = 0;


	/**
	 * Transient to optimize serialization
	 */
	protected transient Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	private transient Object monitor = new Object();

	private int concurrencyLimit = UNBOUNDED_CONCURRENCY;

	private int concurrencyCount = 0;
	
	private String servicename;


	/**
	 * Set the maximum number of concurrent access attempts allowed.
	 * -1 indicates unbounded concurrency.
	 * <p>In principle, this limit can be changed at runtime,
	 * although it is generally designed as a config time setting.
	 * <p>NOTE: Do not switch between -1 and any concrete limit at runtime,
	 * as this will lead to inconsistent concurrency counts: A limit
	 * of -1 effectively turns off concurrency counting completely.
	 */
	public void setConcurrencyLimit(int concurrencyLimit) {
		this.concurrencyLimit = concurrencyLimit;
	}

	public int getConcurrencyCount() {
		return concurrencyCount;
	}

	public void setConcurrencyCount(int concurrencyCount) {
		this.concurrencyCount = concurrencyCount;
	}

	/**
	 * Return the maximum number of concurrent access attempts allowed.
	 */
	public int getConcurrencyLimit() {
		return this.concurrencyLimit;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	/**
	 * Return whether this throttle is currently active.
	 *
	 * @return <code>true</code> if the concurrency limit for this instance is active
	 * @see #getConcurrencyLimit()
	 */
	public boolean isThrottleActive() {
		return (this.concurrencyLimit > 0);
	}


	/**
	 * To be invoked before the main execution logic of concrete subclasses.
	 * <p>This implementation applies the concurrency throttle.
	 *
	 * @see #afterAccess()
	 */
	protected void beforeAccess() {
		if (this.concurrencyLimit == NO_CONCURRENCY) {
			throw new IllegalStateException(
				"Currently no invocations allowed - concurrency limit set to NO_CONCURRENCY");
		}
		if (this.concurrencyLimit > 0) {
			boolean debug = logger.isDebugEnabled();
			synchronized (this.monitor) {
				boolean interrupted = false;
				while (this.concurrencyCount >= this.concurrencyLimit) {
					if (interrupted) {
						throw new IllegalStateException("Thread was interrupted while waiting for invocation access, " +
							"but concurrency limit still does not allow for entering");
					}
					if (debug) {
						logger.debug("Concurrency count " + this.concurrencyCount +
							" has reached limit " + this.concurrencyLimit + " - blocking");
					}
					try {
						this.monitor.wait();
					} catch (InterruptedException ex) {
						// Re-interrupt current thread, to allow other threads to react.
						Thread.currentThread().interrupt();
						interrupted = true;
					}
				}
				if (debug) {
					logger.debug("Entering throttle at concurrency count " + this.concurrencyCount);
				}
				this.concurrencyCount++;
			}
		}
	}

	/**
	 * To be invoked after the main execution logic of concrete subclasses.
	 *
	 * @see #beforeAccess()
	 */
	protected void afterAccess() {
		if (this.concurrencyLimit >= 0) {
			synchronized (this.monitor) {
				this.concurrencyCount--;
				if (logger.isDebugEnabled()) {
					logger.debug("Returning from throttle at concurrency count " + this.concurrencyCount);
				}
				this.monitor.notify();
			}
		}
	}


}
