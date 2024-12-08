package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPass;
	
	
	CreateUserFrame createF = new CreateUserFrame(this);
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
	public IntroPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Car Rental System");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(164, 25, 245, 51);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(246, 119, 163, 27);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(246, 157, 163, 27);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(149, 121, 71, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(149, 159, 71, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBackground(new Color(173, 216, 230));
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignIn.setBounds(197, 208, 174, 32);
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
			}
		});
		btnNewButton.setBackground(new Color(90, 165, 137));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(164, 284, 288, 23);
		contentPane.add(btnNewButton);
	}
}
