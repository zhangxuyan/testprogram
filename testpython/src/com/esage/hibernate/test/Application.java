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
	            .addClass(Department.class) // 添加Hibernate实体类（加载对应的映射文件）
	            .addClass(Employee.class) // 添加Hibernate实体类（加载对应的映射文件）
	            .buildSessionFactory();

	    // 保存，有关联关系
	    @Test
	    public void testSave() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // 新建对象
	        Department department = new Department();
	        department.setName("开发部");

	        Employee employee1 = new Employee();
	        employee1.setName("张三");

	        Employee employee2 = new Employee();
	        employee2.setName("李四");

	        // 关联起来
	        employee1.setDepartment(department); // 告诉员工他属于哪个部门
	        employee2.setDepartment(department);

	        // 保存
	        session.save(department); // 保存部门，记住：被依赖的一般放在前面保存，需要依赖别人的一般放在后面保存
	        session.save(employee1);
	        session.save(employee2);

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }

	    // 获取，可以获取到关联的对方
	    @Test
	    public void testGet() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // 获取一方，并显示另一方信息
	        Employee employee = (Employee) session.get(Employee.class, 1);
	        System.out.println(employee);
	        System.out.println(employee.getDepartment());

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }

	    // 解除关联关系
	    @Test
	    public void testRemoveRelation() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // 从员工方解除
	        Employee employee = (Employee) session.get(Employee.class, 1);
	        employee.setDepartment(null);

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }

	    // 删除对象，对关联对象的影响
	    @Test
	    public void testDelete() {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        // -------------------------------------------

	        // 删除员工方(多方)，对对方没有影响
	        Employee employee = (Employee) session.get(Employee.class, 1);
	        session.delete(employee);

	        // -------------------------------------------
	        session.getTransaction().commit();
	        session.close();
	    }
}
