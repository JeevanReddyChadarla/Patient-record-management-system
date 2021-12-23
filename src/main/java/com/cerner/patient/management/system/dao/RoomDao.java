package com.cerner.patient.management.system.dao;
import java.util.List;
/**
 * @author CJ094392
 * The RoomDao interface has getRoomsOnSelectedFloors method.
 * getRoomsOnSelectedFloors method accepts a floor name parameter.
 * returns all the rooms present in the selected floor.
 */
public interface RoomDao {
	public List<String> getRoomsOnSelectedFloors(String selectedFloor);	
}
