package com.cerner.patient.management.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cerner.patient.management.system.dao.BuildingDao;
import com.cerner.patient.management.system.dao.BuildingDaoImpl;
import com.cerner.patient.management.system.dao.FloorDao;
import com.cerner.patient.management.system.dao.FloorDaoImpl;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;

public class FloorDaoImplTest {
	
	private static DbConnection dbConnMock;
	private static PropertyResource propResMock;
	private static Connection connMock;
	private static Statement stateMock;
	private static PreparedStatement prepStateMock;
	private static ResultSet rsMock;
	
	@BeforeAll
	public static void setUp() {
		dbConnMock = mock(DbConnection.class);
		propResMock = mock(PropertyResource.class);
		connMock = mock(Connection.class);
		stateMock = mock(Statement.class);
		prepStateMock = mock(PreparedStatement.class);
		rsMock = mock(ResultSet.class);
		
	}

	@Test
	public void testFloorDaoImpl() throws SQLException {
		
		FloorDao floor = new FloorDaoImpl(dbConnMock,propResMock, connMock,stateMock,prepStateMock,rsMock);
		
		when(dbConnMock.getDataBaseConnection()).thenReturn(connMock);
		when(propResMock.getDatabaseProperties(Mockito.anyString())).thenReturn("SampleSelectedBuilding");	
		when(connMock.createStatement()).thenReturn(stateMock);
		when(connMock.prepareStatement(Mockito.anyString())).thenReturn(prepStateMock);
		when(prepStateMock.executeQuery()).thenReturn(rsMock);
		when(rsMock.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		when(rsMock.getString(Mockito.anyString())).thenReturn("SampleFloorOne");

		List<String> mockedFloorList = new ArrayList<String>();
		mockedFloorList.add("SampleFloorOne");
		
		List<String> actualFloorListFromDb = floor.getFloorOnSelectedBuilding("");
		
		
		assertEquals(mockedFloorList.get(0), actualFloorListFromDb.get(0));
				
	}
}
