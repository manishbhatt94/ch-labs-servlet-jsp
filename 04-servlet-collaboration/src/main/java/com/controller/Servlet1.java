package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

		// Below message written to response, will be over-written by the response
		// Servlet2 writes if the request is dispatched using forward() method.
		response.getWriter().println("Servlet1: Request validation successful!");

		// RequestDispatcher that can be used to forward request to "Servlet2":
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Servlet2");

		/*
		 * Forwarding request to "Servlet2". The control will be transferred to
		 * "Servlet2" and the response written by "Servlet1" will be over-written by the
		 * response written by "Servlet2".
		 */
		// requestDispatcher.forward(request, response);

		/*
		 * Including response of "Servlet2" in the response of "Servlet1". The control
		 * will be transferred to "Servlet2" and the response written by "Servlet1" will
		 * be included in the response written by "Servlet2".
		 */
		requestDispatcher.include(request, response);

		System.out.println("\n=@=@=@=@=@=@=@= Servlet 1 - doPost Ends =@=@=@=@=@=@=@=\n");

	}

}
