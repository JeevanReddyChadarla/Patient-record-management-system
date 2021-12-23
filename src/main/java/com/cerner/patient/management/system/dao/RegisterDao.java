package com.cerner.patient.management.system.dao;
/**
 * @author CJ094392
 * The RegisterDao has Interface has all the abstract methods.
 * addRegisterServiceDetails method accepts two parameters user name, password and phone number
 */
public interface RegisterDao {
	public String addRegisterServiceDetails(String userName, String password, String phoneNumber);
}