package com.cerner.patient.management.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cerner.patient.management.system.dao.LoginDao;
import com.cerner.patient.management.system.dao.LoginDaoImpl;
import com.cerner.patient.management.system.utils.DbConnection;
import com.cerner.patient.management.system.utils.PropertyResource;

public class LoginDaoImplTest {
	private static DbConnection dbConnMock;
	private static PropertyResource propResMock;
	private static Connection connMock;
	//private static String queryMock;
	private static PreparedStatement prepMock;
	private static ResultSet rsMock;
	
	public String deCodePassword(String PasswordInDb) {
		byte[] decodedBytes = Base64.getDecoder().decode(PasswordInDb);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
	
	@BeforeAll
	public static void setUp() {
		dbConnMock = mock(DbConnection.class);
		propResMock = mock(PropertyResource.class);
		connMock = mock(Connection.class);
		prepMock = mock(PreparedStatement.class);
		rsMock = mock(ResultSet.class);
	}
	@Test
	public void testLoginDaoImpl() throws SQLException {
		
		LoginDao logDao = new LoginDaoImpl(dbConnMock,propResMock,connMock,prepMock, rsMock);
		when(dbConnMock.getDataBaseConnection()).thenReturn(connMock);
		when(propResMock.getDatabaseProperties(Mockito.anyString())).thenReturn("");
		when(connMock.prepareStatement(Mockito.anyString())).thenReturn(prepMock);
		doNothing().when(prepMock).setString(Mockito.anyInt(), Mockito.anyString());
		when(prepMock.executeQuery()).thenReturn(rsMock);
		when(rsMock.next()).thenReturn(true).thenReturn(false);
		when(rsMock.getString(Mockito.anyString())).thenReturn("password");
		
		String msg = logDao.addLoginServiceDetails("UserName", deCodePassword("password"));
		
		assertEquals("Successfully logged in ", msg);
	}
	@Test
	public void testPasswordLoginDaoImpl() throws SQLException {
		
		LoginDao logDao = new LoginDaoImpl(dbConnMock,propResMock,connMock,prepMock, rsMock);
		when(dbConnMock.getDataBaseConnection()).thenReturn(connMock);
		when(propResMock.getDatabaseProperties(Mockito.anyString())).thenReturn("");
		when(connMock.prepareStatement(Mockito.anyString())).thenReturn(prepMock);
		doNothing().when(prepMock).setString(Mockito.anyInt(), Mockito.anyString());
		when(prepMock.executeQuery()).thenReturn(rsMock);
		when(rsMock.next()).thenReturn(true).thenReturn(false);
		when(rsMock.getString(Mockito.anyString())).thenReturn("password");
		
		String msg = logDao.addLoginServiceDetails("UserName", "password123");
		
		assertEquals("Enter correct password ", msg);
	}
}

