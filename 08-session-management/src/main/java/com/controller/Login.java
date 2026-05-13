package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("raju") && password.equals("123456")) {
			request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}

	}

}
