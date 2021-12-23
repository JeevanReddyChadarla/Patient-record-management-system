package com.cerner.patient.management.system.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import com.cerner.patient.management.system.service.LoginViewService;
import com.cerner.patient.management.system.service.LoginViewServiceImpl;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CJ094392
 *
 */
public class LoginView {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginView.class);
	LoginViewService lService = new LoginViewServiceImpl();		
	Display display = Display.getDefault();
	Shell shlSelectionForm = new Shell(SWT.NONE);
	
	static int count = 0;
		public String loginUserName;
		public String loginUserPassword;
		
		private Text enterUserName;
		private Text enterPassword;
		
		/**
		 * @return user entered user name
		 */
		public String getLoginUserName() {
			return loginUserName;
		}


		public void setLoginUserName(String loginUserName) {
			this.loginUserName = loginUserName;
		}


		/**
		 * @return user entered password
		 */
		public String getLoginUserPassword() {
			return loginUserPassword;
		}


		public void setLoginUserPassword(String loginUserPassword) {
			this.loginUserPassword = loginUserPassword;
		}

		
		
			/**
			 * This method is validates user entered input fields 
			 * @return boolean
			 * true if user entered correct user name and password
			 * false in other all conditions
			 */
			public boolean validateLoginDetails() {
				if (loginUserName == "") {
					logger.info("Tried with empty user name");
					MessageBox messageBox = new MessageBox(shlSelectionForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setMessage("Enter the User Name");
					messageBox.open();
					
					return false;

				} else if (loginUserPassword == "") {
					logger.error(enterUserName.getText() +" has tried with empty password");
					MessageBox messageBox = new MessageBox(shlSelectionForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setMessage("Enter the Password");
					messageBox.open();	
					return false;
				} else {
					String messageBoxOp = lService.addLoginDetails(loginUserName, loginUserPassword);
					MessageBox messageBox = new MessageBox(shlSelectionForm, SWT.OK | SWT.CANCEL);
					logger.info(getLoginUserName()+" has "+messageBoxOp);
					messageBox.setText("Login Form");
					messageBox.setMessage(messageBoxOp +"  :  " +enterUserName.getText());
					enterUserName.setText("");
					enterPassword.setText("");
					messageBox.open();
					if(messageBoxOp == "Successfully logged in ") {	
						
						shlSelectionForm.close();	
						return true;
					}else {
						
						return false;
					}
				}
			}
			

		/**
		 * Login method for login page
		 * label lbllogin - header
		 * lblImageUser - user logo
		 * lblUserName - text user name label
		 * lblImagePassword - password logo
		 * lblPassword - text user password label
		 * enterUserName - text box to accept user entered input name
		 * enterPassword - text box to accept user entered input password
		 * loginUserName - on submit converts user enterUserName text to String
		 * loginUserpassword - on submit converts user enterPassword text to String
		 */
		public void Login() {
			
			shlSelectionForm.setMinimumSize(new Point(900, 800));
			shlSelectionForm.setSize(800, 656);
			shlSelectionForm.setBounds(600, 150, 0, 0);
			shlSelectionForm.setText("Select Fields");
			shlSelectionForm.pack();
			shlSelectionForm.setLayout(null);
			
			Label lbllogin = new Label(shlSelectionForm, SWT.NONE);
			lbllogin.setBackground(SWTResourceManager.getColor(21, 61, 112));
			lbllogin.setForeground(SWTResourceManager.getColor(255, 255, 255));
			lbllogin.setAlignment(SWT.CENTER);
			lbllogin.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
			lbllogin.setBounds(10, 28, 878, 95);
			lbllogin.setText("\r\nLogin in to Patient Record Management System");
			
			Label lblImageUser = new Label(shlSelectionForm, SWT.NONE);
			lblImageUser.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/icons8-user-50.png"));	
			lblImageUser.setBounds(110, 250, 50, 40);
			
			Label lblUserName = new Label(shlSelectionForm, SWT.NONE);
			lblUserName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
			lblUserName.setBounds(178, 256, 165, 35);
			lblUserName.setText("User Name : ");
			
			Label lblImagePassword = new Label(shlSelectionForm, SWT.NONE);
			lblImagePassword.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/icons8-password-50.png"));	
			lblImagePassword.setBounds(110, 370, 50, 50);
			
			Label lblPassword = new Label(shlSelectionForm, SWT.NONE);
			lblPassword.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
			lblPassword.setBounds(178, 383, 150, 35);
			lblPassword.setText("Password : ");
			
			enterUserName = new Text(shlSelectionForm, SWT.BORDER);
			enterUserName.setTextLimit(30);
			enterUserName.setText("");
			
			enterUserName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
			enterUserName.setBounds(362, 241, 292, 50);
			
			enterPassword = new Text(shlSelectionForm, SWT.BORDER | SWT.PASSWORD);
			enterPassword.setTextLimit(30);
			enterPassword.setText("");
			System.out.println(enterPassword.getEchoChar());
			enterPassword.setEchoChar('*');
			enterPassword.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
			enterPassword.setBounds(362, 378, 292, 50);
			
			 Button button = new Button(shlSelectionForm, SWT.PUSH);
			 button.setText(" Show ");
		       button.setBounds(662, 378, 52, 50);
		       
		       Label labelInfo = new Label(shlSelectionForm, SWT.NONE);
		       labelInfo.setText(" ");
		       labelInfo.setBounds(362, 430, 20, 10);
		       labelInfo.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));

		       button.addSelectionListener(new SelectionAdapter() {
		           @Override
		           public void widgetSelected(SelectionEvent e) {
		        	   count = count +1;
		        	   if(count%2==0) {
		        		   button.setText(" Show ");
		        		   labelInfo.setText(" ");
		        		   
		        	   }else {
		        		   button.setText(" Hide ");
		               labelInfo.setText(enterPassword.getText());
		        	   }
		        	   labelInfo.pack();
		           }
		       });
			
			Button btnLogin = new Button(shlSelectionForm, SWT.NONE);
			btnLogin.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					loginUserName = enterUserName.getText();
					loginUserPassword = enterPassword.getText();
					
				}
			});
			btnLogin.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
			btnLogin.setBounds(178, 554, 150, 50);
			btnLogin.setText("LOGIN");
			
			btnLogin.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					if(validateLoginDetails() == true) {
						
						BuildingView bView = new BuildingView();
						bView.BuildView(loginUserName);
					}	
				}
			});
			
			
			
			Button btnClose = new Button(shlSelectionForm, SWT.NONE);
			btnClose.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					shlSelectionForm.close();
				}
			});
			btnClose.setText("CLOSE");
			btnClose.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
			btnClose.setBounds(504, 554, 150, 50);

			shlSelectionForm.open();
			shlSelectionForm.layout();

			while (!shlSelectionForm.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}

		}
	}
