package com.esage.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_idcard")
public class IDCard {

	
	@Id
	private String id ;
	
	
	@GenericGenerator(strategy="uuid",name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String cardNum;
	
	
	
}
