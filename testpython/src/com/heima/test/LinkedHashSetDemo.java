package com.heima.test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// 1������һ��Set��������
		Set set = new LinkedHashSet();

		// 2�����Ԫ��
		set.add("abc");
		set.add("heihei");
		set.add("haha");
		set.add("nba");

		// 3��ֻ���õ�����ȡ��
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}
}
