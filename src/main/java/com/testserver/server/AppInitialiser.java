package com.testserver.server;

import com.testserver.server.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitialiser implements WebApplicationInitializer{

    private final static String DISPATCHER = "dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(WebConfig.class);

        servletContext.addListener(new ContextLoaderListener(ctx));
        ServletRegistration.Dynamic servler = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        servler.addMapping("/");
        servler.setLoadOnStartup(1);
    }
}
