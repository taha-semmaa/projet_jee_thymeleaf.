package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Groupe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public Groupe() {
		super();
		
	}

	@Column(name="fName_groups",nullable=false)
	private String Name_groups;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName_groups() {
		return Name_groups;
	}

	public void setName_groups(String name_groups) {
		Name_groups = name_groups;
	}

	public Groupe(long id, String name_groups) {
		super();
		this.id = id;
		Name_groups = name_groups;
	}
	

}
