package com.heima.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d); // ��ӡ��ʱ�俴������ϣ����Щ��ʽ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss");
		String time = sdf.format(d);
		System.out.println("time=" + time);
	}
}
