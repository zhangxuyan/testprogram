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

		// 打印当月的日历

		Calendar cal = Calendar.getInstance();

		// 获取今天日期和月份

		int today = cal.get(Calendar.DAY_OF_MONTH);

		int month = cal.get(Calendar.MONTH);

		// 将日历指向本月第一天

		cal.set(Calendar.DAY_OF_MONTH, 1);

		// 本月第一天是星期几，以及一周的第一天是星期几

		int weekday = cal.get(Calendar.DAY_OF_WEEK);

		int firstDayOfWeek = cal.getFirstDayOfWeek();

		// 判断日历第一行第一列是哪一天

		int daysInLastMonth = 0;

		while (weekday != firstDayOfWeek) {

			// 如果本月第一天不是一周的第一天，那么日历指向前一天

			daysInLastMonth++;

			cal.add(Calendar.DAY_OF_MONTH, -1);

			weekday = cal.get(Calendar.DAY_OF_WEEK);

		}

		// 打印星期名

		String[] weekdayName = new DateFormatSymbols().getWeekdays();

		do {

			System.out.printf("%6s", weekdayName[weekday]);

			cal.add(Calendar.DAY_OF_MONTH, 1);

			weekday = cal.get(Calendar.DAY_OF_WEEK);

		} while (weekday != firstDayOfWeek);

		System.out.println();

		// 打印第一行属于上个月日期的空格

		for (int i = 0; i < daysInLastMonth; i++) {

			System.out.print("      ");

		}

		// 打印日期

		cal.set(Calendar.DAY_OF_MONTH, 1);

		while (month == cal.get(Calendar.MONTH)) {

			int day = cal.get(Calendar.DAY_OF_MONTH);

			System.out.printf("%5d", day);

			// 如果是今天，则打印*

			if (day == today) {

				System.out.print("*");

			} else {

				System.out.print(" ");

			}

			// 日历步进

			cal.add(Calendar.DAY_OF_MONTH, 1);

			weekday = cal.get(Calendar.DAY_OF_WEEK);

			// 如果一行结束，加入换行符

			if (weekday == firstDayOfWeek) {

				System.out.println();

			}

		}

		// 如果该月结束不在一行的末尾，则加入一换行符

		if (weekday != firstDayOfWeek) {

			System.out.println();

		}

	}

}