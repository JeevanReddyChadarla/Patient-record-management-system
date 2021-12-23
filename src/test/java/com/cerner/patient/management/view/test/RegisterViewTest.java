package com.cerner.patient.management.view.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.cerner.patient.management.system.view.RegisterView;

public class RegisterViewTest {
	RegisterView regView = new RegisterView();
	@Test
	public void testRegisterViewPhoneNumber() {
		
	   
			regView.setUserName("Hari");
			regView.setUserPassword("root");
			regView.setUserPhoneNo("1234567890");

				String phoneNumber = regView.getUserPhoneNo();
				boolean expectedValue = regView.isNumeric(phoneNumber);
				assertEquals(true, expectedValue);
		    }
	@Test
	public void testRegisterViewPhoneNo() {
		
	   
			regView.setUserName("Hari");
			regView.setUserPassword("root");
			regView.setUserPhoneNo("123pqrs");

				String phoneNumber = regView.getUserPhoneNo();
				boolean expectedValue = regView.isNumeric(phoneNumber);
				assertEquals(false, expectedValue);
		    }
	}

