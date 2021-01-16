package io.kornys.quarkus;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class Api {

    @Inject
    ApiService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "this is api endpoint";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello/{name}")
    public String greeting(@PathParam String name) {
        return service.sayHello(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/time")
    public String greeting() {
        return service.getTime();
    }
}