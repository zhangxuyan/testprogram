package com.jkxy.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

	/**
	 * 静态代码块
	 */
	static {
		System.out.println("执行静态代码块...");
	}

	/**
	 * 构造代码块
	 */
	{
		System.out.println("执行构造代码块...");
	}

	/**
	 * 无参构造函数
	 */
	public Test() {
		System.out.println("执行无参构造函数...");
	}

	/**
	 * 有参构造函数
	 * 
	 * @param id
	 */
	public Test(String id) {
		System.out.println("执行有参构造函数...");
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
		System.out.println("以为数组：" + array_01.getClass().getName());
		int[][] array_02 = new int[10][10];
		System.out.println("二维数组：" + array_02.getClass().getName());
		int[][][] array_03 = new int[10][10][10];
		System.out.println("三维数组：" + array_03.getClass().getName());
	}

	private static void test8() {
		int[] array = new int[10];
		System.out.println("array 的父类是：" + array.getClass().getSuperclass());
		System.out.println("array的类名是：" + array.getClass().getName());
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
		System.out.println("季利息是：" + i);
	}

	private static void test3() {
		System.out.println("12.5的四舍五入：" + Math.round(12.5));
		System.out.println("-12.5的四舍五入：" + Math.round(-12.5));
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
