package com.jsu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jsu.dao.DataOperate;
import javax.swing.ImageIcon;

public class Deletblalist extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DefaultTableModel model;// 定义表格数据模型
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletblalist frame = new Deletblalist();
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
	public Deletblalist() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(70, 102, 539, 316);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中
			

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "工号", "姓名", "电话号码","部门");
		String sql="select * from Blacklist";//定义查询语句
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
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setRowSorter(sorter);//设置表格的排序器
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//设置排序的集合，
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));//设置第一种排序方式：第1个参数2，为排序字段，指明为3第个字段cj，第2个参数为升序
		//sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//如果第一种排序有相同值，设置第二种排序方式：第1个参数0，为排序字段，指明为1第个字段xh，第2个参数为升序
		sorter.setSortKeys(sortKeys);//设置排序器的排序规则

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
			
		JLabel lblKey = new JLabel("输入关键字：");
		lblKey.setBounds(70, 45, 80, 15);
		contentPane.add(lblKey);
			
		JButton btnFind = new JButton("查找");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=textField.getText().trim();//获取输入关键字文本框的值
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
				}else {
					sorter.setRowFilter(null);//不过滤，显示所有数据
				}
					
			}
		});
		btnFind.setBounds(335, 41, 122, 23);
		contentPane.add(btnFind);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 42, 114, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();// 获取你选中的行号（记录）
				String getname = table.getValueAt(count, 0).toString();// 读取你获取行号的某一列的值（也就是字段）
				DataOperate.addData1(getname);
				DataOperate.deletData1(getname);
				JOptionPane.showMessageDialog(null, "删除成功");
			}
		});
		button.setBounds(516, 41, 93, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\steam\\steamapps\\workshop\\content\\431960\\1433247985\\preview.jpg"));
		lblNewLabel.setBounds(0, 0, 688, 465);
		contentPane.add(lblNewLabel);
	}
}
