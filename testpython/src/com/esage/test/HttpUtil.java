package com.esage.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

//commons-httpclient-3.0.jar ����

/**
 * 
 * Http������
 * 
 * 
 * Http�����࣬Ϊϵͳ�ṩͨ��Http���ʲ���������
 * 
 * 
 * 1������GET����
 * 
 * 2������POST����
 * 
 */
public class HttpUtil {

	/**
	 * 
	 * ����GET����
	 * 
	 * @param url
	 *            GET�����ַ
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 */
	public static byte[] doGet(String url) {

		return HttpUtil.doGet(url, null, null, 0);
	}

	/**
	 * 
	 * ����GET����
	 * 
	 * @param url
	 *            GET�����ַ
	 * @param headerMap
	 *            GET����ͷ��������
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 */
	public static byte[] doGet(String url, Map headerMap) {

		return HttpUtil.doGet(url, headerMap, null, 0);
	}

	/**
	 * 
	 * ����GET����
	 * 
	 * @param url
	 *            GET�����ַ
	 * @param proxyUrl
	 *            �����������ַ
	 * @param proxyPort
	 *            ����������˿ں�
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 * @modify 񼺣��, 2012-03-19
	 */
	public static byte[] doGet(String url, String proxyUrl, int proxyPort) {

		return HttpUtil.doGet(url, null, proxyUrl, proxyPort);
	}

	/**
	 * 
	 * ����GET����
	 * 
	 * @param url
	 *            GET�����ַ
	 * @param headerMap
	 *            GET����ͷ��������
	 * @param proxyUrl
	 *            �����������ַ
	 * @param proxyPort
	 *            ����������˿ں�
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 * @modify 񼺣��, 2012-03-19
	 */
	public static byte[] doGet(String url, Map headerMap, String proxyUrl, int proxyPort) {

		byte[] content = null;
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);

		if (headerMap != null) {

			// ͷ��������Ϣ
			if (headerMap != null) {

				Iterator iterator = headerMap.entrySet().iterator();
				while (iterator.hasNext()) {

					Entry entry = (Entry) iterator.next();
					getMethod.addRequestHeader(entry.getKey().toString(), entry.getValue().toString());
				}
			}
		}

		if (StringUtils.isNotBlank(proxyUrl)) {

			httpClient.getHostConfiguration().setProxy(proxyUrl, proxyPort);
		}

		// ���ó���Ĭ�ϵĻָ����ԣ��ڷ����쳣ʱ���Զ�����3�Σ���������Ҳ�������ó��Զ���Ļָ�����
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
		// postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER ,
		// new DefaultHttpMethodRetryHandler());
		InputStream inputStream = null;
		try {

			if (httpClient.executeMethod(getMethod) == HttpStatus.SC_OK) {

				// ��ȡ����
				inputStream = getMethod.getResponseBodyAsStream();
				content = IOUtils.toByteArray(inputStream);
			} else {

				System.err.println("Method failed: " + getMethod.getStatusLine());
			}
		} catch (IOException ex) {

			ex.printStackTrace();
		} finally {

			IOUtils.closeQuietly(inputStream);
			getMethod.releaseConnection();
		}
		return content;
	}

	/**
	 * 
	 * ����POST����
	 * 
	 * @param url
	 *            POST�����ַ
	 * @param parameterMap
	 *            POST�����������
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 */
	public static byte[] doPost(String url, Map parameterMap) {

		return HttpUtil.doPost(url, null, parameterMap, null, null, 0);
	}

	/**
	 * 
	 * ����POST����
	 * 
	 * @param url
	 *            POST�����ַ
	 * @param parameterMap
	 *            POST�����������
	 * @param paramCharset
	 *            �����ַ�������
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 * @modify 񼺣��, 2012-05-21
	 */
	public static byte[] doPost(String url, Map parameterMap, String paramCharset) {

		return HttpUtil.doPost(url, null, parameterMap, paramCharset, null, 0);
	}

	/**
	 * 
	 * ����POST����
	 * 
	 * @param url
	 *            POST�����ַ
	 * @param headerMap
	 *            POST����ͷ��������
	 * @param parameterMap
	 *            POST�����������
	 * @param paramCharset
	 *            �����ַ�������
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 * @modify 񼺣��, 2012-05-21
	 */
	public static byte[] doPost(String url, Map headerMap, Map parameterMap, String paramCharset) {

		return HttpUtil.doPost(url, headerMap, parameterMap, paramCharset, null, 0);
	}

	/**
	 * 
	 * ����POST����
	 * 
	 * @param url
	 *            POST�����ַ
	 * @param parameterMap
	 *            POST�����������
	 * @param paramCharset
	 *            �����ַ�������
	 * @param proxyUrl
	 *            �����������ַ
	 * @param proxyPort
	 *            ����������˿ں�
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 */
	public static byte[] doPost(String url, Map parameterMap, String paramCharset, String proxyUrl, int proxyPort) {

		return HttpUtil.doPost(url, null, parameterMap, paramCharset, proxyUrl, proxyPort);
	}

	/**
	 * 
	 * ����POST����
	 * 
	 * @param url
	 *            POST�����ַ
	 * @param headerMap
	 *            POST����ͷ��������
	 * @param parameterMap
	 *            POST�����������
	 * @param paramCharset
	 *            �����ַ�������
	 * @param proxyUrl
	 *            �����������ַ
	 * @param proxyPort
	 *            ����������˿ں�
	 * 
	 * @return �뵱ǰ�����Ӧ����Ӧ�����ֽ�����
	 * 
	 * @modify 񼺣��, 2012-05-21
	 */
	public static byte[] doPost(String url, Map headerMap, Map parameterMap, String paramCharset, String proxyUrl,
			int proxyPort) {

		byte[] content = null;
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(url);

		if (StringUtils.isNotBlank(paramCharset)) {

			postMethod.getParams().setContentCharset(paramCharset);
			postMethod.getParams().setHttpElementCharset(paramCharset);
		}

		if (headerMap != null) {

			// ͷ��������Ϣ
			if (headerMap != null) {

				Iterator iterator = headerMap.entrySet().iterator();
				while (iterator.hasNext()) {

					Entry entry = (Entry) iterator.next();
					postMethod.addRequestHeader(entry.getKey().toString(), entry.getValue().toString());
				}
			}
		}

		Iterator iterator = parameterMap.keySet().iterator();
		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			postMethod.addParameter(key, (String) parameterMap.get(key));
		}

		if (StringUtils.isNotBlank(proxyUrl)) {

			httpClient.getHostConfiguration().setProxy(proxyUrl, proxyPort);
		}

		// ���ó���Ĭ�ϵĻָ����ԣ��ڷ����쳣ʱ���Զ�����3�Σ���������Ҳ�������ó��Զ���Ļָ�����
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
		// postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER ,
		// new DefaultHttpMethodRetryHandler());
		InputStream inputStream = null;
		try {

			if (httpClient.executeMethod(postMethod) == HttpStatus.SC_OK) {

				// ��ȡ����
				inputStream = postMethod.getResponseBodyAsStream();
				content = IOUtils.toByteArray(inputStream);
			} else {

				System.err.println("Method failed: " + postMethod.getStatusLine());
			}
		} catch (IOException ex) {

			ex.printStackTrace();
		} finally {

			IOUtils.closeQuietly(inputStream);
			postMethod.releaseConnection();
		}
		return content;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("wd", "nima");
		byte[] b = doGet("http://www.baidu.com", map);
		System.out.println("-------------------" + new String(b, "utf-8"));
	}

}