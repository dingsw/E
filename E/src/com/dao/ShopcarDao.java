package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.ShopcarBean;
import com.tools.DB;
import com.bean.GoodsBean;

public class ShopcarDao {	
	//声明变量
	private DB mydb = null;
	private ShopcarBean shopcarBean = null;
	
	//构造函数，创建连接数据库对象
	public ShopcarDao(){
		mydb=new DB();
	}
	
	
	
	/**
	 * @功能 判断此用户是否有购物车，没有则创建
	 * @param userBeanId
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean isExistShopcar(int userBeanId) throws SQLException{
		boolean flag = false;
		String sql="select id from tb_shopcar where user_id=?";
		Object[] params = {userBeanId};
		try {
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			if(rs!=null&&rs.next()){    //购物车已经存在
				flag = true;
				//rs.close();
			}else{             //不存在
				String sql1 ="insert into tb_shopcar (user_id) values (?)"; 
				mydb.doPstm(sql1, params);
				//mydb.closed();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * @功能 判断次购物车中是否存在要添加的商品
	 * @param params
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean isExistGoods(Object[] params) throws SQLException{
		boolean flag = false;
		String sql="select id from tb_shopcar where user_id=? and shopcar_buygoodsid=?";
		mydb.doPstm(sql, params);
		try {
			ResultSet rs=mydb.getRs();
			if(rs!=null&&rs.next()){
				flag = true;
				//rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * @功能  购物车中已经存在该商品时，点击加入购买则商品数量+1
	 * @param params
	 * @return int 更新操作影响的记录数
	 */
	public int addBuyNum(Object[] params){
		String sql="update tb_shopcar set shopcar_buygoodscount=shopcar_buygoodscount+1 where user_id=? and shopcar_buygoodsid=?";
		return getUpdate(sql,params);
	}
	
	/**
	 * @功能 向购物车中添加新商品 
	 */
	public int addGoods(Object[] params){
		String sql="insert into tb_shopcar(user_id,shopcar_buygoodsid,shopcar_buygoodscount) values(?,?,?)";
		return getUpdate(sql,params);
	} 
	
	/**
	 * @功能 获得执行数据库操作后返回影响的记录数，异常则返回-1
	 */
	private int getUpdate(String sql,Object[] params){
		int i=-1;
		mydb.doPstm(sql, params);
		try {
			i=mydb.getCount();   //获取调用doPstm()方法执行更新操作后返回影响的记录数
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}
		return i;
	}
	
	public ShopcarBean getShopcar(int user_id){
		shopcarBean = new ShopcarBean();
		String sql="select * from tb_shopcar where user_id=? and shopcar_buygoodscount!=0 order by id desc";
		Object[] params={user_id};
		mydb.doPstm(sql, params);
		try {
			ResultSet rs = mydb.getRs();
			if(rs!=null){
				shopcarBean = new ShopcarBean();
				shopcarBean.setUser_id(user_id);
				while(rs.next())
					shopcarBean.setShopcarBuyGoods(getBuyGoodsToShopcar(rs.getInt(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopcarBean;
	}
	private GoodsBean getBuyGoodsToShopcar(int goodsbuyId,int goodsBuyNum) 
			throws SQLException{
		GoodsDao goodsDao = new GoodsDao();
		GoodsBean goodsBean=goodsDao.getGoodsBean(goodsbuyId);
		if(goodsBean!=null)
			goodsBean.setGoods_num(goodsBuyNum);					//设置购买数量
		goodsDao.closed();
		return goodsBean;
	}
	//删除此商品
	public int deleteGoods(int user_id,int goodsId){
		String sql = "delete from tb_shopcar where user_id=? and shopcar_buygoodsid=?";
		Object[] params = {user_id,goodsId};
		return getUpdate(sql,params);
	}
	//清空购物车
	public int clear(int user_id){
		String sql = "delete from tb_shopcar where user_id=?";
		Object[] params = {user_id};
		return getUpdate(sql,params);
	}
	//更新购物车商品的数量
	public int updateGoodsNum(Object[] params){
		String sql="update tb_shopcar set shopcar_buygoodscount=? where user_id=? and shopcar_buygoodsid=?";
		return getUpdate(sql,params);
	}
	
	public void closed(){
		mydb.closed();
	}
}
