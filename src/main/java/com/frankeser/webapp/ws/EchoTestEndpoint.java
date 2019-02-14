package com.frankeser.webapp.ws;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Path("/echo")
public class EchoTestEndpoint {
    @GET
    @Path("/{word}")
    public Response echoWord(@PathParam("word") String word) {
        return Response.ok(
                "{\"word\": \"" + word + "\"}"
        ).build();
    }
}
