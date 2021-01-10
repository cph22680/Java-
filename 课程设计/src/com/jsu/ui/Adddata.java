package com.jsu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jsu.dao.DataOperate;
import com.jsu.util.Judgmentdata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Adddata extends JFrame {

	private JPanel contentPane;
	private JTable table=Conparti.getTable();
	private DefaultTableModel model=Conparti.getDbm();
	private  static JTextField textField;
	private  static JTextField textField_1;
	private  static JTextField textField_2;
	private  static JTextField textField_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adddata frame = new Adddata();
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
	public Adddata() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("工号");
		label.setForeground(Color.ORANGE);
		label.setBounds(151, 69, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setForeground(Color.ORANGE);
		label_1.setBounds(151, 184, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("电话号码");
		label_2.setForeground(Color.ORANGE);
		label_2.setBounds(151, 290, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("部门");
		label_3.setForeground(Color.ORANGE);
		label_3.setBounds(151, 378, 54, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(262, 66, 114, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(262, 181, 114, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(262, 284, 114, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(262, 375, 114, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Judgmentdata.Judge(textField_2.getText())&Judgmentdata.JudgeExist(textField.getText())) {
					DataOperate.addData_Employee_kb(textField.getText(), textField_1.getText(), textField_2.getText(),textField_3.getText());					
					JOptionPane.showMessageDialog(null, "增加成功");
				}else {
					JOptionPane.showMessageDialog(null, "增加失败，请重新输入");
				}
			}
		});
		button.setBounds(498, 222, 93, 23);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\steam\\steamapps\\workshop\\content\\431960\\1433247985\\preview.jpg"));
		lblNewLabel.setBounds(0, 0, 698, 465);
		contentPane.add(lblNewLabel);
	}
	
	public static JTextField getT() {
		return textField;
	}
	
	public static JTextField getT_1() {
		return textField;
	}
	
	public static JTextField getT_2() {
		return textField;
	}
	
	public static JTextField getT_3() {
		return textField;
	}
}
