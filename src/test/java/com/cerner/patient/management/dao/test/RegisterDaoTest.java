package com.cerner.patient.management.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cerner.patient.management.system.dao.RegisterDao;
import com.cerner.patient.management.system.dao.RegisterDaoImpl;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;

public class RegisterDaoTest {
	
	private static DbConnection dbConnMock;
	private static PropertyResource propResMock;
	private static Connection connMock;
	//private static String queryMock;
	private static PreparedStatement prepMock;
	
	@BeforeAll
	public static void setUp() {
		dbConnMock = mock(DbConnection.class);
		propResMock = mock(PropertyResource.class);
		connMock = mock(Connection.class);
//		queryMock = "Sample query";
		prepMock = mock(PreparedStatement.class);
		
	}
	@Test
	public void testRegDaoImpl() throws SQLException {
		
		RegisterDao rDao = new RegisterDaoImpl(dbConnMock,propResMock,connMock,prepMock);
		when(dbConnMock.getDataBaseConnection()).thenReturn(connMock);
		when(propResMock.getDatabaseProperties(Mockito.anyString())).thenReturn("");
		when(connMock.prepareStatement(Mockito.anyString())).thenReturn(prepMock);
		doNothing().when(prepMock).setString(Mockito.anyInt(), Mockito.anyString());
		when(prepMock.executeUpdate()).thenReturn(1);
		
		String msg = rDao.addRegisterServiceDetails("AKHILLLLLLLLLLLL", "jeevan", "99999");
		
		assertEquals("User added successfully", msg);
	}

}











