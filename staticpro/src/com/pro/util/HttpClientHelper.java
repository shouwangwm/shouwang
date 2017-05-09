package com.pro.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;

/***
 * 
* @ClassName: HttpClientHelper 
* @Description: TODO(静态化引擎类) 
* @author yangning 
* @date Jan 14, 2013 1:33:55 PM 
*
 */
public class HttpClientHelper {


	public static final String TIMEOUT = "timeout";
	private static final String DEFAULT_USER_AGENT = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"; // 伪装为一个IE浏览器
	private String charset = "ISO-8859-1"; // 默认字符集
	private int connectionTimeout = 15000; // 默认15秒连接超时
	private int soTimetout = 60000; // 默认60秒读取数据超时
    public HttpClientHelper() {
	}
   public HttpClientHelper(String charset) {
		this.charset = charset;
	}

	public HttpClientHelper(String charset, int connectionTimeout,
			int soTimetout) {
		this.charset = charset;
		this.connectionTimeout = connectionTimeout;
		this.soTimetout = soTimetout;
	}

	public String executePost(String uri, List<NameValuePair> list) {
		String result = null;
		// 创建一个HttpClient
		HttpParams httpParams = new BasicHttpParams();
		httpParams.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET,charset);
		httpParams.setParameter(CoreProtocolPNames.USER_AGENT,DEFAULT_USER_AGENT);
		httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,connectionTimeout);
		httpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, soTimetout);
		httpParams.setParameter(ClientPNames.COOKIE_POLICY,CookiePolicy.BROWSER_COMPATIBILITY);
		HttpClient httpClient = new DefaultHttpClient(httpParams);
		HttpPost httpPost = new HttpPost(uri);
		
		// 设置参数到post请求
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(list, charset));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}

		// 请求URL并得到结果
		try {
			HttpEntity entity = httpClient.execute(httpPost).getEntity();//执行Action
			if (entity != null) {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(entity.getContent(), charset));
				StringBuilder builder = new StringBuilder();
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					if (StringUtils.isNotBlank(line)) {
						builder.append(line);
						builder.append("\r\n");
					}
				}
				IOUtils.closeQuietly(bufferedReader);
				result = StringUtils.trimToEmpty(builder.toString());
				entity.consumeContent();
			}
		} catch (Exception e) {
			e.printStackTrace();

			result = TIMEOUT;
		} finally {
			httpClient.getConnectionManager().shutdown(); // 关闭HttpClient连接，释放资源
		}

		return result;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		System.out.println(new HttpClientHelper("utf-8").executePost("http://localhost:8080/staticpro/admin.action", new ArrayList<NameValuePair>()));
	}
	
	
	
	//获取生成静态化文件的地址路径
		public String getResourceUrl() {
			
			String path = System.getProperty("user.dir");
			path = path.substring(0, path.indexOf("bin"));
			System.out.println("获取项目部署的根路径" + path);
			return path;
		}
		//获取static_html.properties  静态化访问路径
		public static String getProjerctPath() {
	          ResourceBundle bundle=PropertyResourceBundle.getBundle("create_html");
				String path=bundle.getString("path");
			return path;
		}

}
