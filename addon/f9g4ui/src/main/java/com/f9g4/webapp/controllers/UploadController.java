
/*
 * SpringSourcery - http://www.springsourcery.org
 *
 * Copyright (C) 2011 Dan Macklin.
 *
 * SpringSourcery is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * SpringSourcery is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SpringSourcery; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 */

package com.f9g4.webapp.controllers;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;

import com.f9g4.web.utils.UploadFileEnum;
import com.f9g4.web.utils.ViewNames;
import com.f9g4.webapp.servicesFacade.UploadFacade;
import com.f9g4.webapp.domain.UploadProperties;
import com.f9g4.webapp.domain.UploadResult;

@Controller
@RequestMapping("/uploadPictures")
public class UploadController 
{
	
	@Autowired
	@Qualifier(value = "uploadFacadeApacheCommonsUploadImpl")
	private UploadFacade uploadFacade;
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	public UploadController() {
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(@RequestParam(value="mode") String mode,@RequestParam(value="filetype") String filetype,Model model) 
	{
		model.addAttribute("uploadbean", new UploadProperties());
		model.addAttribute("sessionId", RequestContextHolder.currentRequestAttributes().getSessionId());
		model.addAttribute("mode", mode);
		if(filetype.toUpperCase().equals(UploadFileEnum.JPG.getFiletype()))
			model.addAttribute("filetype", UploadFileEnum.JPG);
		else if (filetype.toUpperCase().equals(UploadFileEnum.AI.getFiletype()))
			model.addAttribute("filetype", UploadFileEnum.AI);
		else
			model.addAttribute("filetype", UploadFileEnum.FILES);
		return "UploadPictures";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadcreate(@RequestParam(value="mode") String mode,@RequestParam(value="filetype") String filetype, UploadProperties uploadbean, BindingResult result, HttpServletRequest request,ModelMap model) 
	{
		/*
		 * Mode="LOGO": With Watermark
		 * Mode="BOARD": Without Watermark
		 */
		logger.debug("started uploading");
		if (result.hasErrors()) 
		{
			for (ObjectError error : result.getAllErrors()) 
			{
				System.err.println("Error in uploading: " + error.getCode()
						+ " - " + error.getDefaultMessage());
			}
		}
		
		if(uploadHandler(uploadbean, mode, filetype, model))
		{
			return "UploadPicturesSuccess";
		}
		else
		{
			return "UploadPicturesFailed";
		}
	}
	
	@RequestMapping(value="/json",method = RequestMethod.POST)
	public String upload(@RequestParam(value="mode") String mode,@RequestParam(value="filetype") String filetype, UploadProperties uploadbean, BindingResult result, HttpServletRequest request, ModelMap model) 
	{
		/*
		 * Mode="LOGO": With Watermark
		 * Mode="BOARD": Without Watermark
		 */
		logger.debug("started uploading");
		if (result.hasErrors()) 
		{
			for (ObjectError error : result.getAllErrors()) 
			{
				System.err.println("Error in uploading: " + error.getCode()
						+ " - " + error.getDefaultMessage());
			}
		}
		
		uploadHandler(uploadbean, mode, filetype, model);
		return ViewNames.UPLOAD_RESULT_JSON;
	}
	
	private Boolean uploadHandler(UploadProperties uploadbean, String mode, String filetype, ModelMap model)
	{
		//check the uploadMode
		int uploadMode=-1;
		if(mode.toUpperCase().equals("LOGO"))
			uploadMode=1;
		else if(mode.toUpperCase().equals("BOARD"))
			uploadMode=2;
		else if(mode.toUpperCase().equals("FILES"))
			uploadMode=3;
		
		UploadResult uploadResult = new UploadResult();
		boolean success = uploadFacade.upload(uploadbean,uploadMode,uploadResult);
		logger.debug("UPLOAD File Name=>"+uploadResult.getFileName());
		logger.debug("UPLOAD RESULT=>"+success);
		if(filetype.toUpperCase().equals(UploadFileEnum.JPG.getFiletype()))
			model.addAttribute("filetype", UploadFileEnum.JPG);
		else if (filetype.toUpperCase().equals(UploadFileEnum.AI.getFiletype()))
			model.addAttribute("filetype", UploadFileEnum.AI);
		else
			model.addAttribute("filetype", UploadFileEnum.FILES);
		if (success)
		{	
			model.addAttribute("status","UploadPicturesSuccess");
			model.addAttribute("upload_filename", uploadResult.getFileName());
			model.addAttribute("upload_ext", uploadResult.getOriginal_ext());
			model.addAttribute("upload_filename_100x100", uploadResult.getFileName_size_100());
			model.addAttribute("upload_filename_400x400",uploadResult.getFileName_size_400());
			model.addAttribute("upload_filename_original",uploadResult.getFileName_size_original());
			model.addAttribute("upload_status", uploadResult.getUploadStatus());
			model.addAttribute("original_filename", uploadResult.getOriginalFileName());
			model.addAttribute("isFailedProcessing", uploadResult.isFailedProcessing());
			logger.debug("REDIRECT TO SUCCESS");
			return true;
		}
		else
		{
			model.addAttribute("status","UploadPicturesFailed");
			model.addAttribute("upload_status", uploadResult.getUploadStatus());
			logger.debug("REDIRECT TO ERROR");
			return false;
		}
	}
}