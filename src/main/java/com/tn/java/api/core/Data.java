package com.tn.java.api.core;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Data {

	private Map<String, Object> data;

	private Data() {
	}

	public static Data of() {
		Data d = new Data();
		d.data = new HashMap<String, Object>();
		return d;
	}

	public static Data of(Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		BeanWrapper bw = new BeanWrapperImpl(object);
		for (PropertyDescriptor pd : bw.getPropertyDescriptors()) {
			Method reader = pd.getReadMethod();
			if (reader != null) {
				try {
					map.put(pd.getName(), reader.invoke(object));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return of(map);
	}

	public static Data of(String key, Object value) {
		return Data.of().put(key, value);
	}

	public static Data of(Map<String, Object> data) {
		Data d = Data.of();
		if (data != null) {
			d.data.putAll(data);
		}
		return d;
	}

	public Data put(String key, Object value) {
		this.data.put(key, value);
		return this;
	}

	public Object get(String key) {
		return this.data.get(key);
	}

	public Data remove(String key) {
		this.data.remove(key);
		return this;
	}

	public boolean isNullOrEmpty() {
		return this.data == null || this.data.size() == 0;
	}

	public boolean isNotNullOrEmpty() {
		return !this.isNullOrEmpty();
	}

	public static Data ofError(String errorCode) {
		return Data.of().put("error", errorCode);
	}

	public static Data ofError(String[] errorCodes) {
		return Data.of().put("error", errorCodes);
	}

	public static Data ofError(Map<String, Object> errorData) {
		return Data.of("error", errorData);
	}
}
