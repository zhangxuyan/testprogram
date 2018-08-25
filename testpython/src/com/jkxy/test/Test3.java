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
		// 获取当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String currentDate = sdf.format(today);// 当前日期
		// 获取三十天前日期
		Calendar theCa = Calendar.getInstance();
		theCa.setTime(today);
		// theCa.add(theCa.DATE, -30);// 最后一个数字30可改，30天的意思
		theCa.add(theCa.DAY_OF_YEAR, -1);

		Date start = theCa.getTime();
		String startDate1 = sdf.format(start);
		map.put(currentDate, startDate1);
		System.out.println("当前时间：" + startDate1);

		theCa.add(theCa.MINUTE, -15);
		start = theCa.getTime();
		String startDate2 = sdf.format(start);
		map.put(startDate1, startDate2);
		System.out.println("当前时间：" + startDate2);

		theCa.add(theCa.MINUTE, -15);
		start = theCa.getTime();
		String startDate3 = sdf.format(start);
		map.put(startDate2, startDate3);
		System.out.println("当前时间：" + startDate3);

		theCa.add(theCa.MINUTE, -15);
		start = theCa.getTime();
		String startDate4 = sdf.format(start);
		map.put(startDate3, startDate4);
		System.out.println("当前时间：" + startDate4);

		return map;
	}

	private static void test1() {
		// 创建Calendar对象
		Calendar c = Calendar.getInstance();

		// 将Calendar对象转换为Date对象
		Date date = c.getTime();

		// 创建SimpleDateFormat对象，指定目标格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 将日期转换为指定格式的字符串
		String now = sdf.format(date);
		System.out.println("当前时间：" + now);
	}
}
