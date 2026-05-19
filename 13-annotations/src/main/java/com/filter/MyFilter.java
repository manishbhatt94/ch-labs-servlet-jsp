package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(urlPatterns = { "/test", "/test-servlet" })
public class MyFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("MyFilter destroy() method called! (Filter is destroyed)");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MyFilter doFilter() method: PRE-PROCESSING");

		// pass the request along the filter chain
		chain.doFilter(request, response);

		System.out.println("MyFilter doFilter() method: PRE-PROCESSING");

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter init() method called! (Filter is initialized)");
	}

}
