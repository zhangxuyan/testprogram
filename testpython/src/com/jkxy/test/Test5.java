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
		// ��Ԫ����ӵ�Map ��
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("key1", "value1");
		hashMap.put("key2", "value2");
		hashMap.put("key3", "value3");
		hashMap.put("key4", "value4");
		hashMap.put("key5", "value5");
		
		// ɾ��Map ��Ԫ�أ�ͨ��key ֵ
		hashMap.remove("key1");
		
		// ͨ�� get(key) �õ�Map�е�value
		Object str1 = hashMap.get("key1");
		hashMap.put("key2", "�޸�key2 �� value ");

		// ͨ�� map.value() �õ� map��value ����
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
		// ͨ�� Map.entrySet() �õ�Map �� Entry ���� ��Ȼ�����
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
		treeSet.add(10); // ���һ�� Integer ���͵�����
		treeSet.add(1); // ���һ�� Integer ���͵�����

		treeSet.add(5); // ���һ�� String ���͵�����

		System.out.println(treeSet); // �ᱨ����ת���쳣�Ĵ���
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
		// ����һ��List���ϣ����͵�ʵ��Ϊ ArrayList
		List list = new ArrayList<>();

		// �������Ԫ��
		list.add("Tom");
		list.add("Bob");
		list.add("Marry");
		// ����List�ĵ�����
		Iterator it = list.iterator();
		while (it.hasNext()) {

			Object obj = it.next();
			System.out.println(obj);
		}

		// ��ָ���ط����Ԫ��
		list.add(2, 1);

		// ��ȡ ָ�����������
		int i = list.indexOf(1);
		System.out.println("����Ϊ ��" + i);

		// ���� ��ͨfor ѭ��
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
	}

	private static void collectionTest() {
		// ��ArrayList ������ΪCollection ��ʵ����
		Collection collection = new ArrayList();

		// ���Ԫ��
		collection.add("Tom");
		collection.add("Bob");

		// ɾ��ָ��Ԫ��
		collection.remove("Tome");

		// ɾ������Ԫ��
		Collection c = new ArrayList<>();

		c.add("Bob");
		collection.removeAll(c);

		// ����Ƿ��������Ԫ��
		collection.contains("Tom");

		// �ж� �Ƿ�Ϊ��
		collection.isEmpty();

		// ������ǿfor ѭ�� ��������
		for (Object obj : collection) {
			System.out.println(obj);
		}

		// ���õ����� Iterator
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
