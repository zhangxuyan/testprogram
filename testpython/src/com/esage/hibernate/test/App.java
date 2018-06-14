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
		cfg.configure("hibernate.cfg.xml"); // ��ȡָ�����������ļ�
		sessionFactory = cfg.buildSessionFactory(); // ������������Session����
	}

	@Test
	public void testSave() {

		// ����
		Session session = sessionFactory.openSession(); // ��һ���µ�Session
		Transaction tx = session.beginTransaction(); // ��������
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			user.setStrName("����");
			session.save(user);
		}

		tx.commit(); // �ύ����
		session.close(); // �ر�Session���ͷ���Դ(��һ���������Ĺر�)
	}

	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = (User) session.load(User.class, 1); // ��ȡ��
		System.out.println(user);

		tx.commit();
		session.close();
	}

	// ��ҳ��ѯ
	// һҳ��ʾ10����Ҫ�õ��ڶ�ҳ����
	@Test
	public void test3() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// һҳ��ʾ10����Ҫ�õ��ڶ�ҳ����
		Query query = session.createQuery("from User");
		query.setFirstResult(10); // �ӵڼ�����ʼ������ʼλ�ã���0��ʼ����
		query.setMaxResults(10); // ���β�ѯ������Ե�����
		List<User> list = query.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// ��ѯָ������Ϣ
	@Test
	public void test4() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select id, strName from User where id='103740'"); // ��ʱ���ǵõ��Ĳ�����Customer���󣬶���Object[]
		List<Object[]> list = query.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// ִ�б���sql����ѯȫ��
	@Test
	public void test6() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// ִ�� select * from t_customer;
		SQLQuery sqlQuery = session.createSQLQuery("select * from user  limit 10,10;");
		List<Object[]> list = sqlQuery.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// ����Criteria
	@Test
	public void test8() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// �õ�Criteria
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", 103740));
		// ��ѯ����
		List<User> list = criteria.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();
	}

	// ����һ������
	@Test
	public void test9() {
		// 1.�õ�session
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		User customer = (User) session.get(User.class, 1); // ��ѯid=1��Customer���������ѯ�����ὫCustomer����洢��һ��������
		User customer2 = (User) session.get(User.class, 1); // ���һ�������в�ѯ�������������ݿ��ٷ���sql����ѯ

		// 2.�����ύ�����ر�session
		session.getTransaction().commit();
		session.close();
	}
	// �־û���������Զ��������ݿ������
    @Test
    public void test10() {
        // 1.�õ�session
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        User customer = (User) session.get(User.class, 1); // ��ѯid=1��Customer���������ѯ�����ὫCustomer����浽һ��������
       // customer.setStrName("Tom"); // �����־û��������޸�����
        // 2.�����ύ�����ر�session
        session.getTransaction().commit();
        session.close();
    }
}
