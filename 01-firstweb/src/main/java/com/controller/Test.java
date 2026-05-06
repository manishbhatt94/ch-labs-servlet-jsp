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

		System.out.println("fullname: " + fullname);
		System.out.println("address: " + address);

	}

}
