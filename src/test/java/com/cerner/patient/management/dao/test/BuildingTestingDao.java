package com.cerner.patient.management.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cerner.patient.management.system.dao.BuildingDao;
import com.cerner.patient.management.system.dao.BuildingDaoImpl;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;

public class BuildingTestingDao {
	
	private static DbConnection dbConnMock;
	private static PropertyResource propResMock;
	private static Connection connMock;
	private static Statement stateMock;
	private static ResultSet rsMock;
	
	
	@BeforeAll
	public static void setUp() {
		dbConnMock = mock(DbConnection.class);
		propResMock = mock(PropertyResource.class);
		connMock = mock(Connection.class);
		stateMock = mock(Statement.class);
		rsMock = mock(ResultSet.class);
		
	}
	@Test
	public void testBuildingDao() throws SQLException {
		
		BuildingDao build = new BuildingDaoImpl(dbConnMock,propResMock, connMock,stateMock,rsMock);
		
		when(dbConnMock.getDataBaseConnection()).thenReturn(connMock);
		when(propResMock.getDatabaseProperties(Mockito.anyString())).thenReturn("J1");	
		when(connMock.createStatement()).thenReturn(stateMock);
		when(stateMock.executeQuery(Mockito.anyString())).thenReturn(rsMock);
		when(rsMock.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		when(rsMock.getString(Mockito.anyString())).thenReturn("SampleBuildingOne");
		
		List<String> mockedBuildingList = new ArrayList<String>();
		mockedBuildingList.add("SampleBuildingOne");
		
		List<String> actualListFromDb = build.getAllBuildings();
		
		assertEquals(mockedBuildingList.get(0), actualListFromDb.get(0));
		
	}
}
