package com.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//字符串处理类
public class StringHandler {
	public static String delBlank(String str){
		if(str!=null)
			return str.replace(" ","");
		return null;
	}
	public static Integer strToint(String str){
		if(str!=null&&!str.equals("")){
			try{
				return Integer.parseInt(str);
			}catch(NumberFormatException e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	public static String timeTostr(Date date){
		String strDate="";
		if(date!=null){
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			strDate=format.format(date);		
		}
		return strDate;
	}
	//将时间格式化
	public static String getSerial(Date date){
		SimpleDateFormat fm=new SimpleDateFormat("MMddyyyyHHmmssSS");
		String serials=fm.format(date);
		return serials;
	}
	//将String[]转换成int[]
	public static int[] changeToIntArray(String[] strs){
		int[] nums=null;
		if(strs!=null){
			nums=new int[strs.length];
			for(int i=0;i<strs.length;i++)
				nums[i]=Integer.parseInt(strs[i]);
		}
		return nums;
	}
	public static String cookieEnCode(String str){
		String change="";
		if(str!=null){
			try {
				change=URLEncoder.encode(str,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return change;
	}
	public static String cookieDecCode(String str){
		String change="";
		if(str!=null){
			try {
				change=URLDecoder.decode(str,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return change;
	}
	//将String分割成数组，转换成List
	public static List StringToList(String str){
		String[] arraystrs=null;
		List liststrs=null;
		       
		if(str!=null&&!str.equals("")){
			liststrs=new ArrayList();
			arraystrs=str.split("\r\n");
			for(int i=0;i<arraystrs.length;i++){
				if(arraystrs[i]!=null&&!arraystrs[i].equals(""))
					liststrs.add(arraystrs[i]);
			}
		}
		return liststrs;
	}
	//String[]转换成String，以“，”分割
	public static String ArrayToString(String[] array){
		String str="";
		if(array!=null&&array.length!=0){
			for(int i=0;i<array.length;i++)
				str+=array[i]+",";
		}
		str=str.substring(0,str.lastIndexOf(","));
		return str;
	}
	public static String getSerial(Date date,int index){
		long msel=date.getTime();		//获取毫秒数
		SimpleDateFormat fm=new SimpleDateFormat("MMddyyyyHHmmssSS");		//创建转换对象
		msel+=index;					//通过一个值改变毫秒数	
		date.setTime(msel);				//通过改变后的毫秒数重新设置日期
		String serials=fm.format(date);	//转换日期时间型数据为“MMddyyyyHHmmssSS”格式
		return serials;
	}	

}
