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
		System.out.println("���౻��ʼ��");
	}
}

class Child extends Father {
	public static int m = 100;
	static {
		System.out.println("���౻��ʼ��");
	}
}

class Const {
	public static final String NAME = "���ǳ���";
	static {
		System.out.println("��ʼ��Const��");
	}
}