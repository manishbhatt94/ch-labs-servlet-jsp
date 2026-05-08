package com.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletConfig servletConfig = getServletConfig();
		String connectionUri = servletConfig.getInitParameter("conn-uri");
		System.out.println("Servlet1 's ServletConfig: [conn-uri] = " + connectionUri);

		response.sendRedirect("index.html");

	}

}
