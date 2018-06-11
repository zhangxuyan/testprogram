package com.esage.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateTimeUtil {

	public static void main(String[] args) {
		String str=new Date("yyyy-MM-dd HH:mm:ss").toString();
		HashMap<String, String> date = getTime();
	}

	/*
	 * 返回一个关于时间的HashMap 集合
	 * 
	 * @return
	 */
	public static HashMap<String, String> getTime() {

		HashMap<String, String> hm = new HashMap<String, String>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar c = Calendar.getInstance();
		// 过去一天
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		Date t = c.getTime();
		String days = format.format(t);
		System.out.println("过去一天：" + days);
		hm.put("days", days);

		// 过去七天
		c.setTime(new Date());
		c.add(Calendar.DATE, -7);
		Date d = c.getTime();
		String day = format.format(d);
		System.out.println("过去七天：" + day);
		hm.put("day", day);

		// 过去十天
		c.setTime(new Date());
		c.add(Calendar.DATE, -10);
		Date d10 = c.getTime();
		String day10 = format.format(d10);
		hm.put("day10", day10);

		// 过去一月
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		System.out.println("过去一个月：" + mon);
		hm.put("mon", mon);

		// 过去三个月
		c.setTime(new Date());
		c.add(Calendar.MONTH, -3);
		Date m3 = c.getTime();
		String mon3 = format.format(m3);
		System.out.println("过去三个月：" + mon3);
		hm.put("mon3", mon3);

		// 过去一年

		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date y = c.getTime();
		String year = format.format(y);
		System.out.println("过去一年：" + year);
		hm.put("year", year);

		return hm;
	}

}
