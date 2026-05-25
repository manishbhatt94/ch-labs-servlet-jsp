package com.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDto {

	private int id;
	private String name;
	private String address;
	private LocalDate dateOfBirth;
	private BigDecimal salary;

	public EmployeeDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", salary=" + salary + "]";
	}

}
