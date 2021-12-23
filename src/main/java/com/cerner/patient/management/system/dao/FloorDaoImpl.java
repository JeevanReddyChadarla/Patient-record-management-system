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
 * The FloorDaoImpl implementation class has getFloorOnSelectedBuilding method.
 * @returns a list of floors.
 */
public class FloorDaoImpl implements FloorDao{
	DbConnection dbCon = new DbConnection();
	PropertyResource prop = new PropertyResource();
	Connection connection = dbCon.getDataBaseConnection();
	Statement statement = null;
	PreparedStatement prepStatement;
	ResultSet rs;
	/**
	 * FloorDaoImpl empty constructor
	 */
	public FloorDaoImpl() {	
	}
	/**
	 * FloorDaoImpl constructor for mocking.
	 * @param dbConMock mocks DataBase connection.
	 * @param propMock mocks PropertyResource.
	 * @param connectionMock mocks Connection.
	 * @param statementMock mocks Statement.
	 * @param rsMock mocks ResultSet.
	 */
	public FloorDaoImpl(DbConnection dbConMock, PropertyResource propMock, Connection connectionMock, Statement statementMock, PreparedStatement prepStateMock,ResultSet rsMock) {
		this.dbCon = dbConMock;
		this.prop = propMock;
		this.connection = connectionMock;
		this.statement = statementMock;
		this.prepStatement = prepStateMock;
		this.rs = rsMock;
	}
	/**
	 * getFloorOnSelectedBuilding fires and sql query and fetches all the floors on selected building
	 * @return List of floors present in the database
	 */
	public List<String> getFloorOnSelectedBuilding(String selectedBuilding) {	
		List<String> allFloorsForSelectedBuilding = new ArrayList<String>();
		try {		
			String query =prop.getDatabaseProperties("QUERY_FLOOR") + "'"+selectedBuilding+"'";
			statement = connection.createStatement();
			prepStatement = connection.prepareStatement(query);
			rs = prepStatement.executeQuery();
			while (rs.next()) {
				allFloorsForSelectedBuilding.add(rs.getString("floor_name"));
			}
		} catch (Exception p) {
			p.getCause();
		}
		return allFloorsForSelectedBuilding;
	}
}