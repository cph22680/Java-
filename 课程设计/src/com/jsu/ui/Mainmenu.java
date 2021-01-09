package com.jsu.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Mainmenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu window = new Mainmenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainmenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 150, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u83DC\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu=new Menu();
				menu.setVisible(true);
			}
		});
		button.setBounds(122, 248, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5DE5\u5177\u680F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Toolbar toolbar=new Toolbar();
				toolbar.setVisible(true);
			}
		});
		button_1.setBounds(421, 248, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\steam\\steamapps\\workshop\\content\\431960\\833227004\\preview.jpg"));
		lblNewLabel.setBounds(0, 0, 688, 465);
		frame.getContentPane().add(lblNewLabel);
	}
}
