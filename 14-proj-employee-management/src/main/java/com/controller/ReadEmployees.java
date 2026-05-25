package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

@WebServlet("/read-employees")
public class ReadEmployees extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeService employeeService = new EmployeeServiceImpl();
		request.setAttribute("employees", employeeService.readEmployees());

		request.getRequestDispatcher("/WEB-INF/view/readEmployees.jsp").forward(request, response);

	}

}
