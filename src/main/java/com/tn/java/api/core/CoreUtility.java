package com.tn.java.api.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class CoreUtility {
	
	public String getJSONFromBodyRequest(HttpServletRequest request) throws IOException {
	    BufferedReader reader = request.getReader();
	    StringBuilder sb = new StringBuilder();
	    String line = reader.readLine();
	    while (line != null) {
	      sb.append(line + "\n");
	      line = reader.readLine();
	    }
	    reader.close();
	    String params = sb.toString();
	    String[] _params = params.split("&");
	    for (String param : _params) {
	      System.out.println("params(POST)-->" + param);
	    }
	    return params;
	}

	public Sort sort(String column, String direction){
		if(direction.toUpperCase().equals("ASC")) {
			return Sort.by(Sort.Direction.ASC, column);
		}
		return Sort.by( Sort.Direction.DESC, column);
	}

	public Boolean isNull(Object value) {
		return value == null;
	}
	
	public Boolean isNullOrEmpty(Collection<?> value) {
		return value == null || value.isEmpty();
	}
	
	public Boolean isNullOrWhitespace(String value) {
		return value == null || value.isBlank();
	}
	
	public Boolean isNotNull(Object value) {
		return !this.isNull(value);
	}

	public Boolean isNotNullOrEmpty(Collection<?> value) {
		return !this.isNullOrEmpty(value);
	}
	
	public Boolean isNotNullOrWhitespace(String value) {
		return !this.isNullOrWhitespace(value);
	}
	
}
