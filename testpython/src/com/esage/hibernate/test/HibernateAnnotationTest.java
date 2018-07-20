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
