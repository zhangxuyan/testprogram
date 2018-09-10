package com.heima.test;

@SuppressWarnings("rawtypes")
public class Student implements Comparable {
	private String name;
	private int age;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	// ʵ��ѧ���ıȽϹ��� �� �ù��� �� ��Ȼ����ʹ�õķ���
	// ��Ȼ����������������Ϊ��
	@Override
	public int compareTo(Object o) {
		Student stu = (Student) o;
		System.out.println(this.name + ":" + this.age + "--" + stu.name + ":" + stu.age);

		if (this.age > stu.age) {

			return 1;
		}

		if (this.age < stu.age) {

			return -1;
		}

		return 0;
	}

}
