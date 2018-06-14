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
			.addClass(User.class) // 添加Hibernate实体类（加载对应的映射文件）
			.buildSessionFactory();

	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// -------------------------------------------

		// 构建对象
		User user = new User();
		user.setStrName("张天二");
		user.getAddressSet().add("御富科贸园xxx");
		user.getAddressSet().add("棠东东路");

		// 保存
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

		// 获取数据
		User user = (User) session.get(User.class, 1);
		// 显示信息
		System.out.println(user.getStrName());
		System.out.println(user.getAddressSet());

		// -------------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
