package com.esage.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.esage.hibernate.bean.Book;
import com.esage.hibernate.bean.Husband;
import com.esage.hibernate.bean.IDCard;
import com.esage.hibernate.bean.User1;
import com.esage.hibernate.bean.Wife;import com.esage.hibernate.bean.Customer;
import com.esage.hibernate.bean.Order;
import com.esage.hibernate.bean.Person;
import com.esage.hibernate.bean.Student;
import com.esage.hibernate.bean.Teacher;
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

	// ����uuid���������ɲ��Լ������ɱ���ӳ��
	@Test
	public void test2() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		for (int i = 0; i < 1000; i++) {
			Person p = new Person();
			p.setName("����");
			p.setMsg("����һ������");

			session.save(p);
		}
		session.getTransaction().commit();
		session.close();
	}

	// ����one-to-manyע�����(����ͻ�ʱ�������涩��)
	@Test
	public void test3() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 1.����һ���ͻ�
		Customer c = new Customer();
		c.setName("Ҷ��");

		// 2.������������
		Order o1 = new Order();
		o1.setMoney(1000d);
		o1.setReceiverInfo("�人");
		Order o2 = new Order();
		o2.setMoney(2000d);
		o2.setReceiverInfo("����");

		// 3.������ϵ

		// ԭ����Ϊ��ά���������Ȼ�Ļ�������Ͳ�����ȷ�����ɣ�����
		o1.setC(c);
		o2.setC(c);
		c.getOrders().add(o1);
		c.getOrders().add(o2);

		// 4.����ͻ������������涩��
		session.save(c);

		session.getTransaction().commit();
		session.close();
	}

	// ���Զ�Զ༶������(����ѧ��ʱͬʱ������ʦ)
	@Test
	public void test4() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 1.����������ʦ
		Teacher t1 = new Teacher();
		t1.setName("Tom");

		Teacher t2 = new Teacher();
		t2.setName("Fox");

		// 2.��������ѧ��
		Student s1 = new Student();
		s1.setName("�ŵ�");

		Student s2 = new Student();
		s2.setName("Ҷ��");

		// 3.ѧ��������ʦ
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);

		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);

		// ����ѧ��ͬʱ������ʦ
		session.save(s1);
		session.save(s2);

		session.getTransaction().commit();
		session.close();
	}

	// ���Զ�Զ༶��ɾ��(ǰ���ǽ�����˫��ļ���)
	@Test
	public void test5() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		Student s = (Student) session.get(Student.class, 1l);
		session.delete(s);

		session.getTransaction().commit();
		session.close();
	}


// ����һ��һ�������ӳ�䷽��(��t_idcard����ά�����)
	@Test
	public void test6() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// 1.����һ����
		User1 user1 = new User1();
		user1.setName("Ҷ��000");

		// 2.����һ�����֤
		IDCard idCard = new IDCard();
		idCard.setCardNum("42900619901024165700");

		// 3.�����֤������
		idCard.setUser1(user1);

		// 4.�洢���֤
		session.save(idCard);

		session.getTransaction().commit();
		session.close();
	}

	// ����һ��һ�������ɲ���
	@Test
	public void test7() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();

		// ����һ���ɷ�
		Husband husband = new Husband();
		husband.setName("�����");

		// ����һ������
		Wife wife = new Wife();
		wife.setName("�˽���");

		// Ҫ��˫�����
		husband.setWife(wife);
		wife.setHusband(husband);

		session.save(wife); // �������ӵ�ʱ���������ɷ�

		session.getTransaction().commit();
		session.close();
	}




}
