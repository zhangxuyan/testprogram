package com.esage.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hyperic.sigar.SigarException;

import com.esage.util.*;

public class Testif {

	public static void main(String[] args) throws ParseException, UnknownHostException, SigarException {
		// OSUtil osUtil=new OSUtil();
		// osUtil.

		// OSUtil.property();
		// OSUtil.memory();

	}

	private static void testDate() throws ParseException {
		java.util.Date nowdate = new java.util.Date();
		String myString = "2008/09/08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
		Date d = sdf.parse(myString);

		boolean flag = d.before(nowdate);
		if (flag)
			System.out.print("早于今天");
		else
			System.out.print("晚于今天");
	}

	private static void testCalendar() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		// 设置日期格式
		System.out.println(sdf.format(new Date()));// new Date()为获取当前系统时间

		// 方法二：
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, 10);
		System.out.println(sdf.format(nowTime.getTime()));
		System.out.println("--------\r\n" + sdf.format(Calendar.getInstance().getTime()));
		if (nowTime.before(Calendar.getInstance())) {

			System.out.println("到点了");
		}

		// Calendar curr = Calendar.getInstance();
		// // curr.setTime(timeMap.get(alarm.getOption()));
		// curr.set(Calendar.MINUTE, curr.get(Calendar.MINUTE) + 1);
		// if (curr.getTime().before(new Date())) {
		// System.out.println("到点了");
		// }
	}

	private static void ifMethod() {
		Integer normal = 60;
		Integer important = 80;
		Integer urgent = 90;
		Integer i = 95;
		if (urgent <= i) {
			System.out.println("紧急");
		} else if (important <= i) {

			System.out.println("重要");
		} else if (normal <= i) {

			System.out.println("正常");
		} else {

			System.out.println("没有");
		}
	}

	private static String diskUsedRate() {
		String cmd = "df -lh";
		String line;
		String diskrate = null;
		try {
			Process pr = Runtime.getRuntime().exec(cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));

			while ((line = reader.readLine()) != null) {
				if (line.endsWith("/")) {
					String[] disk = line.split(" ");
					for (String rate : disk) {
						if (rate.contains("%")) {
							diskrate = rate;
						}
					}

				}

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return diskrate;
	}

}
