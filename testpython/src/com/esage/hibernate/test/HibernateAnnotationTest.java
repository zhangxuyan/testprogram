package com.esage.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.esage.hibernate.bean.Book;
import com.esage.hibernate.dao.HibernateUtils;

public class HibernateAnnotationTest {
	// ����PO��ע�⿪��
	@Test
	public void test1() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		for (int i = 0; i < 500; i++) {
			Book b = new Book();
			b.setName("����");
			b.setPrice(56.78);
			b.setPublicationDate(new Date());

			session.save(b);
		}
		session.getTransaction().commit();
		session.close();
	}
}
