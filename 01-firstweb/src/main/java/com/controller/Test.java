package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");

		// Log to console:
		System.out.println("fullname: " + fullname);
		System.out.println("address: " + address);

		// Send response to client:
		/*
		 * response.setContentType("text/html"); PrintWriter writer =
		 * response.getWriter(); writer.println("<h1>Success</h1>");
		 * writer.println("Received data: <br>"); writer.println("<p>Full Name: " +
		 * fullname + "</p>"); writer.println("<p>Address: " + address + "</p>");
		 */

		// Redirect:
		response.sendRedirect("index.html");

	}

}
