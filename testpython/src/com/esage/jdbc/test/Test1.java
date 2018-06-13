package com.esage.jdbc.test;

import java.util.List;

import com.esage.bean.User;
import com.esage.dao.UserDao;

//import com.dao.UserDao;
//import com.entity.User;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDao userDao = new UserDao();
		List<User> userList = userDao.getUserList();
		for(User u :userList){
			
			System.out.println(u);
		}
	}

}
