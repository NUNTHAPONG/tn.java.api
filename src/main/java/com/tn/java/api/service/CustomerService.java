package com.tn.java.api.service;

import java.util.List;

import com.tn.java.api.core.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.tn.java.api.core.CoreUtility;
import com.tn.java.api.model.CustomerModel;
import com.tn.java.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CoreUtility coreUtility;
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerModel> read(String keyword) {
		if (coreUtility.isNotNullOrWhitespace(keyword)) {
			return searchByKeyword(keyword);
		}
		return this.customerRepository.findAll(coreUtility.sort("customerId", "asc"));
	}
	
	public CustomerModel find(Long id) {
		return customerRepository.findByCustomerId(id);
	}
	
	public void update(Long id, CustomerModel model) {
		model.setCustomerId(id);
		this.customerRepository.saveAndFlush(model);
	}
	
	public void create(CustomerModel model) {
		this.customerRepository.saveAndFlush(model);
	}

	public void delete(Long id) {
		this.customerRepository.deleteById(id);
	}
	
	private List<CustomerModel> searchByKeyword(String keyword){
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from customers ");
		sql.append("where concat(email,first_name,last_name,phone) ");
		sql.append("ilike '%' || :keyword || '%' ");
		sql.append("order by customer_id asc");
		SqlParams params = SqlParams.create("keyword", keyword);
		return this.jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<CustomerModel>(CustomerModel.class));
	}
}

