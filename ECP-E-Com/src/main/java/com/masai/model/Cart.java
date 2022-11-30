package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@NotNull
	private Integer productId;
	@NotNull
	private Integer quantity;
	@NotNull
	private Float unitCost;
	@NotNull
	private Float subtotal;
	@NotNull
	private String dateAdde;
	
	
}
