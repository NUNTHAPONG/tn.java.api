package com.tn.java.api.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class ListData {

	private List<Map<String, Object>> rows;
	private long total;
	
	private ListData() {
	}

	public static ListData of(List<Map<String, Object>> rows) {
		ListData d = new ListData();
		d.rows = rows != null ? rows : new ArrayList<>();
		return d;
	}

	public static ListData of(List<Map<String, Object>> rows, long total) {
		ListData data = new ListData();
		data.rows = rows != null ? rows : new ArrayList<>();
		data.total = total;
		return data;
	}
}