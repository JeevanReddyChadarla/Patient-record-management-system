package com.cerner.patient.management.system.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;
/**
 * @author CJ094392
 * The BuildingDaoImpl implementation class has getAllBuildings method.
 * @returns a list of buildings.
 */
public class BuildingDaoImpl implements BuildingDao {
	DbConnection dbCon = new DbConnection();
	PropertyResource prop = new PropertyResource();
	Connection connection = dbCon.getDataBaseConnection();
	Statement statement = null;
	ResultSet rs;
	/**
	 * BuildingDaoImpl empty constructor
	 */
	public BuildingDaoImpl() {	
	}
	/**
	 * BuildingDaoImpl constructor for mocking.
	 * @param dbConMock mocks DataBase connection.
	 * @param propMock mocks PropertyResource.
	 * @param connectionMock mocks Connection.
	 * @param statementMock mocks Statement.
	 * @param rsMock mocks ResultSet.
	 */
	public BuildingDaoImpl(DbConnection dbConMock, PropertyResource propMock, Connection connectionMock, Statement statementMock, ResultSet rsMock) {
		this.dbCon = dbConMock;
		this.prop = propMock;
		this.connection = connectionMock;
		this.statement = statementMock;
		this.rs = rsMock;
	}
	/**
	 * getAllBuildings fires and sql query and fetches all the building data in database
	 * @return List of buildings present in the database
	 */
	public List<String> getAllBuildings() {
		List<String> allBuildings = new ArrayList<String>();
		try {
			String query = prop.getDatabaseProperties("QUERY_BUILDING");
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				allBuildings.add(rs.getString("building_name"));
			}
		} 
		catch (Exception p) {
			p.getCause();
		}
		return allBuildings;
	}
}