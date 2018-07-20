package com.esage.test;

public class Test {

	public static void main(String[] args) {
		System.out.println(Child.m);
		System.out.println(Father.m);
		// System.out.println(Const.NAME);
		System.out.println(Child.m);
	}

}

class Father {
	public static int m = 33;
	static {
		System.out.println("父类被初始化");
	}
}

class Child extends Father {
	public static int m = 100;
	static {
		System.out.println("子类被初始化");
	}
}

class Const {
	public static final String NAME = "我是常量";
	static {
		System.out.println("初始化Const类");
	}
}