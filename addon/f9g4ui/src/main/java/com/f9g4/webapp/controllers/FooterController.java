package com.f9g4.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.businessobjects.domain.TrBoardImagesDomain;
import com.f9g4.businessobjects.services.GetBoardByIdResponse;
import com.f9g4.businessobjects.services.ViewUserResponse;
import com.f9g4.servicesdk.BoardServiceSDK;
import com.f9g4.servicesdk.RegistrationServiceSDK;
import com.f9g4.web.forms.Cart;
import com.f9g4.web.forms.CartItem;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.web.utils.ViewPaths;

@Controller
public class FooterController 
{
	private static final Logger logger = LoggerFactory.getLogger(FooterController.class);
	
	@Autowired @Value("${footer_linkedin_url}")
	private String footer_linkedin_url;
	
	@Autowired @Value("${footer_facebook_url}")
	private String footer_facebook_url;
	
	@Autowired @Value("${footer_twitter_url}")
	private String footer_twitter_url;
	
	@Autowired @Value("${footer_rssfeed_url}")
	private String footer_rssfeed_url;
	
	@ModelAttribute("footer_urls") 
	public ModelMap getFooterUrl()
	{
		ModelMap map=new ModelMap();
		map.addAttribute("footer_linkedin_url", footer_linkedin_url);
		map.addAttribute("footer_facebook_url", footer_facebook_url);
		map.addAttribute("footer_twitter_url", footer_twitter_url);
		map.addAttribute("footer_rssfeed_url", footer_rssfeed_url);
		return map;
	}
	
	@RequestMapping(value = ViewPaths.ABOUT_US, method=RequestMethod.GET)
	public String showAboutUs(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name)
	{
		logger.trace("about_us");
		if(!name.equals("")){
			model.addAttribute("username", name);
			model.addAttribute("rememberme", true);
		}
		else
		{
			model.addAttribute("username", "");
			model.addAttribute("password", "");
			model.addAttribute("rememberme", false);
		}
		return ViewNames.ABOUT_US;
	}
	
	@RequestMapping(value = ViewPaths.WHAT_WE_DO, method=RequestMethod.GET)
	public String showWorkWithUs(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name)
	{
		logger.trace("work_with_us");
		if(!name.equals("")){
			model.addAttribute("username", name);
			model.addAttribute("rememberme", true);
		}
		else
		{
			model.addAttribute("username", "");
			model.addAttribute("password", "");
			model.addAttribute("rememberme", false);
		}
		return ViewNames.WHAT_WE_DO;
	}
	
	@RequestMapping(value = ViewPaths.HOW_IT_WORKS, method=RequestMethod.GET)
	public String showContactUs(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name)
	{
		logger.trace("contact_us");
		if(!name.equals("")){
			model.addAttribute("username", name);
			model.addAttribute("rememberme", true);
		}
		else
		{
			model.addAttribute("username", "");
			model.addAttribute("password", "");
			model.addAttribute("rememberme", false);
		}
		return ViewNames.HOW_IT_WORKS;
	}
	
	@RequestMapping(value = ViewPaths.GET_STARTED, method=RequestMethod.GET)
	public String showGetStarted(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name)
	{
		logger.trace("contact_us");
		if(!name.equals("")){
			model.addAttribute("username", name);
			model.addAttribute("rememberme", true);
		}
		else
		{
			model.addAttribute("username", "");
			model.addAttribute("password", "");
			model.addAttribute("rememberme", false);
		}
		return ViewNames.GET_STARTED;
	}
	
	@RequestMapping(value = ViewPaths.PRIVACY_POLICY, method=RequestMethod.GET)
	public String showPrivacyPolicy(ModelMap model, @CookieValue(value="RememberMef4g",defaultValue="") String name)
	{
		logger.trace("privacy_policy");
		if(!name.equals("")){
			model.addAttribute("username", name);
			model.addAttribute("rememberme", true);
		}
		else
		{
			model.addAttribute("username", "");
			model.addAttribute("password", "");
			model.addAttribute("rememberme", false);
		}
		return ViewNames.PRIVACY_POLICY;
	}
	
	@RequestMapping(value = ViewPaths.CONSOLE_ABOUT_US, method=RequestMethod.GET)
	public String showAboutUsInConsole()
	{
		logger.trace("about_us");
		return ViewNames.CONSOLE_ABOUT_US;
	}
	
	@RequestMapping(value = ViewPaths.CONSOLE_WORK_WITH_US, method=RequestMethod.GET)
	public String showWorkWithUsInConsole()
	{
		logger.trace("work_with_us");
		return ViewNames.CONSOLE_WORK_WITH_US;
	}
	
	@RequestMapping(value = ViewPaths.CONSOLE_CONTACT_US, method=RequestMethod.GET)
	public String showContactUsInConsole()
	{
		logger.trace("contact_us");
		return ViewNames.CONSOLE_CONTACT_US;
	}
	
	@RequestMapping(value = ViewPaths.CONSOLE_PRIVACY_POLICY, method=RequestMethod.GET)
	public String showPrivacyPolicyInConsole()
	{
		logger.trace("privacy_policy");
		return ViewNames.CONSOLE_PRIVACY_POLICY;
	}

}