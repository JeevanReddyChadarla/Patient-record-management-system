package com.cerner.patient.management.system.application;
import com.cerner.patient.management.system.view.AppHomePage;
public class App {	
	/**
	 * @author CJ094392
	 * The main method calls home page of the application
	 */
	public static void main(String[] args){		
		AppHomePage appHome = new AppHomePage();
		appHome.AppHome();
	}
}