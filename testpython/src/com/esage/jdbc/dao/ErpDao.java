package com.esage.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErpDao {

	public void insert() throws SQLException, ParseException {
		String name;
		String id;
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		ResultSet res;
		// 预处理添加数据，其中有两个参数--“？”
		psql = conn.prepareStatement("insert into emp (empno,ename,job,hiredate,sal) " + "values(?,?,?,?,?)");
		psql.setInt(1, 3212); // 设置参数1，创建id为3212的数据
		psql.setString(2, "王刚"); // 设置参数2，name 为王刚
		psql.setString(3, "总裁");

		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate2 = dateFormat2.parse("2010-09-13");
		psql.setDate(4, new java.sql.Date(myDate2.getTime()));
		psql.setFloat(5, (float) 2000.3);
		psql.executeUpdate(); // 执行更新
	}

	public void update() throws SQLException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// 预处理更新（修改）数据，将王刚的sal改为5000.0
		psql = conn.prepareStatement("update emp set sal = ? where ename = ?");
		psql.setFloat(1, (float) 5000.0);
		psql.setString(2, "王刚");
		psql.executeUpdate();
	}

	public void delete() throws SQLException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// 预处理删除数据
		psql = conn.prepareStatement("delete from emp where sal > ?");
		psql.setFloat(1, 4500);
		psql.executeUpdate();
		psql.close();
	}
}
