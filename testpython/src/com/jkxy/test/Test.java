package com.jkxy.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

	/**
	 * ��̬�����
	 */
	static {
		System.out.println("ִ�о�̬�����...");
	}

	/**
	 * ��������
	 */
	{
		System.out.println("ִ�й�������...");
	}

	/**
	 * �޲ι��캯��
	 */
	public Test() {
		System.out.println("ִ���޲ι��캯��...");
	}

	/**
	 * �вι��캯��
	 * 
	 * @param id
	 */
	public Test(String id) {
		System.out.println("ִ���вι��캯��...");
	}

	public static void main(String[] args) {
		// test2();
		// test1();
		// test3();
		//
		// test4();

		// test5();
		// test6();
		// test7();

		// test8();

		// test9();

//		Map<K, V>
//		List<E>
		//ArrayList<E>
	}

	private static void test9() {
		int[] array_01 = new int[10];
		System.out.println("��Ϊ���飺" + array_01.getClass().getName());
		int[][] array_02 = new int[10][10];
		System.out.println("��ά���飺" + array_02.getClass().getName());
		int[][][] array_03 = new int[10][10][10];
		System.out.println("��ά���飺" + array_03.getClass().getName());
	}

	private static void test8() {
		int[] array = new int[10];
		System.out.println("array �ĸ����ǣ�" + array.getClass().getSuperclass());
		System.out.println("array�������ǣ�" + array.getClass().getName());
	}

	private static void test7() {
		String str = "2";
		System.out.println(str.equals("2"));
	}

	private static void test6() {
		System.out.println("----------------------");
		new Test();
		System.out.println("----------------------");
		new Test("1");
	}

	private static void test5() {
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		a1.cry();
		a2.cry();
	}

	private static void test4() {
		BigDecimal d = new BigDecimal(100000);
		BigDecimal r = new BigDecimal(0.001875 * 3);
		BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
		System.out.println("����Ϣ�ǣ�" + i);
	}

	private static void test3() {
		System.out.println("12.5���������룺" + Math.round(12.5));
		System.out.println("-12.5���������룺" + Math.round(-12.5));
	}

	private static void test2() {
		Wine a = new JNC();
		a.fun1();
	}

	private static void test1() {
		Wine[] wines = new Wine[2];

		JNC jnc = new JNC();
		JGJ jgj = new JGJ();

		wines[0] = jnc;
		wines[1] = jgj;
		for (int i = 0; i < 2; i++) {

			System.out.println(wines[i].toString() + "--" + wines[i].drink());
		}

		System.out.println("--------");
	}
}
