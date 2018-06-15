package com.esage.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToMany(targetEntity = Teacher.class)
	// @joinTable : ʹ��@JoinTable �������м�� �������м���������Student��Teacher��ӳ���ϵ
	// JoinColumns:������������Student ���м���ӳ���ϵ
	// inverseJoinColumns: ������������Teacher���м���ӳ���ϵ
	@JoinTable(name = "s_t", joinColumns = {
			@JoinColumn(name = "c_student_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "c_teacher_id") })
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Teacher> teachers = new HashSet<Teacher>(); // ��������ʦ��

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "[Student: id=" + id + ", name=" + name + "]";
	}
}
