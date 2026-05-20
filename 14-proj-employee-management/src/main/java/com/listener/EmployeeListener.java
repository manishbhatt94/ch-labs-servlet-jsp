package com.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dao.ConnectionFactory;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;

@WebListener
public class EmployeeListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		mysqlPoolDestroy();

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext servletContext = sce.getServletContext();

		mysqlPoolSetup(servletContext);
		createSchema();

	}

	private void mysqlPoolSetup(ServletContext servletContext) {
		try {
			System.out.println("EmployeeListener#mysqlPoolSetup(): Reading config.properties file");

			// ####### Construct Properties object from config.properties file #######

			// ======= Method 1: =======
			// == Construct InputStream ourselves to the config.properties file ==
			// (Commenting out this method)

			/*
			 * @formatter:off
			// First: Find realPath of the config.properties file.
			String realPath = servletContext.getRealPath("/WEB-INF/config/config.properties");
			System.out.println("Real Path [for config.properties file]: " + realPath);
			// Then: Construct InputStream to the config.properties file.
			FileInputStream fis = new FileInputStream(realPath); // This throws checked "FileNotFoundException" which we
																	// have to handle
			 * @formatter:on
			*/

			// ======= Method 2: =======
			// == Let ServletContext construct InputStream to the config.properties file ==
			// == using getResourceAsStream() method of ServletContext ==

			InputStream iStream = servletContext.getResourceAsStream("/WEB-INF/config/config.properties");
			System.out.println("EmployeeListener#mysqlPoolSetup(): Obtained InputStream to config.properties file");

			// ### Create Properties object, load it using the InputStream object ###
			Properties properties = new Properties();
			properties.load(iStream); // This throws checked "IOException" which we have to handle
			System.out.println(
					"EmployeeListener#mysqlPoolSetup(): Loaded config.properties " + "file into Properties object");

			String driver = properties.getProperty("mysql.driver");
			String url = properties.getProperty("mysql.url");
			String username = properties.getProperty("mysql.username");
			String password = properties.getProperty("mysql.password");
			System.out.println("EmployeeListener#mysqlPoolSetup(): Connection details - [driver(" + driver + "), url("
					+ url + "), username(" + username + "), password(" + password + ")]");
			System.out.println("EmployeeListener#mysqlPoolSetup(): Call ConnectionFactory.init() "
					+ "with MySQL connection details");

			ConnectionFactory.init(driver, url, username, password);

			// Test code to verify that we are gettting a valid Connection object from the
			// connection pool. Just printing the Connection object to console.
			/*
			 * @formatter:off
			System.out.println(
					"EmployeeListener#mysqlPoolSetup(): Testing connection pool by getting a Connection object");
			System.out.println("Connection object: " + ConnectionFactory.getConnection());
			 * @formatter:on
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void mysqlPoolDestroy() {
		System.out.println("EmployeeListener#mysqlPoolDestroy(): Calling ConnectionFactory.closePool() "
				+ "to destroy MySQL connection pool");
		ConnectionFactory.closePool();
	}

	private void createSchema() {

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.createTable();

	}

}
