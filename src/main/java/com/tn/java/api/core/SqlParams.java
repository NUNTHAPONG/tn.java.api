package com.tn.java.api.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SqlParams {

	Map<String, Object> params;

	private SqlParams() {
		params = new HashMap<>();
	}

	public static SqlParams create() {
		return new SqlParams();
	}

	public static SqlParams create(String name, Object value) {
		return new SqlParams().add(name, value);
	}

	public SqlParams add(String name, Date value) {
		this.params.put(name, value);
		return this;
	}

	public SqlParams add(String name, LocalDate value) {
		this.params.put(name, value);
		return this;
	}

	public SqlParams add(String name, LocalDateTime value) {
		this.params.put(name, value);
		return this;
	}

	public SqlParams add(String name, Object value) {
		this.params.put(name, value);
		return this;
	}

	public SqlParams addIfAbsent(String name, Object value) {
		this.params.putIfAbsent(name, value);
		return this;
	}

	public Object get(String name) {
		return this.params.get(name);
	}

	Map<String, Object> getParams() {
		return this.params;
	}

}