package com.jkxy.test;
//Java ���ڴ��Ϊջ�ڴ�Ͷ��ڴ棬����ջ�ڴ��������һЩ�������͵ı���������Ͷ�������ã�

//���ڴ���Ҫ���һЩ������ JVM ����һ�����ʱ����������� static ���εĳ�Ա�����ͳ�Ա������
//���Ϊ��Щ��Ա�����ͳ�Ա�����ڹ̶���λ�ÿ���һ���̶���С���ڴ�����������Щ���̶��������ԣ���ô JVM �Ϳ��Էǳ�����ط������ǡ�
//ͬʱ�����̬�ĳ�Ա�����ͳ�Ա��������������Ļ������ǵľ�����ᱣ�ֲ��䡣ͬʱ static ���̺�����̬���ĸ����ʾ�����ǲ��ɻָ��ģ�
//�����Ǹ��ط������޸��ˣ����ǲ�����ԭ���ģ��������ˣ����Ͳ�������ˡ�
//ͬʱ�� static ���εĳ�Ա�����ͳ�Ա�����Ƕ����ڸ���ģ�����������ĳ���ض���ʵ��������Ҳ����˵�������������ʵ������
//����ʵ�������ö�ָ��ͬһ���ط����κ�һ��ʵ��������޸Ķ��ᵼ������ʵ���ı仯��

public class User {
	private static int userNumber = 0;

	public User() {
		userNumber++;
	}

	public static void main(String[] args) {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		System.out.println("user1 userNumber��" + User.userNumber);
		System.out.println("user2 userNumber��" + User.userNumber);
	}

}
