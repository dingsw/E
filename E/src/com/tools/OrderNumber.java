package com.tools;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * JAVA�汾���Զ������й���Ķ�����(����)
 * ���ɵĸ�ʽ��: 200908010001 ǰ�漸λΪ��ǰ������,������λΪϵͳ���������͵ı��
 * ԭ��: 
 *      1.��ȡ��ǰ���ڸ�ʽ��ֵ;
 *      2.��ȡ�ļ�,�ϴα�ŵ�ֵ+1��Ϊ��ǰ�˴α�ŵ�ֵ
 *      (�µ�һ������´�1��ʼ���)
 */
public class OrderNumber {
	public String getOrderNum() {
		// ��ȡ��ǰʱ��
		Date currDate = Calendar.getInstance().getTime();
		// ʵ����SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// ���ظ�ʽ�����ڼ�ʱ����ַ���
		return sdf.format(currDate);
	}
	/*
	public static String getOrderNum(){        
		//long No = 0;        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");        
		String nowdate = sdf.format(new Date());        
		//No = Long.parseLong(nowdate)*1000;//�������һ�충����Ļ�������һ������              
		//return getUserId()+No;    
		return 
		}  
	*/  
}
