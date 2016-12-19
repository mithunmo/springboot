
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

package com.f9g4.webapp.servicesFacade;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface DocumentFacade {
	
	public void loadImage(long userId, String fileName, OutputStream out);
	public boolean loadProfileImage(long userId, String fileName);
	public List<String> getUserImages(String username);
	public void scaleImage(long userId, String fileName, int width,int height, OutputStream out);
	public void cropImage(long userId, String fileName, int scaleWidth, int scaleHeight,
							int cropWidth, int cropHeight, int cropStartX, int cropStartY);
	
	public void loadDownload(String fileName, HttpServletResponse response);

}
