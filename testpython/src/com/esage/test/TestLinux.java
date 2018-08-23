package com.esage.test;

import com.esage.util.SysCpuInfo;
import com.esage.util.SysMemInfo;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

public class TestLinux {
	public static void main(String[] args) {
		Connection conn = null;
		boolean isAuthenticated = false;

		String hostname = "192.168.1.180";
		String username = "root";
		String password = "esage2020";

		try {
			/* Create a connection instance */
			conn = new Connection(hostname); // hostname ��ҪԶ�̵�¼������IP��ַ,��10.0.2.1

			/* Now connect */
			conn.connect();

			/*
			 * Authenticate. If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			isAuthenticated = conn.authenticateWithPassword(username, password); // ��ҪԶ�̵�¼���������û���������,��admin/123456
			// System.out.println("authenticate sucess
			// ...........................");
			if (isAuthenticated == false)
				System.out.println("SSH Login  Authentication failed.");
			else {
				/* Create a session */
				Session sess = conn.openSession();
				System.out.println(new SysCpuInfo(sess).getCPUInfo());
				/* ע��,һ��sessionֻ��ִ��һ��shell,���,�����Ҫ��ִ��shell�Ļ�,�������´���һ��session */
				sess.close();
				sess = conn.openSession();
				System.out.println(new SysMemInfo(sess, "").getMEMInfo());
				sess.close();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
