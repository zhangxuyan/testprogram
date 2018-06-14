package com.esage.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.esage.hibernate.bean.*;

/**
 * ��Զ��ϵӳ��
 * 
 * @author chenyonghong
 *
 */
public class App2 {
	private static SessionFactory sessionFactory = new Configuration() //
			.configure() //
			.addClass(Student.class) // ���Hibernateʵ���ࣨ���ض�Ӧ��ӳ���ļ���
			.addClass(Teacher.class) // ���Hibernateʵ���ࣨ���ض�Ӧ��ӳ���ļ���
			.buildSessionFactory();

	// ���棬�й�����ϵ
	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// -------------------------------------------

		// �½�����
		Student student1 = new Student();
		student1.setName("��ͬѧ");

		Student student2 = new Student();
		student2.setName("��ͬѧ");

		Teacher teacher1 = new Teacher();
		teacher1.setName("����ʦ");

		Teacher teacher2 = new Teacher();
		teacher2.setName("����ʦ");

		// ��������
		student1.getTeachers().add(teacher1);
		student1.getTeachers().add(teacher2);
		student2.getTeachers().add(teacher1);
		student2.getTeachers().add(teacher2);

		teacher1.getStudents().add(student1);
		teacher1.getStudents().add(student2);
		teacher2.getStudents().add(student1);
		teacher2.getStudents().add(student2);

		// ����
		session.save(student1);
		session.save(student2);
		session.save(teacher1);
		session.save(teacher2);

		// -------------------------------------------
		session.getTransaction().commit();
		session.close();
	}
}
