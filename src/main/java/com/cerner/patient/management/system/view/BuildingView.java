package com.cerner.patient.management.system.view;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import com.cerner.patient.management.system.service.BuildingService;
import com.cerner.patient.management.system.service.BuildingServiceImpl;
import com.cerner.patient.management.system.service.FloorService;
import com.cerner.patient.management.system.service.FloorServiceImpl;
import com.cerner.patient.management.system.service.PatientDetailsService;
import com.cerner.patient.management.system.service.PatientDetailsServiceImpl;
import com.cerner.patient.management.system.service.RoomService;
import com.cerner.patient.management.system.service.RoomServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildingView {

	private static final Logger logger = LoggerFactory.getLogger(BuildingView.class);

	BuildingService buildService = new BuildingServiceImpl();

	FloorService fService = new FloorServiceImpl();

	RoomService rService = new RoomServiceImpl();

	PatientDetailsService patientService = new PatientDetailsServiceImpl();

	List<String> allPatients;
	ArrayList<Button> pagination;

	Label label1, label2, labName;
	Text text;
	private Combo buildingName;
	private Combo floorName;
	private Label label3, lblFindThePatient;
	private Combo roomName;
	private Button btnSubmit;
	private Label label;

	private Table table;
	private Text userSelectedNumber;
	String selectedBuilding;
	String selectedFloor;
	String selectedRoom;

	int buildingSelectedCount = 0;
	int floorSelectedCount = 0;
	int roomSelectedCount = 0;
	int noOftimesSubmitClick = 0;

	public BuildingView() {
	}

	public void BuildView(String currentUser) {
		Display display = Display.getDefault();
		Shell shlSelectionForm = new Shell(SWT.NONE);
		Color grey = new Color(display, 128, 0, 128);
		Image bg_Image = new Image(display,
				"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/BuildingImg.jpg");

		shlSelectionForm.setBackgroundImage(bg_Image);
		shlSelectionForm.setBackgroundMode(SWT.INHERIT_FORCE);
		shlSelectionForm.setFullScreen(true);

		Label lblLogoImage = new Label(shlSelectionForm, SWT.NONE);
		lblLogoImage.setImage(new Image(display,
				"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/cernerLogo.png"));
		lblLogoImage.setBounds(40, 20, 432, 107);

		shlSelectionForm.setMinimumSize(new Point(1925, 1050));
		shlSelectionForm.setSize(805, 598);
		shlSelectionForm.setBounds(0, 0, 0, 0);
		shlSelectionForm.setText("Select Fields");

		shlSelectionForm.pack();

		shlSelectionForm.setLayout(null);

		Label lblImageUser = new Label(shlSelectionForm, SWT.NONE);
		lblImageUser.setImage(new Image(display,
				"C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/icons8-checked-user-male-96.png"));
		lblImageUser.setBounds(1450, 30, 100, 90);

		labName = new Label(shlSelectionForm, SWT.NONE);
		labName.setForeground(SWTResourceManager.getColor(255, 20, 147));
		labName.setBounds(1450, 120, 250, 40);
		labName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		labName.setAlignment(SWT.LEFT);
		labName.setText("Hello " + currentUser);

		lblFindThePatient = new Label(shlSelectionForm, SWT.NONE);
		lblFindThePatient.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblFindThePatient.setFont(SWTResourceManager.getFont("Segoe UI", 34, SWT.BOLD));
		lblFindThePatient.setBounds(680, 30, 677, 72);
		lblFindThePatient.setText("Find the patient here");

		label1 = new Label(shlSelectionForm, SWT.NONE);
		label1.setForeground(SWTResourceManager.getColor(30, 144, 255));
		label1.setBounds(71, 222, 220, 55);
		label1.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		label1.setText("Select Hospital");

		buildingName = new Combo(shlSelectionForm, SWT.DROP_DOWN);
		buildingName.setBounds(312, 222, 291, 45);
		buildingName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));

		List<String> allBuildings = buildService.fetchAllBuildings();
		for (String building : allBuildings) {
			buildingName.add(building);

		}

		buildingName.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {

				selectedBuilding = buildingName.getText();
				buildingSelectedCount = buildingSelectedCount + 1;
				logger.info(selectedBuilding);
				List<String> allfloors = fService.getFloorOnSelectedBuilding(selectedBuilding);
				if (buildingSelectedCount == 1) {
					for (String floor : allfloors) {
						floorName.add(floor);
					}
					allfloors.clear();
				} else {

					floorName.removeAll();
					roomName.removeAll();
					table.removeAll();
					for (String floor : allfloors) {
						floorName.add(floor);
					}
				}

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("Default selected index: " + buildingName.getSelectionIndex() + ", selected item: "
						+ (buildingName.getSelectionIndex() == -1 ? "<null>"
								: buildingName.getItem(buildingName.getSelectionIndex()))
						+ ", text content in the text field: " + buildingName.getText());
			}
		});

		label2 = new Label(shlSelectionForm, SWT.NONE);
		label2.setForeground(SWTResourceManager.getColor(30, 144, 255));
		label2.setBounds(761, 222, 180, 37);
		label2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		label2.setText("Select Floor");

		floorName = new Combo(shlSelectionForm, SWT.NONE);
		floorName.setBounds(947, 222, 291, 45);
		floorName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));

		floorName.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				selectedFloor = floorName.getText();
				floorSelectedCount = floorSelectedCount + 1;

				logger.info(selectedFloor);

				List<String> allrooms = rService.getRoomsOnSelectedFloors(selectedFloor);

				if (floorSelectedCount == 1) {
					for (String room : allrooms) {
						roomName.add(room);
					}
					allrooms.clear();

				} else {
					table.removeAll();
					roomName.removeAll();
					for (String room : allrooms) {
						roomName.add(room);
					}
				}

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("Default selected index: " + floorName.getSelectionIndex() + ", selected item: "
						+ (floorName.getSelectionIndex() == -1 ? "<null>"
								: buildingName.getItem(floorName.getSelectionIndex()))
						+ ", text content in the text field: " + floorName.getText());
			}
		});

		label3 = new Label(shlSelectionForm, SWT.NONE);
		label3.setForeground(SWTResourceManager.getColor(30, 144, 255));

		label3.setBounds(1333, 222, 174, 37);
		label3.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		label3.setText("Select Room");

		roomName = new Combo(shlSelectionForm, SWT.NONE);
		roomName.setBounds(1524, 222, 291, 45);
		roomName.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));

		roomName.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				selectedRoom = roomName.getText();
				roomSelectedCount = roomSelectedCount + 1;
				table.removeAll();

				logger.info(selectedRoom);

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("Default selected index: " + roomName.getSelectionIndex() + ", selected item: "
						+ (roomName.getSelectionIndex() == -1 ? "<null>"
								: roomName.getItem(roomName.getSelectionIndex()))
						+ ", text content in the text field: " + roomName.getText());
			}
		});

		btnSubmit = new Button(shlSelectionForm, SWT.NONE);
		btnSubmit.setForeground(SWTResourceManager.getColor(0, 0, 205));
		btnSubmit.setBounds(860, 315, 200, 47);
		btnSubmit.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnSubmit.setText("Submit");

		label = new Label(shlSelectionForm, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(54, 390, 1794, 16);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 50, SWT.BOLD));

		Label lblPatientDetails = new Label(shlSelectionForm, SWT.NONE);
		lblPatientDetails.setForeground(SWTResourceManager.getColor(0, 0, 255));
		lblPatientDetails.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.BOLD));
		lblPatientDetails.setBounds(761, 420, 297, 47);
		lblPatientDetails.setText("Patient Details");

		Label lblImageDoctor = new Label(shlSelectionForm, SWT.NONE);
		lblImageDoctor.setImage(
				new Image(display, "C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/doctors.png"));
		lblImageDoctor.setBounds(680, 390, 100, 90);

		table = new Table(shlSelectionForm, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLocation(314, 542);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setSize(1200, 430);
		table.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		table.setForeground(grey);

		String[] titles = { "Id", "Name", "Gender", "Age", "Room" };
		for (int i = 0; i < titles.length; i++) {

			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
			column.setWidth(234);
		}

		Label lblPagination = new Label(shlSelectionForm, SWT.NONE);
		lblPagination.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblPagination.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL | SWT.ITALIC));
		lblPagination.setBounds(312, 471, 172, 45);
		lblPagination.setText("Pagination : ");

		Label lblComboNo = new Label(shlSelectionForm, SWT.NONE);
		lblComboNo.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblComboNo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL | SWT.ITALIC));
		lblComboNo.setBounds(70, 315, 660, 37);
		lblComboNo.setText("Select number of patients to be displayed in each table : ");

		userSelectedNumber = new Text(shlSelectionForm, SWT.BORDER);
		userSelectedNumber.setBounds(730, 320, 67, 40);
		userSelectedNumber.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL | SWT.ITALIC));
		userSelectedNumber.setText("5");
		userSelectedNumber.addListener(SWT.Verify, new Listener() {
			public void handleEvent(Event e) {
				String string = e.text;

				char[] chars = new char[string.length()];
				string.getChars(0, chars.length, chars, 0);
				for (int i = 0; i < chars.length; i++) {
					if (!('0' <= chars[i] && chars[i] <= '9')) {
						e.doit = false;
						return;
					}
				}

			}
		});

		btnSubmit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				allPatients = patientService.getAllPatientsInRoom(selectedRoom);
				String x = (userSelectedNumber.getText() == "") ? ("5") : (userSelectedNumber.getText());

				int q = Integer.parseInt(x);
				if (q == 0) {
					table.removeAll();
					MessageBox messageBox = new MessageBox(shlSelectionForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setMessage("Enter a valid number other than 0");
					messageBox.open();

				} else {
					int jee = (allPatients.size() / (q * 5)) + 1;
					int flag = 1;
					table.removeAll();
					int i = (q * 5) * (flag - 1);
					while (i < allPatients.size()) {
						TableItem item = new TableItem(table, SWT.NONE);
						for (int j = 0; j < 5; j++) {
							item.setText(j, allPatients.get(i));
							i++;
						}
						if (i == (q * 5) * (flag)) {

							break;
						}

					}
				}
			}

		});

		btnSubmit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				noOftimesSubmitClick = noOftimesSubmitClick + 1;
				allPatients = patientService.getAllPatientsInRoom(selectedRoom);

				if (noOftimesSubmitClick == 1 && buildingSelectedCount != 0 && floorSelectedCount != 0
						&& roomSelectedCount != 0) {
					String x = (userSelectedNumber.getText() == "") ? ("5") : (userSelectedNumber.getText());
					int q = Integer.parseInt(x);
					if (q == 0) {
						table.removeAll();
						MessageBox messageBox = new MessageBox(shlSelectionForm,
								SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
						messageBox.setMessage("Enter a valid number other than 0");
						messageBox.open();

					} else {
						int jee = (allPatients.size() / (q * 5)) + 1;

						pagination = new ArrayList<Button>(jee);
						for (int k = 0; k < jee; k++) {
							pagination.add(new Button(shlSelectionForm, SWT.NONE));
							int flag = k + 1;

							pagination.get(k).addSelectionListener(new SelectionAdapter() {
								@Override
								public void widgetSelected(SelectionEvent e) {
									table.removeAll();
									int i = (q * 5) * (flag - 1);
									while (i < allPatients.size()) {
										TableItem item = new TableItem(table, SWT.NONE);
										for (int j = 0; j < 5; j++) {
											item.setText(j, allPatients.get(i));
											i++;
										}
										if (i == (q * 5) * (flag)) {

											break;
										}
									}
								}
							});
							pagination.get(k).setBounds(500 + 50 * k, 478, 40, 40);
							pagination.get(k).setText("" + (k + 1));
						}
					}
				} else if (noOftimesSubmitClick != 1) {
					for (Button w : pagination) {
						w.dispose();
					}
					noOftimesSubmitClick = 0;
					logger.info("Number of time clicked on submit button " + noOftimesSubmitClick);
				}
			}
		});

		Button btnLogout = new Button(shlSelectionForm, SWT.NONE);
		btnLogout.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				logger.info("user has logged out successfully");
				shlSelectionForm.close();
				EndPage end = new EndPage();
				end.Logout();
			}
		});
		btnLogout.setImage(
				new Image(display, "C:/Users/CJ094392/eclipse-workspace/PatientManagementSystem/Images/log.png"));
		btnLogout.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnLogout.setBounds(1700, 38, 100, 100);
		btnLogout.setBackground(null);

		shlSelectionForm.pack();
		shlSelectionForm.open();
		while (!shlSelectionForm.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}