package com.latin.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.lang.StringUtils;

/**
 * 日期工具类
 * @ClassName DateUtils
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:48:23 PM
 */
public class DateUtils {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private static String ymdhms = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyy-MM-dd
	 */
	private static String ymd = "yyyy-MM-dd";

	/**
	 * SimpleDateFormat yyyy-MM-dd
	 */
	public static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);

	/**
	 * yyyy
	 */
	private static String year = "yyyy";

	/**
	 * MM
	 */
	private static String month = "MM";

	/**
	 * dd
	 */
	private static String day = "dd";

	/**
	 * yyyyMMddHHmmss
	 */
	public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(ymdhms);

	/**
	 * SimpleDateFormat yyyy
	 */
	public static SimpleDateFormat yearSDF = new SimpleDateFormat(year);

	/**
	 * SimpleDateFormat MM
	 */
	public static SimpleDateFormat monthSDF = new SimpleDateFormat(month);

	/**
	 * SimpleDateFormat dd
	 */
	public static SimpleDateFormat daySDF = new SimpleDateFormat(day);

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	/**
	 * SimpleDateFormat yyyy-MM-dd
	 */
	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * SimpleDateFormat yyyyMMdd
	 */
	public static SimpleDateFormat yyyyMMddHH_NOT_ = new SimpleDateFormat(
			"yyyyMMdd");

	/**
	 * 一天的时间86400L
	 */
	public static long DATEMM = 86400L;

	/**
	 * 获得当前时间 格式：2016-01-10 17:28:15
	 * @Title DateUtils
	 * @param @return 当前的日期
	 * @return String
	 * @Description TODO
	 */
	public static String getCurrentTime() {
		return yyyyMMddHHmmss.format(new Date());
	}

	/**
	 * 获取昨天的日期 格式：2016-01-09
	 * @Title DateUtils
	 * @param 
	 * @return String 昨天的日期
	 * @Description TODO
	 */
	public static String getYesterdayYYYYMMDD() {
		Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
		String str = yyyyMMdd.format(date);
		try {
			date = yyyyMMddHHmmss.parse(str + " 00:00:00");
			return yyyyMMdd.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取前几天的时间
	 * @Title DateUtils getBackDate
	 * @param backDay 前N天
	 * @return String 日期
	 * @Description TODO
	 */
	public static String getBackDate(int backDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, Integer.parseInt("-" + backDay));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String back = sdf.format(calendar.getTime());
		return back;
	}

	/**
	 * 获取当前的年
	 * @Title DateUtils getCurrentYear
	 * @return String 返回日期
	 * @Description TODO
	 */
	public static String getCurrentYear() {
		return yearSDF.format(new Date());
	}

	/**
	 * 得到当前的月份
	 * @Title DateUtils getCurrentMonth
	 * @return String
	 * @Description TODO
	 */
	public static String getCurrentMonth() {
		return monthSDF.format(new Date());
	}

	/**
	 * 得到当前的日期
	 * @Title DateUtils getCurrentDay
	 * @return String
	 * @Description TODO
	 */
	public static String getCurrentDay() {
		return daySDF.format(new Date());
	}

	/**
	 * 获取年月日 也就是当前时间 格式：2014-12-02
	 * @Title DateUtils getCurrentymd
	 * @return String
	 * @Description TODO
	 */
	public static String getCurrentymd() {
		return ymdSDF.format(new Date());
	}

	/**
	 * 获取今天0点开始的秒数
	 * @Title DateUtils getTimeNumberToday
	 * @return long
	 * @Description TODO
	 */
	public static long getTimeNumberToday() {
		Date date = new Date();
		String str = yyyyMMdd.format(date);
		try {
			date = yyyyMMdd.parse(str);
			return date.getTime() / 1000L;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	/**
	 * 获取今天的日期 格式：20141202
	 * @Title DateUtils getTodateString
	 * @return String
	 * @Description TODO
	 */
	public static String getTodateString() {
		String str = yyyyMMddHH_NOT_.format(new Date());
		return str;
	}

	/**
	 * 获取昨天的日期 格式：20141201
	 * @Title DateUtils getYesterdayString
	 * @return String
	 * @Description TODO
	 */
	public static String getYesterdayString() {
		Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
		String str = yyyyMMddHH_NOT_.format(date);
		return str;
	}

	/**
	 * 获得昨天零点
	 * @Title DateUtils getYesterDayZeroHour
	 * @return Date
	 * @Description TODO
	 */
	public static Date getYesterDayZeroHour() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		return cal.getTime();
	}

	/**
	 * Long类型日期转成String
	 * @Title DateUtils longToString 
	 * @param date Long类型的日期
	 * @param format 格式
	 * @return String 字符串日期
	 * @Description TODO
	 */
	public static String longToString(long date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt2 = new Date(date * 1000L);
		String sDateTime = sdf.format(dt2); // 得到精确到秒的表示：08/31/2006 21:08:00
		return sDateTime;
	}

	/**
	 * 获得今天零点
	 * @Title DateUtils getTodayZeroHour
	 * @return Date 日期
	 * @Description TODO
	 */
	public static Date getTodayZeroHour() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		return cal.getTime();
	}

	/**
	 * 获得昨天23时59分59秒
	 * @Title DateUtils getYesterDay24Hour
	 * @return Date
	 * @Description TODO
	 */
	public static Date getYesterDay24Hour() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.HOUR, 23);
		return cal.getTime();
	}

	/**
	 * 字符串日期按照格式转成日期
	 * @Title DateUtils stringToDate
	 * @param date 待转换的日期
	 * @param format 转换格式
	 * @return Date 转换后的Date
	 * @Description TODO
	 */
	public static Date stringToDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获得指定日期所在的自然周的第一天，即周日
	 * @Title DateUtils getStartDayOfWeek
	 * @param date
	 * @return Date
	 * @Description TODO
	 */
	public static Date getStartDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期所在的自然周的最后一天，即周六
	 * @Title DateUtils getLastDayOfWeek
	 * @param date
	 * @return Date
	 * @Description TODO
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 7);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期所在当月第一天
	 * @Title DateUtils getStartDayOfMonth
	 * @param date
	 * @return Date
	 * @Description TODO
	 */
	public static Date getStartDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期所在当月最后一天
	 * @Title DateUtils getLastDayOfMonth
	 * @param date
	 * @return Date
	 * @Description TODO
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期的下一个月的第一天
	 * @Title DateUtils getStartDayOfNextMonth
	 * @param date
	 * @return Date
	 * @Description TODO
	 */
	public static Date getStartDayOfNextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期的下一个月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfNextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 2);
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		return date;
	}

	/**
	 * 
	 * 求某一个时间向前多少秒的时间(currentTimeToBefer)---OK
	 * 
	 * @param givedTime
	 *            给定的时间
	 * @param interval
	 *            间隔时间的毫秒数；计算方式 ：n(天)*24(小时)*60(分钟)*60(秒)(类型)
	 * @param format_Date_Sign
	 *            输出日期的格式；如yyyy-MM-dd、yyyyMMdd等；
	 */
	public static String givedTimeToBefer(String givedTime, long interval,
			String format_Date_Sign) {
		String tomorrow = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format_Date_Sign);
			Date gDate = sdf.parse(givedTime);
			long current = gDate.getTime(); // 将Calendar表示的时间转换成毫秒
			long beforeOrAfter = current - interval * 1000L; // 将Calendar表示的时间转换成毫秒
			Date date = new Date(beforeOrAfter); // 用timeTwo作参数构造date2
			tomorrow = new SimpleDateFormat(format_Date_Sign).format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tomorrow;
	}

	/**
	 * 把String 日期转换成long型日期；---OK
	 * 
	 * @param date
	 *            String 型日期；
	 * @param format
	 *            日期格式；
	 * @return
	 */
	public static long stringToLong(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dt2 = null;
		long lTime = 0;
		try {
			dt2 = sdf.parse(date);
			// 继续转换得到秒数的long型
			lTime = dt2.getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return lTime;
	}

	/**
	 * 得到二个日期间的间隔日期；
	 * 
	 * @param endTime
	 *            结束时间
	 * @param beginTime
	 *            开始时间
	 * @param isEndTime
	 *            是否包含结束日期；
	 * @return
	 */
	public static Map<String, String> getTwoDay(String endTime,
			String beginTime, boolean isEndTime) {
		Map<String, String> result = new HashMap<String, String>();
		if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
				.equals(""))))
			return null;
		try {
			java.util.Date date = ymdSDF.parse(endTime);
			endTime = ymdSDF.format(date);
			java.util.Date mydate = ymdSDF.parse(beginTime);
			long day = (date.getTime() - mydate.getTime())
					/ (24 * 60 * 60 * 1000);
			result = getDate(endTime, Integer.parseInt(day + ""), isEndTime);
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 得到二个日期间的间隔日期；
	 * 
	 * @param endTime
	 *            结束时间
	 * @param beginTime
	 *            开始时间
	 * @param isEndTime
	 *            是否包含结束日期；
	 * @return
	 */
	public static Integer getTwoDayInterval(String endTime, String beginTime,
			boolean isEndTime) {
		if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
				.equals(""))))
			return 0;
		long day = 0l;
		try {
			java.util.Date date = ymdSDF.parse(endTime);
			endTime = ymdSDF.format(date);
			java.util.Date mydate = ymdSDF.parse(beginTime);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return 0;
		}
		return Integer.parseInt(day + "");
	}

	/**
	 * 根据结束时间以及间隔差值，求符合要求的日期集合；
	 * 
	 * @param endTime
	 * @param interval	
	 * @param isEndTime 是否结束时间
	 * @return
	 */
	public static Map<String, String> getDate(String endTime, Integer interval,
			boolean isEndTime) {
		Map<String, String> result = new HashMap<String, String>();
		if (interval == 0 || isEndTime) {
			if (isEndTime)
				result.put(endTime, endTime);
		}
		if (interval > 0) {
			int begin = 0;
			for (int i = begin; i < interval; i++) {
				endTime = givedTimeToBefer(endTime, DATEMM, ymd);
				result.put(endTime, endTime);
			}
		}
		return result;
	}
	
	 /** 
     * 判断字符串是否为日期字符串 
     * @param date 日期字符串 
     * @return true or false 
     */  
    public static boolean isDate(String date) {  
        boolean isDate = false;  
        if (!StringUtils.isEmpty(date)) {  
            if (stringToDate(date, ymdhms) != null) {  
                isDate = true;  
            }  
        }  
        return isDate;  
    }  

	public static void main(String[] args) {
		System.out.println(DateUtils.getBackDate(2));

	}
}
