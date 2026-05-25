package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AddEmployeeDto;

@WebServlet(urlPatterns = { "/add-employee-view", "/add-employee" })
public class AddEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			AddEmployeeDto addEmployeeDto = addEmployeeRequestToDto(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private AddEmployeeDto addEmployeeRequestToDto(HttpServletRequest request) {

		String name = request.getParameter("name");
		name = name == null ? null : name.trim();
		String address = request.getParameter("address");
		address = address == null ? null : address.trim();
		String dobRaw = request.getParameter("dob");
		dobRaw = dobRaw == null ? null : dobRaw.trim();
		String salaryRaw = request.getParameter("salary");
		salaryRaw = salaryRaw == null ? null : salaryRaw.trim();
		System.out.println("Received from request: {" + "[name=" + name + "], " + "[address=" + address + "], "
				+ "[dob=" + dobRaw + "], " + "[salary=" + salaryRaw + "]}");

		LocalDate dateOfBirth = null;
		BigDecimal salary = null;

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name is required");
		}
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException("Address is required");
		}
		if (dobRaw == null || dobRaw.isEmpty()) {
			throw new IllegalArgumentException("Date of Birth is required");
		} else {
			try {
				dateOfBirth = LocalDate.parse(dobRaw);
			} catch (DateTimeParseException e) {
				throw new IllegalArgumentException("Date of Birth must be in the format YYYY-MM-DD");
			}
		}
		if (salaryRaw == null || salaryRaw.isEmpty()) {
			throw new IllegalArgumentException("Salary is required");
		} else {
			try {
				salary = new BigDecimal(salaryRaw);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Salary must be a valid number");
			}
			if (salary.compareTo(BigDecimal.ZERO) < 0) {
				throw new IllegalArgumentException("Salary must be a positive number");
			}
			salary = salary.setScale(4, BigDecimal.ROUND_HALF_UP);
		}

		AddEmployeeDto addEmployeeDto = new AddEmployeeDto();
		addEmployeeDto.setName(name);
		addEmployeeDto.setAddress(address);
		addEmployeeDto.setDateOfBirth(dateOfBirth);
		addEmployeeDto.setSalary(salary);

		return addEmployeeDto;

	}

}
