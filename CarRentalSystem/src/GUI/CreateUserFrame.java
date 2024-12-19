package GUI;
import MainAndSystemClass.CarGallerySys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Is_A_Classes.*;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitle;
	private JTextField txtAddress;
	private JPasswordField txtPass;

	

	/**
	 * Create the frame.
	 */
	
	public void clean() {
		txtAddress.setText("");
		txtId.setText("");	
		txtTitle.setText("");	
		txtPass.setText("");	
	}
	
	public CreateUserFrame(IntroPage introF) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Car Gallery");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(107, 11, 251, 45);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(160, 88, 217, 29);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(160, 198, 217, 29);
		contentPane.add(txtTitle);
		
		JLabel lblResult = new JLabel("");
		lblResult.setVerticalAlignment(SwingConstants.BOTTOM);
		lblResult.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblResult.setBounds(40, 291, 350, 67);
		contentPane.add(lblResult);
		
		txtAddress = new JTextField();
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					boolean result = CarGallerySys.addCarGallery(txtAddress.getText(),  Integer.parseInt(txtId.getText()), txtTitle.getText(), txtPass.getText());
					
					if(result) {
						dispose();
						introF.setVisible(true);
					}
					else {
						lblResult.setText("Car Gallery ID already exists. Creation Unseccesful");
						
					}
				}
			}
		});
		txtAddress.setColumns(10);
		txtAddress.setBounds(160, 251, 217, 29);
		contentPane.add(txtAddress);
		
		JLabel lblNewLabel_1 = new JLabel("Car Gallery ID: ");
		lblNewLabel_1.setBounds(40, 88, 96, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setBounds(40, 142, 96, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Car Gallery Title:");
		lblNewLabel_1_2.setBounds(40, 198, 96, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address:");
		lblNewLabel_1_3.setBounds(40, 251, 96, 29);
		contentPane.add(lblNewLabel_1_3);
		
		
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = CarGallerySys.addCarGallery(txtAddress.getText(),  Integer.parseInt(txtId.getText()), txtTitle.getText(), txtPass.getText());
				
				if(result) {
					dispose();
					introF.setVisible(true);
				}
				else {
					lblResult.setText("Car Gallery ID already exists. Creation Unseccesful");
					
				}
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(96, 369, 251, 39);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("<-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				introF.setVisible(true);
				introF.clean();
			}
		});
		btnBack.setBounds(10, 11, 45, 23);
		contentPane.add(btnBack);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(160, 142, 217, 29);
		contentPane.add(txtPass);
	}

}
