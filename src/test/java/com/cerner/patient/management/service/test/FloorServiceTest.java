package com.cerner.patient.management.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cerner.patient.management.system.dao.BuildingDao;
import com.cerner.patient.management.system.dao.BuildingDaoImpl;
import com.cerner.patient.management.system.dao.FloorDaoImpl;
import com.cerner.patient.management.system.dao.LoginDaoImpl;
import com.cerner.patient.management.system.service.BuildingServiceImpl;
import com.cerner.patient.management.system.service.FloorServiceImpl;
import com.cerner.patient.management.system.service.LoginViewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class FloorServiceTest {
	
//	@InjectMocks
//	BuildingServiceImpl buildSerImpl;
	     

	@Test
	public void testFetchFloors() {
		FloorDaoImpl floorDaoImplMock = mock( FloorDaoImpl.class);
		
		List<String>AllFloor = Arrays.asList("FloorOne","FloorTwo");
		
		when(floorDaoImplMock.getFloorOnSelectedBuilding(Mockito.anyString())).thenReturn(AllFloor);
		
		FloorServiceImpl floorSer  = new FloorServiceImpl(floorDaoImplMock);
		
		List<String>AllBuildSer = floorSer.getFloorOnSelectedBuilding("");
		
		assertEquals(AllFloor.get(0), AllBuildSer.get(0));
	}

}