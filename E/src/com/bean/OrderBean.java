package com.bean;

public class OrderBean {
	private Integer id;                     //����ID
	private String order_number;           //�������
	private Integer user_id;                //�û�ID
	private Integer shop_id;                //����ID
	private Integer goods_id;               //��ƷID
	private float   goods_price;            //��Ʒ����
	private Integer goods_number;           //��Ʒ����
	private String  goods_picture;          //��ƷͼƬ
	private Integer order_state;            //����״̬ 2-�Ѹ��1-δ���0-ȡ���Ķ���
	private float   totalprice;             //��Ʒ����
	private String  order_time;             //����ʱ��
	private String  user_name;              //�ջ�������
	private String  user_address;           //�ջ��˵�ַ
	private String  user_telephone;         //�ջ��˵绰
	private String  user_remark;            //�������
	private Integer flag;                   //���ɾ����1�û��ɲ飬0�û����ܲ�ѯ��
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}
	public float getGoods_price() {
		return goods_price;
	}
	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}
	public Integer getGoods_number() {
		return goods_number;
	}
	public void setGoods_picture(String goods_picture) {
		this.goods_picture = goods_picture;
	}
	public String getGoods_picture() {
		return goods_picture;
	}
	public void setOrder_state(Integer order_state) {
		this.order_state = order_state;
	}
	public Integer getOrder_state() {
		return order_state;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	public String getUser_remark() {
		return user_remark;
	}
	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}
	public String getUser_telephone() {
		return user_telephone;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getFlag() {
		return flag;
	}

}
