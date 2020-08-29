package edu.pdx.cs410J.whitlock;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import io.swagger.v3.jaxrs2.integration.resources.AcceptHeaderOpenApiResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class RestModule extends ServletModule {

  public RestModule() {
    System.out.println("Creating RestModule");
  }

  @Override
  protected void configureServlets() {
    bind(PhoneBillRestApi.class);
    bind(EchoRestApi.class);

    bind(OpenApiResource.class);
    bind(AcceptHeaderOpenApiResource.class);

    bind(HttpServletDispatcher.class).in(Singleton.class);
    serve("/PhoneBill/*").with(HttpServletDispatcher.class);
    serve("/Echo/*").with(HttpServletDispatcher.class);
    serve("/openapi*").with(HttpServletDispatcher.class);
  }
}
