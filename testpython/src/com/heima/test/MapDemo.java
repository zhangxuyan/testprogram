package com.heima.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		// demo1();
		// demo();
		Map<Employee, String> map = new HashMap<Employee, String>();
		map.put(new Employee("xiaozhang", 24), "北京");
		map.put(new Employee("laoli", 34), "上海");
		map.put(new Employee("mingming", 26), "南京");
		map.put(new Employee("xili", 30), "广州");
		map.put(new Employee("laoli", 34), "铁岭");
		
		Set<Employee> keySet = map.keySet();
		for (Employee employee : keySet) {
			String value = map.get(employee);
			System.out.println(employee.getName() + ":" + employee.getAge() + "..." + value);
		}
	}

	/**
	 * 
	 */
	static void demo1() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		// map.put("01", "zhangsan1");
		map.put("04", "zhangsan4");
		map.put("01", "zhangsan1");
		// // 将map集合中的映射关系取出，存入到set集合中
		// Set<Map.Entry<String, String>> entrySet = map.entrySet();
		// Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		// while (it.hasNext()) {
		// Map.Entry<String, String> me = it.next();
		// String key = me.getKey();
		// String value = me.getValue();
		// System.out.println(key + ":" + value);
		// }

		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key + ":" + value);

		}
	}

	/**
	 * 
	 */
	static void demo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		map.put("01", "zhangsan1");
		map.put("04", "zhangsan4");
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println("key:" + key + ", value :" + value);

		}
	}
}
