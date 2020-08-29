package edu.pdx.cs410J.whitlock;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Tag(name = "Echo Example", description = "Another REST API to document")
@Path("Echo")
@Produces(MediaType.TEXT_PLAIN)
public class EchoRestApi {

  @GET
  @Path("echo")
  public String echo(
    @QueryParam("echo") @Parameter(description = "The string to echo") String echo
  ) {
    return echo;
  }
}
