package com.tn.java.api.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

@Repository
public class CoreUtility {
	
	public String getJSONBodyRequest(HttpServletRequest request) throws IOException {
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
}
