package com.tn.java.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tn.java.api.model.CustomerModel;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

	CustomerModel findByCustomerId(Long id);

	List<CustomerModel> findAllByOrderByCustomerIdAsc();
}
