package com.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("\n============ Servlet2 ============\n");

		// Get values from <servlet> element's <init-param> child elements, in web.xml
		ServletConfig servletConfig = getServletConfig();
		String connectionUri = servletConfig.getInitParameter("conn-uri");
		System.out.println("Servlet2 's ServletConfig: [conn-uri] = " + connectionUri);
		System.out.println();

		// Get values from <context-param> elements (child of root <web-app> element),
		// in web.xml
		ServletContext servletContext = getServletContext();
		String orgSourceCtrlLink = servletContext.getInitParameter("org-src-control-page");
		System.out.println("ServletContext: [org-src-control-page] (Log from Servlet2) = " + orgSourceCtrlLink);
		System.out.println();

		System.out
				.println("Servlet2: Getting the attribute [org-support-email] from ServletContext, set by Servlet1...");
		String orgSupportEmail = (String) servletContext.getAttribute("org-support-email");
		System.out.println("ServletContext: [org-support-email] (Log from Servlet2) = " + orgSupportEmail);

		System.out.println("\n~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%\n");

		response.sendRedirect("index.html");

	}

}
