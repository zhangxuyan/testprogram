package com.esage.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.esage.hibernate.bean.User;

public class App {
	private static SessionFactory sessionFactory;

	 static {
	 Configuration cfg = new Configuration();
	 cfg.configure("hibernate.cfg.xml"); // ��ȡָ�����������ļ�
	 sessionFactory = cfg.buildSessionFactory(); // ������������Session����
	 }
	
	
	
	@Test
	public void testSave() {
		User user = new User();
		user.setStrName("����");

		// ����
		Session session = sessionFactory.openSession(); // ��һ���µ�Session
		Transaction tx = session.beginTransaction(); // ��������

		session.save(user);

		tx.commit(); // �ύ����
		session.close(); // �ر�Session���ͷ���Դ(��һ���������Ĺر�)
	}

	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = (User) session.get(User.class, 1); // ��ȡ��
		System.out.println(user);

		tx.commit();
		session.close();
	}

}
