package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static javax.persistence.GenerationType.TABLE;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_tbl")
@AllArgsConstructor
//@IdClass(ProductPk.class)
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductPk id;
//	@Id
//	private String code;
//	@Id
//	private String size;
	
	private String name;
	private int price;
	@ManyToOne
	private Category category;
	
	
	public Product(String name, int price, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	
	
}
