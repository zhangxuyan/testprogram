package com.heima.test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Set set = new TreeSet();
		set.add(new Student("xiaoqiang", 20));
		set.add(new Student("daniu", 24));
		set.add(new Student("xiaoming", 22));
		set.add(new Student("tudou", 18));
		set.add(new Student("dahuang", 19));

		// 3，只能用迭代器取出
		for (Iterator it = set.iterator(); it.hasNext();) {
			Student stu = (Student) it.next();
			System.out.println(stu.getName() + "::" + stu.getAge());
		}
	}

}
