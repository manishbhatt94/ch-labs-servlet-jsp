package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static HikariDataSource hikariDataSource;

	public static void init(String driver, String url, String username, String password) {

		System.out.println("ConnectionFactory#init(): Begin DB connection pool initialization work!");
		try {
			Class.forName(driver);
			System.out.println("ConnectionFactory#init(): Loaded JDBC driver class: " + driver);

			System.out.println("ConnectionFactory#init(): Creating HikariConfig object...");
			HikariConfig hikariConfig = new HikariConfig();
			System.out.println("ConnectionFactory#init(): Created HikariConfig object. "
					+ "Setting JDBC URL, username and password");

			hikariConfig.setJdbcUrl(url);
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);
			System.out.println("ConnectionFactory#init(): HikariConfig object configured. "
					+ "Creating HikariDataSource object...");

			hikariDataSource = new HikariDataSource(hikariConfig);
			System.out.println("ConnectionFactory#init(): HikariDataSource object created. "
					+ "DB connection pool ready to be used!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Objects.requireNonNull(hikariDataSource,
				"Connection pool is not initialized. Call ConnectionFactory.init() first.");
		return hikariDataSource.getConnection();
	}

	public static void closePool() {
		Objects.requireNonNull(hikariDataSource, "Connection pool is not initialized. "
				+ "Cannot call close on HikariDataSource reference having null value.");
		System.out.println(
				"ConnectionFactory#closePool(): Closing HikariDataSource " + "object to destroy DB connection pool...");
		hikariDataSource.close();
	}

	public static void close(AutoCloseable resource) {
		// Note: Calling .close() on Connection will just return the Connection object
		// back to Hikari's connection pool.
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
