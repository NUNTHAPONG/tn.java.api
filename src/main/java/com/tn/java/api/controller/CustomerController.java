package com.tn.java.api.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.tn.java.api.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tn.java.api.core.CoreUtility;
import com.tn.java.api.model.CustomerModel;
import com.tn.java.api.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CoreUtility coreUtility;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping()
	public List<CustomerModel> Get(HttpServletRequest request){
		return customerService.read(request.getParameter("keyword"));
	}
	
	@GetMapping("/{id}")
	public CustomerModel Find(HttpServletRequest request, @PathVariable ("id") Long id){

		return customerService.find(id);
	}

	@PostMapping()
	public Response Post(HttpServletRequest request, @RequestBody CustomerModel model){
		if(coreUtility.isNull(model)) {
			return Response.fail();
		}else {
			customerService.create(model);
		}
		return Response.success();
	}

	@PutMapping("/{id}")
	public Response Put(HttpServletRequest request, @PathVariable ("id") Long id, @RequestBody CustomerModel model){
		if(coreUtility.isNull(model) && coreUtility.isNull(id)) {
			return Response.fail();
		}else{
			customerService.update(id, model);
		}
		return Response.success();
	}

	@DeleteMapping("/{id}")
	public Response Delete(HttpServletRequest request, @PathVariable ("id") Long id){
		if(coreUtility.isNull(id)){
			return Response.fail();
		}else {
			customerService.delete(id);
		}
		return Response.success();
	}

}
