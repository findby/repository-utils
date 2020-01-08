package com.develop.part.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

/***
 * @author wenxiang.fei
 * @Description 时间格式转换工具类
 * @time 2019-11-27 16:48:40
 */
public class DateUtils {
	public static void main(String[] args) {
//		boolean exist = FileUtil.exist("D:/sys/db_20191130.sql");
//		boolean exist2 = FileUtil.exist("D:/sys/dbresource_utf-8.sql");
//		System.out.println(exist+"---"+exist2);
		BufferedInputStream inputStream = FileUtil.getInputStream("D:/sys/db_20191130.sql");
		BufferedOutputStream outputStream = FileUtil.getOutputStream("D:/sys/dbresource_utf-8.sql");
		byte[] bys=new byte[102400];
		int co=0;
		try {
			while((co=inputStream.read(bys,0,bys.length))>-1) {
				outputStream.write(bys, 0, co);
			}
			inputStream.read(bys);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//FileUtil.copy("D:/sys/db_20191130.sql", "D:/sys/dbresource_utf-8.sql", false);
	}
	private static String DEFAULT_DATE_FORMART = "yyyy-MM-dd";
	private static String SIMPLE_DATE_FORMART = "yyyy-MM-dd HH:mm:ss";
	//private String DEFAULT_FORMART = "";

	/***
	 * @Description Date时间转String
	 * @param date 待转换的时间
	 * @return
	 */
	public static String defaultDateToStr(Date date) {
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMART);
		if (null == date) {
			return null;
		}
		return defaultDateFormat.format(date);
	}

	/***
	 * @Description Date时间转String
	 * @param date 待转换的时间
	 * @return
	 */
	public static String simpleDateToStr(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMART);
		if (null == date) {
			return null;
		}
		return simpleDateFormat.format(date);
	}

	/***
	 * @Description String转Date
	 * @param dateStr 待转换的时间字符串
	 * @param feature (给数值1/2)1:转换成yyyy-MM-dd格式
	 * 				  2:转换成yyyy-MM-dd HH:mm:ss格式
	 * @return
	 */
	public static Date strToDate(String dateStr, Integer feature) {
		Date date = null;
		switch (feature) {
		case 1:// 默认时间格式 yyyy-MM-dd
			SimpleDateFormat defaultDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMART);
			try {
				date = defaultDateFormat.parse(dateStr);
			} catch (ParseException e) {
				throw new RuntimeException(dateStr + ":时间格式错误");
			}
			break;
		case 2:// yyyy-MM-dd HH:mm:ss
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMART);
			try {
				int length = dateStr.length();
				
				if(length==9) {
					StringBuffer stringBuffer = new StringBuffer(dateStr);
					stringBuffer.append(" 00:00:00");
					dateStr=stringBuffer.toString();
				}
				if(length==12) {
					StringBuffer stringBuffer = new StringBuffer(dateStr);
					stringBuffer.append(":00:00");
					dateStr=stringBuffer.toString();
				}
				if(length==15) {
					StringBuffer stringBuffer = new StringBuffer(dateStr);
					stringBuffer.append(":00");
					dateStr=stringBuffer.toString();
				}
				date = simpleDateFormat.parse(dateStr);
			} catch (ParseException e) {
				throw new RuntimeException(dateStr + ":时间格式错误");
			}
			break;
		default:
			break;
		}
		return date;
	}
}
