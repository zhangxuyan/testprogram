package com.heima.test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Comparator<Employee> comparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int temp = o1.getName().compareTo(o2.getName());
				return temp == 0 ? o1.getAge() - o2.getAge() : temp;
			}
		};

		Map<Employee, String> map = new TreeMap<Employee, String>(comparator);

		map.put(new Employee("xiaozhang", 24), "北京");
		map.put(new Employee("laoli", 34), "上海");
		map.put(new Employee("mingming", 26), "南京");
		map.put(new Employee("xili", 30), "广州");
		map.put(new Employee("laoli", 34), "铁岭");

		Set<Map.Entry<Employee, String>> entrySet = map.entrySet();
		for (Map.Entry<Employee, String> me : entrySet) {
			Employee key = me.getKey();
			String value = me.getValue();
			System.out.println(key.getName() + ":" + key.getAge() + "..." + value);
		}
	}
}
