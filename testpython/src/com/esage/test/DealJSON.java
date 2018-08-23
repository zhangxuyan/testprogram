package com.esage.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DealJSON {
	public static void useJSONObject() {
		String jsonString = "{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"10371443@qq.com\"}";
		JSONObject json = JSONObject.fromObject(jsonString);
		System.out.println(json.getString("name"));
		System.out.println(json.getString("password"));
		System.out.println(json.getString("email"));
	}

	public static void main(String[] args) {
		// useJSONObject();
		// useJSONObjects();
		jsonArray();
	}

	public static void useJSONObjects() {
		String jsonString = "{\"name\":\"zhangsan\",\"sex\":\"ÄÐ\",\"phone\":\"1529078877\"}";

		JSONObject json = JSONObject.fromObject(jsonString);
		System.out.println(json.get("name"));
		System.out.println(json.getString("name"));
	}

	public static void jsonArray() {
		String jsonString = "[{\"name\":\"zhangsan\",\"sex\":\"ÄÐ\"},{\"name\":\"lisi\",\"sex\":\"Å®\"}]";
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.println(jsonArray.getJSONObject(i).get("name"));
			System.out.println(jsonArray.getJSONObject(i).get("sex"));
			System.out.println("-----------------");

		}

	}
}
