package com.cerner.patient.management.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cerner.patient.management.system.dao.LoginDaoImpl;
import com.cerner.patient.management.system.service.LoginViewServiceImpl;


class LoginServiceTest {
	
//	@InjectMocks
//	BuildingServiceImpl buildSerImpl;
	     

	@Test
	public void testUserLogin() {
		LoginDaoImpl loginDaoImpl = mock( LoginDaoImpl.class);
		
		String loginDetailsDao = "Successfully logged in ";
		
		when(loginDaoImpl.addLoginServiceDetails(Mockito.anyString(), Mockito.anyString())).thenReturn(loginDetailsDao);
		
		LoginViewServiceImpl loginSer  = new LoginViewServiceImpl(loginDaoImpl);
		
		String loginDetailsSer = loginSer.addLoginDetails("jeevan","jeevan123");
		
		System.out.println(loginDetailsSer);
		assertEquals("Successfully logged in ", loginDetailsSer);
	}

}