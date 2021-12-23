package com.cerner.patient.management.system.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import com.cerner.patient.management.system.service.RegisterViewService;
import com.cerner.patient.management.system.service.RegisterViewServiceImpl;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CJ094392
 *
 */
public class RegisterView {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterView.class);
	
	RegisterViewService rService = new RegisterViewServiceImpl();
	
	
	Label lblRegistrationForm, lblUserName, lblUserPassword, lblUserPhoneNo;

	public Text enterUserName;
	public Text enterPassword;
	public Text enterPhoneNo;

	private String userName;
	private String userPassword;
	private String userPhoneNo;
	
	private Text txtUserNameMust;
	private Text txtPasswordFieldMust;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public RegisterView() {
		
	}

	public boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean validateDetails(Shell shlRegistrationForm) {

		String regularExpressionUserName = "^[[A-Z]|[a-z]][[A-Z]|[a-z]|\\d|[_]]{4,29}$";
		String regularExpPassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
		String regularExpPhoneNo = "^[0-9]*$";
		
		if (!userName.matches(regularExpressionUserName)) {
				MessageBox messageBox = new MessageBox(shlRegistrationForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
				messageBox.setMessage("Enter the User Name");
				messageBox.open();
				return false;

			} else if (!userPassword.matches(regularExpPassword)) {
				MessageBox messageBox = new MessageBox(shlRegistrationForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
				messageBox.setMessage("Enter the Password");
				messageBox.open();
				return false;
			} else if (!isNumeric(userPhoneNo)) {
				MessageBox messageBox = new MessageBox(shlRegistrationForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
				messageBox.setMessage("Enter the Phone number");
				messageBox.open();
				return false;

			}
			else{
				logger.info(getUserName()+" has successfully registered as a new user");
				return true;
			}
		

	}


	public void Register() {
		Display display = Display.getDefault();
		Shell shlRegistrationForm = new Shell(SWT.NONE);

		shlRegistrationForm.setMinimumSize(new Point(1000, 800));
		shlRegistrationForm.setSize(277, 205);
		shlRegistrationForm.setBounds(560, 160, 0, 0);
		shlRegistrationForm.setText("Registration form");
		shlRegistrationForm.setLayout(null);
		shlRegistrationForm.pack();
		
		lblRegistrationForm = new Label(shlRegistrationForm, SWT.CENTER);
		lblRegistrationForm.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblRegistrationForm.setBackground(SWTResourceManager.getColor(21, 61, 112));
		lblRegistrationForm.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblRegistrationForm.setBounds(10, 23, 975, 124);
		lblRegistrationForm.setText("\r\n Register in to Patient Record Management System");
		
		Label lblImageUser = new Label(shlRegistrationForm, SWT.NONE);
		lblImageUser.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/icons8-user-50.png"));	
		lblImageUser.setBounds(170, 230, 50, 40);
		
		lblUserName = new Label(shlRegistrationForm, SWT.NULL);
		lblUserName.setBounds(230, 235, 155, 50);
		lblUserName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblUserName.setText("User Name : ");

		enterUserName = new Text(shlRegistrationForm, SWT.SINGLE | SWT.BORDER);
		enterUserName.setBounds(450, 232, 380, 50);
		enterUserName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		enterUserName.setText("");
		enterUserName.setTextLimit(30);
		
		Label lblImagePassword = new Label(shlRegistrationForm, SWT.NONE);
		lblImagePassword.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/icons8-password-50.png"));	
		lblImagePassword.setBounds(170, 336, 50, 50);
		
		lblUserPassword = new Label(shlRegistrationForm, SWT.NULL);
		lblUserPassword.setBounds(230, 346, 140, 50);
		lblUserPassword.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblUserPassword.setText("Password : ");

		enterPassword = new Text(shlRegistrationForm, SWT.SINGLE | SWT.BORDER);
		enterPassword.setBounds(450, 343, 380, 50);
		enterPassword.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		System.out.println(enterPassword.getEchoChar());
		enterPassword.setEchoChar('*');
		enterPassword.setTextLimit(30);

		Label lblImagePhoneNo = new Label(shlRegistrationForm, SWT.NONE);
		lblImagePhoneNo.setImage(new Image(display,"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/icons8-phone-50.png"));	
		lblImagePhoneNo.setBounds(170, 457, 50, 50);
		
		lblUserPhoneNo = new Label(shlRegistrationForm, SWT.NONE);
		lblUserPhoneNo.setBounds(230, 467, 204, 50);
		lblUserPhoneNo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblUserPhoneNo.setText("Phone Number : ");

		enterPhoneNo = new Text(shlRegistrationForm, SWT.BORDER);
		enterPhoneNo.setBounds(450, 464, 380, 50);
		enterPhoneNo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		enterPhoneNo.setTextLimit(10);
		enterPhoneNo.setText("");
		enterPhoneNo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Button btnSubmit = new Button(shlRegistrationForm, SWT.PUSH);
		btnSubmit.setBounds(450, 584, 129, 50);
		btnSubmit.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnSubmit.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				userName = enterUserName.getText();
				userPassword = enterPassword.getText();
				userPhoneNo = enterPhoneNo.getText();

			}

		});
		btnSubmit.setText("Submit");
		
		Button btnClose = new Button(shlRegistrationForm, SWT.PUSH);
		btnClose.setBounds(698, 584, 129, 50);
		btnClose.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnClose.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {				
				shlRegistrationForm.close();
				
			}

		});
		btnClose.setText("Close");

		btnSubmit.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				if (validateDetails(shlRegistrationForm) == true) {

					String messageBoxOp = rService.addRegisterDetails(userName, userPassword, userPhoneNo);
					MessageBox messageBox = new MessageBox(shlRegistrationForm, SWT.OK | SWT.CANCEL);
					messageBox.setText("Registration Form");
					messageBox.setMessage(messageBoxOp + "  :  " + enterUserName.getText());
					messageBox.open();					
					shlRegistrationForm.close();
				}
			}
			

		});
		
		txtUserNameMust = new Text(shlRegistrationForm, SWT.NONE);
		txtUserNameMust.setText("* User name must have atleast 5 characters, special characters are not allowed.");
		txtUserNameMust.setBounds(170, 700, 530, 26);
		txtUserNameMust.setBackground(SWTResourceManager.getColor(255, 255, 255));
		
		txtPasswordFieldMust = new Text(shlRegistrationForm, SWT.NONE);
		txtPasswordFieldMust.setText("* Password field must have atleast 6 characters, with atleast one number and alphabet.");
		txtPasswordFieldMust.setBounds(170, 740, 590, 26);
		txtPasswordFieldMust.setBackground(SWTResourceManager.getColor(255, 255, 255));
			
		shlRegistrationForm.open();
		shlRegistrationForm.layout();

		while (!shlRegistrationForm.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}	
	}
}
