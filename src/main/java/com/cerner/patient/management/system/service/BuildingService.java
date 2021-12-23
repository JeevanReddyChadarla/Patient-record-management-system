package com.cerner.patient.management.system.service;
import java.util.List;
/**
 * The interface which is implemented in BuildingServiceImpl
 * fetchAllBuildings method fetches all the buildings
 * @return List of Buildings
 */
public interface BuildingService {
	public List<String> fetchAllBuildings();
}
