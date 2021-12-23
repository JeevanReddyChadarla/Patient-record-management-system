package com.cerner.patient.management.system.dao;
import java.util.List;
/**
 * @author CJ094392
 * The PatientDetailsDao interface has getAllPatientsInRoom method.
 * getAllPatientsInRoom method accepts a room name parameter
 * returns all the Patients present in the selected room
 */
public interface PatientDetailsDao {
	public List<String> getAllPatientsInRoom(String selectedRoom);
}
