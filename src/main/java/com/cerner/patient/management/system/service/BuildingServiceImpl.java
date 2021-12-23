package com.cerner.patient.management.system.service;
import java.util.List;
import com.cerner.patient.management.system.dao.BuildingDao;
import com.cerner.patient.management.system.dao.BuildingDaoImpl;
/**
 * @author CJ094392
 *
 */
public class BuildingServiceImpl implements BuildingService{
	BuildingDao BuildDao = new BuildingDaoImpl();
	/**
	 * Default empty Constructor for class BuildingServiceImpl
	 */
	public BuildingServiceImpl() {	
	}
	/**
	 * Parameterized constructor mocking for class BuildingDaoImpl
	 * @param buildDaoImplMock that will be set to this buildingDao instance
	 */
	public BuildingServiceImpl(BuildingDaoImpl buildDaoImplMock) {
		this.BuildDao = buildDaoImplMock;
	}
	/**
	 * fetchAllBuildings method fetches all buildings
	 * @return List of Buildings
	 */
	public List<String> fetchAllBuildings(){
		return BuildDao.getAllBuildings();
	}
	}