
package com.mll.utils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MyHttpUtil {
	
	private static CloseableHttpClient httpClient =HttpClients.createDefault();
	private static String encode = "UTF-8";
	public static String httpPostRequest(String url, String json)
			throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(json, "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		return getResult(httpPost);
	}
	
	
	
	/**
	 * 存在header的请求
	 * 
	 * @param url
	 *            访问的url
	 * @param headers
	 *            头信息
	 * @param params
	 *            参数信息
	 * @return
	 * @throws URISyntaxException
	 */
	public static String httpGetRequest(String url, Map<String, Object> headers)
			throws URISyntaxException {
		HttpGet httpGet = new HttpGet(url);
		for (Map.Entry<String, Object> param : headers.entrySet()) {
			httpGet.addHeader(param.getKey(), param.getValue() + "");
		}
		return getResult(httpGet);
	}

	
	
	public static String httpPostRequest(String url, Map<String, Object> params)
			throws UnsupportedOperationException, IOException {
		HttpPost httpPost = new HttpPost(url);
		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		
		httpPost.setEntity(new UrlEncodedFormEntity(pairs, encode));
		System.out.println(EntityUtils.toString(httpPost.getEntity()));
		return getResult(httpPost);
	}
	
	//online
	public static CloseableHttpClient getHttpsClient() throws NoSuchAlgorithmException, KeyManagementException
	{
		
		 TrustManager[] trustAllCerts = new TrustManager[] {
			        new X509TrustManager() {
			         
						@Override
						public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
								throws CertificateException {
							// TODO Auto-generated method stub
					
							
						}
						@Override
						public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
								throws CertificateException {
							// TODO Auto-generated method stub
							
						}
						@Override
						public java.security.cert.X509Certificate[] getAcceptedIssuers() {
							// TODO Auto-generated method stub
							return null;
						}
			        }
			    };
			    
			    SSLContext ctx = SSLContext.getInstance("TLS");
			    ctx.init(null, trustAllCerts, null);
			    
			    LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(ctx);
			    
			    CloseableHttpClient httpclient = HttpClients.custom()
			            .setSSLSocketFactory(sslSocketFactory)
			            .build();
			    
		return httpclient;
	}
	

	
	private static ArrayList<NameValuePair> covertParams2NVPS(
			Map<String, Object> params) {
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			pairs.add(new BasicNameValuePair(param.getKey(), param.getValue()
					+ ""));
		}
		return pairs;
	}
	
	public static String httpGetRequest(String url) {
		HttpGet httpGet = new HttpGet(url);
		return getResult(httpGet);
	}
	
	private static String getResult(HttpRequestBase request) {
		
		URI uri = request.getURI();
		String strUrl = uri.toString();
		HttpResponse	response;
		String result="";
		List<String> li=new ArrayList<String>();
		try {
			
			if(strUrl.startsWith("http"))
			{
			
			response= httpClient.execute(request);
			
			}
			else
			{
				
				response=getHttpsClient().execute(request);
				
			}
			int status = response.getStatusLine().getStatusCode();
			if (status == 200) {

				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity, "utf-8");
				return result;
			} else {
				
				return null;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {
		
		}
		return result;
	}
	

}
