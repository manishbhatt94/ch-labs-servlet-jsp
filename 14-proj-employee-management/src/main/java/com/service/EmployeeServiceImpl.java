package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.dto.AddEmployeeRequestDto;
import com.dto.EmployeeDto;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String addEmployee(AddEmployeeRequestDto addEmployeeDto) {

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.insertEmployee(addEmployeeDto);
	}

	@Override
	public List<EmployeeDto> readEmployees() {

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.fetchEmployees();
	}

}
