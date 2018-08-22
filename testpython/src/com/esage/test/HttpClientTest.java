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
		// ����HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		// ������Ŀ�������ַ���˿ں�,Э������
		// HttpHost target = new HttpHost("10.10.100.102:8080/mytest", 8080,
		// "http");
		HttpHost target = new HttpHost("http://192.168.1.201:8009/api/admin/enterprises/1/users/1", 8009, "http");

		// �����Ǵ����ַ������˿ںţ�Э������
		HttpHost proxy = new HttpHost("yourproxy", 8080, "http");
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

		// �����ַ
		// HttpPost httpPost = new HttpPost("http://10.10.100.102:8080/mytest");
		// httpPost.setConfig(config);
		HttpGet httpget = new HttpGet("http://192.168.1.201:8009/api/admin/enterprises/1/users/1");
		// ������������
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		// ������Ϊpid��ֵ��2
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
				// ��ӡ��Ӧ����
				System.out.println("response:" + EntityUtils.toString(httpEntity, "UTF-8"));
			}
			// �ͷ���Դ
			closeableHttpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
