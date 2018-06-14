package com.esage.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.esage.hibernate.bean.*;

/**
 * 多对多关系映射
 * 
 * @author chenyonghong
 *
 */
public class App2 {
	private static SessionFactory sessionFactory = new Configuration() //
			.configure() //
			.addClass(Student.class) // 添加Hibernate实体类（加载对应的映射文件）
			.addClass(Teacher.class) // 添加Hibernate实体类（加载对应的映射文件）
			.buildSessionFactory();

	// 保存，有关联关系
	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// -------------------------------------------

		// 新建对象
		Student student1 = new Student();
		student1.setName("王同学");

		Student student2 = new Student();
		student2.setName("李同学");

		Teacher teacher1 = new Teacher();
		teacher1.setName("赵老师");

		Teacher teacher2 = new Teacher();
		teacher2.setName("蔡老师");

		// 关联起来
		student1.getTeachers().add(teacher1);
		student1.getTeachers().add(teacher2);
		student2.getTeachers().add(teacher1);
		student2.getTeachers().add(teacher2);

		teacher1.getStudents().add(student1);
		teacher1.getStudents().add(student2);
		teacher2.getStudents().add(student1);
		teacher2.getStudents().add(student2);

		// 保存
		session.save(student1);
		session.save(student2);
		session.save(teacher1);
		session.save(teacher2);

		// -------------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
