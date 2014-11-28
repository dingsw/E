package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tools.DB;
import com.tools.StringHandler;
import com.bean.GoodsBean;

public class OrderDao {
	private DB mydb=null;
	public OrderDao(){
		mydb=new DB();
	}
	/** @功能：获取订单号 */
	public int getOrderformNumber(int whoid,String time){
		int number=-1;
		String sql="select orderform_number from tb_orderform where orderform_whoid=? and orderform_time=?";
		Object[] params={whoid,time};
		mydb.doPstm(sql, params);
		try {
			ResultSet rs = mydb.getRs();
			if(rs!=null&&rs.next()){
				number=rs.getInt(1);
				rs.close();
			}
		} catch (SQLException e) {
			number=-1;
			e.printStackTrace();
		}
		return number;
	}
	/** @功能：保存订单 */
	public int addOrder(Object[] params){
		int i=-1;
		String sql="insert into tb_order (order_number,user_id,shop_id,goods_id,goods_price,goods_number,goods_picture,order_state,totalprice,order_time,user_name,user_address,user_telephone,user_remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		mydb.doPstm(sql, params);
		try {
			i=mydb.getCount();
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}
		return i;
	}
	/** @功能：获取某订单中的所有商品 */
	public List getBuyGoodsToOrderform(int orderformnumber){
		List buygoodslist=null;
		String sql="select orderform_goodsids,orderform_goodsnum from tb_orderform where orderform_number=?";
		Object[] params={orderformnumber};
		
		mydb.doPstm(sql,params);
		try {
			ResultSet rs=mydb.getRs();
			if(rs!=null&&rs.next()){
				String buygoodsids=rs.getString(1);
				String buygoodsnum=rs.getString(2);
				buygoodslist=getListForOrderform(buygoodsids.split(","),buygoodsnum.split(","));			
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buygoodslist;
	}
	private List getListForOrderform(String[] buyids,String[] num){
		List buygoodslist=null;
		String sql="select * from tb_goods where id in (buys[])";
		if(buyids!=null&&buyids.length!=0){
			Map mapnum=new HashMap();
			String ids="";
			Object[] params=new Object[buyids.length];
			for(int i=0;i<buyids.length;i++){
				params[i]=buyids[i];
				ids+="?,";
				mapnum.put(buyids[i],num[i]);
			}
			ids=ids.substring(0,ids.length()-1);
			sql=sql.replace("buys[]",ids);
			try {
				mydb.doPstm(sql,params);
				ResultSet rs=mydb.getRs();
				if(rs!=null){
					buygoodslist=new ArrayList();
					while(rs.next()){
						GoodsBean single=new GoodsBean();
						single.setId(rs.getInt(1));
						single.setGoods_info(rs.getString(2));
		/*				single.setGoodsName(rs.getString(3));
						single.setGoodsPrice(rs.getFloat(4));
						single.setGoodsStoreNum(rs.getInt(5));
						single.setGoodsStocktime(StringHandler.timeTostr(rs.getTimestamp(6)));
						single.setGoodsInfo(rs.getString(7));
						single.setGoodsMaker(rs.getString(8));
						single.setGoodsBuyNum(Integer.parseInt((String)mapnum.get(String.valueOf(single.getId()))));
			*/			buygoodslist.add(single);
					}
					rs.close();
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return buygoodslist;
	}
	public void closed(){
		mydb.closed();
	}
}
