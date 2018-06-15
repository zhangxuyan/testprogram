package com.esage.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double money;

	private String receiverInfo;// 说获地址

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "c_customer_id") // 指定外间列
	private Customer c;// 描述订单属于某一个客户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getReceiverInfo() {
		return receiverInfo;
	}

	public void setReceiverInfo(String receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	
	
}
