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
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cerner.patient.management.system.dao.PatientDetailsDao;
import com.cerner.patient.management.system.dao.PatientDetailsDaoImpl;
import com.cerner.patient.management.system.dao.RoomDao;
import com.cerner.patient.management.system.dao.RoomDaoImpl;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;

public class PatientDetailsDaoImplTest {
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
	public void testPatientDetailsDaoImpl() throws SQLException {
		
		PatientDetailsDao patient = new PatientDetailsDaoImpl(dbConnMock,propResMock, connMock,stateMock,prepStateMock,rsMock);
		
		when(dbConnMock.getDataBaseConnection()).thenReturn(connMock);
		when(propResMock.getDatabaseProperties(Mockito.anyString())).thenReturn("SamplePatientDetailsOne");	
		when(connMock.createStatement()).thenReturn(stateMock);
		when(connMock.prepareStatement(Mockito.anyString())).thenReturn(prepStateMock);
		when(prepStateMock.executeQuery()).thenReturn(rsMock);
		when(rsMock.next()).thenReturn(true).thenReturn(false);
		when(rsMock.getString(Mockito.anyString())).thenReturn("SamplePatientDetailsOne");

		List<String> mockedPatientList = new ArrayList<String>();
		mockedPatientList.add("SamplePatientDetailsOne");
		
		List<String> actualRoomListFromDb = patient.getAllPatientsInRoom("");
		
		
		assertEquals(mockedPatientList.get(0), actualRoomListFromDb.get(0));
				
	}
}
