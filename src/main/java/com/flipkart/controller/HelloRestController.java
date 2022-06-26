package com.flipkart.controller;

import javax.ws.rs.GET;//ws: web-service   rs: rest
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloRestController {
    @GET
    @Path("/world")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployees() {
        return "Hello World!";
    }
}