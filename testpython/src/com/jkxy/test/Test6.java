package com.jkxy.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test6 {
	public static void main(String[] args) {

		// //String str =
		// "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]";
		// // һ��δת�����ַ���
		//
		// String str =
		// "[{"dev":"esage_13","recev":0.0,"send":0.0},{"dev":"esage_12","recev":0.0,"send":0.0}]"
		// ;
		// JSONArray jsonArray = JSONArray.fromObject(str); // ���Ȱ��ַ���ת��
		// JSONArray
		// // ����
		// if (jsonArray.size() > 0) {
		// for (int i = 0; i < jsonArray.size(); i++) {
		// // ����json��������
		// JSONObject object = jsonArray.getJSONObject(i);
		// object.get(i);
		// System.out.println(object.getString("name"));
		// }
		// }

		/* ���Ժϲ�����������ͬ��list */
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		// ��list1��ֵ
		list1.add("��");
		list1.add("��");
		list1.add("һ");
		list1.add("��");
		// ��list2��ֵ
		list2.add("��");
		list2.add("��");
		list2.add("��");
		list2.add("��");
		list2.add("��");
		list2.add("��");
		// ��list1.list2�ϲ�
		list1.addAll(list2);
		// ѭ�����list1 �������
		for (String s : list1) {
			System.out.print(s);
		}

	}
}
