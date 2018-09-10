package com.heima.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new Student("����", 11));
		set.add(new Student("����", 22));
		set.add(new Student("����", 33));
		set.add(new Student("����", 44));

		for (Iterator it = set.iterator(); it.hasNext();) {
			Student stu = (Student) it.next();
			System.out.println(stu.getName() + "--" + stu.getAge());

		}

	}
}
