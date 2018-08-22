package sortList;

//
//public class Main {
//
//}
import java.util.ArrayList;

import java.util.Collections;

import java.util.Comparator;

import java.util.List;

public class Main {

	public static List<Book> getBookList() {

		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book(1L, "first", 10.00, "zhangsan", 19);
		Book book2 = new Book(2L, "first", 9.00, "zhangsan", 24);
		Book book3 = new Book(3L, "first", 8.00, "zhangsan", 29);
		Book book4 = new Book(4L, "first", 7.00, "zhangsan", 13);
		Book book5 = new Book(5L, "first", 6.00, "zhangsan", 14);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		return books;

	}

	/**
	 * 
	 * 打印函数
	 * 
	 * @param lisbk
	 */

	public static void printf(List<Book> lisbk) {

		if (lisbk.isEmpty() || lisbk == null) {
			System.out.println("没有数据");
			return;
		}

		for (Book book : lisbk) {
			System.out.println("Id: " + book.getId() + " price: " + book.getPrice() + " weight:" + book.getWeight());
			// System.out.println(book);
		}

		System.out.println();

		return;

	}

	public static void main(String[] args) {

		List<Book> bks = getBookList();

		System.out.println("原先的顺序：");

		printf(bks);

		System.out.println("根据价格排序：");

		Collections.sort(bks, new sortList<Book>("Price", true));

		printf(bks);

		System.out.println("根据Id排序：");

		Collections.sort(bks, new sortList<Book>("Id", true));

		printf(bks);

		System.out.println("根据weight排序：");

		Collections.sort(bks, new sortList<Book>("Weight", true));

		printf(bks);

	}

}