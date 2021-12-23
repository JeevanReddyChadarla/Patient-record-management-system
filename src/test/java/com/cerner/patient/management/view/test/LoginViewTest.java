package com.cerner.patient.management.view.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.cerner.patient.management.system.view.LoginView;

public class LoginViewTest {
	LoginView loginView = new LoginView();
	
	@Test
    public void testLoginViewUserName() {

		loginView.setLoginUserName("");
		loginView.setLoginUserPassword("root");
				
		boolean expectedValue = loginView.validateLoginDetails();
		assertEquals(false, expectedValue);
    }
	
	@Test
    public void testLoginViewDetails() {

		loginView.setLoginUserName("");
		loginView.setLoginUserPassword("");
				
		boolean expectedValue = loginView.validateLoginDetails();
		assertEquals(false, expectedValue);
    }
}
