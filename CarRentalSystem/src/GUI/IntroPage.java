package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Has_A_Class.CarGallery;
import MainAndSystemClass.CarGallerySys;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class IntroPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	
	
	CreateUserFrame createF = new CreateUserFrame(this);
	GalleryFrame galF = new GalleryFrame(this);
	private JPasswordField txtPass;
	private JLabel lblCalcRes;
	private JLabel lblResult;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroPage frame = new IntroPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void clean() {
		txtId.setText("");
		txtPass.setText("");
	}
	public IntroPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblResult = new JLabel("");
		lblResult.setForeground(Color.RED);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResult.setBounds(164, 212, 245, 51);
		contentPane.add(lblResult);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Car Rental System");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(164, 25, 245, 51);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(246, 85, 163, 27);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(149, 87, 71, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(149, 121, 71, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().equals("") || txtPass.getText().equals(""))
					lblResult.setText("All fields must be filled!");
				else {
					int id = Integer.parseInt(txtId.getText());
					CarGallery galleryObj = CarGallerySys.getCarGalleryById(id);
					if(galleryObj == null) {  //meaning no such id is existent in the data.
						lblResult.setText("The entered ID or Password is incorrect");
						clean();
					}
					else {
						String pass = CarGallerySys.getPassword(id);
						if(!pass.equals(txtPass.getText()) ){		//Wrong Password
							lblResult.setText("The entered ID or Password is incorrect");
							clean();
						}
						
						else {
							GalleryFrame.setGalleryObj(galleryObj);
							setVisible(false);
							galF.setVisible(true);
							galF.fillInfo();
						}
					}
				}
				
				
			}
		});
		btnSignIn.setBackground(new Color(173, 216, 230));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignIn.setBounds(192, 169, 174, 32);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel_2 = new JLabel("Not a User?");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(93, 289, 89, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Create an Account For Your Car Gallery Now!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createF.setVisible(true);
				setVisible(false);
				createF.clean();
			}
		});
		btnNewButton.setBackground(new Color(90, 165, 137));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(164, 284, 288, 23);
		contentPane.add(btnNewButton);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(246, 119, 163, 27);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_3 = new JLabel("Want to see howmany cars in total we currently have in the system?");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(29, 356, 423, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCalc = new JButton("Click Here!");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCalcRes.setText("Across all of the galleries registered in the system, we have a total of " + CarGallerySys.calculateTotalCarCount() + " cars!");
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalc.setBackground(new Color(173, 216, 230));
		btnCalc.setBounds(447, 355, 97, 27);
		contentPane.add(btnCalc);
		
		lblCalcRes = new JLabel("");
		lblCalcRes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCalcRes.setBounds(80, 385, 447, 40);
		contentPane.add(lblCalcRes);
		
		
		
	}
}
