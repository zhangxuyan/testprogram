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

		// // 在遍历的过程中，如果遍历到abc2，添加一个元素haha
		// for (Iterator it = list.iterator(); it.hasNext();) {
		// Object obj = it.next();
		// if (obj.equals("abc2")) {
		// list.add("haha"); //
		// 出现java.util.ConcurrentModificationException(并发修改异常)
		// }
		// }

		// 使用list集合的特有的迭代器——ListIterator，可以通过List集合的方法listIterator()获取该迭代器对象。
		// ListIterator可实现在迭代过程中的增删改查。
		for (ListIterator it = list.listIterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj.equals("abc2")) {
				it.add("haha");
			}
		}
		System.out.println(list);

	}
}
