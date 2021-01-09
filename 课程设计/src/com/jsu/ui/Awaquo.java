package com.jsu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsu.dao.DataOperate;
import com.jsu.util.Judgmentdata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Awaquo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton button;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Awaquo frame = new Awaquo();
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
	public Awaquo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("特等奖");
		label.setBounds(27, 74, 77, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("一等奖");
		label_1.setBounds(27, 175, 77, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("二等奖");
		label_2.setBounds(27, 281, 77, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("三等奖");
		label_3.setBounds(27, 377, 77, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(114, 71, 85, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 172, 85, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 278, 85, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 374, 85, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel label_4 = new JLabel("\u540D\u989D");
		label_4.setBounds(255, 74, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u540D\u989D");
		label_5.setBounds(255, 175, 54, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u540D\u989D");
		label_6.setBounds(255, 281, 54, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u540D\u989D");
		label_7.setBounds(255, 377, 54, 15);
		contentPane.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(319, 71, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(319, 172, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(319, 278, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(319, 374, 66, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				if(Judgmentdata.Judge(textField_5.getText())&Judgmentdata.Judge(textField_4.getText())&
						Judgmentdata.Judge(textField_6.getText())&Judgmentdata.Judge(textField_7.getText())&
						Judgmentdata.JudgeEmpty(textField.getText(),textField_1.getText(),
								textField_2.getText(),textField_3.getText())) {
                DataOperate.addData2(textField.getText(),textField_4.getText(), textField_1.getText(), textField_5.getText(), textField_2.getText(), textField_6.getText(),
                		textField_3.getText(), textField_7.getText());
                JOptionPane.showMessageDialog(null, "输入成功");
            }else {
					JOptionPane.showMessageDialog(null, "输入失败，请重新输入");
				}
            }
        });
		button.setBounds(558, 225, 93, 23);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\steam\\steamapps\\workshop\\content\\431960\\824911868\\preview.jpg"));
		lblNewLabel.setBounds(0, 0, 700, 476);
		contentPane.add(lblNewLabel);
	}

}
