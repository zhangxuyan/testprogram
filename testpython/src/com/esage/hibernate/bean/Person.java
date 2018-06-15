package com.esage.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="t_person" ,catalog="test")
public class Person {

	
	//����uuid���������ɲ���
	@Id
	@GenericGenerator(name="myuuid",strategy="uuid")//����һ���������ɲ���
	@GeneratedValue(generator="myuuid")//����uuid�������ɲ���
	private String id;
	
	@Type(type="string")
	private String name ;
	
	@Transient
	private String msg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
