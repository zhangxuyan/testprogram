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
			System.out.print("���ڽ���");
		else
			System.out.print("���ڽ���");
	}

	private static void testCalendar() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		// �������ڸ�ʽ
		System.out.println(sdf.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��

		// ��������
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, 10);
		System.out.println(sdf.format(nowTime.getTime()));
		System.out.println("--------\r\n" + sdf.format(Calendar.getInstance().getTime()));
		if (nowTime.before(Calendar.getInstance())) {

			System.out.println("������");
		}

		// Calendar curr = Calendar.getInstance();
		// // curr.setTime(timeMap.get(alarm.getOption()));
		// curr.set(Calendar.MINUTE, curr.get(Calendar.MINUTE) + 1);
		// if (curr.getTime().before(new Date())) {
		// System.out.println("������");
		// }
	}

	private static void ifMethod() {
		Integer normal = 60;
		Integer important = 80;
		Integer urgent = 90;
		Integer i = 95;
		if (urgent <= i) {
			System.out.println("����");
		} else if (important <= i) {

			System.out.println("��Ҫ");
		} else if (normal <= i) {

			System.out.println("����");
		} else {

			System.out.println("û��");
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
