package com.esage.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer id; // 推荐使用包装类
	private String strName;

	// private Set<String> addressSet; // 未初始化的Set集合

	private Set<String> addressSet = new HashSet<String>(); // Set集合

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String strName, Set<String> addressSet) {
		super();
		this.id = id;
		this.strName = strName;
		this.addressSet = addressSet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
}
