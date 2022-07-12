package com.tn.java.api.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tn.java.api.model.CustomerModel;
import com.tn.java.api.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerModel> findAllCustomers(HttpServletRequest request){
		return customerRepository.findAll();
	}
}
