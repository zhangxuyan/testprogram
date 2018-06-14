package com.esage.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.esage.hibernate.bean.User;

public class App1 {
	private static SessionFactory sessionFactory = new Configuration() //
			.configure("hibernate.cfg.xml") //
			.addClass(User.class) // ���Hibernateʵ���ࣨ���ض�Ӧ��ӳ���ļ���
			.buildSessionFactory();

	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// -------------------------------------------

		// ��������
		User user = new User();
		user.setStrName("�����");
		user.getAddressSet().add("������ó԰xxx");
		user.getAddressSet().add("�Ķ���·");

		// ����
		session.save(user);

		// -------------------------------------------
		session.getTransaction().commit();
		session.close();
	}

	
	
	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// -------------------------------------------

		// ��ȡ����
		User user = (User) session.get(User.class, 1);
		// ��ʾ��Ϣ
		System.out.println(user.getStrName());
		System.out.println(user.getAddressSet());

		// -------------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
