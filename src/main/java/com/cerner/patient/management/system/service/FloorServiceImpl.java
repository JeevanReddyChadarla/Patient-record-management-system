package com.cerner.patient.management.system.service;
import java.util.List;
import com.cerner.patient.management.system.dao.FloorDao;
import com.cerner.patient.management.system.dao.FloorDaoImpl;
/**
 * @author CJ094392
 *
 */
public class FloorServiceImpl implements FloorService{
	FloorDao floorDao = new FloorDaoImpl();
	/**
	 * Default empty Constructor for class FloorServiceImpl
	 */
	public FloorServiceImpl() {	
	}
	/**
	 * Parameterized constructor mocking for class FloorServiceImpl 
	 * @param floorDaoImplMock that will be set to this floorDao instance
	 */
	public FloorServiceImpl(FloorDaoImpl floorDaoImplMock) {
		this.floorDao = floorDaoImplMock;
	} 
	/**
	 * getFloorOnSelectedBuilding method accept a selected building parameter
	 * @return List of floors
	 */
	public List<String> getFloorOnSelectedBuilding(String selectedBuilding){
		return floorDao.getFloorOnSelectedBuilding(selectedBuilding);
	}
}