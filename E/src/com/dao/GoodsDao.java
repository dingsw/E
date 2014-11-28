package com.dao;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.GoodsBean;
import com.tools.ConnDB;
import com.tools.DB;
//上传
public class GoodsDao extends SuperDao{
	ConnDB con = null;
	String sql = null;
	DB mydb = null;
	GoodsBean goodsBean = null;
	
	//添加商品对象到数据库中
	public boolean addGoods(GoodsBean goodsBean){
		boolean flag = false;
		con = new ConnDB();
		sql = "insert into tb_goods (shop_id,goods_type,goods_name,goods_price,goods_picture,goods_stock,goods_info,goods_maker,goods_sales,goods_time)values('"
			+goodsBean.getShop_id()
			+"','"+goodsBean.getGoods_type()
			+"','"+goodsBean.getGoods_name()
			+"','"+goodsBean.getGoods_price()
			+"','"+goodsBean.getGoods_picture()
			+"','"+goodsBean.getGoods_stock()
			+"','"+goodsBean.getGoods_info()
			+"','"+goodsBean.getGoods_maker()
			+"','"+goodsBean.getGoods_sales()
			+"','"+goodsBean.getGoods_time()+"')";
		if(con.executeUpdate(sql))
			flag = true;
		con.close();
		System.out.println("调用addGoods方法");
		return flag;
	}
	
	
	/**
	 * @从数据库中获取当前页的的商品集合,分页
	 * @return List
	 * @throws SQLException 
	 */
	public List getPartGoods(String currentPage1,String currentGroup,String url,String type) throws SQLException{
		String sql = null;
		Object[] params = {type};
		String sql2 = "";
		List alllist;
		if(type==null){
			sql = "select * from tb_goods order by goods_time desc";
			setDaoPage(sql,null,currentPage1, currentGroup, url);      //给PageBar对象daoPage赋值
		} else {
			sql = "select * from tb_goods where shop_id=? order by goods_time  desc";
			setDaoPage(sql,params,currentPage1, currentGroup, url);      //给PageBar对象daoPage赋值
		}
		int currentPage = getPageBar().getCurrentP();    //得到当前页码
		int everyPageCount = getPageBar().getPerR();     //得到每页显示记录数
		int top2 = (currentPage-1)*everyPageCount;           //得到查询范围的开始数
		if (type==null) {
			if (currentPage == 1)
				sql2 = "select top " + everyPageCount
						+ " * from tb_goods order by goods_time desc";
			else
				sql2 = "select top "
						+ everyPageCount
						+ " * from tb_goods where (goods_time < (select min(goods_time) from (select top "
						+ top2
						+ " * from tb_goods order by goods_time desc) as minv)) order by goods_time desc";
			alllist = getList(sql2,null);      //将当前页的所有的商品对象（12个）保存在alllist中
		} else {
			if (currentPage == 1){
				System.out.println("当前页面"+currentPage);
				sql2 = "select top " + everyPageCount
						+ " * from tb_goods where shop_id=? order by goods_time desc";
			}else{
				System.out.println("当前页面"+currentPage);
				sql2 = "select top "
						+ everyPageCount
						+ " * from tb_goods where (goods_time < (select min(goods_time) from (select top "
						+ top2
						+ " * from tb_goods where shop_id=? order by goods_time desc) as minv)) order by goods_time desc";
			}alllist = getList(sql2,params);      //将当前页的所有的商品对象（12个）保存在alllist中
		}
		List goodslist = divide(alllist,everyPageCount);   //将12个商品分成3组，每组4个
		return goodslist;
	}
	
	
	private List getList(String sql,Object[] params) throws SQLException{
		List list = null;
		mydb = new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			list = new ArrayList();
			while(rs.next()){           //将当前页的所有的商品对象（12个）保存在list中
				GoodsBean goodsBean=new GoodsBean();
				goodsBean.setId(rs.getInt(1));
				goodsBean.setShop_id(rs.getInt(2));
				goodsBean.setGoods_type(rs.getString(3));
				goodsBean.setGoods_name(rs.getString(4));
				goodsBean.setGoods_price(rs.getFloat(5));
				goodsBean.setGoods_picture(rs.getString(6));
				goodsBean.setGoods_stock(rs.getInt(7));
				goodsBean.setGoods_info(rs.getString(8));
				goodsBean.setGoods_maker(rs.getString(9));
				goodsBean.setGoods_sales(rs.getInt(10));
				goodsBean.setGoods_time(rs.getString(11));
				System.out.println(goodsBean.getGoods_time());
				//single.setGoodsStocktime(StringHandler.timeTostr(rs.getTimestamp(6)));
				list.add(goodsBean);
			}
/*			Iterator<GoodsBean> a= list.iterator();
			while (a.hasNext()) {
				GoodsBean e = a.next();
				System.out.println(e.getGoods_info());
			}*/
			rs.close();
		}
		return list;
	}
	
	/*将当前页的12个商品划分成3组，每一行一组保存在长度为3的goodslist中*/
	private List divide(List list,int perR){
		List goodslist = null;
		if(list!=null){
			goodslist = new ArrayList();
			/* ①首先补齐长度 */
			int blank=perR-list.size();			//因为每页显示perR条记录，所以list的长度只能等于perR或小于perR
			if(blank>0){						//若list的长度小于perR，则向list中存放blank个null值，将list长度补齐到perR
				for(int i=0;i<blank;i++)
					list.add(null);
			}	
		
			/* ②然后进行划分 */
			for(int i=0;i<3;i++){				//平均分成3份
				List temp=new ArrayList();
				for(int j=0;j<4;j++){			//将每份中的元素存储到temp中
					temp.add(list.get(4*i+j));
				}
				goodslist.add(temp);			//存储temp到medialist中
			}			
		}
		return goodslist;
	}
	
	//根据商品id获得goodsBean对象
	public GoodsBean getGoodsBean(int goodId){
		mydb = new DB();
		GoodsBean goodsBean = null;
		String sql="select * from tb_goods where id=?";
		Object[] params={goodId};
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while(rs.next()){
				goodsBean=new GoodsBean();
				goodsBean.setId(rs.getInt(1));
				goodsBean.setShop_id(rs.getInt(2));
				goodsBean.setGoods_type(rs.getString(3));
				goodsBean.setGoods_name(rs.getString(4));
				goodsBean.setGoods_price(rs.getFloat(5));
				goodsBean.setGoods_picture(rs.getString(6));
				goodsBean.setGoods_stock(rs.getInt(7));
				goodsBean.setGoods_info(rs.getString(8));
				goodsBean.setGoods_maker(rs.getString(9));
				goodsBean.setGoods_sales(rs.getInt(10));
				goodsBean.setGoods_time(rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return goodsBean;
	}
	
	//修改商品信息
	public boolean alterGoods(GoodsBean goodsBean){
		boolean flag = false;
		con = new ConnDB();
		sql = "update tb_goods set goods_name='"+goodsBean.getGoods_name()+"',goods_picture='"+goodsBean.getGoods_picture()+"',goods_type='"+goodsBean.getGoods_type()+"',goods_stock='"+goodsBean.getGoods_stock()+"',goods_info='"+goodsBean.getGoods_info()+"',goods_maker='"+goodsBean.getGoods_maker()+"',goods_price='"+goodsBean.getGoods_price()+"' where id='"+goodsBean.getId()+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	//删除商品
	public boolean deleteGoods(int id){
		boolean flag = false;
		con = new ConnDB();
		sql = "delete from tb_goods where id='"+id+"'";
		if (con.executeUpdate(sql)) {
			flag = true;
		}
		con.close();
		return flag;
	}
	
	//模糊查询（未完）
	public List queryGoods(String currentPage1,String currentGroup,String url,Object[] param,String name1) throws SQLException{
		String sql,sql1,sql2 = null;
		Object[] params = param;
		String type = String.valueOf(params[0]);
		//String name = String.valueOf(params[1]);
		String name = "";
		if (name1!=null) {
			try {
				name = new String(name1.getBytes("ISO-8859-1"), "GB2312");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String price1 = String.valueOf(params[1]);
		String price2 = String.valueOf(params[2]);
		String id = String.valueOf(params[3]);
		System.out.println(type);
		System.out.println(name);
		System.out.println(price1);
		System.out.println(price2);
		System.out.println("id是"+id);
		if(type=="null"||type==""){
			if(name=="null"||name.equals("")||name==null){
				if(price1=="null"||price1==""){
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_price<'"+price2+"' ";
					}
				}else{
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_price>'"+price1+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_price>'"+price1+"' and goods_price<'"+price2+"' ";
					}
				}
			}else{
				if(price1=="null"||price1==""){
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_name='"+name+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_name='"+name+"' and goods_price<'"+price2+"' ";
					}
				}else{
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_name='"+name+"' and goods_price>'"+price1+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_name='"+name+"' and goods_price>'"+price1+"' and goods_price<'"+price2+"' ";
					}
				}
			}
		}else{
			if(name=="null"||name==""){
				if(price1=="null"||price1==""){
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_price<'"+price2+"' ";
					}
				}else{
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_price>'"+price1+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_price>'"+price1+"' and goods_price<'"+price2+"' ";
					}
				}
			}else{
				if(price1=="null"||price1==""){
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_name='"+name+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_name='"+name+"' and goods_price<'"+price2+"' ";
					}
				}else{
					if(price2=="null"||price2==""){
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_name='"+name+"' and goods_price>'"+price1+"' ";
					}else{
						sql1=" * from tb_goods where shop_id=? and goods_type='"+type+"' and goods_name='"+name+"' and goods_price>'"+price1+"' and goods_price<'"+price2+"' ";
					}
				}
			}
		}
		sql = "select"+sql1+" order by goods_time desc";
		System.out.println("sql是"+sql);
		List alllist;
		Object[] p = {id};
		System.out.println("P[0]是"+p[0]);
		//sql = "select * from tb_goods where goods_type=? and goods_name=? and goods_price>price1 and goods_price<price2 and goods_time>time1 and goods_time<time2 order by goods_time desc";
		setDaoPage(sql,p,currentPage1, currentGroup, url);      //给PageBar对象daoPage赋值
		int currentPage = getPageBar().getCurrentP();    //得到当前页码
		int everyPageCount = getPageBar().getPerR();     //得到每页显示记录数
		int top2 = (currentPage-1)*everyPageCount;           //得到查询范围的开始数
		if (currentPage == 1)
			sql2 = "select top " + everyPageCount
					+ sql1;
		else
			sql2 = "select top "
					+ everyPageCount
					+ sql1+" and (goods_time < (select min(goods_time) from (select top "
					+ top2
					+ " * from tb_goods order by goods_time desc) as minv)) order by goods_time desc";
		alllist = getList(sql2,p);      //将当前页的所有的商品对象（12个）保存在alllist中
		List goodslist = divide(alllist,everyPageCount);   //将12个商品分成3组，每组4个
		return goodslist;
	}
	public void closed(){
		mydb.closed();
	}
}
