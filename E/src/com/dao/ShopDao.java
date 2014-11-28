package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.ShopBean;
import com.tools.ConnDB;

public class ShopDao {
	private ConnDB con = null;
	private String sql = null;
	//添加shopBean对象到数据库
	public boolean addShop(ShopBean shopBean){
		boolean flag = false;
		con = new ConnDB();
		sql = "insert into tb_shop (shop_name,shop_logo,shop_type,shop_address,shop_telephone,shop_card,shop_info,shop_own) values ('" + shopBean.getName()
		+ "','"+ shopBean.getLogo()
		+ "','"+ shopBean.getType()
		+ "','" + shopBean.getAddress()
		+ "','"+ shopBean.getTelephone()
		+ "','"+ shopBean.getCard()
		+ "','" + shopBean.getInfo()
		+ "','" + shopBean.getOwn() + "')";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	//根据id从得到shopBean对象
	public ShopBean queryShop(int id){
		con = new ConnDB();
		ShopBean shopBean = null;
		sql = "select * from tb_shop where id="+id+"";
		try {
			ResultSet rs = con.executeQuery(sql);	
			while(rs.next()){
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
				System.out.println("调用ShopDao.java");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
		return shopBean;
	}
	//根据own(商家用户id)得到此人的shopBean对象
	public ShopBean getShopId(int own){
		con = new ConnDB();
		ShopBean shopBean = null;
		sql = "select * from tb_shop where shop_own="+own+"";
		try {
			ResultSet rs = con.executeQuery(sql);	
			while(rs.next()){
				shopBean = new ShopBean();
				shopBean.setId(rs.getInt(1));
				shopBean.setName(rs.getString(2));
				shopBean.setLogo(rs.getString(3));
				shopBean.setType(rs.getString(4));
				shopBean.setAddress(rs.getString(5));
				shopBean.setTelephone(rs.getString(6));
				shopBean.setCard(rs.getString(7));
				shopBean.setInfo(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.close();
		return shopBean;
	}
	
	public boolean alterShop(ShopBean shopBean){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_shop set shop_name='"+shopBean.getName()+"',shop_logo='"+shopBean.getLogo()+"',shop_type='"+shopBean.getType()+"',shop_address='"+shopBean.getAddress()+"',shop_telephone='"+shopBean.getTelephone()+"',shop_card='"+shopBean.getCard()+"',shop_info='"+shopBean.getInfo()+"' where shop_own='"+shopBean.getOwn()+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
}
