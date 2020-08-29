package edu.pdx.cs410J.whitlock;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class RestModule extends ServletModule {

  public RestModule() {
    System.out.println("Creating RestModule");
  }

  @Override
  protected void configureServlets() {
    bind(PhoneBillRestApi.class);

    bind(HttpServletDispatcher.class).in(Singleton.class);
    serve("/PhoneBill/*").with(HttpServletDispatcher.class);
  }
}
