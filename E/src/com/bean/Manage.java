package com.bean;

public class Manage {
	private Integer id = -1;            //�Զ���Ŷ���
	private String account="";          //�û�����
	private String password="";         //�û���¼�������
	private int    flag  =0;
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFlag() {
		return flag;
	}
}
