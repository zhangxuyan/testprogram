package com.jkxy.test;

public class Client {
	public static void main(String[] args) {

		test1();

		// test2();

	}

	private static void test2() {
		// д���ʼ�
		Email email = new Email("��μӻ���", "�������12:30���������Ҳμӻ���...");

		Person person1 = new Person("����", email);

		Person person2 = CloneUtils.clone(person1);
		person2.setName("����");
		Person person3 = CloneUtils.clone(person1);
		person3.setName("����");
		person1.getEmail().setContent("�������12:00���������Ҳμӻ���...");

		System.out.println(person1.getName() + "���ʼ������ǣ�" + person1.getEmail().getContent());
		System.out.println(person2.getName() + "���ʼ������ǣ�" + person2.getEmail().getContent());
		System.out.println(person3.getName() + "���ʼ������ǣ�" + person3.getEmail().getContent());
	}

	private static void test1() {
		Email email = new Email("��μӻ��� ", "�������12:30 �������Ҳμӻ��顣����");
		Person person1 = new Person("����", email);
		Person person2 = person1.clone();
		person2.setName("����");
		Person person3 = person1.clone();
		person3.setName("����");
		person1.getEmail().setContent("�������12:00 �������Ҳμӻ��顣����");

		System.out.println(person1.getName() + " �ʼ������� ��" + person1.getEmail().getContent());
		System.out.println(person2.getName() + " �ʼ������� ��" + person2.getEmail().getContent());
		System.out.println(person3.getName() + " �ʼ������� ��" + person3.getEmail().getContent());
	}

}