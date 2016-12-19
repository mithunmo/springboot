
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

import com.f9g4.webapp.domain.UploadProperties;
import com.f9g4.webapp.domain.UploadResult;

public interface UploadFacade 
{	
	public String getFileName();
	public String getOriginal_ext();
	public String getFileName_size_400();
	public String getFileName_size_100();
	public String getFileName_size_original();
	public String getOriginalFileName();
	public int getUploadStatus();
	public boolean isFailedProcessing();
	public boolean setupProperties();
	public boolean upload(UploadProperties uploadDetails,int uploadMode, UploadResult result);
}
