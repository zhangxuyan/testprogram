package com.heima.test;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		// demo();
		Calendar c = Calendar.getInstance();
		String[] mons = { "һ��", "����", "����", "����", "����", "����", "����", "����", "����", "ʮ��", "ʮһ��", "ʮ����" };
		String[] weeks = { "", "������", "����һ", "���ڶ�", "������", "������", "������", "������" };

		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_WEEK);

		sop(c.get(Calendar.YEAR) + "��");
		sop(mons[index]);
		sop(c.get(Calendar.DAY_OF_MONTH) + "��");
		sop(weeks[index1]);
	}

	/**
	 * 
	 */
	static void demo() {
		Calendar c = Calendar.getInstance();

		sop(c.get(Calendar.YEAR) + "��");
		sop((c.get(Calendar.MONTH) + 1) + "��");
		sop(c.get(Calendar.DAY_OF_MONTH) + "��");
		sop("����" + c.get(Calendar.DAY_OF_WEEK));
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
