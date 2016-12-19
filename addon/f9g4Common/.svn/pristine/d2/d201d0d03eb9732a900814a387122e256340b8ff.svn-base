package com.f9g4.common.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This class allows the ability to get Spring Application context and other Spring beans from the application context.
 * This class is created as singleton and can be used as static. Using this class spring beans can be retrieved from non
 * spring beans / objects.
 * 
 * Method behaviors:
 * <ul>
 * <li>setApplicationContext() - called by Spring when this bean is created</li>
 * <li>getBean() - Get the bean from the application context </li>
 * </ul>
 */
public final class SpringContextAware implements ApplicationContextAware
{
    private static final Logger log = Logger.getLogger(SpringContextAware.class.getName());

    /*
     * Make the constructor private so object can be not be created. This allows for a singleton SpringContextAware that
     * allows getting Spring beans from Non Spring beans / objects
     */
    private SpringContextAware()
    {

    }

    /*
     * The ApplicationContect under which this bean was created.
     */
    private static ApplicationContext ctx;

    /**
     * Since this class implements ApplicationContextAware this method is called by spring to set the applicationContext
     * under which this bean was created.
     * 
     * @param ApplicationContext
     *            appCtx
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext appCtx) throws BeansException
    {
        ctx = appCtx;
        log.debug("SpringAwareContext: " + ctx.getId());
    }

    /**
     * This method is used to get the Spring bean given the beanName.
     * 
     * @param String
     *            beanName
     * @return Object the springBean
     */
    public static Object getBean(String beanName)
    {
        return ctx.getBean(beanName);
    }

}
