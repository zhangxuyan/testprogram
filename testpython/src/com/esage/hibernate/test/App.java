package com.esage.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.esage.hibernate.bean.User;
import com.esage.hibernate.dao.HibernateUtils;

public class App {
	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // 读取指定的主配置文件
		sessionFactory = cfg.buildSessionFactory(); // 根据配置生成Session工厂
	}

	@Test
	public void testSave() {

		// 保存
		Session session = sessionFactory.openSession(); // 打开一个新的Session
		Transaction tx = session.beginTransaction(); // 开启事务
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			user.setStrName("张三");
			session.save(user);
		}

		tx.commit(); // 提交事务
		session.close(); // 关闭Session，释放资源(不一定是真正的关闭)
	}

	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = (User) session.load(User.class, 1); // 获取？
		System.out.println(user);

		tx.commit();
		session.close();
	}

	// 分页查询
	// 一页显示10条，要得到第二页数据
	@Test
	public void test3() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 一页显示10条，要得到第二页数据
		Query query = session.createQuery("from User");
		query.setFirstResult(10); // 从第几条开始，即开始位置，从0开始计数
		query.setMaxResults(10); // 本次查询结果回显的条数
		List<User> list = query.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// 查询指定列信息
	@Test
	public void test4() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select id, strName from User where id='103740'"); // 这时我们得到的不再是Customer对象，而是Object[]
		List<Object[]> list = query.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// 执行本地sql，查询全部
	@Test
	public void test6() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 执行 select * from t_customer;
		SQLQuery sqlQuery = session.createSQLQuery("select * from user  limit 10,10;");
		List<Object[]> list = sqlQuery.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// 测试Criteria
	@Test
	public void test8() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 得到Criteria
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", 103740));
		// 查询所有
		List<User> list = criteria.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// 测试一级缓存
	@Test
	public void test9() {
		// 1.得到session
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		User customer = (User) session.get(User.class, 1); // 查询id=1的Customer对象，如果查询到，会将Customer对象存储到一级缓存中
		User customer2 = (User) session.get(User.class, 1); // 会从一级缓存中查询，而不会向数据库再发送sql语句查询

		// 2.事务提交，并关闭session
		session.getTransaction().commit();
		session.close();
	}
	// 持久化对象具有自动更新数据库的能力
    @Test
    public void test10() {
        // 1.得到session
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        User customer = (User) session.get(User.class, 1); // 查询id=1的Customer对象，如果查询到，会将Customer对象存到一级缓存中
       // customer.setStrName("Tom"); // 操作持久化对象来修改属性
        // 2.事务提交，并关闭session
        session.getTransaction().commit();
        session.close();
    }
}
