package com.cerner.patient.management.system.dao;
/**
 * @author CJ094392
 * The LoginDao has Interface has all the abstract methods.
 * addLoginServiceDetails method accepts two parameters user name and password
 */
public interface LoginDao {
	public String addLoginServiceDetails(String userName, String password);
}
