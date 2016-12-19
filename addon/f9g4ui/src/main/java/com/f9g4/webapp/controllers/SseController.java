package com.f9g4.webapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrMessagesDomain;
import com.f9g4.businessobjects.services.DrawerInfoResponse;
import com.f9g4.businessobjects.services.GetAlertsResponse;
import com.f9g4.businessobjects.services.GetlatestMessagesByBoardGroupByUserResponse;
import com.f9g4.common.util.LookupTypeValueEnum;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.MessageServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"user", "userId", "referralsList","cart", "languagesList",  "skillsList", "timezoneOffset","sseCurrentThreadId"})
public class SseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SseController.class);
	
	@Autowired
	private RegistrationServiceSDK registrationServiceSDK;
	
	@Autowired
	private MessageServiceSDK messageServiceSDK;
	
	@Autowired
	private BoardServiceSDK boardServiceSDK;
	
	@Autowired @Value("${f9g4.webapp.sse.duration}")
	private Integer sseDuration;
	
	@ModelAttribute("sseCurrentThreadId")
	private Integer getCurrentThreadId()
	{
		return null;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "console/sse", method=RequestMethod.GET)
	public /*@ResponseBody ModelMap*/ void getSSE(ServletRequest req, ServletResponse res,@ModelAttribute(value="user") AdUsersDomain adUsersDomain) throws IOException
	{
		//ModelMap model=new ModelMap();
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
		response.setContentType("text/event-stream;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Connection", "keep-alive");
		
		PrintWriter out = response.getWriter();
		
		//Register current thread id to session
		session.setAttribute("sseCurrentThreadId", Thread.currentThread().getId());
		logger.debug("Register current thread id => " + Thread.currentThread().getId());
				
		while (true) 
		{
			Calendar cal=Calendar.getInstance();
			Date date = cal.getTime();             
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			logger.debug("SSE fire=>"+format1.format(date)+" at "+Thread.currentThread().getId());
			
			out.print("id: " + "Test" + "\n");
			ModelMap result=updateNotification(adUsersDomain);
			String content= "("+result.toString().replace("=", ":")+")"; //convert modelmap to string
			out.print("data: " + content + "\n\n");
			out.flush();
			try 
			{
				HttpSession currentSession = request.getSession(false);
				//validate session object, if the session object is null. break the loop to close the connection.
				if(currentSession==null)
				{
					logger.debug("Detect the session is null");
					break;
				}
				else if(currentSession.getAttribute("user").equals(null))
				{
					logger.debug("Detect the session user is null");
					break;
				}
				else if(Thread.currentThread().getId()!=Long.parseLong(session.getAttribute("sseCurrentThreadId").toString()))
				{
					logger.debug("Detect the thread: "+Thread.currentThread().getId()+" is not the current thread id: "+session.getAttribute("sseCurrentThreadId").toString());
					break;
				}
				logger.debug("Thread #"+Thread.currentThread().getId()+" sleep.");
				Thread.currentThread().sleep(sseDuration); //Sleep for period
			} 
			catch (Exception e) 
			{
				logger.error("Exception=>" + e);
				//e.printStackTrace();
				break;
			}
		}
		logger.debug("Left the loop to close the sse connection. Thread #"+Thread.currentThread().getId());
		out.close(); //Close the writer!
		//return model;
	}
	
	@RequestMapping(value = "console/sse_alt", method=RequestMethod.GET)
	public @ResponseBody ModelMap getSSEAlt(@ModelAttribute(value="user") AdUsersDomain adUsersDomain) throws IOException
	{
		return updateNotification(adUsersDomain);
	}
	
	private ModelMap updateNotification(AdUsersDomain adUsersDomain)
	{
		ModelMap model=new ModelMap();
		DrawerInfoResponse response = boardServiceSDK.drawerInfo(adUsersDomain.getUserId());
		Long unreadAlertsCount=response.getYourMessages().getAlerts();
		Long unreadMessagesCount=response.getYourMessages().getMessages();
		Calendar latestAlertsTS=null;
		Calendar latestMessagesTS=null;
		Calendar eventTS = null;
		boolean hasUnreadAlert=false;
		boolean hasUnreadMessage=false;
		if(unreadAlertsCount>0)
		{
			hasUnreadAlert=true;
			latestAlertsTS=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(response.getYourMessages().getLatestAlertsTS());
			model.addAttribute("latestAlertsTS", latestAlertsTS.getTimeInMillis());
			if(eventTS==null)
				eventTS=latestAlertsTS;
			if(latestAlertsTS.after(eventTS)) //update the eventTS
				eventTS=latestAlertsTS;
		}
		else
			model.addAttribute("latestAlertsTS", "0");
		
		if(unreadMessagesCount>0)
		{
			hasUnreadMessage=true;
			latestMessagesTS=XMLGregorianCalendarConverter.convertXMLGregorianCalendarToCalendar(response.getYourMessages().getLatestMessagesTS());
			model.addAttribute("latestMessagesTS", latestMessagesTS.getTimeInMillis());
			if(eventTS==null)
				eventTS=latestMessagesTS;
			if(latestMessagesTS.after(eventTS)) //update the event TS
				eventTS=latestMessagesTS;
		}
		else
			model.addAttribute("latestMessagesTS", "0");
		
		model.addAttribute("hasUnreadAlert", hasUnreadAlert);
		model.addAttribute("unreadAlertsCount", unreadAlertsCount);
		model.addAttribute("hasUnreadMessage", hasUnreadMessage);
		model.addAttribute("unreadMessagesCount", unreadMessagesCount);
		if(eventTS==null)
			model.addAttribute("eventTS", "0");
		else
			model.addAttribute("eventTS", eventTS.getTimeInMillis());
		
		return model;
	}
}
