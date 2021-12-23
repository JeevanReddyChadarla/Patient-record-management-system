package com.cerner.patient.management.system.service;
import java.util.List;
/**
 * The interface which is implemented in FloorServiceImpl
 * getFloorOnSelectedBuilding method accept a selected building parameter
 * @return List of floors
 */
public interface FloorService {
	public List<String> getFloorOnSelectedBuilding(String selectedBuilding);
}
