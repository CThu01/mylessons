package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
public class Sale implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private double total;
	private double discount;
	
	@ManyToMany
	@JoinTable(
			name = "sale_details", 
			joinColumns = @JoinColumn(name = "sale_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "products_id", 
			referencedColumnName = "id")
		)
	private List<Product> products;
	
	
}
