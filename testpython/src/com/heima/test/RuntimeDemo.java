package com.heima.test;

public class RuntimeDemo {
	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime();
		// Process p = r.exec("D:\\���\\QQ\\Bin\\QQScLauncher.exe"); //
		// ���������·�������Ǵ���ģ����Կ��ܻ��׳��쳣
		// Thread.sleep(4000); // �ȴ�4s���ɱ�����̣���Ȼ������ɱ
		// p.destroy(); // ɱ������

		Process p = r.exec("notepad.exe SystemDemo.java"); // �ü��±������SystemDemo.java�ļ�
	}

}
