package com.cerner.patient.management.system.service;
/**
 * The interface which is implemented in RegisterViewServiceImpl
 * addRegisterDetails method accept a user name, password and phone number from user interface
 */
public interface RegisterViewService {
	public String addRegisterDetails(String userName, String password, String phoneNumber);
}
