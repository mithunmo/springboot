package com.f9g4.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f9g4.businessobjects.services.AddRatingRequest;
import com.f9g4.businessobjects.services.AddRatingResponse;
import com.f9g4.businessobjects.services.GetBoardRatingsResponse;
import com.f9g4.businessobjects.services.GetUserRatingRequest;
import com.f9g4.businessobjects.services.GetUserRatingResponse;

@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface IRatingService {

@PUT
@Path("/addRating/")
public AddRatingResponse addRating(AddRatingRequest request);


@GET
@Path("/rating/{userid}/{boardid}")
public GetBoardRatingsResponse getRatingforBoardbyUser(@PathParam("userid") int userid,@PathParam("boardid") int boardid);

@POST
@Path("/rating/")
public GetUserRatingResponse getRatingforUser(GetUserRatingRequest request);

}


