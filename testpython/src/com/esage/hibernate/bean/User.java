package com.esage.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GenericGenerator(strategy = "uuid", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private Integer id; // �Ƽ�ʹ�ð�װ��

	private String strName;

	// private Set<String> addressSet; // δ��ʼ����Set����

	private Set<String> addressSet = new HashSet<String>(); // Set����

	@OneToOne(targetEntity = IDCard.class, mappedBy = "user")
	private IDCard idCard;

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

	
	
	
	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", strName=" + strName + ", addressSet=" + addressSet + "]";
	}
}
