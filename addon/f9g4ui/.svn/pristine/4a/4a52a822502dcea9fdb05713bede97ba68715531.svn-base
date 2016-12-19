package com.f9g4.webapp.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.f9g4.businessobjects.domain.AdUsersDomain;
import com.f9g4.web.utils.ViewPaths;

@Controller
@SessionAttributes({"user", "userId"})
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired @Value("${fileStore_error_files}")
	private String profileLocation_error_files;
	
	@Autowired @Value("${fileStore_ai}")
	private String profileLocation_files;
	
	@RequestMapping(value = ViewPaths.FILE_RETRIEVER, method = RequestMethod.GET)
	public void retrieveSourceFile(@RequestParam(value="sourcefile") String sourceFile, @ModelAttribute("user") AdUsersDomain user,HttpServletResponse response, ModelMap map) 
	{
		retrieveFile(response, this.profileLocation_error_files, this.profileLocation_files, sourceFile, user);
	}
	
	private void retrieveFile(HttpServletResponse response, String location, String fallbackLocation, String targetFileName, AdUsersDomain user)
	{
		File target = new File(location + targetFileName);
		File fallbackTarget = new File(fallbackLocation + targetFileName);
		String mimeType;
		try
		{
			if(target.exists())
			{
				InputStream is = new FileInputStream(target);
				Path path = Paths.get(location + targetFileName);
				mimeType = Files.probeContentType(path);
				responseHandler(response, mimeType, targetFileName);
		      	IOUtils.copy(is, response.getOutputStream());
		      	response.flushBuffer();
			}
			else
			{
				if(fallbackTarget.exists())
				{
					//fallback location
					InputStream is = new FileInputStream(fallbackTarget);
					Path path = Paths.get(fallbackLocation + targetFileName);
					mimeType = Files.probeContentType(path);
					responseHandler(response, mimeType, targetFileName);
			      	IOUtils.copy(is, response.getOutputStream());
			      	response.flushBuffer();	
				}
				else
				{
					response.setContentType(MediaType.TEXT_PLAIN);
					response.setStatus(HttpStatus.NOT_FOUND.value());
					response.getOutputStream().print("File not found.");
					response.flushBuffer();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void responseHandler(HttpServletResponse response, String mimeType, String fileName)
	{
		if(mimeType.contains("pdf"))
			response.setContentType(mimeType);
		else
			response.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
	}
}
