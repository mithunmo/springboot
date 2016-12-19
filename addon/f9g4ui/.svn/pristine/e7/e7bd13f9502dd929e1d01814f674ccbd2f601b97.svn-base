package com.f9g4.web.filters;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class SessionValidator
 */
public class SessionValidator implements Filter {

	   private ArrayList<String> urlList;
    /**
     * Default constructor. 
     */
    public SessionValidator() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	private static final Logger logger = LoggerFactory.getLogger(SessionValidator.class);

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();
        boolean passthroughpage = false;
        boolean redirect = false;
        if(urlList.contains(url)) {
        	passthroughpage = true;
        }
        
        if(!passthroughpage){
        	HttpSession session = request.getSession(false);
            if (null == session) {
            		redirect = true;
            		logger.debug("null session");
            }else{
            	if(null== session.getAttribute("user")){
            		redirect = true;
            		logger.debug("user session object is not existed");
            	}
            	else if (true == (Boolean)session.getAttribute("isLoginFailed")){
            		redirect = true;            		
            		logger.debug("login failed");
            	}
            }
        }
        
        try
        {
        	if (redirect == true) 
        	{
        		//response.sendRedirect(request.getContextPath() + "/user/login");
        		response.sendRedirect("/"); //redirect to home page
        	}
        	else
        		chain.doFilter(request, response); //Call filter again only if the session object exists.
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String urls = fConfig.getInitParameter("passthroughpages");
        StringTokenizer token = new StringTokenizer(urls, ",");
 
        urlList = new ArrayList<String>();
 
        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
 
        }
	}

}
