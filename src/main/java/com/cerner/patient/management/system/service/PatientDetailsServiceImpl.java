package com.cerner.patient.management.system.service;
import java.util.List;
import com.cerner.patient.management.system.dao.PatientDetailsDao;
import com.cerner.patient.management.system.dao.PatientDetailsDaoImpl;
public class PatientDetailsServiceImpl implements PatientDetailsService{
	PatientDetailsDao patDetails = new PatientDetailsDaoImpl();
	/**
	 * Default empty Constructor for class PatientDetailsServiceImpl
	 */
	public PatientDetailsServiceImpl() {
	}
	/**
	 * Parameterized constructor mocking for class PatientDetailsServiceImpl 
	 * @param PatientDetailsServiceImpl that will be set to this patients details instance
	 */
	public PatientDetailsServiceImpl(PatientDetailsDaoImpl patientDetailsDaoImplMock) {
		this.patDetails = patientDetailsDaoImplMock;
	}
	/**
	 * getAllPatientsInRoom method accept a selected room parameter
	 * @return List of patients details
	 */
	public List<String> getAllPatientsInRoom(String selectedRoom) {	
		return patDetails.getAllPatientsInRoom(selectedRoom);
	}
}