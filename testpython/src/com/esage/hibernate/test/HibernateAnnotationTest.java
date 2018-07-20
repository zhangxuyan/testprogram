package com.esage.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.esage.hibernate.bean.Book;
import com.esage.hibernate.bean.Husband;
import com.esage.hibernate.bean.IDCard;
import com.esage.hibernate.bean.User1;
import com.esage.hibernate.bean.Wife;
import com.esage.hibernate.dao.HibernateUtils;

public class HibernateAnnotationTest {
	// 测试PO的注解开发
	@Test
	public void test1() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		for (int i = 0; i < 500; i++) {
			Book b = new Book();
			b.setName("情书");
			b.setPrice(56.78);
			b.setPublicationDate(new Date());

			session.save(b);
		}
		session.getTransaction().commit();
		session.close();
	}

	// 测试一对一操作外键映射方案(由t_idcard表来维护外键)
	@Test
	public void test6() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 1.创建一个人
		User1 user1 = new User1();
		user1.setName("叶子000");

		// 2.创建一个身份证
		IDCard idCard = new IDCard();
		idCard.setCardNum("42900619901024165700");

		// 3.让身份证关联人
		idCard.setUser1(user1);

		// 4.存储身份证
		session.save(idCard);

		session.getTransaction().commit();
		session.close();
	}

	// 测试一对一主键生成策略
	@Test
	public void test7() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 创建一个丈夫
		Husband husband = new Husband();
		husband.setName("武大郎");

		// 创建一个妻子
		Wife wife = new Wife();
		wife.setName("潘金莲");

		// 要做双向关联
		husband.setWife(wife);
		wife.setHusband(husband);

		session.save(wife); // 保存妻子的时候级联保存丈夫

		session.getTransaction().commit();
		session.close();
	}

}
