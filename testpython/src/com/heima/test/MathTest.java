package com.heima.test;

import java.text.DecimalFormat;

public class MathTest {
	public static void main(String[] args) {
		System.out.println(getNumber(0.9));
	}

	public static String getNumber(double num) {
		DecimalFormat df = new DecimalFormat("#0.000");// ģʽ����д��"#.00"
		return df.format(num);
	}

}
