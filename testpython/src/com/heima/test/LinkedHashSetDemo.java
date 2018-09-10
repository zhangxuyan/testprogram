package com.heima.test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// 1，创建一个Set容器对象
		Set set = new LinkedHashSet();

		// 2，添加元素
		set.add("abc");
		set.add("heihei");
		set.add("haha");
		set.add("nba");

		// 3，只能用迭代器取出
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}
}
