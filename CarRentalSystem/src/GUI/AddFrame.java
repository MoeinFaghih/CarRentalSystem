package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Has_A_Class.CarGallery;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private CarGallery galleryObj;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtBrand;
	private JTextField txtHorse;
	private JTextField txtYear;
	private JTextField txtColor;
	private JTextField txtMile;
	private JTextField txtPlate;
	private JTextField txtSpeed;
	private JTextField txtTankCapacity;
	private JTextField txtFuelTank;
	private JTextField txtFuelType;
	private JTextField txtMilesPerTank;
	private JTextField txtBatteryPercentage;
	private JTextField txtMilePerBattery;
	private JTextField txtBatteryChargeTime;
	private JCheckBox chckbxFastCharge;
	private JLabel lblNewLabel_15;
	private JLabel lblInfo;
	private JLabel lblRes;

	

	/**
	 * Create the frame.
	 */
	public AddFrame(GalleryFrame galleryF) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 542);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				galleryF.setVisible(true);
				dispose();
				galleryF.fillInfo();
				System.out.println("invoked here");
				
			}
		});
		btnNewButton.setBounds(370, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(21, 48, 46, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Combustion");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
				{
					txtBatteryPercentage.setEditable(false);
					txtBatteryChargeTime.setEditable(false);
					txtMilePerBattery.setEditable(false);
					chckbxFastCharge.setEnabled(false);
					txtTankCapacity.setEditable(true);
					txtFuelTank.setEditable(true);
					txtFuelType.setEditable(true);
					txtMilesPerTank.setEditable(true);
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(94, 44, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Electric");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected())
				{
					txtBatteryPercentage.setEditable(true);
					txtBatteryChargeTime.setEditable(true);
					txtMilePerBattery.setEditable(true);
					chckbxFastCharge.setEnabled(true);
					txtTankCapacity.setEditable(false);
					txtFuelTank.setEditable(false);
					txtFuelType.setEditable(false);
					txtMilesPerTank.setEditable(false);
					
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(205, 44, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Brand:");
		lblNewLabel_1.setBounds(21, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtBrand = new JTextField();
		txtBrand.setBounds(83, 70, 120, 20);
		contentPane.add(txtBrand);
		txtBrand.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Horsepower");
		lblNewLabel_2.setBounds(232, 73, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		txtHorse = new JTextField();
		txtHorse.setBounds(327, 70, 120, 20);
		contentPane.add(txtHorse);
		txtHorse.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Year");
		lblNewLabel_3.setBounds(21, 109, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtYear = new JTextField();
		txtYear.setBounds(83, 106, 120, 20);
		contentPane.add(txtYear);
		txtYear.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setBounds(232, 109, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(326, 106, 121, 20);
		contentPane.add(txtColor);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mileage");
		lblNewLabel_3_1.setBounds(21, 146, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtMile = new JTextField();
		txtMile.setColumns(10);
		txtMile.setBounds(83, 143, 120, 20);
		contentPane.add(txtMile);
		
		JLabel lblNewLabel_5 = new JLabel("Licanse Plate");
		lblNewLabel_5.setBounds(232, 146, 72, 14);
		contentPane.add(lblNewLabel_5);
		
		txtPlate = new JTextField();
		txtPlate.setColumns(10);
		txtPlate.setBounds(327, 143, 120, 20);
		contentPane.add(txtPlate);
		
		JLabel lblNewLabel_3_2 = new JLabel("Top Speed");
		lblNewLabel_3_2.setBounds(21, 189, 62, 14);
		contentPane.add(lblNewLabel_3_2);
		
		txtSpeed = new JTextField();
		txtSpeed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					galleryF.setVisible(true);
					dispose();
					
				}
			}
		});
		txtSpeed.setBounds(99, 186, 104, 20);
		contentPane.add(txtSpeed);
		txtSpeed.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("COMBUSTION");
		lblNewLabel_6.setBounds(50, 236, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("ELECTRIC");
		lblNewLabel_6_1.setBounds(277, 236, 62, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("Tank Capacity");
		lblNewLabel_7.setBounds(10, 274, 78, 14);
		contentPane.add(lblNewLabel_7);
		
		txtTankCapacity = new JTextField();
		txtTankCapacity.setBounds(99, 271, 86, 20);
		contentPane.add(txtTankCapacity);
		txtTankCapacity.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fuel in Tank");
		lblNewLabel_8.setBounds(10, 311, 68, 14);
		contentPane.add(lblNewLabel_8);
		
		txtFuelTank = new JTextField();
		txtFuelTank.setBounds(99, 308, 86, 20);
		contentPane.add(txtFuelTank);
		txtFuelTank.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Fuel Type");
		lblNewLabel_9.setBounds(10, 351, 68, 14);
		contentPane.add(lblNewLabel_9);
		
		txtFuelType = new JTextField();
		txtFuelType.setBounds(99, 348, 86, 20);
		contentPane.add(txtFuelType);
		txtFuelType.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Miles per Tank");
		lblNewLabel_10.setBounds(10, 389, 73, 14);
		contentPane.add(lblNewLabel_10);
		
		txtMilesPerTank = new JTextField();
		txtMilesPerTank.setBounds(99, 386, 86, 20);
		contentPane.add(txtMilesPerTank);
		txtMilesPerTank.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Battery Percentage");
		lblNewLabel_11.setBounds(217, 274, 109, 14);
		contentPane.add(lblNewLabel_11);
		
		txtBatteryPercentage = new JTextField();
		txtBatteryPercentage.setBounds(329, 271, 93, 20);
		contentPane.add(txtBatteryPercentage);
		txtBatteryPercentage.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Mile per Battery");
		lblNewLabel_12.setBounds(217, 311, 87, 14);
		contentPane.add(lblNewLabel_12);
		
		txtMilePerBattery = new JTextField();
		txtMilePerBattery.setBounds(329, 308, 93, 20);
		contentPane.add(txtMilePerBattery);
		txtMilePerBattery.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Fast Charge");
		lblNewLabel_13.setBounds(217, 351, 70, 14);
		contentPane.add(lblNewLabel_13);
		
		chckbxFastCharge = new JCheckBox("");
		chckbxFastCharge.setBounds(329, 348, 97, 23);
		contentPane.add(chckbxFastCharge);
		
		JLabel lblNewLabel_14 = new JLabel("Battery Charge Time");
		lblNewLabel_14.setBounds(217, 389, 122, 14);
		contentPane.add(lblNewLabel_14);
		
		txtBatteryChargeTime = new JTextField();
		txtBatteryChargeTime.setBounds(329, 386, 86, 20);
		contentPane.add(txtBatteryChargeTime);
		txtBatteryChargeTime.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean res=false;
				boolean everythingFine=true;
				boolean isCombSelected=rdbtnNewRadioButton.isSelected();
				boolean isElecSelected=rdbtnNewRadioButton_1.isSelected();
				
				if(!isCombSelected && !isElecSelected)
				{
					lblRes.setText("Select a type");
				}
				else {
					if(isCombSelected)
					{
						if(txtBrand.getText().equalsIgnoreCase("")||
								txtHorse.getText().equalsIgnoreCase("")||
								txtYear.getText().equalsIgnoreCase("")||
								txtColor.getText().equalsIgnoreCase("")||
								txtMile.getText().equalsIgnoreCase("")||
								txtPlate.getText().equalsIgnoreCase("")||
								txtSpeed.getText().equalsIgnoreCase("")||
								txtTankCapacity.getText().equalsIgnoreCase("")||
								txtFuelTank.getText().equalsIgnoreCase("")||
								txtFuelType.getText().equalsIgnoreCase("")||
								txtMilesPerTank.getText().equalsIgnoreCase(""))
						{
							everythingFine=false;
						}
						else {
							res = galleryObj.addCar("Combustion", txtBrand.getText(), Double.parseDouble(txtHorse.getText()), 
									Integer.parseInt(txtYear.getText()), txtColor.getText(), Double.parseDouble(txtMile.getText()), txtPlate.getText(), 
									Double.parseDouble(txtSpeed.getText()), 0.0, 0.0, false, 
									0.0, Double.parseDouble(txtTankCapacity.getText()), Double.parseDouble(txtFuelTank.getText()), 
									txtFuelType.getText(), Double.parseDouble(txtMilesPerTank.getText()));
						}
					}
						
					else 
						if(txtBrand.getText().equalsIgnoreCase("")||
								txtHorse.getText().equalsIgnoreCase("")||
								txtYear.getText().equalsIgnoreCase("")||
								txtColor.getText().equalsIgnoreCase("")||
								txtMile.getText().equalsIgnoreCase("")||
								txtPlate.getText().equalsIgnoreCase("")||
								txtSpeed.getText().equalsIgnoreCase("")||
								txtBatteryPercentage.getText().equalsIgnoreCase("")||
								txtMilePerBattery.getText().equalsIgnoreCase("")||
								chckbxFastCharge.isSelected()||
								txtBatteryChargeTime.getText().equalsIgnoreCase(""))
						{
							everythingFine=false;
							
						}
						else {
							res = galleryObj.addCar("Electric", txtBrand.getText(), Double.parseDouble(txtHorse.getText()), 
									Integer.parseInt(txtYear.getText()), txtColor.getText(), Double.parseDouble(txtMile.getText()), txtPlate.getText(), 
									Double.parseDouble(txtSpeed.getText()), Double.parseDouble(txtBatteryPercentage.getText()), Double.parseDouble(txtMilePerBattery.getText()), 
									chckbxFastCharge.isSelected(), Double.parseDouble(txtBatteryChargeTime.getText()), 0.0, 0.0, 
									"", 0.0 );
						}
						
					
					if(everythingFine)
					{
						if(res) {
							lblRes.setText("The car was added successfuly!");
							clear();
						}
						else
							lblRes.setText("The entered lisence plate already exists!");
					}
					else
						lblRes.setText("Fill all the areas");
					
					
				}
				
					
				
				
					
			}
		});
		btnNewButton_1.setBounds(303, 449, 144, 31);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(21, 449, 95, 31);
		contentPane.add(lblNewLabel_15);
		
		lblInfo = new JLabel("");
		lblInfo.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 16));
		lblInfo.setBounds(77, 0, 273, 47);
		contentPane.add(lblInfo);
		
		lblRes = new JLabel("");
		lblRes.setBounds(21, 425, 244, 67);
		contentPane.add(lblRes);
	}
	
	public void setGalleryObj(CarGallery galleryObj) {
		this.galleryObj = galleryObj;
	}
	
	public void fillInfo() {
		lblInfo.setText(galleryObj.getTitle() + " Car Gallery");
	}
	
	public void clear() {
	txtBatteryChargeTime.setText("");
	txtBatteryPercentage.setText("");
	txtBrand.setText("");
	txtColor.setText("");
	txtFuelTank.setText("");
	txtFuelType.setText("");
	txtHorse.setText("");
	txtMile.setText("");
	txtMilePerBattery.setText("");
	txtMilesPerTank.setText("");
	txtPlate.setText("");
	txtSpeed.setText("");
	txtTankCapacity.setText("");
	txtYear.setText("");
	}
	
	public void cleanResult() {
		lblRes.setText("");
	}
	
	
	
}
