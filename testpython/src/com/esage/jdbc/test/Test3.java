package com.esage.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.esage.jdbc.dao.ErpDao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
public class Test3 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		// selectDB();
	//	insertDB();
//		updateDB();
		ErpDao delete = new ErpDao();
		try {
			delete.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void updateDB() {
		ErpDao update = new ErpDao();
		try {
			update.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void insertDB() {
		ErpDao insert = new ErpDao();
		try {
			insert.insert();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void selectDB() {
		// ����Connection����
		Connection con;
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���mydata
		String url = "jdbc:mysql://192.168.1.180:3306/test";
		// MySQL����ʱ���û���
		String user = "root";
		// MySQL����ʱ������
		String password = "123456";
		// ������ѯ�����
		try {
			// ������������
			Class.forName(driver);
			// 1.getConnection()����������MySQL���ݿ⣡��
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.����statement���������ִ��SQL��䣡��
			Statement statement = con.createStatement();
			// Ҫִ�е�SQL���
			String sql = "select * from emp";
			// 3.ResultSet�࣬������Ż�ȡ�Ľ��������
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-----------------");
			System.out.println("����" + "\t" + "ְ��");
			System.out.println("-----------------");

			String job = null;
			String id = null;
			while (rs.next()) {
				// ��ȡstuname��������
				job = rs.getString("job");
				// ��ȡstuid��������
				id = rs.getString("ename");

				// ������
				System.out.println(id + "\t" + job);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// ���ݿ��������쳣����
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// ���ݿ�����ʧ���쳣����
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("���ݿ����ݳɹ���ȡ����");
			// System.exit(0);
		}
	}

}
