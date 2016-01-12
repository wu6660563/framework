package com.latin.api.app.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import com.latin.common.constant.ExceptionCodeConstant;
import com.latin.common.exception.BaseException;

/**
 * IP工具类
 * @ClassName IPUtils
 * @Description IPUtils
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:31:18 PM
 */
public class IPUtils {

	public static String getRequestIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 检查是否是IPV4的IP地址格式
	 * @Title IPUtils
	 * @param @param ipAddress IP地址
	 * @param @return
	 * @return boolean true/false
	 * @Description TODO
	 * @thorws
	 */
	public static boolean isIpv4(String ipAddress) {
		String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}

	/**
	 * 
	 * @Title IPUtils
	 * @param @param ip
	 * @param @return
	 * @param @throws IOException
	 * @param @throws BaseException
	 * @return String
	 * @Description TODO
	 * @thorws
	 */
	public static String getIpInfo(String ip) throws IOException, BaseException {
		if (!isIpv4(ip)) {
			throw new BaseException("IP Error", ExceptionCodeConstant.IPERROR);
		}
		URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
		HttpURLConnection htpcon = (HttpURLConnection) url.openConnection();
		htpcon.setRequestMethod("GET");
		htpcon.setDoOutput(true);
		htpcon.setDoInput(true);
		htpcon.setUseCaches(false);

		InputStream in = htpcon.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(in));
		StringBuffer temp = new StringBuffer();
		String line = bufferedReader.readLine();
		while (line != null) {
			temp.append(line).append("\r\n");
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		JSONObject obj = JSONObject.fromObject(temp.toString());
		return obj.toString();
	}

	/**
	 * IP转成Long类型
	 * @Title IPUtils
	 * @param @param strIP IP地址的字符串
	 * @param @return
	 * @param @throws BaseException
	 * @return long IP地址的LONG类型
	 * @Description TODO
	 * @thorws
	 */
	public static long ip2Long(String strIP) throws BaseException {
		if (!isIpv4(strIP)) {
			throw new BaseException("IP Error", ExceptionCodeConstant.IPERROR);
		}
		long[] ip = new long[4];

		int position1 = strIP.indexOf(".");
		int position2 = strIP.indexOf(".", position1 + 1);
		int position3 = strIP.indexOf(".", position2 + 1);
		ip[0] = Long.parseLong(strIP.substring(0, position1));
		ip[1] = Long.parseLong(strIP.substring(position1 + 1, position2));
		ip[2] = Long.parseLong(strIP.substring(position2 + 1, position3));
		ip[3] = Long.parseLong(strIP.substring(position3 + 1));
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	/**
	 * Long类型转IP
	 * @Title IPUtils
	 * @param @param longIp LONG类型的IP地址
	 * @param @return
	 * @return String IP的字符串
	 * @Description TODO
	 * @thorws
	 */
	public static String long2Ip(long longIp) {
		int[] b = new int[4];
		b[0] = (int) ((longIp >> 24) & 0xff);
		b[1] = (int) ((longIp >> 16) & 0xff);
		b[2] = (int) ((longIp >> 8) & 0xff);
		b[3] = (int) (longIp & 0xff);
		String x = "";
		x = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "."
				+ Integer.toString(b[2]) + "." + Integer.toString(b[3]);
		return x;
	}

	/**
	 * 是否是本地IP
	 * @Title IPUtils
	 * @param @param ipAddress IP地址的字符串类型
	 * @param @return
	 * @param @throws BaseException
	 * @return boolean true/false
	 * @Description TODO
	 * @thorws
	 */
	public static boolean isLocal(String ipAddress) throws BaseException {
		if (!isIpv4(ipAddress)) {
			throw new BaseException("IP Error", ExceptionCodeConstant.IPERROR);
		}
		if ("127.0.0.1".equals(ipAddress))
			return true;
		long l = ip2Long(ipAddress);
		if (l >= 3232235520L)
			return l <= 3232301055L;
		return (l >= 167772160L) && (l <= 184549375L);
	}

}
