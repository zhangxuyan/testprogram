package com.esage.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;// 主键

	@Column
	private String name;// 姓名

	// 描述客户可以有多个订单
	/*
	 * targetEntity="..."：相当于<one-to-many class="...">
	 * mappedBy="..."：相当于inverse=true，即放弃关联关系的维护，不然会生成一个中间表
	 */
	@OneToMany(targetEntity = Order.class, mappedBy = "c", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", orders=" + orders + "]";
	}

}
