package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[MyListener # contextDestroyed] ON CLOSE");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("[MyListener # contextInitialized] ON STARTUP");
		System.out.println("[MyListener # contextInitialized] Setting ServletContext's initParams...");
		ServletContext servletContext = sce.getServletContext();
		servletContext.setInitParameter("org-src-control-page", "https://github.com/manishbhatt94/");

	}

}
