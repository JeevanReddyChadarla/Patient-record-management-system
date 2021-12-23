package com.cerner.patient.management.system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;
/**
 * @author CJ094392
 * The PatientDetailsDaoImpl implementation class has getAllPatientsInRoom method.
 * @returns a list of floors.
 */
public class PatientDetailsDaoImpl implements PatientDetailsDao{
	DbConnection dbCon = new DbConnection();
	PropertyResource prop = new PropertyResource();
	Connection connection = dbCon.getDataBaseConnection();
	Statement statement = null;
	PreparedStatement prepStatement;
	ResultSet rs;
	/**
	 * FloorDaoImpl empty constructor
	 */
	public PatientDetailsDaoImpl() {	
	}
	/**
	 * PatientDetailsDaoImpl constructor for mocking.
	 * @param dbConMock mocks DataBase connection.
	 * @param propMock mocks PropertyResource.
	 * @param connectionMock mocks Connection.
	 * @param statementMock mocks Statement.
	 * @param prepStateMock mocks PreparedStatement.
	 * @param rsMock mocks ResultSet.
	 */
	public PatientDetailsDaoImpl(DbConnection dbConMock, PropertyResource propMock, Connection connectionMock, Statement statementMock, PreparedStatement prepStateMock,ResultSet rsMock) {
		this.dbCon = dbConMock;
		this.prop = propMock;
		this.connection = connectionMock;
		this.statement = statementMock;
		this.prepStatement = prepStateMock;
		this.rs = rsMock;
	}
	/**
	 * getAllPatientsInRoom fires and sql query and fetches all the patients on selected room
	 * @return List of patients present in the database
	 */
	public List<String> getAllPatientsInRoom(String selectedRoom) {
		List<String> allPatientsForSelectedRoom = new ArrayList<String>();
		try {
			String query = prop.getDatabaseProperties("QUERY_PATIENT") +"'"+ selectedRoom+"'";
			statement = connection.createStatement();
			prepStatement = connection.prepareStatement(query);
			rs = prepStatement.executeQuery();
			while (rs.next()) {
				allPatientsForSelectedRoom.add(rs.getString("patient_id"));
				allPatientsForSelectedRoom.add(rs.getString("patient_name"));
				allPatientsForSelectedRoom.add(rs.getString("patient_gender"));
				allPatientsForSelectedRoom.add(rs.getString("patient_age"));
				allPatientsForSelectedRoom.add(rs.getString("room_name"));	
			}
		} catch (Exception p) {
			p.getCause();
		}
		return allPatientsForSelectedRoom;
	}
}