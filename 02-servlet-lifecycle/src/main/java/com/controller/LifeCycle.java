package com.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycle extends HttpServlet {

	static {
		System.out.println("LifeCycle Servlet - LOADING. Inside LifeCycle class's static block.");
	}

	public LifeCycle() {
		System.out.println("LifeCycle Servlet - INSTANTIATION. Inside LifeCycle class's default constructor.");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeCycle Servlet - INIT. Inside LifeCycle class's init() method.");
	}

	@Override
	public void destroy() {
		System.out.println("LifeCycle Servlet - DESTROY. Inside LifeCycle class's destroy() method.");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycle Servlet - SERVICE. Inside LifeCycle class's service() method.");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycle Servlet - doGET. Inside LifeCycle class's doGet() method.");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LifeCycle Servlet - doPOST. Inside LifeCycle class's doPost() method.");
	}

}
