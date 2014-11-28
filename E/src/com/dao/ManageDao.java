package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tools.ConnDB;
import com.tools.DB;
import com.bean.GoodsBean;
import com.bean.Manage;
import com.bean.ShopBean;
import com.bean.UserBean;
import com.bean.ShopKeeper;

public class ManageDao extends SuperDao{
	private ConnDB connection = null;
	private String sql = "";
	private Boolean flag = false; 
	private UserBean UserInfo = null;
	private ShopKeeper suserInfo = null;
	private ShopBean shopBean = null;
	private Manage   manage   = null;
	DB mydb = null;
	public ManageDao() {
		connection = new ConnDB();
	}
	/**
	 * @从数据库中获取当前页的的商品集合,分页
	 * @return List
	 * @throws SQLException 
	 */
	public List getPartGoods(String currentPage1,String currentGroup,String url) throws SQLException{
		String sql = null;
		String sql2 = "";
		List alllist;
			sql = "select * from tb_user order by id asc";
			setDaoPage(sql,null,currentPage1, currentGroup, url);      //给PageBar对象daoPage赋值
		int currentPage = getPageBar().getCurrentP();    //得到当前页码
		int everyPageCount = getPageBar().getPerR();     //得到每页显示记录数
		int top2 = (currentPage-1)*everyPageCount;           //得到查询范围的开始数
		
			if (currentPage == 1)
				sql2 = "select top " + everyPageCount
						+ " * from tb_user order by id asc";
			else
				sql2 = "select top "
						+ everyPageCount
						+ " * from tb_user where (id > (select max(id) from (select top "
						+ top2
						+ " * from tb_user order by id asc) as minv)) order by id asc";
			alllist = getList(sql2,null);      //将当前页的所有的商品对象（12个）保存在alllist中
		 
		List list = alllist;
		return list;
	}
	
	//查询用户表单
	private List getList(String sql,Object[] params) throws SQLException{
		List list = null;
		mydb = new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			list = new ArrayList();
			while(rs.next()){           //将当前页的所有的商品对象（12个）保存在list中
				UserInfo = new UserBean();
				UserInfo.setId(rs.getInt(1));
				UserInfo.setAccount(rs.getString(2));
				UserInfo.setPassword(rs.getString(3));
				UserInfo.setSex(rs.getString(4));
				UserInfo.setEmail(rs.getString(5));
				UserInfo.setTelephone(rs.getString(6));
				UserInfo.setAddress(rs.getString(7));
				UserInfo.setQuestion(rs.getString(8));
				UserInfo.setAnswer(rs.getString(9));
				list.add(UserInfo);
			}
			rs.close();
		}
		return list;
	}
	//删除
	public boolean manage_userdelete(String id) {
		int i = Integer.valueOf(id).intValue();
		sql = "delete from tb_user where id='"+ i +"'";
		System.out.println(id);
		flag = connection.executeUpdate(sql);
		connection.close();
		return flag;
	}
	public Manage manage_queryObject(String account) {
		manage = new Manage();
		sql = "select * from tb_manage where account = '" + account + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				manage.setId(rs.getInt(1));
				manage.setAccount(rs.getString(2));
				manage.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return manage;
	}
	//店家表单删除
	public boolean manage_shopkeeperdelete(String id) {
		int i = Integer.valueOf(id).intValue();
		sql ="delete  from tb_shopkeeper where id='"+i+"'";
		flag = connection.executeUpdate(sql);
		connection.close();
		return flag;
	}
	//店铺表单删除
	public boolean manage_shopdelete(String id) {
		int i = Integer.valueOf(id).intValue();
		sql ="delete  from tb_shop where id='"+i+"'";
		flag = connection.executeUpdate(sql);
		connection.close();
		return flag;
	}
	public List<ShopKeeper> Manage_shopkeeperqueryObject(){
		List<ShopKeeper> list = new ArrayList<ShopKeeper>();
		sql = "select * from tb_shopkeeper ";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				suserInfo = new ShopKeeper();
				suserInfo.setId(rs.getInt(1));
				suserInfo.setAccount(rs.getString(2));
				suserInfo.setPassword(rs.getString(3));
				suserInfo.setSex(rs.getString(4));
				suserInfo.setEmail(rs.getString(5));
				suserInfo.setTelephone(rs.getString(6));
				suserInfo.setQuestion(rs.getString(7));
				suserInfo.setAnswer(rs.getString(8));
				suserInfo.setShop_id(rs.getInt(9));
				list.add(suserInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return list;
		}
	public List<ShopBean> Manage_shopqueryObject(){
		List<ShopBean> list = new ArrayList<ShopBean>();
		sql = "select * from tb_shop ";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				shopBean = new ShopBean();
				shopBean.setId(rs.getInt(1));
				shopBean.setName(rs.getString(2));
				shopBean.setLogo(rs.getString(3));
				shopBean.setType(rs.getString(4));
				shopBean.setAddress(rs.getString(5));
				shopBean.setTelephone(rs.getString(6));
				shopBean.setCard(rs.getString(7));				
				shopBean.setInfo(rs.getString(8));
				shopBean.setOwn(rs.getInt(9));
				list.add(shopBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return list;
		}
	public List<Manage> Manage_managequeryObject() {
		List<Manage> list = new ArrayList<Manage>();
		sql = "select * from tb_manage ";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				manage = new Manage();
				manage.setId(rs.getInt(1));
				manage.setAccount(rs.getString(2));
				manage.setPassword(rs.getString(3));
				list.add(manage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return list;
	}
	public Boolean Manage_manageadd(Manage manage) {
		sql = "insert into tb_manage values ( '" + manage.getAccount()
				+ "', '" + manage.getPassword() + "')";
		flag = connection.executeUpdate(sql);
		connection.close();
		return flag;
	}
	public boolean manage_managedelete(String id) {
		int i = Integer.valueOf(id).intValue();
		sql ="delete  from tb_manage where id='"+i+"'";
		flag = connection.executeUpdate(sql);
		connection.close();
		return flag;
	}
	public void closed(){
		connection.close();
	}

}
