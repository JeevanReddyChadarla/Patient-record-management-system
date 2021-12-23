package com.cerner.patient.management.system.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author CJ094392
 * The DbConnection class has getDataBaseConnection.
 * Provides connection between database and dao layer.
 */
public class DbConnection {
	Connection connection = null;
	PropertyResource dataProp = new PropertyResource();
	String dbUrl = dataProp.getDatabaseProperties("dbConnectionURL");
	String driver = dataProp.getDatabaseProperties("DRIVER");
	String dbUsername = dataProp.getDatabaseProperties("dbConnectionUSER");
	String dbUserPassword = dataProp.getDatabaseProperties("dbConnectionPASSWORD");
	/**
	 * getDataBaseConnection provides database connection
	 * @return Connection
	 */
	public Connection getDataBaseConnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbUserPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {		
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * closeConnection closes database connection.
	 */
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}