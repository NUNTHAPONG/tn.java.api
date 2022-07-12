package com.tn.java.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "customers")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false)
	public Long customerId;
	
	@Column(name = "first_name", nullable = false)
     public String firstName;
	
	@Column(name = "last_name", nullable = false)
     public String lastName;
	
	@Column(name = "phone", nullable = true)
     public String phone;
	
	@Column(name = "email", nullable = false)
     public String email;
	
	@Column(name = "street", nullable = true)
     public String street;
	
	@Column(name = "city", nullable = true)
     public String city;
	
	@Column(name = "state", nullable = true)
     public String state;
	
	@Column(name = "zip_code", nullable = true)
     public String zipCode;
    
}
