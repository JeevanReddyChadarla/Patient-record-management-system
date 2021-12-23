package com.cerner.patient.management.system.service;
import com.cerner.patient.management.system.dao.LoginDao;
import com.cerner.patient.management.system.dao.LoginDaoImpl;
public class LoginViewServiceImpl implements LoginViewService{
	LoginDao lDao = new LoginDaoImpl();
	/**
	 * Default empty Constructor for class LoginViewServiceImpl
	 */
	public LoginViewServiceImpl() {	
	}
	/**
	 * Parameterized constructor mocking for class LoginViewServiceImpl 
	 * @param LoginViewServiceImpl that will be set to this LoginDao instance
	 */
	public LoginViewServiceImpl(LoginDaoImpl loginMock) {
		this.lDao = loginMock;
	}
	/**
	 * addLoginDetails method accept two parameters
	 * @param user name
	 * @param password
	 * @return String message form LoginDaoImpl
	 */
	public String addLoginDetails(String userName, String password) {
		String msg = lDao.addLoginServiceDetails(userName, password);
		return msg;
	}
}