package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ShopBean;
import com.bean.ShopKeeper;
import com.dao.ShopDao;
import com.dao.ShopkeeperDao;

public class ShopServlet extends HttpServlet {
	
	private int method;
	private ShopKeeper shopkeeper;
	private ShopBean shopBean;
	private ShopDao shopDao;
	private ShopkeeperDao shopkeeperDao;
	private String information;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = Integer.parseInt(request.getParameter("method"));
		if(method==1){
			this.creatShop(request, response);        //��������
		}
		if(method==2){
			this.showShop(request, response);         //��ʾ����
		}
		if(method==3){
			this.alterShop(request, response);         //�޸ĵ���
		}
	}
	/**
	 * @���� ��������
	 */
	public void creatShop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		information = "";
		shopBean = new ShopBean();
		shopDao = new ShopDao();
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
		String logo = request.getParameter("logo");
		String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"GB2312");
		String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"GB2312");
		String telephone = request.getParameter("telephone");
		String card = new String(request.getParameter("card").getBytes("ISO-8859-1"),"GB2312");
		String info = new String(request.getParameter("info").getBytes("ISO-8859-1"),"GB2312");
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		int own = shopkeeper.getId();
		shopBean.setOwn(own);
		shopBean.setName(name);
		shopBean.setLogo(logo);
		shopBean.setType(type);
		shopBean.setAddress(address);
		shopBean.setTelephone(telephone);
		shopBean.setCard(card);
		shopBean.setInfo(info);	
		if(!shopDao.addShop(shopBean)){
			information = "���̴���ʧ�ܣ�";
		}else{
			//�����ݿ��л��shopBean��id��
			int shop_id = shopDao.getShopId(own).getId();
			System.out.println("�����ݿ��л��shopBean��id��,Ҫд��shopkeeper��"+shop_id);
			int	shopkeeper_id = shopkeeper.getId();
			shopkeeper.setShop_id(shop_id);
			shopkeeperDao = new ShopkeeperDao();
			shopkeeperDao.updateShopKeeper(shop_id,shopkeeper_id);
			request.getSession().setAttribute("shopkeeper", shopkeeper); 
		}
		if (information.equals("")) {
			information = "�������̴����ɹ���";
			request.setAttribute("information", information);
			request.getRequestDispatcher("shop/myShop.jsp").forward(request, response);
		} else {
			out.print("<script>alert('"+ information + "');window.history.go(-1);</script>");
		}
	}
	
	/**
	 * @���ܣ���ʾ���̣�û�����򴴽���
	 */
	public void showShop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		shopBean = getShopBean(request,response);
		request.setAttribute("shopBean", shopBean);	
		if(flag==null){         //û��flag��������ʱΪ��ʾ�̵���Ϣ
			request.getRequestDispatcher("shop/myShop.jsp").forward(request, response);
		} else {               //��flagʱ���޸���Ϣ������Ϣ��ʾ��table��
			request.getRequestDispatcher("shop/alterShop.jsp").forward(request, response);
		}
		
	}
	//�õ���ǰ��¼�ߵ�shopBean����
	private ShopBean getShopBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		shopkeeper = new ShopKeeper();	
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		if(shopkeeper.getShop_id()!=0){          //���̵�id�����Ѵ������� 
			int Shop_id = shopkeeper.getShop_id();
			System.out.println(Shop_id);
			shopBean = new ShopBean();
			shopDao = new ShopDao();
			shopBean = shopDao.queryShop(Shop_id);	
		} 
		return shopBean;
	}
	
	/**
	 * @���ܣ��޸ĵ�����Ϣ
	 */
	public void alterShop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
		String logo = request.getParameter("logo");
		String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"GB2312");
		String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"GB2312");
		String telephone = request.getParameter("telephone");
		String card = new String(request.getParameter("card").getBytes("ISO-8859-1"),"GB2312");
		String info = new String(request.getParameter("info").getBytes("ISO-8859-1"),"GB2312");
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		int own = shopkeeper.getId();
		shopBean.setOwn(own);
		shopBean.setName(name);
		shopBean.setLogo(logo);
		shopBean.setType(type);
		shopBean.setAddress(address);
		shopBean.setTelephone(telephone);
		shopBean.setCard(card);
		shopBean.setInfo(info);	
		if(!shopDao.alterShop(shopBean)){
			information = "�޸�ʧ�ܣ�";
		}else{
			request.getRequestDispatcher("shop/myShop.jsp").forward(request, response);
		}
	}

}
