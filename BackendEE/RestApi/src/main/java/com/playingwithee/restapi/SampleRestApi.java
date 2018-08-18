package com.playingwithee.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/samplerest")
@Consumes({"application/json"})
@Produces({"application/json"})
public class SampleRestApi {

    @GET
    @Path("")
    public String getSmth() {
        return "fadfa";
    }
}
