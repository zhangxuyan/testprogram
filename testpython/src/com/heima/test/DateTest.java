package com.heima.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d); // 打印的时间看不懂，希望有些格式。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		String time = sdf.format(d);
		System.out.println("time=" + time);
	}
}
