package com.jsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.jsu.ui.Adddata;
import com.jsu.ui.Awaquo;

import static java.lang.Math.random;

public class DataOperate {
	// ��������
	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������"
			+ "ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵��"
			+ "��Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��"
			+ "ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť����"
			+ "���ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ��"
			+ "���������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼�"
			+ "�����Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ��"
			+ "���������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺���"
			+ "��Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������"
			+ "ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸�������"
			+ "���ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī��������" + "����١�����Ը��ټ�����";
	// ����Ů������
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ��"
			+ "��ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ"
			+ "���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	// ������������
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��"
			+ "�ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ�����"
			+ "����ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾���" + "������ŷ纽��";

	public static int getNum(int start, int end) {// ������ط���ָ����Χ�������
		// Math.random()�������0.0��1.0֮�����
		return (int) (Math.random() * (end - start + 1) + start);
	}

	public static StringBuilder getEid() {// ��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
		StringBuilder eid = new StringBuilder("2021");// ����ǰ4λ��ͬ
		StringBuilder eid1 = new StringBuilder(String.valueOf(getNum(1, 99999)));// ���ȡ��5λ
		if (eid1.length() == 1) {
			eid1 = eid1.insert(0, "0000");// �����1λ����ǰ������4��0
			eid = eid.append(eid1);// ǰ6λ���3λƴ�ӳ�ѧ��
		} else if (eid1.length() == 2) {
			eid1 = eid1.insert(0, "000");// �����2λ����ǰ������3��0
			eid = eid.append(eid1);
		} else if (eid1.length() == 3) {
			eid1 = eid1.insert(0, "00");// �����3λ����ǰ������2��0
		} else if (eid1.length() == 4) {
			eid1 = eid1.insert(0, "0");// �����4λ����ǰ������1��0
		} else {
			eid = eid.append(eid1);
		}
		return eid;
	}

	// ���������������
	public static String getChineseName() {
		int index = getNum(0, firstName.length() - 1);// ���ȡ�����ַ����е�����λ��
		String first = firstName.substring(index, index + 1);// ��ȡ��λ�õ�����
		int sex = getNum(0, 1);// ���ȡ�Ա�����1Ϊ������0ΪŮ��
		String str = boy;// ��������Ϊ�����ַ���
		int length = boy.length();// ��ȡ�����ַ����ĳ���
		if (sex == 0) {// ��������ȡΪ0�������ָ�ΪŮ��
			str = girl;
			length = girl.length();
		}
		index = getNum(0, length - 1);// �����ȡ���ֵ�λ��
		String second = str.substring(index, index + 1);// ��ȡ��λ���е�����
		int hasThird = getNum(0, 1);// �����ȡ�����Ƿ��е�������
		String third = "";// Ĭ��û�е�������
		if (hasThird == 1) {// ��������ȡΪ1�����е�������
			index = getNum(0, length - 1);
			third = str.substring(index, index + 1);
		}
		return first + second + third;// ��������
	}

	// �������һ������
	public static String getDepart() {
		String[] departArray = { "������", "������", "������", "����", "������", "���²�", "�ɹ���", "���۲�" };
		int departPos = (int) (7 * random());
		return departArray[departPos];
	}

	// �漴����һ���绰����
	private static String getTele() {
		String[] telFirst = ("134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156," + "133,153")
				.split(",");
		int index = (int) (Math.random() * telFirst.length);
		String first = telFirst[index];
		String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
		String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
		return first + second + thrid;
	}

	public static void main(String[] args) {
		//addDataAll();
	}

	public static void addDataAll() {// ��������
		DatabaseConnection dbcs = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
		String sql = "insert into Employee(eid,ename,department,telenum) values(?,?,?,?)";// ʹ��ռλ������������
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement
			ArrayList<String> alist = new ArrayList<String>();// ���弯��
			for (int i = 1; i <= 20000;) {
				String eid = getEid().toString();// �����ȡ����
				if (!alist.contains(eid)) {// �жϹ����Ƿ�Ψһ
					alist.add(eid);// ��ѧ�ż��뼯��
					String ename = getChineseName();// �����ȡ����
					String dem = getDepart();// �����ȡ����
					String telenum = getTele();// �����ȡ�绰����
					pstmt.setString(1, eid);// �����1��ռλ��������
					pstmt.setString(2, ename);// �����2��ռλ��������
					pstmt.setString(3, dem);// �����3��ռλ��������
					pstmt.setString(4, telenum);// �����4��ռλ��������
					pstmt.addBatch();// ����������ȴ�ִ��
					i++;// ѧ��Ψһ��ѭ����������ִ��
				}
			}
			pstmt.executeBatch();// ����ִ�в������
			JOptionPane.showMessageDialog(null, "sucess");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Vector<Vector> getSelectAll(String sql) {
		Vector<Vector> rows = new Vector<Vector>();// ����Ҫ���ص����м�¼����
		DatabaseConnection dbcs = new DatabaseConnection();// ʹ��1�ж�����������ݿ����
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement
			ResultSet rs = pstmt.executeQuery();// ִ�в�ѯ��䣬����ŵ����ݼ���
			while (rs.next()) {// �������ݼ�
				Vector row = new Vector();// ����������
				row.add(rs.getString(1));// ��ȡ��һ���ֶ�ѧ��
				row.add(rs.getString(2));// ��ȡ�ڶ����ֶ�����
				row.add(rs.getString(3));// ��ȡ�������ֶβ���
				row.add(rs.getString(4));// ��ȡ���ĸ��ֶε绰����
				rows.add(row);// ����������ӵ���¼������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;// ��������������
	}
	
	public static void addData(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement pstmt = conn.createStatement()){// ʵ����PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Blacklist (Eid,Ename,Telenum,Department) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql1);// ʵ����PreparedStatement
				) {
			pstmt.setString(1, e1);// �����1��ռλ��������
			pstmt.setString(2, n1);// �����2��ռλ��������
			pstmt.setString(3, t1);// �����3��ռλ��������
			pstmt.setString(4, d1);// �����4��ռλ��������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void deletData(String eid){
        DatabaseConnection dbcs=new DatabaseConnection();
        String sql="delete from Employee where Eid="+eid;
        Connection conn=dbcs.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
	
	public static void addData1(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Blacklist";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement pstmt = conn.createStatement()){// ʵ����PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Employee (Eid,Ename,Telenum,Department) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql1);// ʵ����PreparedStatement
				) {
			pstmt.setString(1, e1);// �����1��ռλ��������
			pstmt.setString(2, n1);// �����2��ռλ��������
			pstmt.setString(3, t1);// �����3��ռλ��������
			pstmt.setString(4, d1);// �����4��ռλ��������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void deletData1(String eid){
        DatabaseConnection dbcs=new DatabaseConnection();
        String sql="delete from Blacklist where Eid="+eid;
        Connection conn=dbcs.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
	
	public static void addData_Employee_kb(String eid,String ename,String telenum,String department) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String sql="insert into Employee(Eid,Ename,Telenum,Department) values(?,?,?,?)";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
	             PreparedStatement pstmt = conn.prepareStatement(sql);// ʵ����PreparedStatement
	        ) {
	            pstmt.setString(1, eid);// �����1��ռλ��������
	            pstmt.setString(2, ename);// �����2��ռλ��������
	            pstmt.setString(3, telenum);// �����3��ռλ��������
	            pstmt.setString(4, department);// �����4��ռλ��������	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            // TODO �Զ����ɵ� catch ��
	            e.printStackTrace();
	        }
	}
	public static void addData2(String award,String quota,String award1,String quota1,String award2,String quota2,String award3,String quota3) {
        DatabaseConnection dbcs = new DatabaseConnection();
        String sql="insert into Award(Grandpri,Gnum,Firstpri,Fnum,Secondpri,Snum,Thirdpri,Tnum) values (?,?,?,?,?,?,?,?)";
        try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
             PreparedStatement pstmt = conn.prepareStatement(sql);// ʵ����PreparedStatement
        ) {
            pstmt.setString(1, award);// �����1��ռλ��������
            pstmt.setString(2, quota);// �����2��ռλ��������
            pstmt.setString(3, award1);// �����3��ռλ��������
            pstmt.setString(4, quota1);// �����4��ռλ��������
            pstmt.setString(5, award2);// �����5��ռλ��������
            pstmt.setString(6, quota2);// �����6��ռλ��������
            pstmt.setString(7, award3);// �����7��ռλ��������
            pstmt.setString(8, quota3);// �����8��ռλ��������
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
	}
	
	public static void addData_award1(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement pstmt = conn.createStatement()){// ʵ����PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_1 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql1);// ʵ����PreparedStatement
				) {
			pstmt.setString(1, e1);// �����1��ռλ��������
			pstmt.setString(2, n1);// �����2��ռλ��������
			pstmt.setString(3, t1);// �����3��ռλ��������
			pstmt.setString(4, Awaquo.getT());// �����4��ռλ��������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void addData_award2(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement pstmt = conn.createStatement()){// ʵ����PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_2 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql1);// ʵ����PreparedStatement
				) {
			pstmt.setString(1, e1);// �����1��ռλ��������
			pstmt.setString(2, n1);// �����2��ռλ��������
			pstmt.setString(3, t1);// �����3��ռλ��������
			pstmt.setString(4, Awaquo.getT_1());// �����4��ռλ��������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void addData_award3(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement pstmt = conn.createStatement()){// ʵ����PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_3 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql1);// ʵ����PreparedStatement
				) {
			pstmt.setString(1, e1);// �����1��ռλ��������
			pstmt.setString(2, n1);// �����2��ռλ��������
			pstmt.setString(3, t1);// �����3��ռλ��������
			pstmt.setString(4, Awaquo.getT_2());// �����4��ռλ��������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void addData_award4(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				Statement pstmt = conn.createStatement()){// ʵ����PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_4 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql1);// ʵ����PreparedStatement
				) {
			pstmt.setString(1, e1);// �����1��ռλ��������
			pstmt.setString(2, n1);// �����2��ռλ��������
			pstmt.setString(3, t1);// �����3��ռλ��������
			pstmt.setString(4, Awaquo.getT_3());// �����4��ռλ��������
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static void upData_Employee(String eid,String ename,String telenum,String department) {
		DatabaseConnection dbcs=new DatabaseConnection();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		String sql="update Employee set Ename='"+ename+"',Telenum='"+telenum+"',Department='"+department+"' where Eid="+eid;
		try {
			Statement stm=conn.createStatement();
			stm.executeUpdate(sql);
			stm.addBatch(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static ArrayList getData() {
        ArrayList arrayList = new ArrayList();
        DatabaseConnection dbcs = new DatabaseConnection();
        String sql = "select Eid from Employee";
        try {
            try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
                 Statement pstmt = conn.createStatement()) {// ʵ����PreparedStatement
                ResultSet rs = pstmt.executeQuery(sql);// ִ�в�ѯ��䣬����ŵ����ݼ���
                while (rs.next()) {
                    arrayList.add(rs.getString("Eid"));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }
}
