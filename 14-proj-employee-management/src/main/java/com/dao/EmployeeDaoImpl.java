package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

}
