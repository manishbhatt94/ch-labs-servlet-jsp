package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.dto.AddEmployeeRequestDto;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void createTable() {

		// @formatter:off
		final String sql = "CREATE TABLE IF NOT EXISTS `employee` (\n"
				+ "    `id` INT NOT NULL AUTO_INCREMENT,\n"
				+ "    `name` VARCHAR(100) NOT NULL,\n"
				+ "    `address` VARCHAR(180) NOT NULL,\n"
				+ "    `date_of_birth` DATE NOT NULL,\n"
				+ "    `salary` DECIMAL(19, 4) NOT NULL,\n"
				+ "    PRIMARY KEY (`id`)\n"
				+ ");";
		// @formatter:on
		System.out.println("EmployeeDaoImpl: SQL for CREATE TABLE:\n" + sql);
		Connection connection = null;
		Statement statement = null;

		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("EmployeeDaoImpl: Executed CREATE TABLE for `employee` table.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

	}

	@Override
	public String insertEmployee(AddEmployeeRequestDto addEmployeeDto) {

		// @formatter:off
		final String sql = "INSERT INTO `employee` (`name`, `address`, `date_of_birth`, `salary`)\n"
				+ "    VALUES (?, ?, ?, ?);";
		// @formatter:on
		System.out.println("EmployeeDaoImpl: SQL for INSERT:\n" + sql);
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addEmployeeDto.getName());
			preparedStatement.setString(2, addEmployeeDto.getAddress());
			preparedStatement.setDate(3, java.sql.Date.valueOf(addEmployeeDto.getDateOfBirth()));
			preparedStatement.setBigDecimal(4, addEmployeeDto.getSalary());

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected == 1) {
				return "SAVED";
			} else {
				return "FAILED TO SAVE";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "FAILED TO SAVE";
		} finally {
			ConnectionFactory.close(preparedStatement);
			ConnectionFactory.close(connection);
		}

	}

}
