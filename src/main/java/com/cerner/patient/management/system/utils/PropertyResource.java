package com.cerner.patient.management.system.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @author CJ094392
 * The PropertyResource class has getDatabaseProperties.
 * Provides connection between database and dao sql query.
 */
public class PropertyResource {
	/**
	 * PropertyResource empty constructor
	 */
	public PropertyResource() {
	}
	String filePath = "C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/src/main/resources/config.properties";
	Properties pros = new Properties();
	String dbValue;
	public String getDatabaseProperties(String dbProperty) {
		try (InputStream input = new FileInputStream(filePath)) {
			pros.load(input);
			dbValue = pros.getProperty(dbProperty);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dbValue;
	}
}