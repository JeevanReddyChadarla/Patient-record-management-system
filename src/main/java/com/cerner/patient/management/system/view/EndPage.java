package com.cerner.patient.management.system.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;

public class EndPage {

		public void Logout() {
			Display display =  Display.getDefault();
			Shell shlSelectionForm = new Shell();
			shlSelectionForm.setBackground(SWTResourceManager.getColor(255, 250, 250));
			
			shlSelectionForm.setMinimumSize(new Point(1925, 1050));
			shlSelectionForm.setSize(800, 656);
			shlSelectionForm.setBounds(0, 0, 0, 0);

			shlSelectionForm.setText("Successfully Logged out");

			shlSelectionForm.pack();

			shlSelectionForm.setLayout(null);
		
			
			Label lblLogoImage = new Label(shlSelectionForm, SWT.NONE);
			lblLogoImage.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/cernerLogo.png"));
			lblLogoImage.setBounds(700, 10, 432, 107);
			
			
			
			Label lblSuccessfullyLoggedOut = new Label(shlSelectionForm, SWT.NONE);
			lblSuccessfullyLoggedOut.setForeground(SWTResourceManager.getColor(255, 165, 0));
			lblSuccessfullyLoggedOut.setBackground(SWTResourceManager.getColor(255,250,250));
			lblSuccessfullyLoggedOut.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.ITALIC));
			lblSuccessfullyLoggedOut.setBounds(690, 240, 508, 51);
			lblSuccessfullyLoggedOut.setText("You have, Successfully Logged out...");
			
			Label lblImageThankyou = new Label(shlSelectionForm, SWT.NONE);
			lblImageThankyou.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/thanks.png"));	
			lblImageThankyou.setBounds(850, 320, 130, 140);
			
			Label lblThankYouUser = new Label(shlSelectionForm, SWT.NONE);
			lblThankYouUser.setForeground(SWTResourceManager.getColor(0, 0, 139));
			lblThankYouUser.setBackground(SWTResourceManager.getColor(255,250,250));
			lblThankYouUser.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD | SWT.ITALIC));
			lblThankYouUser.setBounds(487, 483, 965, 51);
			lblThankYouUser.setText("Thank you, for using Patient Record Management System App");
		
			Label lblVisitAgain = new Label(shlSelectionForm, SWT.NONE);
			lblVisitAgain.setForeground(SWTResourceManager.getColor(75,184,239));
			lblVisitAgain.setBackground(SWTResourceManager.getColor(255,250,250));
			lblVisitAgain.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.ITALIC));
			lblVisitAgain.setBounds(851, 572, 175, 51);
			lblVisitAgain.setText("Visit Again.");


			shlSelectionForm.open();
			shlSelectionForm.layout();

			while (!shlSelectionForm.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}

		}
	}
