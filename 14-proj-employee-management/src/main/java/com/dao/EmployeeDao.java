package com.dao;

import com.dto.AddEmployeeRequestDto;

public interface EmployeeDao {

	void createTable();

	String insertEmployee(AddEmployeeRequestDto addEmployeeDto);

}
