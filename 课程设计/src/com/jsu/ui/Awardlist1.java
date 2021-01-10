package com.jsu.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jsu.dao.DataOperate;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Awardlist1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;// ����������ģ��
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Awardlist frame = new Awardlist();
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
	public Awardlist1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(70, 102, 539, 316);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������
			

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����", "����", "�绰����","��Ʒ");
		String sql="select * from Awardlist_2";//�����ѯ���
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
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setRowSorter(sorter);//���ñ���������
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//��������ļ��ϣ�
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));//���õ�һ������ʽ����1������2��Ϊ�����ֶΣ�ָ��Ϊ3�ڸ��ֶ�cj����2������Ϊ����
		//sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//�����һ����������ֵͬ�����õڶ�������ʽ����1������0��Ϊ�����ֶΣ�ָ��Ϊ1�ڸ��ֶ�xh����2������Ϊ����
		sorter.setSortKeys(sortKeys);//�������������������

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
			
		JLabel lblKey = new JLabel("����ؼ��֣�");
		lblKey.setBounds(70, 45, 80, 15);
		contentPane.add(lblKey);
			
		JButton btnFind = new JButton("����");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=textField.getText().trim();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
				}else {
					sorter.setRowFilter(null);//�����ˣ���ʾ��������
				}
					
			}
		});
		btnFind.setBounds(487, 41, 122, 23);
		contentPane.add(btnFind);
		
		textField = new JTextField();
		textField.setBounds(256, 42, 113, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u83B7\u5956\u540D\u5355");
		lblNewLabel.setBounds(278, 10, 54, 15);
		contentPane.add(lblNewLabel);
		
		
	}
}

