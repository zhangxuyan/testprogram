package com.heima.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PackageDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		List list = new ArrayList();

		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");

		// // �ڱ����Ĺ����У����������abc2�����һ��Ԫ��haha
		// for (Iterator it = list.iterator(); it.hasNext();) {
		// Object obj = it.next();
		// if (obj.equals("abc2")) {
		// list.add("haha"); //
		// ����java.util.ConcurrentModificationException(�����޸��쳣)
		// }
		// }

		// ʹ��list���ϵ����еĵ���������ListIterator������ͨ��List���ϵķ���listIterator()��ȡ�õ���������
		// ListIterator��ʵ���ڵ��������е���ɾ�Ĳ顣
		for (ListIterator it = list.listIterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj.equals("abc2")) {
				it.add("haha");
			}
		}
		System.out.println(list);

	}
}
