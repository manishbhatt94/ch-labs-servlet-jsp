package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("MyFilter destroy() method called! (Filter is destroyed)");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String userAgent = httpRequest.getHeader("User-Agent");
		System.out.println("User-Agent: " + userAgent);

		/**
		 * Only allow access if the User-Agent header contains "Firefox". If it doesn't,
		 * return a 403 Forbidden response with a message indicating that only Firefox
		 * browsers are allowed.
		 *
		 * Sample User-Agent header for Mozilla Firefox:
		 *
		 * Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:151.0) Gecko/20100101
		 * Firefox/151.0 ---
		 *
		 * Sample User-Agent header for Microsoft Edge:
		 *
		 * Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like
		 * Gecko) Chrome/148.0.0.0 Safari/537.36 Edg/148.0.0.0 ---
		 *
		 * Sample User-Agent header for Google Chrome:
		 *
		 * Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like
		 * Gecko) Chrome/148.0.0.0 Safari/537.36
		 */

		if (userAgent != null && !userAgent.contains("Firefox/")) {
			httpResponse.setContentType("text/html; charset=UTF-8");
			httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
			// httpResponse.getWriter().write("Access denied: Only Firefox browsers are
			// allowed.");
			httpResponse.getWriter()
					.println("<section style=\"margin: 50px auto; max-width: 600px; text-align: center;\">"
							+ "<h1>Access denied: Only Firefox browsers are allowed.</h1>"
							+ "<p>Download Firefox by visiting <a href=\"https://www.firefox.com/en-US/download/all/\">https://www.firefox.com/en-US/download/all/</a></p>"
							+ "</section>");
			return; // Stop further processing
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter init() method called! (Filter is initialized)");
	}

}
