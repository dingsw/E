package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.ShopcarBean;
import com.tools.DB;
import com.bean.GoodsBean;

public class ShopcarDao {	
	//��������
	private DB mydb = null;
	private ShopcarBean shopcarBean = null;
	
	//���캯���������������ݿ����
	public ShopcarDao(){
		mydb=new DB();
	}
	
	
	
	/**
	 * @���� �жϴ��û��Ƿ��й��ﳵ��û���򴴽�
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
			if(rs!=null&&rs.next()){    //���ﳵ�Ѿ�����
				flag = true;
				//rs.close();
			}else{             //������
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
	 * @���� �жϴι��ﳵ���Ƿ����Ҫ��ӵ���Ʒ
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
	 * @����  ���ﳵ���Ѿ����ڸ���Ʒʱ��������빺������Ʒ����+1
	 * @param params
	 * @return int ���²���Ӱ��ļ�¼��
	 */
	public int addBuyNum(Object[] params){
		String sql="update tb_shopcar set shopcar_buygoodscount=shopcar_buygoodscount+1 where user_id=? and shopcar_buygoodsid=?";
		return getUpdate(sql,params);
	}
	
	/**
	 * @���� ���ﳵ���������Ʒ 
	 */
	public int addGoods(Object[] params){
		String sql="insert into tb_shopcar(user_id,shopcar_buygoodsid,shopcar_buygoodscount) values(?,?,?)";
		return getUpdate(sql,params);
	} 
	
	/**
	 * @���� ���ִ�����ݿ�����󷵻�Ӱ��ļ�¼�����쳣�򷵻�-1
	 */
	private int getUpdate(String sql,Object[] params){
		int i=-1;
		mydb.doPstm(sql, params);
		try {
			i=mydb.getCount();   //��ȡ����doPstm()����ִ�и��²����󷵻�Ӱ��ļ�¼��
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
			goodsBean.setGoods_num(goodsBuyNum);					//���ù�������
		goodsDao.closed();
		return goodsBean;
	}
	//ɾ������Ʒ
	public int deleteGoods(int user_id,int goodsId){
		String sql = "delete from tb_shopcar where user_id=? and shopcar_buygoodsid=?";
		Object[] params = {user_id,goodsId};
		return getUpdate(sql,params);
	}
	//��չ��ﳵ
	public int clear(int user_id){
		String sql = "delete from tb_shopcar where user_id=?";
		Object[] params = {user_id};
		return getUpdate(sql,params);
	}
	//���¹��ﳵ��Ʒ������
	public int updateGoodsNum(Object[] params){
		String sql="update tb_shopcar set shopcar_buygoodscount=? where user_id=? and shopcar_buygoodsid=?";
		return getUpdate(sql,params);
	}
	
	public void closed(){
		mydb.closed();
	}
}
