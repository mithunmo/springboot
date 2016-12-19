package com.f9g4.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.services.GetCompanyNewsDetailbyIdResponse;
import com.f9g4.businessobjects.services.GetCompanyNewsResponse;

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface ICompanyNews {

	@GET
	@Path("/companynews")
	public GetCompanyNewsResponse getCompanyNews();
	
	@GET
	@Path("/companynews/detail/{newsdetailid}")
	public GetCompanyNewsDetailbyIdResponse getCompanyNewsDetail(@PathParam("newsdetailid") int newsdetailid);
}
