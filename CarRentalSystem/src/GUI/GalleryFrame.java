package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Has_A_Class.CarGallery;
import Is_A_Classes.Car;
import MainAndSystemClass.CarGallerySys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class GalleryFrame extends JFrame {

	private JPanel contentPane;
	private CarGallery galleryObj;  // the object coming from the IntroFrame, its information going to be displayed and altered
	private JLabel lblId;
	private JLabel lblTitle;
	private JLabel lblAddress;
	private JTextPane textArea;
	private JComboBox comboBox;
	private JButton displayAllCarBtn;
	private JButton addButton;
	private JButton deleteBtn;
	
	
	AddFrame addF = new AddFrame(this);
	private JButton btnNewButton_3;
	
	
	
	
	public CarGallery getGalleryObj() {
		return galleryObj;
	}

	/**
	 * Create the frame.
	 */
	public GalleryFrame(IntroPage intF) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				intF.clean();		//clean the previously entered user/pass
				intF.setVisible(true);
			}
		});
		btnNewButton.setBounds(631, 8, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Gallery Information:");
		lblNewLabel.setBackground(new Color(158, 204, 241));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 349, 20);
		contentPane.add(lblNewLabel);
		
		lblId = new JLabel("ID:    ");
		lblId.setBackground(Color.WHITE);
		lblId.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblId.setBounds(43, 42, 104, 39);
		contentPane.add(lblId);
		
		lblTitle = new JLabel("Title:   ");
		lblTitle.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(139, 42, 113, 39);
		contentPane.add(lblTitle);
		
		lblAddress = new JLabel("Address:    ");
		lblAddress.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblAddress.setBackground(Color.WHITE);
		lblAddress.setBounds(250, 42, 332, 39);
		contentPane.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 107, 419, 330);
		contentPane.add(scrollPane);
		
		textArea = new JTextPane();
		scrollPane.setViewportView(textArea);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car wantedCar = galleryObj.findCar((String)comboBox.getSelectedItem());
				if(wantedCar!=null)
				{
					textArea.setText(wantedCar.toString());
				}
			}
		});
		comboBox.setBounds(574, 92, 156, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Calculate the mıleage the can can go");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plate = comboBox.getSelectedItem().toString();
				Car carObject = galleryObj.findCar(plate);
				textArea.setText("The " + carObject.getBrand() + " car with the license plate: " + carObject.getLicensePlate() + " can go "
						+ carObject.calculateMilage()+ " miles with the current charge/fuel");
			}
		});
		btnNewButton_1.setBounds(488, 192, 242, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMıleRes = new JLabel("");
		lblMıleRes.setBounds(504, 121, 226, 61);
		contentPane.add(lblMıleRes);
		
		displayAllCarBtn = new JButton("Display All Cars");
		displayAllCarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(galleryObj.displayCars());
			}
		});
		displayAllCarBtn.setBounds(33, 448, 156, 40);
		contentPane.add(displayAllCarBtn);
		
		addButton = new JButton("Add New Car");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addF.setVisible(true);
				setVisible(false);
				addF.setGalleryObj(galleryObj);
				addF.fillInfo();
			}
		});
		addButton.setBounds(521, 293, 211, 23);
		contentPane.add(addButton);
		
		deleteBtn = new JButton("Delete selected Car");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem()==null)
					textArea.setText("A car plate must be selected from the combo box!\nThe list is currently Empty!");
				else {
					String plate = comboBox.getSelectedItem().toString();
					Car carObj = galleryObj.removeCar(plate);
					if(carObj!=null)
						textArea.setText("The intended car was deleted from the list.");
					else
						textArea.setText("There was a problem in removing the intended car!!");
					fillInfo();
				}
			}
		});
		deleteBtn.setBounds(250, 448, 156, 40);
		contentPane.add(deleteBtn);
		
		JButton btnNewButton_2 = new JButton("Display Gallery");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(CarGallerySys.display(galleryObj.getId()));
			}
		}); 
		btnNewButton_2.setBounds(545, 370, 150, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Delete Gallery");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CarGallerySys.deleteCarGallery(galleryObj.getId());
				intF.clean();		//clean the previously entered user/pass
				intF.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(546, 432, 124, 23);
		contentPane.add(btnNewButton_3);

		
		
		
		
	}
	
	public void fillInfo() {  //fills the information of the Gallery into the labels according to the object coming from Intro
		lblId.setText("ID:   "+ galleryObj.getId());
		lblTitle.setText("Title:  " + galleryObj.getTitle());
		lblAddress.setText("Address:  " + galleryObj.getAddress());
		comboBox.setModel(new DefaultComboBoxModel<>(galleryObj.getAllCarsPlate()));
		System.out.println("invoked");	
	}
	
	public void clear() {
		textArea.setText("");
	}


	public void setGalleryObj(CarGallery galleryObj) {
		this.galleryObj = galleryObj;
	}
}
