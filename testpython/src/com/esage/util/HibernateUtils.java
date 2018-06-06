package com.esage.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtils {
	private static Configuration cfg;
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {

		cfg = new Configuration().configure();
		System.out.println(cfg);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		System.out.println(serviceRegistry);
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
