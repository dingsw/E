package com.bean;

public class GoodsBean {
	
	private int id;                   //商品id
	private int shop_id;              //所属商家ID
	private String goods_type;        //商品类型
	private String goods_name;        //商品名字
	private float goods_price;        //商品价格
	private String goods_picture;     //商品图片
	private int goods_stock;          //库存
	private String goods_info;        //商品描述
	private String goods_maker;       //商品制造商
	private int goods_sales;   		  //销量
	private String goods_time;        //商品上架时间
	private int goods_num;            //购物车中商品数量
	
	
	
	
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goodsNum) {
		goods_num = goodsNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shopId) {
		shop_id = shopId;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goodsType) {
		goods_type = goodsType;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(float goodsPrice) {
		goods_price = goodsPrice;
	}
	public String getGoods_picture() {
		return goods_picture;
	}
	public void setGoods_picture(String goodsPicture) {
		goods_picture = goodsPicture;
	}
	public int getGoods_stock() {
		return goods_stock;
	}
	public void setGoods_stock(int goodsStock) {
		goods_stock = goodsStock;
	}
	public String getGoods_info() {
		return goods_info;
	}
	public void setGoods_info(String goodsInfo) {
		goods_info = goodsInfo;
	}
	public String getGoods_maker() {
		return goods_maker;
	}
	public void setGoods_maker(String goodsMaker) {
		goods_maker = goodsMaker;
	}
	public int getGoods_sales() {
		return goods_sales;
	}
	public void setGoods_sales(int goodsSales) {
		goods_sales = goodsSales;
	}
	public String getGoods_time() {
		return goods_time;
	}
	public void setGoods_time(String goodsTime) {
		goods_time = goodsTime;
	}
	public float getGoodsMoney(){
		return Math.round(goods_price*goods_num*100)/100f;
	}
}
