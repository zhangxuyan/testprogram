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

	/**
	 * 创建一张数据库表
	 * 
	 * @throws SQLException
	 */
	public void creatTable() throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "CREATE TABLE emp (empno int not null, ename varchar(20) not null, age int null, job varchar(20) ,"
				+ " hiredate Date ,sal Double ,primary  key (empno));";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	/**
	 * 
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void insert(int i) throws SQLException, ParseException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// 预处理添加数据，其中有两个参数--“？”
		psql = conn.prepareStatement("insert into emp (empno,ename,job,hiredate,sal) " + "values(?,?,?,?,?)");
		psql.setInt(1, i); // 设置参数1，创建id为3212的数据
		psql.setString(2, "王刚"); // 设置参数2，name 为王刚
		psql.setString(3, "总裁");

		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate2 = dateFormat2.parse("2010-09-13");
		psql.setDate(4, new java.sql.Date(myDate2.getTime()));
		psql.setFloat(5, (float) 2000.3);
		psql.executeUpdate(); // 执行更新
		psql.close();
		conn.close();
	}

	public void update() throws SQLException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// 预处理更新（修改）数据，将王刚的sal改为5000.0
		psql = conn.prepareStatement("update emp set sal = ? where ename = ?");
		psql.setFloat(1, (float) 5000.0);
		psql.setString(2, "王刚");
		psql.executeUpdate();
		psql.close();
		conn.close();
	}

	public void delete() throws SQLException {

		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// 预处理删除数据
		psql = conn.prepareStatement("delete from emp where sal > ?");
		psql.setFloat(1, 4500);
		psql.executeUpdate();
		psql.close();
		conn.close();
	}

	public void executeBatchInsert() throws SQLException {

		long startTime = System.currentTimeMillis();

		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO emp(empno,ename) VALUES (?,?)");
			// System.out.println("数据大小：" + datas.size()); // 1000000

			int num = 0;
			// for (Values v : datas) {
			// num++;
			// stmt.setInt(1, v.getId());
			// stmt.setString(2, v.getStr1());
			// stmt.setString(3, v.getStr2());
			// stmt.setString(4, v.getStr3());
			// stmt.addBatch();
			// // 注意:
			// // 每5万，提交一次;这里不能一次提交过多的数据,我测试了一下，6万5000是极限，6万6000就会出问题，插入的数据量不对。
			// if (num > 50000) {
			// stmt.executeBatch();
			// conn.commit();
			// num = 0;
			// }
			// }

			for (int i = 1; i < 1000000; i++) {
				num++;
				stmt.setInt(1, i);
				stmt.setString(2, "name" + i);
				stmt.addBatch();
				// 注意:
				// 每5万，提交一次;这里不能一次提交过多的数据,我测试了一下，6万5000是极限，6万6000就会出问题，插入的数据量不对。
				if (num > 50000) {
					stmt.executeBatch();
					conn.commit();
					num = 0;
				}

			}
			stmt.executeBatch();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			// closeConnection(conn);
			conn.close();
			long endTime = System.currentTimeMillis();
			System.out.println("方法执行时间：" + (endTime - startTime) + "ms");
		}
	}
}
