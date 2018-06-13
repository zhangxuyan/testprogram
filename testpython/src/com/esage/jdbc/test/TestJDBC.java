//package com.esage.jdbc.test;
//
//public class TestJDBC {
//
//}
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
public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creatTable();
		// insertDB();
		// selectDB();

		// updateDB();
		// delete();
		executeBatchInsert();
	}

	private static void creatTable() {
		ErpDao createTable = new ErpDao();
		try {
			createTable.creatTable();
			System.out.println("创建表成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void delete() {
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
			System.out.println("update data success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void insertDB() {
		ErpDao insert = new ErpDao();
		try {
			for (int i = 14620; i < 100000; i++) {
				insert.insert(i);
			}
			System.out.println("insert data  succeeded");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void selectDB() {
		// 声明Connection对象
		Connection con;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://192.168.1.180:3306/test";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "esage2020";
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
			String sql = "select * from emp";
			// 3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("姓名" + "\t" + "职称");
			System.out.println("-----------------");

			String job = null;
			String id = null;
			while (rs.next()) {
				// 获取stuname这列数据
				job = rs.getString("job");
				// 获取stuid这列数据
				id = rs.getString("ename");

				// 输出结果
				System.out.println(id + "\t" + job);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("数据库数据成功获取！！");
			// System.exit(0);
		}
	}

	private static void executeBatchInsert() {

		ErpDao executeBatchInsert = new ErpDao();
		try {
			executeBatchInsert.executeBatchInsert();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
