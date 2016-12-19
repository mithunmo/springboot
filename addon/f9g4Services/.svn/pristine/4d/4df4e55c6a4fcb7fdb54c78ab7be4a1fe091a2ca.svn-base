package com.f9g4.services.FileUpload;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

import com.f9g4.services.rest.IFileUploadService;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
 
import javax.activation.DataHandler;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class FileUploadService implements IFileUploadService {

	
// Created two methods - find out the best option for using this.
	public Response uploadFile(MultipartBody multipartBody) {
		// TODO Auto-generated method stub
		 List<Attachment> attachments = multipartBody.getAllAttachments();
	        DataHandler dataHandler1 = attachments.get(0).getDataHandler();
	        DataHandler dataHandler2 = attachments.get(1).getDataHandler();
	       
	        try {
	            dataHandler1.getInputStream();
	           
	 
	            System.out.println("Processing Attachment 2 ...");
	            String comment = getStringFromInputStream(dataHandler2.getInputStream());
	            System.out.println("Comment : " + comment);
	 
	        } catch (Exception e) {
	            throw new WebApplicationException(500);
	        }
	        return Response.ok("ok").build();
	}
//	
//	  public static Project getProjectFromInputStream(InputStream is) throws Exception {
//	        JAXBContext c = JAXBContext.newInstance(new Class[]{Project.class});
//	        Unmarshaller u = c.createUnmarshaller();
//	        Project project = (Project) u.unmarshal(is);
//	        project.setRank(1);
//	        return project;
//	    }
	 
	    public static String getStringFromInputStream(InputStream in) throws Exception {
	        CachedOutputStream bos = new CachedOutputStream();
	        IOUtils.copy(in, bos);
	        in.close();
	        bos.close();
	        return bos.getOut().toString();
	    }
	    
	    //Write the code for handling file location and virus scan.
	public void addFile(String id, String name, InputStream text)

	{
		try {
			FileOutputStream fos = new FileOutputStream(new File(
					"c:/tmp/attachment"));
			int len;
			byte buf[] = new byte[1024];
			while ((len = text.read(buf)) > 0)
				fos.write(buf, 0, len);
			fos.close();
			text.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
