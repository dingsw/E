package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserBean;
import com.tools.ConnDB;

public class UserDao {
	private ConnDB con = null;
	private String sql = null;
	
	//将userBean添加到数据库
	public boolean addUser(UserBean userBean){
		boolean flag = false;
		con = new ConnDB();
		sql = "insert into tb_user (account,password,sex,email,telephone,address,question,answer) values ('" + userBean.getAccount()
				+ "','"+ userBean.getPassword()
				+ "','"+ userBean.getSex()
				+ "','" + userBean.getEmail() 
				+ "','"+ userBean.getTelephone()
				+ "','"+ userBean.getAddress()
				+ "','" + userBean.getQuestion()
				+ "','" + userBean.getAnswer() + "')";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	public UserBean queryUser(String account){
		con = new ConnDB();
		UserBean userBean = null;
		sql = "select * from tb_user where account='"+account+"'";
		try {
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				userBean = new UserBean();
				userBean.setId(rs.getInt(1));
				userBean.setAccount(rs.getString(2));
				userBean.setPassword(rs.getString(3));
				userBean.setSex(rs.getString(4));
				userBean.setEmail(rs.getString(5));
				userBean.setTelephone(rs.getString(6));
				userBean.setAddress(rs.getString(7));
				userBean.setQuestion(rs.getString(8));
				userBean.setAnswer(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
		return userBean;
	}
	
	//修改用户个人信息
	public boolean alterUserBean(UserBean userBean){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_user set account='"+userBean.getAccount()+"',sex='"+userBean.getSex()+"',email='"+userBean.getEmail()+"',telephone='"+userBean.getTelephone()+"',address='"+userBean.getAddress()+"' where id = '"+userBean.getId()+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	//根据id获取UserBean对象
	public UserBean queryUserBean(int id){
		con = new ConnDB();
		UserBean userBean = null;
		sql = "select * from tb_user where id='"+id+"'";
		try {
			ResultSet rs = con.executeQuery(sql);
			while(rs.next()){
				userBean = new UserBean();
				userBean.setId(rs.getInt(1));
				userBean.setAccount(rs.getString(2));
				userBean.setPassword(rs.getString(3));
				userBean.setSex(rs.getString(4));
				userBean.setEmail(rs.getString(5));
				userBean.setTelephone(rs.getString(6));
				userBean.setAddress(rs.getString(7));
				userBean.setQuestion(rs.getString(8));
				userBean.setAnswer(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
		return userBean;
	}
	//修改用户密码
	public boolean alterPassword(int id,String password){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_user set password='"+password+"' where id = '"+id+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	//修改提示问题
	public boolean alterQuestion(String question,String answer,int id){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_user set question='"+question+"',answer='"+answer+"' where id = '"+id+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
}
