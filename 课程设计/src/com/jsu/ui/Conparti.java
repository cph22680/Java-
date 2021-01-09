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
	private static DefaultTableModel model;// 定义表格数据模型

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
		
		JLabel label = new JLabel("工号");
		label.setBounds(40, 40, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(144, 37, 118, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(342, 40, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(430, 37, 105, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("电话号码");
		label_2.setBounds(40, 117, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 114, 118, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("部门");
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
		
		JLabel label_4 = new JLabel("输入关键字");
		label_4.setBounds(40, 190, 75, 15);
		contentPane.add(label_4);
			

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(70, 229, 547, 215);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中
				
				
		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "工号", "姓名", "电话号码","部门");
		String sql="select * from Employee";//定义查询语句
		Vector<Vector> empInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(empInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);//设置表格的排序器
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//设置排序的集合，
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));//设置第一种排序方式：第1个参数2，为排序字段，指明为3第个字段cj，第2个参数为升序
		//sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//如果第一种排序有相同值，设置第二种排序方式：第1个参数0，为排序字段，指明为1第个字段xh，第2个参数为升序
		sorter.setSortKeys(sortKeys);
		
		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		JButton button = new JButton("查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String key=textField_4.getText().trim();//获取输入关键字文本框的值
					if(key.length()!=0) {
						sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
					}else {
						sorter.setRowFilter(null);//不过滤，显示所有数据
					}
			}
		});
		button.setBounds(279, 186, 93, 23);
		contentPane.add(button);
		
		JButton button_3 = new JButton("选择");
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
		
		JButton button_2 = new JButton("修改");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataOperate.upData_Employee(textField.getText(), textField_1.getText(), textField_2.getText(),textField_3.getText());
				Vector<String> titles = new Vector<String>();
				Collections.addAll(titles, "工号", "姓名","电话号码", "部门");
				String sql="select * from Employee";
				model=new DefaultTableModel(DataOperate.getSelectAll(sql),titles);
				table.setModel(model);
				JOptionPane.showMessageDialog(null, "修改成功");
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
