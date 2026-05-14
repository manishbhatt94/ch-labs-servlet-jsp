package com.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Startup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Prints: Application is shutting down... [/09-listener]
		System.out.println("Application is shutting down... [" + sce.getServletContext().getContextPath() + "]");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Prints: Application is starting up... [/09-listener]
		System.out.println("Application is starting up... [" + sce.getServletContext().getContextPath() + "]");
	}

}
