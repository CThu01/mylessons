package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category_tbl")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_seq")
	@TableGenerator(allocationSize = 1, name = "category_seq")
	private int id;
	private String name;
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	
	
	
}
