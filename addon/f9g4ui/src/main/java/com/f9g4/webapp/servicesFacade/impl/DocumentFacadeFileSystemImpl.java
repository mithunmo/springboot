
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

package com.f9g4.webapp.servicesFacade.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.f9g4.webapp.servicesFacade.DocumentFacade;



@Service
public class DocumentFacadeFileSystemImpl extends DocumentFacadeAbstract implements DocumentFacade {

	

	@Autowired
	@Value("${downloadStore}")
	private String downloadLocation;

	public void loadImage(long userId, String fileName, OutputStream out) {
		loadImageFromFileSystem(userId, fileName, out);
	}

//	
//	public boolean loadProfileImage(long userId, String fileName) {
//
//		User u = userDAO.findByPrimaryKey(userId);
//
//		if (u.getProfilePictureLocation().equalsIgnoreCase("no-profile.jpg")) {
//			return false;
//		}
//
//		else if (u.getProfilePictureLocation().equalsIgnoreCase(fileName + ".JPG")) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	private void loadImageFromFileSystem(long userId, String fileName, OutputStream out) {

		// check that the filename is valid
		// TODO: Make this security check better.

		if (fileName.startsWith(".")) {
			throw new IllegalArgumentException("File : " + fileName + " invalid");
		} else {

			FileInputStream fis = null;

			try {

				byte[] buffer = new byte[1024];
				fis = new FileInputStream(profileLocation + "/" + userId + "/pictures/" + fileName + ".JPG");
				int size;

				while ((size = fis.read(buffer)) != -1) {
					out.write(buffer, 0, size);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


	public List<String> getUserImages(String username) {


		File directory = new File(profileLocation + "/" + "portfolioid" + "/pictures/");

		if (directory.exists()) {
			return Arrays.asList(directory.list(new JPGFilter()));
		} else {
			return new ArrayList<String>();
		}
	}

	/**
	 * Load an image and scale it so that it can be cropped.
	 */

	public void scaleImage(long userId, String fileName, int width, int height, OutputStream out) {

		try {
			ImageIO.write(scaleToBufferedImage(userId, fileName, width, height), "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Take an image, scale it to a consistent size and then crop it and save it
	 * to a users file area,
	 * 
	 * @param username
	 * @param fileName
	 * @param scaleWidth
	 * @param scaleHeight
	 * @param cropWidth
	 * @param cropHeight
	 * @param cropStartX
	 * @param cropStartY
	 */

	public void cropImage(long userId, String fileName, int scaleWidth, int scaleHeight, int cropWidth, int cropHeight,
			int cropStartX, int cropStartY) {

		BufferedImage cropped = cropToBufferedImage(userId, fileName, scaleWidth, scaleHeight, cropWidth, cropHeight,
				cropStartX, cropStartY);

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(profileLocation + "/" + userId + "/pictures/cropped" + fileName);
			ImageIO.write(cropped, "jpg", fos);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void loadDownload(String fileName, HttpServletResponse response) {
	
		File file = new File(downloadLocation + "/" + fileName);
		
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition","attachment; filename=\"" + fileName +"\"");
		
		OutputStream out = null;
		FileInputStream fis = null;

		try {
			out = response.getOutputStream();
			byte[] buffer = new byte[1024];
			fis = new FileInputStream(downloadLocation + "/" + fileName);
			int size;

			while ((size = fis.read(buffer)) != -1) {
				out.write(buffer, 0, size);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (out != null) {
				try{
					out.close();
				}
				catch (Exception ex2){
					ex2.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean loadProfileImage(long userId, String fileName) {
		// TODO Auto-generated method stub
		return false;
	}
}
