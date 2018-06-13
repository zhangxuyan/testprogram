package com.esage.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.esage.hibernate.bean.Department;
import com.esage.hibernate.bean.Employee;

public class Application {
	 private static SessionFactory sessionFactory = new Configuration() //
	            .configure() //
	            .addClass(Department.class) // ���Hibernateʵ���ࣨ���ض�Ӧ��ӳ���ļ���
	            .addClass(Employee.class) // ���Hibernateʵ���ࣨ���ض�Ӧ��ӳ���ļ���
	            .buildSessionFactory();

	    // ���棬�й�����ϵ
	    @Test
	    public void testSave() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // �½�����
	        Department department = new Department();
	        department.setName("������");

	        Employee employee1 = new Employee();
	        employee1.setName("����");

	        Employee employee2 = new Employee();
	        employee2.setName("����");

	        // ��������
	        employee1.setDepartment(department); // ����Ա���������ĸ�����
	        employee2.setDepartment(department);

	        // ����
	        session.save(department); // ���沿�ţ���ס����������һ�����ǰ�汣�棬��Ҫ�������˵�һ����ں��汣��
	        session.save(employee1);
	        session.save(employee2);

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }

	    // ��ȡ�����Ի�ȡ�������ĶԷ�
	    @Test
	    public void testGet() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // ��ȡһ��������ʾ��һ����Ϣ
	        Employee employee = (Employee) session.get(Employee.class, 1);
	        System.out.println(employee);
	        System.out.println(employee.getDepartment());

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }

	    // ���������ϵ
	    @Test
	    public void testRemoveRelation() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // ��Ա�������
	        Employee employee = (Employee) session.get(Employee.class, 1);
	        employee.setDepartment(null);

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }

	    // ɾ�����󣬶Թ��������Ӱ��
	    @Test
	    public void testDelete() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // ɾ��Ա����(�෽)���ԶԷ�û��Ӱ��
	        Employee employee = (Employee) session.get(Employee.class, 1);
	        session.delete(employee);

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }
}
