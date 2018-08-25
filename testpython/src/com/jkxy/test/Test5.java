package com.jkxy.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test5 {

	public static void main(String[] args) {
		// collectionTest();
		// listTest();
		// testTreeSet();
		// testTreeSet1();
		// 将元素添加到Map 中
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("key1", "value1");
		hashMap.put("key2", "value2");
		hashMap.put("key3", "value3");
		hashMap.put("key4", "value4");
		hashMap.put("key5", "value5");
		
		// 删除Map 中元素，通过key 值
		hashMap.remove("key1");
		
		// 通过 get(key) 得到Map中的value
		Object str1 = hashMap.get("key1");
		hashMap.put("key2", "修改key2 的 value ");

		// 通过 map.value() 得到 map中value 集合
		Collection<Object> value = hashMap.values();
		for (Object obj : value) {
			System.out.println(obj);
		}

		System.out.println("----------------");
		Set<String> set = hashMap.keySet();
		for (String str : set) {
			Object obj = hashMap.get(str);
			System.out.println(str + "=" + obj);
		}

		System.out.println("----------------");
		// 通过 Map.entrySet() 得到Map 的 Entry 集合 ，然后遍历
		Set<Map.Entry<String, Object>> entrys = hashMap.entrySet();
		for (Map.Entry<String, Object> entry : entrys) {
			String key = entry.getKey();
			Object value2 = entry.getValue();
			System.out.println(key + "=" + value2);
		}
		
		// String
		//
		// Hashtable<K, V>
	}

	/**
	 * 
	 */
	static void testTreeSet1() {
		Set treeSet = new TreeSet();
		treeSet.add(10); // 添加一个 Integer 类型的数据
		treeSet.add(1); // 添加一个 Integer 类型的数据

		treeSet.add(5); // 添加一个 String 类型的数据

		System.out.println(treeSet); // 会报类型转换异常的错误
	}

	/**
	 * 
	 */
	static void testTreeSet() {
		Persons p1 = new Persons("name1", 8);
		Persons p2 = new Persons("name2", 2);
		Persons p3 = new Persons("name4", 1);
		Persons p4 = new Persons("name3", 10);
		Set<Persons> set = new TreeSet<>(new Persons());
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		Set set1 = Collections.synchronizedSet(set);
		System.out.println(set);
	}

	private static void listTest() {
		// 产生一个List集合，典型的实现为 ArrayList
		List list = new ArrayList<>();

		// 添加三个元素
		list.add("Tom");
		list.add("Bob");
		list.add("Marry");
		// 构造List的迭代器
		Iterator it = list.iterator();
		while (it.hasNext()) {

			Object obj = it.next();
			System.out.println(obj);
		}

		// 在指定地方添加元素
		list.add(2, 1);

		// 获取 指定对象的索引
		int i = list.indexOf(1);
		System.out.println("索引为 ：" + i);

		// 遍历 普通for 循环
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
	}

	private static void collectionTest() {
		// 将ArrayList 集合作为Collection 的实现类
		Collection collection = new ArrayList();

		// 添加元素
		collection.add("Tom");
		collection.add("Bob");

		// 删除指定元素
		collection.remove("Tome");

		// 删除所有元素
		Collection c = new ArrayList<>();

		c.add("Bob");
		collection.removeAll(c);

		// 检查是否存在摸个元素
		collection.contains("Tom");

		// 判断 是否为空
		collection.isEmpty();

		// 利用增强for 循环 便利集合
		for (Object obj : collection) {
			System.out.println(obj);
		}

		// 利用迭代器 Iterator
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();

			System.out.println(obj);
		}
	}

}

class Persons implements Comparator<Persons> {

	private String name;
	private int age;
	private int height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Persons() {
	}

	public Persons(int age) {

		this.age = age;
	}

	public Persons(String name, int age) {

		this.name = name;
		this.age = age;
	}

	@Override
	public int compare(Persons o1, Persons o2) {
		if (o1.age > o2.age) {
			return 1;
		} else if (o1.age < o2.age) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;

		}

		if (obj == null) {

			return false;
		}

		if (getClass() != obj.getClass()) {

			return false;
		}

		Persons other = (Persons) obj;
		if (age != other.age) {

			return false;

		}
		if (height != other.height) {

			return false;
		}
		return true;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Persons [name=" + name + ", age=" + age + "]";
	}

}
