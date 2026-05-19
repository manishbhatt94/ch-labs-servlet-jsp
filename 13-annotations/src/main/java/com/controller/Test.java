package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @formatter:off
@WebServlet(
		name = "TestServlet",
		urlPatterns = { "/test-servlet", "/servlet-test", "/test" },
		initParams = {
				@WebInitParam(name = "conn-uri", value = "jdbc:mysql://localhost:3306/jfsseptkart"),
				@WebInitParam(name = "weather-api-uri", value = "https://api.openweathermap.org/data/3.0/onecall")
		}
)
// @formatter:on
public class Test extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletConfig servletConfig = getServletConfig();
		String connUri = servletConfig.getInitParameter("conn-uri");
		String weatherApiUri = servletConfig.getInitParameter("weather-api-uri");

		PrintWriter out = response.getWriter();

		// @formatter:off
		out.println("<!DOCTYPE html>"
				+ "<html lang=\"en-IN\"><head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>Test Servlet</title></head>"
				+ "<body>"
				+ "<header>"
				+ "<h1>Welcome to Test Servlet</h1>"
				+ "<nav><ul>"
				+ "<li><a href=\".\">Index page</a></li>"
				+ "</ul></nav>"
				+ "</header>"
				+ "<main>"
				+ "<p>This page is brought to you by <strong>Test Servlet</strong></p>"
				+ "<p>ServletConfig init-param 'conn-uri' value = \""+ connUri +"\"</p>"
				+ "<p>ServletConfig init-param 'weather-api-uri' value = \""+ weatherApiUri +"\"</p>"
				+ "<p>Goodbye!</p></main>"
				+ "</body></html>");
		// @formatter:on

	}

}
