package com.f9g4.webapp.controllers;

import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.f9g4.businessobjects.domain.AdActiveUserDomain;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.services.AddUserLogRequest;
import com.f9g4.common.util.Constants;
import com.f9g4.common.util.XMLGregorianCalendarConverter;
import com.f9g4.servicesdk.DataCaptureServiceSDK;
import com.f9g4.web.utils.ViewPaths;

@Controller
@SessionAttributes({"user", "uName", "secQs", "adUserDomain","isMembershipExpired","currTermsId", "loggedInUserUUID"})
public class LogoutController {

	@Autowired
	private DataCaptureServiceSDK dataCaptureServiceSDK; 
	
	@RequestMapping(value = ViewPaths.LOGOUT, method = RequestMethod.GET)
	public String logout(@ModelAttribute("user") AdUsersDomain user, HttpSession session, SessionStatus status) throws DatatypeConfigurationException {
		
		String loggedInUserUUID = (String) session.getAttribute("loggedInUserUUID");
		if(null != loggedInUserUUID){
			AddUserLogRequest aduserLogRequest = new AddUserLogRequest();
			aduserLogRequest.setAction(Constants.ADD_USER_LOG_ACTION_UPDATE);
			AdActiveUserDomain domain = new AdActiveUserDomain();
			domain.setLastupdateby(user.getUserId());
			domain.setLogoutDate(XMLGregorianCalendarConverter.convertCalendarToXMLGregorianCalendar(Calendar.getInstance())); //UTC time
	//		domain.setSessionId(session.getId());
			domain.setSessionId(loggedInUserUUID);
			aduserLogRequest.setUserLogger(domain);
			dataCaptureServiceSDK.logUserData(aduserLogRequest);
		}
		//spring way of cleaning session..
		status.setComplete();
		session.invalidate();
		//return ViewPaths.REDIRECT_STRING + ViewPaths.LOGIN;
		return ViewPaths.REDIRECT_STRING + "//"; //redirect to home page
	}
}
