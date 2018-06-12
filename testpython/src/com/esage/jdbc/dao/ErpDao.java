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

	
	public void creatTable(){
		
		
		
	}
	
	
	public void insert() throws SQLException, ParseException {
		String name;
		String id;
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		ResultSet res;
		// Ԥ����������ݣ���������������--������
		psql = conn.prepareStatement("insert into emp (empno,ename,job,hiredate,sal) " + "values(?,?,?,?,?)");
		psql.setInt(1, 3212); // ���ò���1������idΪ3212������
		psql.setString(2, "����"); // ���ò���2��name Ϊ����
		psql.setString(3, "�ܲ�");

		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate2 = dateFormat2.parse("2010-09-13");
		psql.setDate(4, new java.sql.Date(myDate2.getTime()));
		psql.setFloat(5, (float) 2000.3);
		psql.executeUpdate(); // ִ�и���
	}

	public void update() throws SQLException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// Ԥ������£��޸ģ����ݣ������յ�sal��Ϊ5000.0
		psql = conn.prepareStatement("update emp set sal = ? where ename = ?");
		psql.setFloat(1, (float) 5000.0);
		psql.setString(2, "����");
		psql.executeUpdate();
	}

	public void delete() throws SQLException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psql;
		// Ԥ����ɾ������
		psql = conn.prepareStatement("delete from emp where sal > ?");
		psql.setFloat(1, 4500);
		psql.executeUpdate();
		psql.close();
	}
}
