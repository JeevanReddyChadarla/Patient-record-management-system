package com.cerner.patient.management.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cerner.patient.management.system.dao.LoginDaoImpl;
import com.cerner.patient.management.system.dao.RegisterDaoImpl;
import com.cerner.patient.management.system.service.LoginViewServiceImpl;
import com.cerner.patient.management.system.service.RegisterViewServiceImpl;


class RegisterServiceTest {
	
//	@InjectMocks
//	BuildingServiceImpl buildSerImpl;
	     

	@Test
	public void testToRegisterUser() {
		RegisterDaoImpl registerDaoImpl = mock( RegisterDaoImpl.class);
		
		String registerDetailsDao = "User added successfully";
		
		when(registerDaoImpl.addRegisterServiceDetails(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(registerDetailsDao);
		
		RegisterViewServiceImpl registerSer  = new RegisterViewServiceImpl(registerDaoImpl);
		
		String registerDetailsSer = registerSer.addRegisterDetails("jeevanchadarla","jeevan123","9750354126");
	
		assertEquals("User added successfully", registerDetailsSer);
	}

}