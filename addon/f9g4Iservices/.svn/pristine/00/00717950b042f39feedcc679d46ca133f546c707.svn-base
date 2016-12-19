package com.f9g4.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.services.GetUserbyEmailResponse;
import com.f9g4.businessobjects.services.GetUserbyUsernamePasswordResponse;



@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface ISecurityService {
@GET
@Path("/getuser/credentials/{username}/{password}")
public GetUserbyUsernamePasswordResponse getUserbyUsernamePasword(@PathParam("username") String username, @PathParam("password") String password);

@GET
@Path("/getuser/emailid/{emailid}")
public GetUserbyEmailResponse getUserbyEmailId(@PathParam("emailid")String emailid);




}
