package com.heima.test;

import java.util.Comparator;

public class ComparatorByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub

		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		int temp = s1.getName().compareTo(s2.getName());

		return temp == 0 ? s1.getAge() - s2.getAge() : temp;
	}

}
