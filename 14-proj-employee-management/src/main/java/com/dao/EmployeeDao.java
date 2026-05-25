package com.dao;

import java.util.List;

import com.dto.AddEmployeeRequestDto;
import com.dto.EmployeeDto;

public interface EmployeeDao {

	void createTable();

	String insertEmployee(AddEmployeeRequestDto addEmployeeDto);

	List<EmployeeDto> fetchEmployees();

}
