package com.esage.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	// SessionFactoryȫ��ֻ��Ҫ��һ���Ϳ����ˣ���Ϊ���Ĵ�����������Ҫ���Ĵ�������Դ����ʼ����Ϣ��Ƚ϶࣬���������̰߳�ȫ�ģ������ڶ��̵߳Ļ�����ʹ����
	private static SessionFactory sessionFactory;

	static {
		// ��ʼ��SessionFactory��ʽһ��
		/*
		 * Configuration cfg = new Configuration(); // ���������ļ���һ������
		 * cfg.configure(); // ��ȡĬ�ϵ������ļ�(hibernate.cfg.xml) //
		 * cfg.configure("hibernate.cfg.xml"); // ��ȡָ��λ�õ������ļ� sessionFactory =
		 * cfg.buildSessionFactory();
		 */

		// ��ʼ��SessionFactory��ʽ����
		sessionFactory = new Configuration() //
				.configure() //
				.buildSessionFactory(); // ������
	}

	/**
	 * ��ȡȫ��Ψһ��SessionFactory
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * ��ȫ��Ψһ��SessionFactory�д�һ��Session
	 * 
	 * @return
	 */
	public static Session openSession() {
		return sessionFactory.openSession();
	}

}
