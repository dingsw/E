package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.ShopKeeper;
import com.tools.ConnDB;

public class ShopkeeperDao {
	private ConnDB con = null;
	private String sql = null;
	
	//将ShopkeeperBean添加到数据库
	public boolean addShopkeeper(ShopKeeper shopkeeper){
		boolean flag = false;
		con = new ConnDB();
		sql = "insert into tb_shopkeeper (account,password,sex,email,telephone,question,answer) values ('" 
				+ shopkeeper.getAccount()
				+ "','"+ shopkeeper.getPassword()
				+ "','"+ shopkeeper.getSex()
				+ "','" + shopkeeper.getEmail() 
				+ "','"+ shopkeeper.getTelephone()
				+ "','" + shopkeeper.getQuestion()
				+ "','" + shopkeeper.getAnswer() + "')";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	//根据用户名获取ShopKeeper对象
	public ShopKeeper queryShopKeeper(String account){
		con = new ConnDB();
		ShopKeeper userBean = null;
		sql = "select * from tb_shopkeeper where account='"+account+"'";
		try {
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				userBean = new ShopKeeper();
				userBean.setId(rs.getInt(1));
				userBean.setAccount(rs.getString(2));
				userBean.setPassword(rs.getString(3));
				userBean.setSex(rs.getString(4));
				userBean.setEmail(rs.getString(5));
				userBean.setTelephone(rs.getString(6));
				userBean.setQuestion(rs.getString(7));
				userBean.setAnswer(rs.getString(8));
				userBean.setShop_id(rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
		return userBean;
	}
	//根据id获取ShopKeeper对象
	public ShopKeeper queryShopKeeper(int id){
		con = new ConnDB();
		ShopKeeper userBean = null;
		sql = "select * from tb_shopkeeper where id='"+id+"'";
		try {
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				userBean = new ShopKeeper();
				userBean.setId(rs.getInt(1));
				userBean.setAccount(rs.getString(2));
				userBean.setPassword(rs.getString(3));
				userBean.setSex(rs.getString(4));
				userBean.setEmail(rs.getString(5));
				userBean.setTelephone(rs.getString(6));
				userBean.setQuestion(rs.getString(7));
				userBean.setAnswer(rs.getString(8));
				userBean.setShop_id(rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
		return userBean;
	}
	//将店铺ID添加到相应的商家数据表中
	public boolean updateShopKeeper(int shop_id,int shopkeeper_id){
		System.out.println(shop_id+shopkeeper_id);
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_shopkeeper set shop_id = '"+shop_id+"' where id = '"+shopkeeper_id+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	
	//修改商家个人信息
	public boolean alterShopKeeper(ShopKeeper shopKeeper){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_shopkeeper set account='"+shopKeeper.getAccount()+"',sex='"+shopKeeper.getSex()+"',email='"+shopKeeper.getEmail()+"',telephone='"+shopKeeper.getTelephone()+"' where id = '"+shopKeeper.getId()+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	//修改商家密码
	public boolean alterPassword(int id,String password){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_shopkeeper set password='"+password+"' where id = '"+id+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	//修改商家提示问题
	public boolean alterQuestion(String question,String answer,int id){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_shopkeeper set question='"+question+"',answer='"+answer+"' where id = '"+id+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
}
