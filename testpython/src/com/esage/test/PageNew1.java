package com.esage.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

/*
 * https://www.cnblogs.com/sunny08/p/8038440.html
 */
public class PageNew1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("javax.net.debug", "all");
		String url = "https://www.timeanddate.com/weather/";
		CloseableHttpClient httpclient;
		try {
			// SSLContext ctx = SSLContexts.createSystemDefault();
			// SSLConnectionSocketFactory fac =
			// new SSLConnectionSocketFactory(ctx, new String[] {"TLSv1.2"},
			// null,
			// SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			// httpclient =
			// HttpClientBuilder.create().setSSLSocketFactory(fac).build();
			SSLContext ctx = SSLContexts.custom().useProtocol("TLSv1.2").build();
			httpclient = HttpClientBuilder.create().setSslcontext(ctx).build();

			HttpPost httpPost = new HttpPost(url);
			CloseableHttpResponse resp = httpclient.execute(httpPost);
			HttpEntity entity = resp.getEntity();
			String reStr = EntityUtils.toString(entity);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date now = new Date();
			String nowStr = sdf.format(now);
			System.out.println("======>WeatherCrawler getCurrentWeather time=" + nowStr + ", body=" + reStr);
		} catch (Exception e) {
			System.out.println("======>WeatherCrawler getCurrentWeather error" + e);
		}
	}

}
