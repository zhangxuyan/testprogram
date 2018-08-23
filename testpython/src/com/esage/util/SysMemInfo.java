package com.esage.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.StringTokenizer;

import ch.ethz.ssh2.Session;

import java.io.*;
import java.lang.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SysMemInfo {
	private int MEM_INFO = 0;

	public SysMemInfo(Session session, String hostname) {
		InputStream is = null;
		BufferedReader brStat = null;
		StringTokenizer tokenStat = null;
		Session sess = null;
		String str = "";
		int i = 0, j = 0, free = 0, buff = 0, cache = 0, totalmemory = 0, memidle = 0;
		double memused = 0;
		// DataBaseCon datacon = null;
		ResultSet reset;
		Statement stmt = null;
		/**
		 * ����ִ��linux shell�д����ض���͹ܵ����˵�����,��Ҫʹ�����������ʽ.
		 */
		try {
			// datacon = new DataBaseCon();
			// stmt = datacon.getDBconnection().createStatement();

			// reset = stmt.executeQuery("select TOTAL_MEMORY from machine_info
			// where machine_ip='" + hostname + "'");
			// while (reset.next()) {
			// totalmemory = reset.getInt("TOTAL_MEMORY");
			// }
			sess = session;
			sess.execCommand("vmstat 2 10 ");
			/**
			 * ִ��vmstat������ϵͳCPU�������,vmstat 2 10��ʾ2�������һ�ι����10������ ��ʾ�������:
			 * [mon724@v0A-202-40-18 ~]$ vmstat 2 10 procs
			 * -----------memory---------- ---swap-- -----io---- --system--
			 * -----cpu------ r b swpd free buff cache si so bi bo in cs us sy
			 * id wa st 1 0 41328 58860 199292 1877728 0 0 2 23 0 0 2 0 98 0 0 0
			 * 0 41328 58744 199292 1877884 0 0 0 0 1080 1057 3 0 96 0 0 0 0
			 * 41328 58084 199300 1878036 0 0 0 250 1310 1258 6 0 94 0 0 0 0
			 * 41328 57844 199300 1878148 0 0 0 32 761 697 3 0 97 0 0 0 0 41328
			 * 57852 199304 1878224 0 0 0 214 630 593 1 1 98 0 0 0 0 41328 56984
			 * 199304 1878372 0 0 0 50 1033 881 6 0 94 0 0 0 0 41328 56860
			 * 199304 1878440 0 0 0 0 536 578 2 0 98 0 0 1 0 41328 56868 199308
			 * 1878552 0 0 0 200 545 581 1 0 99 0 0 0 0 41328 56876 199308
			 * 1878644 0 0 0 102 628 663 1 0 99 0 0 0 0 41328 56876 199308
			 * 1878696 0 0 0 118 615 580 3 0 96 0 0
			 */
			is = new StreamGobbler(sess.getStdout());

			brStat = new BufferedReader(new InputStreamReader(is));
			/*
			 * �ȶ�ȡ��һ��Title��Ϣ procs -----------memory---------- ---swap--
			 * -----io---- --system-- -----cpu------
			 */
			brStat.readLine();
			/*
			 * ��ȡ�ڶ���Title��Ϣ��ȡ��������Ϣ r b swpd free buff cache si so bi bo in cs us
			 * sy id wa st
			 */
			brStat.readLine();

			/*
			 * ��ȡ��������Ϣ 1 0 41328 58860 199292 1877728 0 0 2 23 0 0 2 0 98 0 0
			 * ע��ÿ��ִ��vmstat����ʱ,������Ϣ��������,��˲���Ϊ��ȡ����ʹ��
			 */
			brStat.readLine();
			/*
			 * ��ȡ��4�е���12����Ϣ
			 */
			for (j = 0; j < 9; j++) {
				str = brStat.readLine();

				if (str == null)
					break;
				tokenStat = new StringTokenizer(str);
				/*
				 * ����ÿ��ǰ3����Ϣ r b swpd 1 0 41328
				 */
				for (i = 0; i < 3; i++) {
					tokenStat.nextToken();
				}
				/*
				 * ��ȡÿ����free,buff,cache����Ϣ r b swpd free buff cache si so bi bo
				 * in cs us sy id wa st 1 0 41328 58860 199292 1877728 0 0 2 23
				 * 0 0 2 0 98 0 0
				 * 
				 */
				/* ��ȡfree����Ϣ */
				free = free + new Integer(tokenStat.nextToken()).intValue();
				// SysLogger.log("free is :"+free);
				/* ��ȡbuff����Ϣ */
				buff = buff + new Integer(tokenStat.nextToken()).intValue();
				// SysLogger.log("buff is :"+buff);
				/* ��ȡcache����Ϣ */
				cache = cache + new Integer(tokenStat.nextToken()).intValue();
				// SysLogger.log("cache is :"+cache);

			}
			/*
			 * ===========================================================
			 * ����ڴ�IDLE��ƽ��ֵ,��Ϊ��ȡ��9�����������Ҫ����9�ó�ƽ��ֵ
			 * ����Ӧ�ó�����˵ϵͳ�������ڴ������free+buff+cache֮��
			 * ===========================================================
			 */
			memidle = (free + buff + cache) / 9;
			/* ����ڴ�ռ���� */
			memused = ((totalmemory - memidle) * 100) / totalmemory;
			// SysLogger.log("SysMemInfo memidle is :"+memidle+"===memused is
			// :"+memused);
			MEM_INFO = new Double(memused).intValue();
			//// SysLogger.log("SysMemInfo MEM_INFO IS : " + MEM_INFO);
		} catch (Exception e) {
			//// SysLogger.log("SysMemInfo error at line 39 :" + e.toString());
		}
	}

	public int getMEMInfo() {
		return MEM_INFO;
	}
}
