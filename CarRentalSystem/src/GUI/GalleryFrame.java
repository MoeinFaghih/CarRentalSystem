package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Has_A_Class.CarGallery;

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
import javax.swing.JScrollPane;

public class GalleryFrame extends JFrame {

	private JPanel contentPane;
	private static CarGallery galleryObj;  // the object coming from the IntroFrame, its information going to be displayed and altered
	private JLabel lblId;
	private JLabel lblTitle;
	private JLabel lblAddress;
	

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
		lblNewLabel.setBounds(10, 11, 720, 77);
		contentPane.add(lblNewLabel);
		
		lblId = new JLabel("ID:    ");
		lblId.setBackground(Color.WHITE);
		lblId.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblId.setBounds(43, 42, 128, 39);
		contentPane.add(lblId);
		
		lblTitle = new JLabel("Title:   ");
		lblTitle.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(139, 42, 171, 39);
		contentPane.add(lblTitle);
		
		lblAddress = new JLabel("Address:    ");
		lblAddress.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblAddress.setBackground(Color.WHITE);
		lblAddress.setBounds(374, 42, 332, 39);
		contentPane.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 200, 201, 240);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setForeground(new Color(0, 0, 0));
		list.setBackground(new Color(206, 234, 187));
		list.setFont(new Font("Tahoma", Font.BOLD, 13));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Item1", "Item2", "Item3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
	}
	
	public void fillInfo() {  //fills the information of the Gallery into the labels according to the object coming from Intro
		lblId.setText("ID:   "+ galleryObj.getId());
		lblTitle.setText("Title:  " + galleryObj.getTitle());
		lblAddress.setText("Address:  " + galleryObj.getAddress());
		
	}


	public static void setGalleryObj(CarGallery galleryObj) {
		GalleryFrame.galleryObj = galleryObj;
	}
}
