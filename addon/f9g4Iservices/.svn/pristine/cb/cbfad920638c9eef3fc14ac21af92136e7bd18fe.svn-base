package com.f9g4.services.rest;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

import javax.ws.rs.core.Response;


@Consumes(MediaType.MULTIPART_FORM_DATA)
public interface IFileUploadService {
	
	@POST
	@Path("/uploadFile")
	public Response uploadFile(MultipartBody multipartBody);
	
	@POST
	@Path("/addFile")
	public void addFile (@PathParam("id") String id,
            @PathParam("name") String name,
            InputStream text); 

}
