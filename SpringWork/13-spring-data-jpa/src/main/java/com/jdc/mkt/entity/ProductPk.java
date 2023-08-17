package com.jdc.mkt.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "porductPK_tbl")
public class ProductPk implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String size;

}
