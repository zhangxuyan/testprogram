package com.esage.hibernate.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity // 定义了一个实体
@Table(name = "t_book", catalog = "test")
public class Book {

	@Id // 这表示一个主键
	// @GeneratedValue 相当于native主键生成策略
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 相当于identity主键生成策略
	private Integer id; // 主键

	@Column(name = "c_name", length = 30, nullable = true)
	private String name;

	@Temporal(TemporalType.TIMESTAMP) // 是用来定义日期类型
	private Date publicationDate; // 出版日期

	@Type(type = "double") // 允许你去指定Hibernate里面的一些类型
	private Double price; // 价格，如果没有添加注解，也会自动的生成在表中

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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
