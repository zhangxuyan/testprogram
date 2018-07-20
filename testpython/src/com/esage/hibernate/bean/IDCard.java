package com.esage.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_idcard", catalog = "test")
public class IDCard {

	@Id
	@GenericGenerator(strategy = "uuid", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;

	private String cardNum;

	@OneToOne(targetEntity=User1.class)
	@JoinColumn(name="c_user_id")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private User1 user1;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}


	public User1 getUser1() {
		return user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

	@Override
	public String toString() {
		return "IDCard [id=" + id + ", cardNum=" + cardNum + ", user=" + user1 + "]";
	}
	
	
}
