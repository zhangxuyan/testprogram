package com.jkxy.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test4 {
	public static void main(String[] args) {
		insertTest();
	}

	public static void insertTest() {

		List<String> arrayList = new ArrayList<>();
		List<String> linkedList = new LinkedList<>();
		long arrayListExcuteTime = excuteTime(arrayList);
		long linkedListExcuteTime = excuteTime(linkedList);
		System.out.println("arrayListExcuteTime:" + arrayListExcuteTime);
		System.out.println("linkedListExcuteTime:" + linkedListExcuteTime);
	}

	private static long excuteTime(List list) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 700000; i++) {
			list.add("aa");

		}
		long endTime = System.currentTimeMillis();

		return endTime - startTime;
	}

}
