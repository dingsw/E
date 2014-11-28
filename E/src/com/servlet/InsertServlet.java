package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.lxh.smart.File;
import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import com.bean.GoodsBean;
import com.bean.ShopBean;
import com.bean.ShopKeeper;
import com.dao.GoodsDao;
import com.tools.StringHandler;


public class InsertServlet extends HttpServlet {
	private GoodsBean goodsBean = null;
	private GoodsDao goodsDao = null;
	private ShopKeeper shopkeeper = null;
	private ShopBean shopBean = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		shopkeeper = new ShopKeeper();
		goodsDao = new GoodsDao();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		String information="";
		int shop_id = shopkeeper.getShop_id();
		goodsBean = new GoodsBean();
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		//取得excel文件的绝对路径
		SmartUpload myup=new SmartUpload();
		JspFactory jspFactory=null;
		PageContext pageContext=null;
		jspFactory=JspFactory.getDefaultFactory();
		pageContext=jspFactory.getPageContext(this, request, response, "", true, 8192, true);
		myup.initialize(pageContext);//初始化上传操作
		try {
			myup.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		String fileName="";
		fileName=myup.getFiles().getFile(0).getFileName();
		System.out.println(fileName);
		String filePath=this.getServletContext().getRealPath("/")+"upload\\"+fileName;
		System.out.println(filePath);
		try {
			
			myup.getFiles().getFile(0).saveAs(filePath) ;
			
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date date=new Date();		    								//获取当前时间
	    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式//获取上传文件数量
		String goods_name = new String(myup.getRequest().getParameter("goods_name").getBytes("ISO8859_1"),"GB2312");
		String goods_type = new String(myup.getRequest().getParameter("goods_type").getBytes("ISO8859_1"),"GB2312");
		float goods_price = new Float(myup.getRequest().getParameter("goods_price"));
		String goods_info = new String(myup.getRequest().getParameter("goods_info").getBytes("ISO8859_1"),"GB2312");
		String goods_maker = new String(myup.getRequest().getParameter("goods_maker").getBytes("ISO8859_1"),"GB2312");
		int goods_stock = Integer.parseInt(myup.getRequest().getParameter("goods_stock"));
		//String name = shop_id+"_"+smartupload.getRequest().getParameter("uname");
		String goods_picture = fileName;     //商品名字+"."+后缀
		System.out.println(goods_picture);
		goodsBean.setShop_id(shop_id);
		goodsBean.setGoods_name(goods_name);
		goodsBean.setGoods_type(goods_type);
		goodsBean.setGoods_price(goods_price);
		goodsBean.setGoods_picture(goods_picture);
		goodsBean.setGoods_info(goods_info);
		goodsBean.setGoods_stock(goods_stock);
		goodsBean.setGoods_maker(goods_maker);
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		goodsBean.setGoods_time(df.format(new Date()));	
		System.out.println(goodsBean);
		if(!goodsDao.addGoods(goodsBean))		//保存文件信息到数据库中														//信息保存失败！
			//information+="●文件 <b><font color='red'>"+file.getFilePathName()+"</font></b> 上传失败！<br>";
			System.out.println("c");
		else{
			//file.saveAs(filedir+savename,File.SAVEAS_VIRTUAL);			//保存文件到磁盘的指定目录下
			//information+="●文件 <b><font color='red'>"+file.getFilePathName()+"</font></b> 上传成功！<br>";
			System.out.println("f");
		}	 
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
