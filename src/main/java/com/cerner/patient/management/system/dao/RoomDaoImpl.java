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
 * The RoomDaoImpl implementation class has getRoomsOnSelectedFloors method.
 * @returns a list of rooms.
 */
public class RoomDaoImpl implements RoomDao{
	
	DbConnection dbCon = new DbConnection();
	PropertyResource prop = new PropertyResource();
	Connection connection = dbCon.getDataBaseConnection();
	Statement statement = null;
	PreparedStatement prepStatement;
	ResultSet rs;	
	/**
	 * RoomDaoImpl empty constructor
	 */
	public RoomDaoImpl() {	
	}
	/**
	 * RoomDaoImpl constructor for mocking.
	 * @param dbConMock mocks DataBase connection.
	 * @param propMock mocks PropertyResource.
	 * @param connectionMock mocks Connection.
	 * @param statementMock mocks Statement.
	 * @param prepStateMock mocks PreparedStatement.
	 * @param rsMock mocks ResultSet.
	 */
	public RoomDaoImpl(DbConnection dbConMock, PropertyResource propMock, Connection connectionMock, Statement statementMock, PreparedStatement prepStateMock,ResultSet rsMock) {
		this.dbCon = dbConMock;
		this.prop = propMock;
		this.connection = connectionMock;
		this.statement = statementMock;
		this.prepStatement = prepStateMock;
		this.rs = rsMock;
	}	
	/**
	 * getRoomsOnSelectedFloors fires and sql query and fetches all the rooms on selected floor
	 * @return List of rooms present in the database
	 */

	public List<String> getRoomsOnSelectedFloors(String selectedFloor) {
		List<String> allRoomsForSelectedFloor = new ArrayList<String>();
		try {
			String query = prop.getDatabaseProperties("QUERY_ROOM") + "'"+selectedFloor+"'";
			statement = connection.createStatement();
			prepStatement = connection.prepareStatement(query);
			rs = prepStatement.executeQuery();
			while (rs.next()) {
				allRoomsForSelectedFloor.add(rs.getString("room_name"));
			}		

		} catch (Exception p) {
			p.printStackTrace();
		}
		return allRoomsForSelectedFloor;
	}
}