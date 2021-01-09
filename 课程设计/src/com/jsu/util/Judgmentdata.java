package com.jsu.util;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.jsu.dao.DataOperate;

//判断输入的名额是否为数字
public class Judgmentdata {
	public static boolean Judge(String quota) {    
		 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
		 return pattern.matcher(quota).matches();     
	}
	public static boolean JudgeEmpty(String award,String award1,String award2,String award3) {
		if(award.length()!=0&award1.length()!=0&award2.length()!=0&award3.length()!=0) {
			return true;
		}
		else
			return false;
	}
	public static boolean JudgeExist(String eid) {
		ArrayList<String> arraylist=DataOperate.getData();
		if(!arraylist.contains(eid)) {
			return true;
		}else {
			return false;
		}
	}
}
