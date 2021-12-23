package com.cerner.patient.management.system.dao;
import java.util.List;
/**
 * @author CJ094392
 * The FloorDao interface has getFloorOnSelectedBuilding method.
 * getFloorOnSelectedBuilding method accepts a building name parameter
 * returns all the floors present in the selected building
 */
public interface FloorDao {
	public List<String> getFloorOnSelectedBuilding(String selectedBuilding);
}
