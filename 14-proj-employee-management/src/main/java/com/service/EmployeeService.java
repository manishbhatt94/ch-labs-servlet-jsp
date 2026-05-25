package com.service;

import java.util.List;

import com.dto.AddEmployeeRequestDto;
import com.dto.EmployeeDto;

public interface EmployeeService {

	String addEmployee(AddEmployeeRequestDto addEmployeeDto);

	List<EmployeeDto> readEmployees();

}
