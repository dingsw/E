package com.bean;

import java.util.List;
import java.util.ArrayList;

public class ShopcarBean {
	private int id;
	private int user_id;
	private List<GoodsBean> shopcarBuyGoods = new ArrayList<GoodsBean>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public List<GoodsBean> getShopcarBuyGoods() {
		return shopcarBuyGoods;
	}
	public void setShopcarBuyGoods(GoodsBean goodsBean) {
		shopcarBuyGoods.add(goodsBean);
	}
}
