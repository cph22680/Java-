package com.jsu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JMenuBar;

public class Toolbar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Toolbar frame = new Toolbar();
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
	public Toolbar() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u914D\u7F6E\u5956\u54C1\u53CA\u540D\u989D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Awaquo awaquo=new Awaquo();
				awaquo.setVisible(true);
			}
		});
		button.setBounds(285, 139, 129, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u914D\u7F6E\u53C2\u4E0E\u4EBA\u5458");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conparti cpt=new Conparti();
				cpt.setVisible(true);
			}
		});
		button_1.setBounds(457, 335, 123, 23);
		contentPane.add(button_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(122, 335, 129, 23);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("\u9ED1\u540D\u5355");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u589E\u52A0\u9ED1\u540D\u5355");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conblalist cbl=new Conblalist();
				cbl.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664\u9ED1\u540D\u5355");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletblalist dbl=new Deletblalist();
				dbl.setVisible(true);
			}
		});
		menu.add(menuItem_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\steam\\steamapps\\workshop\\content\\431960\\1233762404\\preview.jpg"));
		lblNewLabel.setBounds(0, 0, 699, 475);
		contentPane.add(lblNewLabel);
	}
}
