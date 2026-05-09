package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("\n=#=#=#=#=#=#=#=#=#= Servlet 2 - doPost Starts =#=#=#=#=#=#=#=#=#=\n");

		String name = request.getParameter("name");
		String address = request.getParameter("address");

		System.out.println("Inserting into Database... [ name = {" + name + "}, address = {" + address + "} ].");
		System.out.println("Database insertion: Success.");

		System.out.println("\n=#=#=#=#=#=#=#=#=#= Servlet 2 - doPost Ends =#=#=#=#=#=#=#=#=#=\n");

	}

}
