package com.esage.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	public static void main(String args[]) throws Exception {
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		// 依次是目标请求地址，端口号,协议类型
		// HttpHost target = new HttpHost("10.10.100.102:8080/mytest", 8080,
		// "http");
		HttpHost target = new HttpHost("http://192.168.1.201:8009/api/admin/enterprises/1/users/1", 8009, "http");

		// 依次是代理地址，代理端口号，协议类型
		HttpHost proxy = new HttpHost("yourproxy", 8080, "http");
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

		// 请求地址
		// HttpPost httpPost = new HttpPost("http://10.10.100.102:8080/mytest");
		// httpPost.setConfig(config);
		HttpGet httpget = new HttpGet("http://192.168.1.201:8009/api/admin/enterprises/1/users/1");
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		// 参数名为pid，值是2
		formparams.add(new BasicNameValuePair("pid", "2"));

		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(formparams, "UTF-8");
			// httpPost.setEntity(entity);
			// CloseableHttpResponse response =
			// closeableHttpClient.execute(target, httpPost);
			CloseableHttpResponse response = closeableHttpClient.execute(target, httpget);
			// getEntity()
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				// 打印响应内容
				System.out.println("response:" + EntityUtils.toString(httpEntity, "UTF-8"));
			}
			// 释放资源
			closeableHttpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
