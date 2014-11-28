package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tools.ConnDB;
import com.bean.OrderBean;

public class OrderFormDao {
	private ConnDB connection = null;
	private String sql = "";
	private Boolean flag = false;
	private OrderBean orderInfo = null;
	
	public OrderFormDao() {
		connection = new ConnDB();
	}
	public boolean order_delete(String order_id,String order_state) {
		int i = Integer.valueOf(order_id).intValue();
		int s = Integer.valueOf(order_state).intValue();
		sql ="update tb_order set flag=0 where id='"+i+"'and order_state='"+s+"'";
		flag = connection.executeUpdate(sql);
		connection.close();
		return flag;
	}
	public List<OrderBean> order_queryObject(int user_id) {
		
		List<OrderBean> list = new ArrayList<OrderBean>();
		sql = "select * from tb_order where user_id = '" + user_id + "'";
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while (rs.next()) {
				orderInfo = new OrderBean();
				orderInfo.setId(rs.getInt(1));
				orderInfo.setOrder_number(rs.getString(2));
				orderInfo.setUser_id(rs.getInt(3));
				orderInfo.setShop_id(rs.getInt(4));			
				orderInfo.setOrder_state(rs.getInt(9));
				orderInfo.setTotalprice(rs.getInt(10));
				orderInfo.setOrder_time(rs.getString(11));
				orderInfo.setUser_name(rs.getString(12));
				orderInfo.setUser_address(rs.getString(13));
				orderInfo.setUser_telephone(rs.getString(14));
				orderInfo.setUser_remark(rs.getString(15));
				orderInfo.setFlag(rs.getInt(16));
				orderInfo.setGoods_id(rs.getInt(5));
				orderInfo.setGoods_price(rs.getInt(6));
				orderInfo.setGoods_number(rs.getInt(7));
				orderInfo.setGoods_picture(rs.getString(8));
				list.add(orderInfo);
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return list;
	}

}
