package com.jkxy.test;

import java.io.Serializable;

public class Person implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3995266708001442843L;

	/**
	 * 
	 */

	private String name;

	private Email email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Person(String name, Email email) {

		this.name = name;
		this.email = email;
	}

	public Person(String name) {
		this.name = name;

	}

	protected Person clone() {

		Person person = null;

		try {
			person = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;

	}
}
