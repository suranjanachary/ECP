package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@NotNull(message = "Format should be dd/mm/yyyy ")
	private LocalDate dateCteated;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@NotNull(message = "Format should be dd/mm/yyyy ")
	private LocalDate dateShipped;
	
	private String customerName;
	private Integer customerId;
	private String status;
	private Integer shippingId;
	private String paymentType;

	
}
