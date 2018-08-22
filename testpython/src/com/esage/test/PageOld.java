package com.esage.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class PageOld {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 System.setProperty("javax.net.debug", "all");
		 String url ="https://192.168.1.180/api/admin/enterprises/1/users/1" ;
//		String url = "https://www.timeanddate.com/weather/";
		HttpClient client = HttpClients.createDefault();
		HttpRequestBase http = new HttpGet(url);
		HttpContext context = new BasicHttpContext();
		try {
			HttpResponse response = client.execute(http, context);
			int statusCode = response.getStatusLine().getStatusCode();

			switch (statusCode) {
			case 200:
			case 400:// “µŒÒ“Ï≥£
				break;
			default:
				throw new HttpException(url + " Status Code:" + statusCode);
			}

			HttpEntity entity = response.getEntity();
			String reStr = EntityUtils.toString(entity);
			System.out.println(reStr);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
