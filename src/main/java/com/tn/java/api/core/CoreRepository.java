package com.tn.java.api.core;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoreRepository {
	
	private final NamedParameterJdbcTemplate jdbcTemplate = null;
	
	public List<Map<String, Object>> executeQuery(String sql, SqlParams params) {

		List<Map<String, Object>> result = this.jdbcTemplate.queryForList(sql.toString(), params.getParams());

		return result;
	}


}
