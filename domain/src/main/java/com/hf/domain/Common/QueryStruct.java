package com.hf.domain.Common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class QueryStruct {

	private int offset=0;
	// 每页条数
	private int limit=10000;
	
	private String sort;
	private String order;
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String,Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = (field.get(obj));
            map.put(fieldName, value);
        }
        return map;
    }
	
}
