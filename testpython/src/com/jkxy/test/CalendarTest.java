package com.jkxy.test;
//

//public class CalendarTest {
//
//}

//package date;

import java.text.DateFormatSymbols;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		// ��ӡ���µ�����

		Calendar cal = Calendar.getInstance();

		// ��ȡ�������ں��·�

		int today = cal.get(Calendar.DAY_OF_MONTH);

		int month = cal.get(Calendar.MONTH);

		// ������ָ���µ�һ��

		cal.set(Calendar.DAY_OF_MONTH, 1);

		// ���µ�һ�������ڼ����Լ�һ�ܵĵ�һ�������ڼ�

		int weekday = cal.get(Calendar.DAY_OF_WEEK);

		int firstDayOfWeek = cal.getFirstDayOfWeek();

		// �ж�������һ�е�һ������һ��

		int daysInLastMonth = 0;

		while (weekday != firstDayOfWeek) {

			// ������µ�һ�첻��һ�ܵĵ�һ�죬��ô����ָ��ǰһ��

			daysInLastMonth++;

			cal.add(Calendar.DAY_OF_MONTH, -1);

			weekday = cal.get(Calendar.DAY_OF_WEEK);

		}

		// ��ӡ������

		String[] weekdayName = new DateFormatSymbols().getWeekdays();

		do {

			System.out.printf("%6s", weekdayName[weekday]);

			cal.add(Calendar.DAY_OF_MONTH, 1);

			weekday = cal.get(Calendar.DAY_OF_WEEK);

		} while (weekday != firstDayOfWeek);

		System.out.println();

		// ��ӡ��һ�������ϸ������ڵĿո�

		for (int i = 0; i < daysInLastMonth; i++) {

			System.out.print("      ");

		}

		// ��ӡ����

		cal.set(Calendar.DAY_OF_MONTH, 1);

		while (month == cal.get(Calendar.MONTH)) {

			int day = cal.get(Calendar.DAY_OF_MONTH);

			System.out.printf("%5d", day);

			// ����ǽ��죬���ӡ*

			if (day == today) {

				System.out.print("*");

			} else {

				System.out.print(" ");

			}

			// ��������

			cal.add(Calendar.DAY_OF_MONTH, 1);

			weekday = cal.get(Calendar.DAY_OF_WEEK);

			// ���һ�н��������뻻�з�

			if (weekday == firstDayOfWeek) {

				System.out.println();

			}

		}

		// ������½�������һ�е�ĩβ�������һ���з�

		if (weekday != firstDayOfWeek) {

			System.out.println();

		}

	}

}