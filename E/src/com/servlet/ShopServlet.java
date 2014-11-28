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
			this.creatShop(request, response);        //创建店铺
		}
		if(method==2){
			this.showShop(request, response);         //显示店铺
		}
		if(method==3){
			this.alterShop(request, response);         //修改店铺
		}
	}
	/**
	 * @功能 创建店铺
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
			information = "商铺创建失败！";
		}else{
			//从数据库中获得shopBean的id号
			int shop_id = shopDao.getShopId(own).getId();
			System.out.println("从数据库中获得shopBean的id号,要写入shopkeeper中"+shop_id);
			int	shopkeeper_id = shopkeeper.getId();
			shopkeeper.setShop_id(shop_id);
			shopkeeperDao = new ShopkeeperDao();
			shopkeeperDao.updateShopKeeper(shop_id,shopkeeper_id);
			request.getSession().setAttribute("shopkeeper", shopkeeper); 
		}
		if (information.equals("")) {
			information = "您的商铺创建成功！";
			request.setAttribute("information", information);
			request.getRequestDispatcher("shop/myShop.jsp").forward(request, response);
		} else {
			out.print("<script>alert('"+ information + "');window.history.go(-1);</script>");
		}
	}
	
	/**
	 * @功能：显示店铺（没创建则创建）
	 */
	public void showShop(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		shopBean = getShopBean(request,response);
		request.setAttribute("shopBean", shopBean);	
		if(flag==null){         //没有flag参数传出时为显示商店信息
			request.getRequestDispatcher("shop/myShop.jsp").forward(request, response);
		} else {               //有flag时是修改信息，将信息显示到table中
			request.getRequestDispatcher("shop/alterShop.jsp").forward(request, response);
		}
		
	}
	//得到当前登录者的shopBean对象
	private ShopBean getShopBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		shopkeeper = new ShopKeeper();	
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		if(shopkeeper.getShop_id()!=0){          //有商店id，则已创建店铺 
			int Shop_id = shopkeeper.getShop_id();
			System.out.println(Shop_id);
			shopBean = new ShopBean();
			shopDao = new ShopDao();
			shopBean = shopDao.queryShop(Shop_id);	
		} 
		return shopBean;
	}
	
	/**
	 * @功能：修改店铺信息
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
			information = "修改失败！";
		}else{
			request.getRequestDispatcher("shop/myShop.jsp").forward(request, response);
		}
	}

}
