package com.esage.test;
//

//public class Test1 {
//
//}

//package com.xs.waybill.eparcel;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;

import org.apache.commons.httpclient.UsernamePasswordCredentials;

import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.commons.httpclient.methods.StringRequestEntity;

import org.apache.commons.io.FileUtils;

public class Test1 {

	public static void main(String[] args) throws Exception {

		HttpClient client = new HttpClient();

		client.getState().setCredentials(AuthScope.ANY,

				new UsernamePasswordCredentials("admin", "superadmin"));

		// PostMethod method = new
		// PostMethod("https://webapi.auspost.com.au/soap/LodgementManagement_MerchantTest_v1");
		GetMethod method = new GetMethod("http://192.168.1.201:8009/api/admin/enterprises/1/users/1");
		// method.setRequestHeader("Content-Type",
		// "application/soap+xml;charset=utf-8;action=\"generateLabel\"");

		// File file = new
		// File(Test.class.getResource("request2.xml").getPath());
		//
		// String content = FileUtils.readFileToString(file, "UTF-8");
		//
		// StringRequestEntity requestEntity = new StringRequestEntity(content,
		// "text/xml", "UTF-8");
		//
		// method.setRequestEntity(requestEntity);

		int code = client.executeMethod(method);

		System.out.println(code);

		System.out.println(method.getResponseBodyAsString());

	}

}
