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
	// 定义姓氏
	private static String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏"
			+ "水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍"
			+ "余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江"
			+ "童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程"
			+ "嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘"
			+ "钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬"
			+ "申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都"
			+ "耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游"
			+ "竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩"
			+ "辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋"
			+ "楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年" + "爱阳佟第五言福百家姓续";
	// 定义女生的名
	private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香"
			+ "月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁"
			+ "梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	// 定义男生的名
	private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥"
			+ "才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊"
			+ "民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠" + "策腾楠榕风航弘";

	public static int getNum(int start, int end) {// 随机返回返回指定范围间的整数
		// Math.random()随机返回0.0至1.0之间的数
		return (int) (Math.random() * (end - start + 1) + start);
	}

	public static StringBuilder getEid() {// 不使用String，因为需要大量拼接字符串
		StringBuilder eid = new StringBuilder("2021");// 工号前4位相同
		StringBuilder eid1 = new StringBuilder(String.valueOf(getNum(1, 99999)));// 随机取后5位
		if (eid1.length() == 1) {
			eid1 = eid1.insert(0, "0000");// 如果是1位数，前面增加4个0
			eid = eid.append(eid1);// 前6位与后3位拼接成学号
		} else if (eid1.length() == 2) {
			eid1 = eid1.insert(0, "000");// 如果是2位数，前面增加3个0
			eid = eid.append(eid1);
		} else if (eid1.length() == 3) {
			eid1 = eid1.insert(0, "00");// 如果是3位数，前面增加2个0
		} else if (eid1.length() == 4) {
			eid1 = eid1.insert(0, "0");// 如果是4位数，前面增加1个0
		} else {
			eid = eid.append(eid1);
		}
		return eid;
	}

	// 随机返回中文姓名
	public static String getChineseName() {
		int index = getNum(0, firstName.length() - 1);// 随机取姓氏字符串中的任意位置
		String first = firstName.substring(index, index + 1);// 获取该位置的姓氏
		int sex = getNum(0, 1);// 随机取性别，例如1为男生，0为女生
		String str = boy;// 定义名字为男生字符串
		int length = boy.length();// 获取男生字符串的长度
		if (sex == 0) {// 如果随机获取为0，则名字改为女生
			str = girl;
			length = girl.length();
		}
		index = getNum(0, length - 1);// 随机获取名字的位置
		String second = str.substring(index, index + 1);// 获取该位置中的名字
		int hasThird = getNum(0, 1);// 随机获取名字是否有第三个字
		String third = "";// 默认没有第三个字
		if (hasThird == 1) {// 如果随机获取为1，则有第三个字
			index = getNum(0, length - 1);
			third = str.substring(index, index + 1);
		}
		return first + second + third;// 返回姓名
	}

	// 随机返回一个部门
	public static String getDepart() {
		String[] departArray = { "技术部", "宣传部", "质量部", "财务部", "生产部", "人事部", "采购部", "销售部" };
		int departPos = (int) (7 * random());
		return departArray[departPos];
	}

	// 随即返回一个电话号码
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

	public static void addDataAll() {// 增加数据
		DatabaseConnection dbcs = new DatabaseConnection();// 使用1中定义的连接数据库的类
		String sql = "insert into Employee(eid,ename,department,telenum) values(?,?,?,?)";// 使用占位符定义插入语句
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// 实例化PreparedStatement
			ArrayList<String> alist = new ArrayList<String>();// 定义集合
			for (int i = 1; i <= 20000;) {
				String eid = getEid().toString();// 随机获取工号
				if (!alist.contains(eid)) {// 判断工号是否唯一
					alist.add(eid);// 将学号加入集合
					String ename = getChineseName();// 随机获取姓名
					String dem = getDepart();// 随机获取部门
					String telenum = getTele();// 随机获取电话号码
					pstmt.setString(1, eid);// 定义第1个占位符的内容
					pstmt.setString(2, ename);// 定义第2个占位符的内容
					pstmt.setString(3, dem);// 定义第3个占位符的内容
					pstmt.setString(4, telenum);// 定义第4个占位符的内容
					pstmt.addBatch();// 加入批处理等待执行
					i++;// 学号唯一，循环继续往下执行
				}
			}
			pstmt.executeBatch();// 批量执行插入操作
			JOptionPane.showMessageDialog(null, "sucess");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Vector<Vector> getSelectAll(String sql) {
		Vector<Vector> rows = new Vector<Vector>();// 定义要返回的所有记录集合
		DatabaseConnection dbcs = new DatabaseConnection();// 使用1中定义的连接数据库的类
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// 实例化PreparedStatement
			ResultSet rs = pstmt.executeQuery();// 执行查询语句，结果放到数据集中
			while (rs.next()) {// 遍历数据集
				Vector row = new Vector();// 定义行数据
				row.add(rs.getString(1));// 获取第一个字段学号
				row.add(rs.getString(2));// 获取第二个字段姓名
				row.add(rs.getString(3));// 获取第三个字段部门
				row.add(rs.getString(4));// 获取第四个字段电话号码
				rows.add(row);// 将行数据添加到记录集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;// 返回所有行数据
	}
	
	public static void addData(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement pstmt = conn.createStatement()){// 实例化PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Blacklist (Eid,Ename,Telenum,Department) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql1);// 实例化PreparedStatement
				) {
			pstmt.setString(1, e1);// 定义第1个占位符的内容
			pstmt.setString(2, n1);// 定义第2个占位符的内容
			pstmt.setString(3, t1);// 定义第3个占位符的内容
			pstmt.setString(4, d1);// 定义第4个占位符的内容
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement pstmt = conn.createStatement()){// 实例化PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Employee (Eid,Ename,Telenum,Department) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql1);// 实例化PreparedStatement
				) {
			pstmt.setString(1, e1);// 定义第1个占位符的内容
			pstmt.setString(2, n1);// 定义第2个占位符的内容
			pstmt.setString(3, t1);// 定义第3个占位符的内容
			pstmt.setString(4, d1);// 定义第4个占位符的内容
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
	             PreparedStatement pstmt = conn.prepareStatement(sql);// 实例化PreparedStatement
	        ) {
	            pstmt.setString(1, eid);// 定义第1个占位符的内容
	            pstmt.setString(2, ename);// 定义第2个占位符的内容
	            pstmt.setString(3, telenum);// 定义第3个占位符的内容
	            pstmt.setString(4, department);// 定义第4个占位符的内容	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	        }
	}
	public static void addData2(String award,String quota,String award1,String quota1,String award2,String quota2,String award3,String quota3) {
        DatabaseConnection dbcs = new DatabaseConnection();
        String sql="insert into Award(Grandpri,Gnum,Firstpri,Fnum,Secondpri,Snum,Thirdpri,Tnum) values (?,?,?,?,?,?,?,?)";
        try (Connection conn = dbcs.getConnection(); // 获取数据库接
             PreparedStatement pstmt = conn.prepareStatement(sql);// 实例化PreparedStatement
        ) {
            pstmt.setString(1, award);// 定义第1个占位符的内容
            pstmt.setString(2, quota);// 定义第2个占位符的内容
            pstmt.setString(3, award1);// 定义第3个占位符的内容
            pstmt.setString(4, quota1);// 定义第4个占位符的内容
            pstmt.setString(5, award2);// 定义第5个占位符的内容
            pstmt.setString(6, quota2);// 定义第6个占位符的内容
            pstmt.setString(7, award3);// 定义第7个占位符的内容
            pstmt.setString(8, quota3);// 定义第8个占位符的内容
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
	}
	
	public static void addData_award1(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement pstmt = conn.createStatement()){// 实例化PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_1 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql1);// 实例化PreparedStatement
				) {
			pstmt.setString(1, e1);// 定义第1个占位符的内容
			pstmt.setString(2, n1);// 定义第2个占位符的内容
			pstmt.setString(3, t1);// 定义第3个占位符的内容
			pstmt.setString(4, Awaquo.getT());// 定义第4个占位符的内容
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void addData_award2(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement pstmt = conn.createStatement()){// 实例化PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_2 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql1);// 实例化PreparedStatement
				) {
			pstmt.setString(1, e1);// 定义第1个占位符的内容
			pstmt.setString(2, n1);// 定义第2个占位符的内容
			pstmt.setString(3, t1);// 定义第3个占位符的内容
			pstmt.setString(4, Awaquo.getT_1());// 定义第4个占位符的内容
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void addData_award3(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement pstmt = conn.createStatement()){// 实例化PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_3 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql1);// 实例化PreparedStatement
				) {
			pstmt.setString(1, e1);// 定义第1个占位符的内容
			pstmt.setString(2, n1);// 定义第2个占位符的内容
			pstmt.setString(3, t1);// 定义第3个占位符的内容
			pstmt.setString(4, Awaquo.getT_2());// 定义第4个占位符的内容
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void addData_award4(String eid) {
		DatabaseConnection dbcs = new DatabaseConnection();
		String e1 = null, n1 = null, t1 = null, d1 = null;
		String sql = "select * from Employee";
		try (Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement pstmt = conn.createStatement()){// 实例化PreparedStatement
				ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
				while(rs.next()) {
					if(rs.getString("Eid").equals(eid)){
						e1 = rs.getString("Eid");
						n1 = rs.getString("Ename");
						t1 = rs.getString("Telenum");
						//d1 = rs.getString("Department");
					}
				}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		DatabaseConnection dbcs1 = new DatabaseConnection();
		String sql1 = "insert into Awardlist_4 (Eid,Ename,Telenum,Award) values (?,?,?,?)";
		try (Connection conn = dbcs1.getConnection(); // 获取数据库接
				PreparedStatement pstmt = conn.prepareStatement(sql1);// 实例化PreparedStatement
				) {
			pstmt.setString(1, e1);// 定义第1个占位符的内容
			pstmt.setString(2, n1);// 定义第2个占位符的内容
			pstmt.setString(3, t1);// 定义第3个占位符的内容
			pstmt.setString(4, Awaquo.getT_3());// 定义第4个占位符的内容
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static void upData_Employee(String eid,String ename,String telenum,String department) {
		DatabaseConnection dbcs=new DatabaseConnection();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		String sql="update Employee set Ename='"+ename+"',Telenum='"+telenum+"',Department='"+department+"' where Eid="+eid;
		try {
			Statement stm=conn.createStatement();
			stm.executeUpdate(sql);
			stm.addBatch(sql);
			stm.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static ArrayList getData() {
        ArrayList arrayList = new ArrayList();
        DatabaseConnection dbcs = new DatabaseConnection();
        String sql = "select Eid from Employee";
        try {
            try (Connection conn = dbcs.getConnection(); // 获取数据库接
                 Statement pstmt = conn.createStatement()) {// 实例化PreparedStatement
                ResultSet rs = pstmt.executeQuery(sql);// 执行查询语句，结果放到数据集中
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
