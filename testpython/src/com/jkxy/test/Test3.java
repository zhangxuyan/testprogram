package com.jkxy.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test3 {

	static Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
		// test1();

		// String d1 = test2(-15);
		// String d2 = test2(-30);
		// String d3 = test2(-45);
		// String d4 = test2(-60);
		// map.put(new Date("yyyy-MM-dd HH:mm:ss").toString(), d1);
		// System.out.println(d1 + " \n" + d2 + " \n" + d3 + " \n" + d4 + "
		// \n");
		
		map=test2();
		map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		 

//		for( :map.keySet()){
//			
//			
//		}
	}

	private static Map<String, String> test2() {
		// ��ȡ��ǰ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String currentDate = sdf.format(today);// ��ǰ����
		// ��ȡ��ʮ��ǰ����
		Calendar theCa = Calendar.getInstance();
		theCa.setTime(today);
		// theCa.add(theCa.DATE, -30);// ���һ������30�ɸģ�30�����˼
		theCa.add(theCa.DAY_OF_YEAR, -1);

		Date start = theCa.getTime();
		String startDate1 = sdf.format(start);
		map.put(currentDate, startDate1);
		System.out.println("��ǰʱ�䣺" + startDate1);

		theCa.add(theCa.MINUTE, -15);
		start = theCa.getTime();
		String startDate2 = sdf.format(start);
		map.put(startDate1, startDate2);
		System.out.println("��ǰʱ�䣺" + startDate2);

		theCa.add(theCa.MINUTE, -15);
		start = theCa.getTime();
		String startDate3 = sdf.format(start);
		map.put(startDate2, startDate3);
		System.out.println("��ǰʱ�䣺" + startDate3);

		theCa.add(theCa.MINUTE, -15);
		start = theCa.getTime();
		String startDate4 = sdf.format(start);
		map.put(startDate3, startDate4);
		System.out.println("��ǰʱ�䣺" + startDate4);

		return map;
	}

	private static void test1() {
		// ����Calendar����
		Calendar c = Calendar.getInstance();

		// ��Calendar����ת��ΪDate����
		Date date = c.getTime();

		// ����SimpleDateFormat����ָ��Ŀ���ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// ������ת��Ϊָ����ʽ���ַ���
		String now = sdf.format(date);
		System.out.println("��ǰʱ�䣺" + now);
	}
}
