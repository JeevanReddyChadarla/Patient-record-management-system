package com.cerner.patient.management.system.service;
import java.util.List;
/**
 * The interface which is implemented in PatientDetailsServiceImpl
 * getAllPatientsInRoom method accept a selected room parameter
 * @return List of patient details
 */
public interface PatientDetailsService {
	public List<String> getAllPatientsInRoom(String selectedRoom);
}