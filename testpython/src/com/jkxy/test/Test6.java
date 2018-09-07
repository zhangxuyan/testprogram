package com.jkxy.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test6 {
	public static void main(String[] args) {

		// //String str =
		// "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]";
		// // 一个未转化的字符串
		//
		// String str =
		// "[{"dev":"esage_13","recev":0.0,"send":0.0},{"dev":"esage_12","recev":0.0,"send":0.0}]"
		// ;
		// JSONArray jsonArray = JSONArray.fromObject(str); // 首先把字符串转成
		// JSONArray
		// // 对象
		// if (jsonArray.size() > 0) {
		// for (int i = 0; i < jsonArray.size(); i++) {
		// // 遍历json数组内容
		// JSONObject object = jsonArray.getJSONObject(i);
		// object.get(i);
		// System.out.println(object.getString("name"));
		// }
		// }

		/* 测试合并两个类型相同的list */
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		// 给list1赋值
		list1.add("测");
		list1.add("试");
		list1.add("一");
		list1.add("下");
		// 给list2赋值
		list2.add("合");
		list2.add("并");
		list2.add("列");
		list2.add("表");
		list2.add("测");
		list2.add("试");
		// 将list1.list2合并
		list1.addAll(list2);
		// 循环输出list1 看看结果
		for (String s : list1) {
			System.out.print(s);
		}

	}
}
