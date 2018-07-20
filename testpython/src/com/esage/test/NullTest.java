package com.esage.test;

public class NullTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testNullObject();
	}

	public static void testNull() {
		int age = 0;
		System.out.println("user age:" + age);

		long money;
		money = 10L;
		System.out.println("user money" + money);

		String name = null;
		System.out.println("user name:" + name);
	}

	public static void testNullObject() {
		if ("11" instanceof java.lang.String) {
			System.out.println("null属于java.lang.Object类型");
		} else {
			System.out.println("null不属于java.lang.Object类型");
		}
	}

}
