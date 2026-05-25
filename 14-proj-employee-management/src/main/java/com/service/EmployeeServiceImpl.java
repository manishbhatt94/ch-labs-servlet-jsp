package com.service;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.dto.AddEmployeeRequestDto;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String addEmployee(AddEmployeeRequestDto addEmployeeDto) {

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		return employeeDao.insertEmployee(addEmployeeDto);
	}

}
