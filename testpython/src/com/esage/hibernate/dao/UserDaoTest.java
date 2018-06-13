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
		user.setName("张三");

		// 保存
		userDao.save(user);
	}

	@Test
	public void testGetById() {
		User user = userDao.getById(1);
		System.out.println(user);
	}

	@Test
	public void testUpdate() {
		// 从数据库中获取一条存在的数据
		User user = userDao.getById(1);
		if (user != null) {
			user.setName("李四");
			// 更新
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

			userDao.save(user); // 保存
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
		// 查询
		// QueryResult qr = userDao.findAll(0, 10); // 第1页，每页10条
		// QueryResult qr = userDao.findAll(10, 10); // 第2页，每页10条
		QueryResult qr = userDao.findAll(20, 10); // 第3页，每页10条

		// 显示结果
		System.out.println("总记录数：" + qr.getCount());
		for (User user : (List<User>) qr.getList()) {
			System.out.println(user);
		}

	}

}
