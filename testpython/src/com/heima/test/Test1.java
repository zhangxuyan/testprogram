package com.heima.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test1 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// demo1();
		Map<String, String> map = new HashMap();
		map.put("A", "@");
		map.put("W", "@");
		map.put("E", "@");
		map.put("Q", "@");
		map.put("R", "@");
		map.put("B", "@");
		map.put("U", "@");
		
		// 这样能得到map的key和value，在某些应用中，这很有用
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "" + entry.getValue());
		}

		// 如果想对Map集合的元素按照key进行排序怎么办？如下，用Collections.sort方法
		List<Map.Entry<String, String>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return (o1.getKey()).compareTo(o2.getKey());
			}
		});
		
		System.out.println(list);
	}

	/**
	 * 
	 */
	static void demo1() {
		LinkedList<String> link = new LinkedList<String>();
		link.add("444");
		link.add("111");
		link.add("222");
		link.add("333");

		// link.addFirst("abc1");
		// link.addFirst("abc2");
		// link.addFirst("abc3");
		// link.addFirst("123");
		System.out.println(link);
	}
}
