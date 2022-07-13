package com.tn.java.api.model;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "customers")
public class CustomerModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id", nullable = false)
	@SequenceGenerator(name = "customers_customer_id_seq", sequenceName = "customers_customer_id_seq")
	private Long customerId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "street", nullable = true)
	private String street;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "state", nullable = true)
	private String state;
	
	@Column(name = "zip_code", nullable = true)
	private String zipCode;
    
}
