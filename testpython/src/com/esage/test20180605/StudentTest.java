package com.esage.test20180605;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class StudentTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7031417446995714773L;
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	public static void main(String[] args) {
		 demo1();

	//	demo2();

	}

	private static void demo2() {
		List<Integer> ls = getIntValue();
		ls.forEach(row -> {
			System.out.println(row.intValue());
		});
	}

	public static List<Integer> getIntValue() {
		List<Integer> ls = new ArrayList<Integer>();

		for (int i = 0; i < 1000; i++) {

			ls.add(i);
		}
		return ls;
	}

	private static void demo1() {
		Student xiaoming = getBean();
		List<String> validate = validate(xiaoming);
		validate.forEach(row -> {
			System.out.println(row.toString());
		});
	}

	private static Student getBean() {
		Student bean = new Student();
		bean.setName("张旭彦");
		bean.setAddress("北京市朝阳区大屯路");
		bean.setBirthday(new Date("2021/01/01"));
		bean.setFriendName("111");
		bean.setWeight(new BigDecimal(101));
		bean.setEmail("xiaogangfan@163.com");
		bean.setSpellName("XIAOGANGFAN".toUpperCase());
		System.out.println(bean);
		return bean;
	}

	public static <T> List<String> validate(T t) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

		List<String> messageList = new ArrayList<>();
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			messageList.add(constraintViolation.getMessage());
		}
		return messageList;
	}

}
