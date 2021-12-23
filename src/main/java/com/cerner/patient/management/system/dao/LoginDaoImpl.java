package com.cerner.patient.management.system.dao;
import java.util.Base64;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;
/**
 * LoginDaoImpl class implements the abstract methods of LoginDao
 * The methods of LoginDaoImpl are used to interact with database
 */
public class LoginDaoImpl implements LoginDao{
	DbConnection dbCon = new DbConnection();
	Connection connection = dbCon.getDataBaseConnection();
	PropertyResource propResource = new PropertyResource();
	PreparedStatement prepStatement;
	ResultSet rs;
	String message;	
	/**
	 * LoginDaoImpl empty constructor
	 */
	public LoginDaoImpl() {
	}
	/**
	 * LoginDaoImpl constructor for mocking.
	 * @param dbConMock mocks DataBase connection.
	 * @param propMock mocks PropertyResource.
	 * @param connectionMock mocks Connection.
	 * @param statementMock mocks Statement.
	 * @param rsMock mocks ResultSet.
	 */
	public LoginDaoImpl(DbConnection dbConMock, PropertyResource dataPropMock,Connection connectionMock, PreparedStatement prepStatementMock, ResultSet rsMock) {	
		this.dbCon = dbConMock;
		this.connection = connectionMock;
		this.propResource = dataPropMock;
		this.prepStatement = prepStatementMock;
		this.rs = rsMock;
	}
	/**
	 * LoginDaoImpl method decodes the password.
	 * @param String Password.
	 */
	public String deCodePassword(String PasswordInDb) {
		byte[] decodedBytes = Base64.getDecoder().decode(PasswordInDb);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
	/**
	 * addLoginServiceDetails method fires and sql query
	 * @return String message
	 */
	public String addLoginServiceDetails(String userName, String password){	
		try {
			String query = propResource.getDatabaseProperties("QUERY_LOGIN");
			prepStatement = connection.prepareStatement(query);
			prepStatement.setString(1, userName);
			rs = prepStatement.executeQuery();
			if(rs.next()) {
			String original = rs.getString("password");
			if(password.equals(deCodePassword(original))) {
				message = "Successfully logged in ";
			}else {
				message = "Enter correct password ";	
			}
			} else {
				message  = "User not found ";	
			}
		} catch (SQLException e) {		
			e.getCause();	
		}
		return message;		
	}
}