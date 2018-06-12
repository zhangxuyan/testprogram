package com.esage.dao;
import java.util.List;
import org.hibernate.Session;

import com.esage.bean.User;
//import com.entity.User;
//import com.util.HibernateSessionFactory;
import com.esage.util.HibernateSessionFactory;

public class UserDao{
	public List<User> getUserList(){
		List<User> userList=null;
		String hql="from User";
		Session session=HibernateSessionFactory.getSession();
		/*session.get(User.class, 1);
		session.save();*/
		userList=session.createQuery(hql).list();
		return userList;
	}
}
