package com.cerner.patient.management.system.service;
import com.cerner.patient.management.system.dao.RegisterDaoImpl;
import java.util.Base64;
import com.cerner.patient.management.system.dao.RegisterDao;
public class RegisterViewServiceImpl implements RegisterViewService{
	RegisterDao rDao = new RegisterDaoImpl();
	/**
	 * Default empty Constructor for class RegisterViewServiceImpl
	 */
	public RegisterViewServiceImpl() {
	}
	/**
	 * Parameterized constructor mocking for class RegisterViewServiceImpl 
	 * @param RegisterViewServiceImpl that will be set to this RegisterDao instance
	 */
	public RegisterViewServiceImpl(RegisterDaoImpl rDaoMock) {
		this.rDao = rDaoMock;
	}
	/**
	 * encodePass method accept one parameters
	 * @param password
	 * @return String Base64 encrypted 
	 */
	public String encodePass(String pass) {
		return Base64.getEncoder().encodeToString(pass.getBytes());
	}
	/**
	 * addLoginDetails method accept two parameters
	 * @param user name
	 * @param password
	 * @param phone number
	 * @return String message from RegisterDaoImpl
	 */
	public String addRegisterDetails(String userName, String password, String phoneNumber) {
		String encodedPassword = encodePass(password);	
		String msg = rDao.addRegisterServiceDetails(userName, encodedPassword, phoneNumber);
		return msg;
	}	
}