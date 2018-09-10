package com.heima.test;

public class RuntimeDemo {
	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime();
		// Process p = r.exec("D:\\软件\\QQ\\Bin\\QQScLauncher.exe"); //
		// 传的命令的路径可能是错误的，所以可能会抛出异常
		// Thread.sleep(4000); // 等待4s后才杀掉进程，不然就是秒杀
		// p.destroy(); // 杀掉进程

		Process p = r.exec("notepad.exe SystemDemo.java"); // 用记事本程序打开SystemDemo.java文件
	}

}
