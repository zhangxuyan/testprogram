package test.tool.gui.dbtool.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		Student s1 = new Student();

		s1.setName("s1");
		s1.setAge(20);

		Student s2 = new Student();
		s2.setName("s2");
		s2.setAge(21);

		Student s3 = new Student();

		s3.setName("s3");
		s3.setAge(22);

		List<Student> list = new ArrayList<>();

		list.add(s1);
		list.add(s3);
		list.add(s2);
		System.out.println("≈≈–Ú«∞£∫" + list);

		Collections.sort(list, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {

				if (o1.getAge() > o2.getAge()) {

					return 1;
				}

				if (o1.getAge() == o2.getAge()) {

					return 0;
				}

				return -1;
			};
		});
		System.out.println("≈≈–Ú∫Û£∫" + list);

	}

}
