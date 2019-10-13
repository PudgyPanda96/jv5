package com.penrose.Jv5Core.Utill;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
	public static String convertToJson(Object obj) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
}
