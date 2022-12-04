package org.studyeasy.showroom.resources;

import javax.ws.rs.core.HttpHeaders;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.studyeasy.showroom.model.ErrorPayload;

@Path("/")
public class DemoResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;

	@GET
	public String usefullAnnotaion() {
		return "Hello JAX-RS";
	}
	
	@GET
	@Path("demo")
	@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	public String contextDemo(@HeaderParam("header") String header) {
		if (header == null) {
			throw new NotFoundException();
		}
		return "The value of custom header is "+header;
	}
}
