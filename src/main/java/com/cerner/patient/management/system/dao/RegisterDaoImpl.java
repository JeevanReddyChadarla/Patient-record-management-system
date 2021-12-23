package com.cerner.patient.management.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;
/**
 * RegisterDaoImpl class implements the abstract methods of RegisterDao
 * The methods of RegisterDaoImpl are used to interact with database
 */
public class RegisterDaoImpl implements RegisterDao {
	private static final Logger logger = LoggerFactory.getLogger(RegisterDaoImpl.class);
	DbConnection dbCon = new DbConnection();
	Connection connection = dbCon.getDataBaseConnection();	
	PropertyResource dataProp = new PropertyResource();
	PreparedStatement prepStatement;
	String query;
	/**
	 * RegisterDaoImpl empty constructor
	 */
	public RegisterDaoImpl() {
	}
	/**
	 * LoginDaoImpl constructor for mocking.
	 * @param dbConMock mocks DataBase connection.
	 * @param PropertyResource mocks dataPropMock.
	 * @param Connection mocks connectionMock.
	 * @param PreparedStatement mocks prepStatementMock.
	 */
	public RegisterDaoImpl(DbConnection dbConMock, PropertyResource dataPropMock,Connection connectionMock, PreparedStatement prepStatementMock) {	
		this.dbCon = dbConMock;
		this.connection = connectionMock;
		this.dataProp = dataPropMock;
		this.prepStatement = prepStatementMock;
	}
	/**
	 * addRegisterServiceDetails method fires and sql query
	 * @return String message
	 */
	public String addRegisterServiceDetails(String userName, String password, String phoneNumber) {	
		String message="";
		query = dataProp.getDatabaseProperties("QUERY_REGISTER");
		try {			
			prepStatement = connection.prepareStatement(query);	
			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);
			prepStatement.setString(3, phoneNumber);
			prepStatement.executeUpdate();
			message = "User added successfully";
		} 
		catch (SQLException p) {	
			message = p.getLocalizedMessage();
			if(message.contains("duplicate key value violates unique constraint")) {
			message= "User Already taken, Try With a new user name";	
			}
			} 
		logger.trace(userName+" has newly registered here");
		return message;
	}
}