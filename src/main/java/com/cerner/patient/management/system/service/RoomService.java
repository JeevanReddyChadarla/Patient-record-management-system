package com.cerner.patient.management.system.service;
import java.util.List;
/**
 * The interface which is implemented in RoomServiceImpl
 * getRoomsOnSelectedFloors method accept a selected floor parameter
 * @return List of rooms
 */
public interface RoomService {
	public List<String> getRoomsOnSelectedFloors(String selectedFloor);
}