package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test-servlet")
public class Test extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// @formatter:off
		out.println("<!DOCTYPE html>"
				+ "<html lang=\"en-IN\"><head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Test Servlet</title></head>"
				+ "<body>"
				+ "<header><h1>Welcome to Test Servlet</h1></header>"
				+ "<main><p>Goodbye!</p></main>"
				+ "</body></html>");
		// @formatter:on

	}

}
