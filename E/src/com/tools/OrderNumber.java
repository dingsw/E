package com.tools;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * JAVA版本的自动生成有规则的订单号(或编号)
 * 生成的格式是: 200908010001 前面几位为当前的日期,后面五位为系统自增长类型的编号
 * 原理: 
 *      1.获取当前日期格式化值;
 *      2.读取文件,上次编号的值+1最为当前此次编号的值
 *      (新的一天会重新从1开始编号)
 */
public class OrderNumber {
	public String getOrderNum() {
		// 获取当前时间
		Date currDate = Calendar.getInstance().getTime();
		// 实例化SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// 返回格式化日期及时间的字符串
		return sdf.format(currDate);
	}
	/*
	public static String getOrderNum(){        
		//long No = 0;        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");        
		String nowdate = sdf.format(new Date());        
		//No = Long.parseLong(nowdate)*1000;//这里如果一天订单多的话可以用一万或更大              
		//return getUserId()+No;    
		return 
		}  
	*/  
}
