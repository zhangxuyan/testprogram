package com.esage.test;

//public class HttpRemoter {

//
//}

import java.io.BufferedReader;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.apache.http.Header;

import org.apache.http.HttpEntity;

import org.apache.http.NameValuePair;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.apache.http.message.BasicNameValuePair;

/**
 * 
 * @author zhangdapeng
 * 
 * @version 1.0,2014��3��12��
 * 
 * @since 1.0
 * 
 */

public class HttpRemoter {

	private CloseableHttpClient httpclient = null;

	private String cookie = null;

	private Log logger = LogFactory.getLog(getClass());

	/**
	  * 
	  */

	public HttpRemoter() {

	}

	public static void main(String[] args) {
		String url = "http://192.168.1.201:8009/api/admin/enterprises/1/users/1";// "https://192.168.1.201/api/admin/enterprises/1/users/1";
		HttpRemoter httpremoter = new HttpRemoter();
		try {
			httpremoter.login(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login(String url) throws Exception {

		// Map<String, String> config = ConfigurResourceContext.configure();
		Map<String, String> config = new HashMap<>();
		config.put("ip", "192.168.1.201");
		config.put("port", "8009");
		config.put("username", "admin");
		config.put("password", "superadmin");
		httpclient = HttpClients.createDefault();

		// HttpPost httpPost = new HttpPost(url);
		HttpGet httpPost = new HttpGet(url);
		httpPost.setHeader("Host", config.get("ip") + ":" + config.get("port"));

		httpPost.setHeader("Connection", "keep-alive");

		// httpPost.setHeader("Content-Length","45");

		// httpPost.setHeader("Cache-Control", "max-age=0");

		httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

		httpPost.setHeader("Origin", "http://" + config.get("ip") + ":" + config.get("port"));

		httpPost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");

		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

		httpPost.setHeader("Accept-Encoding", "gzip,deflate,sdch");

		httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.8");

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		nvps.add(new BasicNameValuePair("encoding", "UTF-8"));

		nvps.add(new BasicNameValuePair("user.id", config.get("username")));

		nvps.add(new BasicNameValuePair("user.password", config.get("password")));

		CloseableHttpResponse response = null;

		try {

//			httpPost.setEntity(new UrlEncodedFormEntity(nvps));

			response = httpclient.execute(httpPost);

		} catch (IOException e) {

			logger.error(e.getMessage());

			throw new Exception("");

		}

		Header h = response.getFirstHeader("Set-Cookie");

		cookie = h.getValue();

		cookie = cookie.substring(0, cookie.indexOf(";"));

	}

	public String obtainContent(String url) throws Exception {

		HttpPost httpPost = new HttpPost(url);

		httpPost.setHeader("Cookie", cookie);

		CloseableHttpResponse response = null;

		StringBuffer entitys = null;

		try {

			response = httpclient.execute(httpPost);

		} catch (IOException e) {

			logger.error(e.getMessage());

			throw new Exception("");

		}

		// ��÷�������Ӧ����Ϣ�壨������http head��

		entitys = new StringBuffer();

		HttpEntity entity = response.getEntity();

		if (entity != null) {

			BufferedReader reader;

			try {

				reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));

				String line = null;

				while ((line = reader.readLine()) != null) {

					entitys.append(line);

				}

			} catch (IllegalStateException | IOException e) {

				logger.error(e.getMessage());

				throw new Exception("");

			}

		}

		return entitys.toString();

	}

	public void saveByHttp(String url, String dirPath, String filePath, boolean append, boolean create) throws Exception

	{

		HttpPost httpPost = new HttpPost(url);

		httpPost.setHeader("Cookie", cookie);

		CloseableHttpResponse response;

		HttpEntity entity = null;

		try {

			response = httpclient.execute(httpPost);

			entity = response.getEntity();

		} catch (IOException e) {

			logger.error(e.getMessage());

			throw new Exception("");

		}

		// ��÷�������Ӧ����Ϣ�壨������http head��

		if (entity != null) {

			try {

				saveToDisk(entity.getContent(), dirPath, filePath, append, create);

			} catch (Exception e) {

				logger.error(e.getMessage());

				throw new Exception("");

			}

		}

	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * ��ͼƬ���浽 Ӳ��ָ��Ŀ¼��
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param in
	 * 
	 * 
	 * 
	 * 
	 * @param dirPath
	 * 
	 * 
	 * 
	 * 
	 * @param filePath
	 * 
	 * 
	 * 
	 * 
	 * @param append
	 * 
	 * 
	 * 
	 * 
	 * @param newFile
	 * 
	 * 
	 * 
	 * 
	 * @throws Exception
	 * 
	 * 
	 * 
	 * 
	 */

	private void saveToDisk(InputStream in, String dirPath, String filePath, boolean append, boolean create)

			throws Exception {

		FileOutputStream fos = null;

		try {

			File dir = new File(dirPath);

			if (dir == null || !dir.exists()) {

				dir.mkdirs();

			}

			// �ļ���ʵ·��

			String realPath = dirPath.concat(filePath);

			File file = new File(realPath);

			if (file == null || !file.exists()) {

				file.createNewFile();

			} else {

				if (!create) {

					return;

				}

			}

			fos = new FileOutputStream(file, append);

			byte[] buf = new byte[1024];

			int len = 0;

			while ((len = in.read(buf)) != -1) {

				fos.write(buf, 0, len);

			}

			fos.flush();

		} finally {

			if (fos != null)

				fos.close();

			if (in != null)

				in.close();

		}

	}

}