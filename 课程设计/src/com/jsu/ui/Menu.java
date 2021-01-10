package com.jsu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsu.util.BlackBoard;
import com.jsu.util.BlackBoard1;
import com.jsu.util.BlackBoard2;
import com.jsu.util.BlackBoard3;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("奖项等级");
		label.setBounds(55, 275, 54, 15);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"请选择","特等奖", "一等奖", "二等奖", "三等奖"}));
		comboBox.setBounds(232, 271, 100, 23);
		contentPane.add(comboBox);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=comboBox.getSelectedIndex()+1;
		        String s=(String)comboBox.getSelectedItem();
				if(s=="特等奖") {
					BlackBoard bbd=new BlackBoard(Integer.parseInt(Awaquo.getT_4()));
					bbd.setVisible(true);
				}else if(s=="一等奖") {
					BlackBoard1 bbd1=new BlackBoard1(Integer.parseInt(Awaquo.getT_5()));
					bbd1.setVisible(true);
				}else if(s=="二等奖") {
					BlackBoard2 bbd2=new BlackBoard2(Integer.parseInt(Awaquo.getT_6()));
					bbd2.setVisible(true);
				}else if(s=="三等奖") {
					BlackBoard3 bbd3=new BlackBoard3(Integer.parseInt(Awaquo.getT_7()));
					bbd3.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "请选择奖项");
				}
					
				
			}
		});
		button.setBounds(459, 271, 93, 23);
		contentPane.add(button);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\steam\\steamapps\\workshop\\content\\431960\\2134276902\\preview.jpg"));
		lblNewLabel.setBounds(0, 0, 688, 491);
		contentPane.add(lblNewLabel);
	}
}
