package com.cerner.patient.management.system.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppHomePage {
	private static final Logger logger = LoggerFactory.getLogger(AppHomePage.class);
	public AppHomePage() {
	}
	public void AppHome() {
		Display display = Display.getDefault();
		Shell shlHomeForm = new Shell();
		Label lblHomeForm;
		Image bg_Image = new Image(display,
				"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/homeImg.jpg");
		shlHomeForm.setMinimumSize(new Point(1925, 1050));
		shlHomeForm.setSize(277, 505);
		shlHomeForm.setBounds(0, 0, 0, 0);
		shlHomeForm.setBackgroundImage(bg_Image);
		shlHomeForm.setBackgroundMode(SWT.INHERIT_FORCE);
		shlHomeForm.setFullScreen(true);
		shlHomeForm.setText("Welcome Home Page");
		shlHomeForm.setLayout(null);
		shlHomeForm.pack();
		Label lblLogoImage = new Label(shlHomeForm, SWT.NONE);
		lblLogoImage.setImage(new Image(display,
				"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/cernerLogo.png"));
		lblLogoImage.setBounds(800, 10, 432, 107);
		lblHomeForm = new Label(shlHomeForm, SWT.NONE);
		lblHomeForm.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblHomeForm.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblHomeForm.setBounds(613, 205, 822, 50);
		lblHomeForm.setText("APP FOR PATIENT RECORD MANAGEMENT SYSTEM");

		Label lblNewLabel = new Label(shlHomeForm, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(218, 125, 32));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD | SWT.ITALIC));
		lblNewLabel.setBounds(618, 320, 221, 37);
		lblNewLabel.setText("New Customers");

		Label lblByCreatingAn = new Label(shlHomeForm, SWT.NONE);
		lblByCreatingAn.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblByCreatingAn.setBounds(618, 383, 387, 117);
		lblByCreatingAn.setText(
				"By creating an account with our app, you \r\nwill be able to move through the checkout \r\nprocess faster, view and track your patients\r\nin your hospital and more.");

		Button registerbtn = new Button(shlHomeForm, SWT.PUSH);
		registerbtn.setBounds(618, 560, 152, 62);
		registerbtn.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		registerbtn.setText("REGISTER");
		registerbtn.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					logger.info("Register Button pressed");
					RegisterView regView = new RegisterView();				
					regView.Register();

				}
			}
		});

		Label lblLogin = new Label(shlHomeForm, SWT.NONE);
		lblLogin.setForeground(SWTResourceManager.getColor(153, 50, 204));
		lblLogin.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD | SWT.ITALIC));
		lblLogin.setBounds(1100, 320, 221, 37);
		lblLogin.setText("Registered User");

		Label lblByLogin = new Label(shlHomeForm, SWT.NONE);
		lblByLogin.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblByLogin.setBounds(1100, 383, 387, 117);
		lblByLogin.setText(
				"Welcome Back,\r\nIf you are an existing user with us to keep\r\nconnected with us please Login in with your\r\ncredentials.");
		Button loginbtn = new Button(shlHomeForm, SWT.NONE);
		loginbtn.setText("LOGIN");
		loginbtn.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		loginbtn.setBounds(1100, 560, 152, 62);
		loginbtn.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					logger.info("Login Button pressed");
					LoginView logView = new LoginView();
					logView.Login();
				}
			}
		});
		shlHomeForm.open();
		shlHomeForm.layout();
		while (!shlHomeForm.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}