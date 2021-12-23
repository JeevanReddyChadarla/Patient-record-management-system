package com.cerner.patient.management.system.service;
import java.util.List;
import com.cerner.patient.management.system.dao.RoomDao;
import com.cerner.patient.management.system.dao.RoomDaoImpl;
public class RoomServiceImpl implements RoomService{
	RoomDao rDao = new RoomDaoImpl();
	/**
	 * Default empty Constructor for class RoomServiceImpl
	 */
	public RoomServiceImpl() {	
	}
	/**
	 * Parameterized constructor mocking for class RoomServiceImpl 
	 * @param roomDaoImplMock that will be set to this roomDao instance
	 */
	public RoomServiceImpl(RoomDaoImpl roomDaoImplMock) {
		this.rDao = roomDaoImplMock;
	}
	/**
	 * getRoomsOnSelectedFloors method accept a selected floor parameter
	 * @return List of rooms
	 */
	public List<String> getRoomsOnSelectedFloors(String selectedFloor) {	
		return rDao.getRoomsOnSelectedFloors(selectedFloor);
	}
}
