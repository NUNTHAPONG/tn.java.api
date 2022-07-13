package com.tn.java.api.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResponseList extends ResponseEntity<List<Map<String, Object>>> {

	public ResponseList(HttpStatus status) {
		super(status);
	}

	public ResponseList(List<Map<String, Object>> body, HttpStatus status) {
		super(body, status);
	}

	public ResponseList(List<Map<String, Object>> body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, headers, status);
	}

	public static ResponseList success(List<Map<String, Object>> data) {
		return new ResponseList(data, HttpStatus.OK);
	}
	
	public static ResponseList success() {
		Map<String, Object> content = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		content.put("success", true);
		list.add(content);
		return new ResponseList(list, HttpStatus.OK);
	}

	public static ResponseList fail() {
		Map<String, Object> content = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		content.put("success", false);
		list.add(content);
		return new ResponseList(list, HttpStatus.ACCEPTED);
	}

	public static ResponseList fail(HttpStatus httpStatus) {
		Map<String, Object> content = new HashMap<>();
		List<Map<String, Object>> list = new ArrayList<>();
		content.put("success", false);
		list.add(content);
		return new ResponseList(list, httpStatus);
	}

}
