package com.jkxy.test;
//Java 把内存分为栈内存和堆内存，其中栈内存用来存放一些基本类型的变量、数组和对象的引用，

//堆内存主要存放一些对象。在 JVM 加载一个类的时候，若该类存在 static 修饰的成员变量和成员方法，
//则会为这些成员变量和成员方法在固定的位置开辟一个固定大小的内存区域，有了这些“固定”的特性，那么 JVM 就可以非常方便地访问他们。
//同时如果静态的成员变量和成员方法不出作用域的话，它们的句柄都会保持不变。同时 static 所蕴含“静态”的概念表示着它是不可恢复的，
//即在那个地方，你修改了，他是不会变回原样的，你清理了，他就不会回来了。
//同时被 static 修饰的成员变量和成员方法是独立于该类的，它不依赖于某个特定的实例变量，也就是说它被该类的所有实例共享。
//所有实例的引用都指向同一个地方，任何一个实例对其的修改都会导致其他实例的变化。

public class User {
	private static int userNumber = 0;

	public User() {
		userNumber++;
	}

	public static void main(String[] args) {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		System.out.println("user1 userNumber：" + User.userNumber);
		System.out.println("user2 userNumber：" + User.userNumber);
	}

}
