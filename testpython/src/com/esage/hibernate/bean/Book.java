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

@Entity // ������һ��ʵ��
@Table(name = "t_book", catalog = "test")
public class Book {

	@Id // ���ʾһ������
	// @GeneratedValue �൱��native�������ɲ���
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �൱��identity�������ɲ���
	private Integer id; // ����

	@Column(name = "c_name", length = 30, nullable = true)
	private String name;

	@Temporal(TemporalType.TIMESTAMP) // ������������������
	private Date publicationDate; // ��������

	@Type(type = "double") // ������ȥָ��Hibernate�����һЩ����
	private Double price; // �۸����û�����ע�⣬Ҳ���Զ��������ڱ���

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
