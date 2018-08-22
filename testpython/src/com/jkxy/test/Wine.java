package com.jkxy.test;

public class Wine {
	public void fun1() {
		System.out.println("Wine ��Fun.....");
		fun2();
	}

	public void fun2() {
		System.out.println("Wine ��Fun2...");
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Wine [name=" + name + "]";
	}

	public String drink() {

		return " �ȵ���" + getName();
	}
}

class JNC extends Wine {
	/**
	 * @desc �������ظ��෽�� �����в����ڸ÷���������ת�ͺ󣬸����ǲ������ø÷�����
	 * @param a
	 * @return void
	 */
	public void fun1(String a) {
		System.out.println("JNC �� Fun1...");
		fun2();
	}

	/**
	 * ������д���෽�� ָ������ĸ������õ���fun2ʱ���ض��ǵ��ø÷���
	 */
	public void fun2() {
		System.out.println("JNC ��Fun2...");
	}

	public JNC() {
		setName("JNC");
		// TODO Auto-generated constructor stub
	}

	public String drink() {

		return " �ȵ��� " + getName();

	}

	@Override
	public String toString() {
		return "Wine " + getName();
	}
}

class JGJ extends Wine {
	public JGJ() {

		setName("JGJ");
	}

	public String drink() {

		return " �ȵ��� " + getName();
	}

	public String toString() {

		return "Wine :" + getName();

	}

}