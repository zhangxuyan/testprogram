package com.jkxy.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Test2 {

	/*  
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {

		// Map<Integer, Integer> map =new Map<Integer, Integer>();
		// 5.、、区别？
		// HashSet hs=new HashSet<>();

		// TreeSet
		// LinkedHashSet
		getLinkedList();
	}

	public static void getArrayList() {
		ArrayList aa = new ArrayList();
		System.out.println(new Date());

		for (int i = 0; i < 100; i++) {
			aa.add(i);
		}
		aa.add(0);
		for (int i = 0; i < aa.size(); i++) {

			System.out.println("输出：" + aa.get(i));
		}
		System.out.println(aa.size());
		System.out.println(new Date());
	}

	public static void getLinkedList() {
		LinkedList bb = new LinkedList();
		for (int i = 0; i < 100; i++) {
			bb.add(i);
		}
		bb.add(0);
		for (int i = 0; i < bb.size(); i++) {
			System.out.println("输出：" + bb.get(i));
		}

		System.out.println(bb.size());
		System.out.println(new Date());
		bb.toArray();
		// bb.removeAll(bb);
		System.out.println(new Date());
	}

}
