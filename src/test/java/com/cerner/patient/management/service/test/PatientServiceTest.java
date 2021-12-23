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
import com.cerner.patient.management.system.dao.PatientDetailsDaoImpl;
import com.cerner.patient.management.system.dao.LoginDaoImpl;
import com.cerner.patient.management.system.service.BuildingServiceImpl;
import com.cerner.patient.management.system.service.RoomServiceImpl;
import com.cerner.patient.management.system.service.LoginViewServiceImpl;
import com.cerner.patient.management.system.service.PatientDetailsServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class PatientServiceTest {
	
//	@InjectMocks
//	BuildingServiceImpl buildSerImpl;
	     

	@Test
	public void testFetchPatients() {
		PatientDetailsDaoImpl patientDetailsDaoImpl = mock( PatientDetailsDaoImpl.class);
		
		List<String>AllPatients = Arrays.asList("PatientOne","PatientTwo");
		
		when(patientDetailsDaoImpl.getAllPatientsInRoom(Mockito.anyString())).thenReturn(AllPatients);
		
		PatientDetailsServiceImpl patientSer  = new PatientDetailsServiceImpl(patientDetailsDaoImpl);
		
		List<String>AllPatientsSer = patientSer.getAllPatientsInRoom("");
		
		assertEquals(AllPatients.get(0), AllPatientsSer.get(0));
	}

}


