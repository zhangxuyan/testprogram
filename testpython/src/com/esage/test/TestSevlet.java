package com.esage.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestSevlet {
	/**
	 * ����������������
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		test1();

	}

	private static void test1() {
		Map<String, String> parameters = new HashMap<String, String>();
		// parameters.put("is137", "1");
		// parameters.put("originId", "gh_5fd39f2036a0");
		// parameters.put("openId137", "o294705BFZf-Kui1UcWKWhiL3GDQ");
		// parameters.put("content137", "�澯����");
		// parameters.put("MsgType", "text");

		// http://hrjwua.natappfree.cc/weChat_20171103/wechat.do
		// http://localhost:8080/servlets/HelloWorld

		// String result =
		// sendPost("http://hrjwua.natappfree.cc/weChat_20171103/wechat.do",
		// parameters);
		String result = sendPost("http://192.168.1.201:8009/api/admin/enterprises/1/users/1", parameters);
		// ToUserName=gh_5fd39f2036a0,
		// FromUserName=o294705BFZf-Kui1UcWKWhiL3GDQ,

		System.out.println(result);
	}

	/**
	 * ����GET����
	 * 
	 * @param urlĿ�ĵ�ַ
	 * @param parameters���������Map���͡�
	 * @return Զ����Ӧ���
	 */
	public static String sendGet(String url, Map<String, String> parameters) {
		String result = "";// ���صĽ��
		BufferedReader in = null;// ��ȡ��Ӧ������
		StringBuffer sb = new StringBuffer();// �洢����
		String params = "";// ����֮��Ĳ���
		try {
			// �����������
			if (parameters.size() == 1) {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
				}
				params = sb.toString();
			} else {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
							.append("&");
				}
				String temp_params = sb.toString();
				// params = temp_params.substring(0, temp_params.length() - 1);
			}
			String full_url = url + "?" + params;
			System.out.println(full_url);
			// ����URL����
			java.net.URL connURL = new java.net.URL(full_url);
			// ��URL����
			java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// ����ͨ������
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// ����ʵ�ʵ�����
			httpConn.connect();
			// ��Ӧͷ����ȡ
			Map<String, List<String>> headers = httpConn.getHeaderFields();
			// �������е���Ӧͷ�ֶ�
			for (String key : headers.keySet()) {
				System.out.println(key + "\t��\t" + headers.get(key));
			}
			// ����BufferedReader����������ȡURL����Ӧ,�����ñ��뷽ʽ
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// ��ȡ���ص�����
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * ����POST����
	 * 
	 * @param urlĿ�ĵ�ַ
	 * @param parameters���������Map���͡�
	 * @return Զ����Ӧ���
	 */
	public static String sendPost(String url, Map<String, String> parameters) {
		String result = "";// ���صĽ��
		BufferedReader in = null;// ��ȡ��Ӧ������
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();// �����������
		String params = "";// ����֮��Ĳ���
		try {
			if (parameters.size() == 0) {
			} else {
				// �����������
				if (parameters.size() == 1) {
					for (String name : parameters.keySet()) {
						sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"));
					}
					params = sb.toString();
				} else {
					for (String name : parameters.keySet()) {
						sb.append(name).append("=").append(java.net.URLEncoder.encode(parameters.get(name), "UTF-8"))
								.append("&");
					}
					String temp_params = sb.toString();
					params = temp_params.substring(0, temp_params.length() - 1);
				}
			}
			// ����URL����
			java.net.URL connURL = new java.net.URL(url);
			// ��URL����
			java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL.openConnection();
			// ����ͨ������
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// ����POST��ʽ
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			// ��ȡHttpURLConnection�����Ӧ�������
			out = new PrintWriter(httpConn.getOutputStream());
			// �����������
			out.write(params);
			// flush������Ļ���
			out.flush();
			// ����BufferedReader����������ȡURL����Ӧ�����ñ��뷽ʽ
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// ��ȡ���ص�����
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
