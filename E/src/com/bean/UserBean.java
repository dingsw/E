package com.bean;

public class UserBean {
	
	
	private int id = -1;           
	private String account ="";      //�ʺ�
	private String password ="";     //����
	private String sex ="";          //�Ա�
	private String email ="";        //����
	private String telephone ="";    //��ϵ�绰
	private String address ="";      //��ַ
	private String question ="";     //��֤����
	private String answer ="";       //��֤��
	private ShopcarBean shopcar;     //���ﳵ
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public ShopcarBean getShopcar() {
		return shopcar;
	}
	public void setShopcar(ShopcarBean shopcar) {
		this.shopcar = shopcar;
	}
}
