package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("\n=@=@=@=@=@=@=@= Servlet 1 - doPost Starts =@=@=@=@=@=@=@=\n");

		String name = request.getParameter("name");
		String address = request.getParameter("address");

		System.out.println("Validating request... [ name = {" + name + "}, address = {" + address + "} ].");
		System.out.println("Request validation: Success.");

		System.out.println("\n=@=@=@=@=@=@=@= Servlet 1 - doPost Ends =@=@=@=@=@=@=@=\n");

	}

}
