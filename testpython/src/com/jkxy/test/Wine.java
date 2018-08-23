package com.jkxy.test;

public class Wine {
	public void fun1() {
		System.out.println("Wine 的Fun.....");
		fun2();
	}

	public void fun2() {
		System.out.println("Wine 的Fun2...");
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

		return " 喝的是" + getName();
	}
}

class JNC extends Wine {
	/**
	 * @desc 子类重载父类方法 父类中不存在该方法，向上转型后，父类是不能引用该方法的
	 * @param a
	 * @return void
	 */
	public void fun1(String a) {
		System.out.println("JNC 的 Fun1...");
		fun2();
	}

	/**
	 * 子类重写父类方法 指向子类的父类引用调用fun2时，必定是调用该方法
	 */
	public void fun2() {
		System.out.println("JNC 的Fun2...");
	}

	public JNC() {
		setName("JNC");
		// TODO Auto-generated constructor stub
	}

	public String drink() {

		return " 喝的是 " + getName();

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

		return " 喝的是 " + getName();
	}

	public String toString() {

		return "Wine :" + getName();

	}

}