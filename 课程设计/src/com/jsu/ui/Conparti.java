package com.jsu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jsu.dao.DataOperate;
import com.jsu.util.Judgmentdata;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Conparti extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JTable table;
	private JTextField textField_4;
	private static DefaultTableModel model;// ����������ģ��

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conparti frame = new Conparti();
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
	public Conparti() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("����");
		label.setBounds(40, 40, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(144, 37, 118, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("����");
		label_1.setBounds(342, 40, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(430, 37, 105, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("�绰����");
		label_2.setBounds(40, 117, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 114, 118, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("����");
		label_3.setBounds(342, 117, 54, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(430, 114, 105, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 187, 105, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel("����ؼ���");
		label_4.setBounds(40, 190, 75, 15);
		contentPane.add(label_4);
			

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(70, 229, 547, 215);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������
				
				
		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����", "����", "�绰����","����");
		String sql="select * from Employee";//�����ѯ���
		Vector<Vector> empInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(empInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);//���ñ���������
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//��������ļ��ϣ�
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));//���õ�һ������ʽ����1������2��Ϊ�����ֶΣ�ָ��Ϊ3�ڸ��ֶ�cj����2������Ϊ����
		//sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//�����һ����������ֵͬ�����õڶ�������ʽ����1������0��Ϊ�����ֶΣ�ָ��Ϊ1�ڸ��ֶ�xh����2������Ϊ����
		sorter.setSortKeys(sortKeys);
		
		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String key=textField_4.getText().trim();//��ȡ����ؼ����ı����ֵ
					if(key.length()!=0) {
						sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
					}else {
						sorter.setRowFilter(null);//�����ˣ���ʾ��������
					}
			}
		});
		button.setBounds(279, 186, 93, 23);
		contentPane.add(button);
		
		JButton button_3 = new JButton("ѡ��");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					textField.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
					textField_1.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
					textField_2.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
					textField_3.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
				}

			}
		});
		button_3.setBounds(402, 186, 93, 23);
		contentPane.add(button_3);
		
		JButton button_2 = new JButton("�޸�");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataOperate.upData_Employee(textField.getText(), textField_1.getText(), textField_2.getText(),textField_3.getText());
				Vector<String> titles = new Vector<String>();
				Collections.addAll(titles, "����", "����","�绰����", "����");
				String sql="select * from Employee";
				model=new DefaultTableModel(DataOperate.getSelectAll(sql),titles);
				table.setModel(model);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}
		});
		button_2.setBounds(524, 186, 93, 23);
		contentPane.add(button_2);
		
	}
	public static JTable getTable() {
		return table;
	}
	
	public static DefaultTableModel getDbm() {
		return model;
	}
}
