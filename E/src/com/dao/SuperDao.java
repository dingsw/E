package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tools.*;


public class SuperDao {
	private PageBar daoPage=new PageBar();
	private int daoPerR=daoPage.getPerR();    //ÿҳ��ʾ��¼����PageBar��Ĭ��1
	private int daoPerP=daoPage.getPerP();	   //ÿҳ��ʾҳ������PageBar��Ĭ��1
	
	
	
	/**
	 * @���� ����PageBar�Ķ���daoPage
	 * @param sql
	 * @param params
	 * @param strcurrentP
	 * @param strcurrentG
	 * @param goWhich
	 * @throws SQLException
	 */
	public void setDaoPage(String sql,Object[] params,String currentPage,String currentGroup,String url) throws SQLException{
		System.out.println("SuperDao  setDaoPage()"+url);
		daoPage.setAllR(getAllR(sql,params));     //����PageBar������ܼ�¼��������ѯ���ݿ���Ʒ����
		daoPage.setPerR(daoPerR);                 //����PageBar�����ÿҳ��ʾ����Ĭ��
		daoPage.setPerP(daoPerP);                 //����PageBar�����ÿҳ��ʾҳ������Ĭ�� 
		daoPage.setPageBar(currentPage, currentGroup, url);  //���õ�ǰҳ����ǰ�飬���ɷ�ҳ������
	}	
	public void setDaoPerR(int daoPerR){
		this.daoPerR=daoPerR;
	}
	public void setDaoPerP(int daoPerP){
		this.daoPerP=daoPerP;
	}
	//��ѯ��Ʒ���������ܼ�¼��
	private int getAllR(String sql,Object[] params) throws SQLException{
		int allR=0;
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		if(rs!=null&&rs.next()){
			rs.last();
			allR=rs.getRow();
			rs.close();			
		}
		mydb.closed();
		return allR;		
	}
	public PageBar getPageBar() {
		return daoPage;
	}
	public int getDaoPerR() {
		return daoPerR;
	}
	public int getDaoPerP() {
		return daoPerP;
	}
}
