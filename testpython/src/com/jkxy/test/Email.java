package com.jkxy.test;

import java.io.Serializable;

public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8293691413552919267L;

	public Email(String str, String content) {
		super();
		// TODO Auto-generated constructor stub
		this.content = content;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
