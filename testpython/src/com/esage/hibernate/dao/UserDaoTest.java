package com.esage.hibernate.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.esage.hibernate.bean.QueryResult;
import com.esage.hibernate.bean.User;

public class UserDaoTest {

	private UserDao userDao = new UserDao();

	@Test
	public void testSave_1() {
		User user = new User();
		user.setName("����");

		// ����
		userDao.save(user);
	}

	@Test
	public void testGetById() {
		User user = userDao.getById(1);
		System.out.println(user);
	}

	@Test
	public void testUpdate() {
		// �����ݿ��л�ȡһ�����ڵ�����
		User user = userDao.getById(1);
		if (user != null) {
			user.setName("����");
			// ����
			userDao.update(user);
		}
	}

	@Test
	public void testDelete() {
		userDao.delete(1);
	}

	// -------------------------

	@Test
	public void testSave_25() {
		for (int i = 1; i <= 25; i++) {
			User user = new User();
			user.setName("test_" + i);

			userDao.save(user); // ����
		}
	}

	@Test
	public void testFindAll() {
		List<User> list = userDao.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindAllIntInt() {
		// ��ѯ
		// QueryResult qr = userDao.findAll(0, 10); // ��1ҳ��ÿҳ10��
		// QueryResult qr = userDao.findAll(10, 10); // ��2ҳ��ÿҳ10��
		QueryResult qr = userDao.findAll(20, 10); // ��3ҳ��ÿҳ10��

		// ��ʾ���
		System.out.println("�ܼ�¼����" + qr.getCount());
		for (User user : (List<User>) qr.getList()) {
			System.out.println(user);
		}

	}

}
