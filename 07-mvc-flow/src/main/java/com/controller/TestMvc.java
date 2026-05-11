package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestMvc extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("TestMvc doGet()...");

		List<String> employees = Arrays.asList("Raju", "Ravi", "Ramesh", "Rakesh");

		// add the list of employees to session
		HttpSession session = request.getSession();
		session.setAttribute("employees", employees);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/readall.jsp");
		requestDispatcher.forward(request, response);

	}

}
