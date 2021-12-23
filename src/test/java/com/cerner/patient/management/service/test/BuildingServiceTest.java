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
import com.cerner.patient.management.system.dao.LoginDaoImpl;
import com.cerner.patient.management.system.service.BuildingServiceImpl;
import com.cerner.patient.management.system.service.LoginViewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class BuildingServiceTest {
	
//	@InjectMocks
//	BuildingServiceImpl buildSerImpl;
	     

	@Test
	public void testFetchBuildings() {
		BuildingDaoImpl buildDaoImplMock = mock( BuildingDaoImpl.class);
		
		List<String>AllBuild = Arrays.asList("Jeevan","Chadarla");
		
		when(buildDaoImplMock.getAllBuildings()).thenReturn(AllBuild);
		
		BuildingServiceImpl buildSer  = new BuildingServiceImpl(buildDaoImplMock);
		
		List<String>AllBuildSer = buildSer.fetchAllBuildings();
		
		assertEquals(AllBuild.get(0), AllBuildSer.get(0));
	}

}