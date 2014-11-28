package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tools.*;


public class SuperDao {
	private PageBar daoPage=new PageBar();
	private int daoPerR=daoPage.getPerR();    //每页显示记录数，PageBar中默认1
	private int daoPerP=daoPage.getPerP();	   //每页显示页码数，PageBar中默认1
	
	
	
	/**
	 * @功能 设置PageBar的对象daoPage
	 * @param sql
	 * @param params
	 * @param strcurrentP
	 * @param strcurrentG
	 * @param goWhich
	 * @throws SQLException
	 */
	public void setDaoPage(String sql,Object[] params,String currentPage,String currentGroup,String url) throws SQLException{
		System.out.println("SuperDao  setDaoPage()"+url);
		daoPage.setAllR(getAllR(sql,params));     //设置PageBar对象的总记录数，即查询数据库商品总数
		daoPage.setPerR(daoPerR);                 //设置PageBar对象的每页显示数，默认
		daoPage.setPerP(daoPerP);                 //设置PageBar对象的每页显示页码数，默认 
		daoPage.setPageBar(currentPage, currentGroup, url);  //设置当前页，当前组，生成分页导航栏
	}	
	public void setDaoPerR(int daoPerR){
		this.daoPerR=daoPerR;
	}
	public void setDaoPerP(int daoPerP){
		this.daoPerP=daoPerP;
	}
	//查询商品总数，及总记录数
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
