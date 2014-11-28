package com.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import com.bean.GoodsBean;
import com.bean.ShopBean;
import com.bean.ShopKeeper;
import com.dao.GoodsDao;
import com.dao.ShopDao;
import com.tools.StringHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.lxh.smart.*;

import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

public class GoodsServlet extends HttpServlet {

	private int method;
	private GoodsBean goodsBean = null;
	private GoodsDao goodsDao = null;
	private ShopKeeper shopkeeper = null;
	private ShopBean shopBean = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = Integer.parseInt(request.getParameter("method"));
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		if(method==1){
			this.addGoods(request, response);   //添加商品
		}
		if(method==2){
			this.showGoodsList(request, response);   //显示商品列表
		}
		if(method==3){
			this.goodsDetail(request, response);    //商品详细信息
		}
		if(method==4){ 
			this.alterGoods(request, response);       //修改商品信息
		}
		if(method==5){
			this.getGoods(request, response);         //获得商品对象
		}
		if(method==6){
			this.queryGoods(request, response);       //查询符合要求的商品
		}
		if(method==7){
			this.deleteGoods(request, response);      //删除商品
		}
		if(method==8){
			this.browserGoods(request, response);       //已浏览商品
		}
	}
	/**
	 * @添加商品从表中获得商品属性添加到数据库
	 **/
	public void addGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        request.setCharacterEncoding("GBK");
		int shop_id = shopkeeper.getShop_id();           //从登录者对象中获取shop_id(商店id)
		String information="";
		long maxsize=1024*1024*20;			//设置允许上传文件的总长度为20兆
		String filedir="/upload/";			//设置存放文件的目录(该目录位于web应用根目录下)
		int k=0;
		try{			
			SmartUpload myup=new SmartUpload();
			JspFactory jspFactory=null;
			PageContext pageContext=null;
			jspFactory=JspFactory.getDefaultFactory();
			pageContext=jspFactory.getPageContext(this, request, response, "", true, 8192, true);
			myup.initialize(pageContext);//初始化上传操作
			try {
				myup.upload();
				System.out.println("453262");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                			//上传文件
		    Files files=myup.getFiles();                        			//获取所有的上传文件
		    int count=files.getCount();	    
		    Date date=new Date();		    								//获取当前时间
		    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式//获取上传文件数量	
		    boolean mark = false;
		    goodsDao = new GoodsDao();
		    for(int i=0;i<count;i++){               						//逐个获取上传的文件
		    	File file=files.getFile(i);
		        if(!file.isMissing()){                   				//如果有文件
		        	mark=true;
		        	int filesize=file.getSize();
		        	if(filesize==0)
		        		information+="<li>文件 <b><font color='red'>"+file.getFilePathName()+"</font></b> 的大小为0！本系统不允许上传0字节的文件！<><br>";
		        	else{
		        		String filename = file.getFileName();			//获取上传文件的名称
		        		String filetype = file.getContentType().trim();
		        		String savename = StringHandler.getSerial(date,i)+"."+file.getFileExt();
		        		String uptime = StringHandler.timeTostr(date);
		        		String goods_name = new String(myup.getRequest().getParameter("goods_name").getBytes("ISO8859_1"),"GB2312");
		        		String goods_type = new String(myup.getRequest().getParameter("goods_type").getBytes("ISO8859_1"),"GB2312");
		        		float goods_price = new Float(myup.getRequest().getParameter("goods_price"));
		        		String goods_info = new String(myup.getRequest().getParameter("goods_info").getBytes("ISO8859_1"),"GB2312");
		        		String goods_maker = new String(myup.getRequest().getParameter("goods_maker").getBytes("ISO8859_1"),"GB2312");
		        		int goods_stock = Integer.parseInt(myup.getRequest().getParameter("goods_stock"));
		        		//String name = shop_id+"_"+smartupload.getRequest().getParameter("uname");
		        		String goods_picture = StringHandler.getSerial(date,i) + "." + file.getFileExt();     //商品名字+"."+后缀
		        		goodsBean = new GoodsBean();
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
		        		if(!goodsDao.addGoods(goodsBean))		//保存文件信息到数据库中														//信息保存失败！
		        			information+="●文件 <b><font color='red'>"+file.getFilePathName()+"</font></b> 上传失败！<br>";		        		
		        		else{
		        			file.saveAs(filedir+savename,File.SAVEAS_VIRTUAL);			//保存文件到磁盘的指定目录下
		        			information+="●文件 <b><font color='red'>"+file.getFilePathName()+"</font></b> 上传成功！<br>";
		        		}
		        	}		        	
		        }
		    }
		    if(!mark)
		    	information="●请至少选择一个要上传的文件！<br>";		    	
		    goodsDao.closed();
		}catch(java.lang.SecurityException e1){
			k=-1;
			information="●上传的文件总大小不允许超过"+(maxsize/1024/1024)+"兆！<br>";
		    e1.printStackTrace();
		}
		catch(Exception e2){
			k=-1;
			information="●文件上传失败！<br>";
		    e2.printStackTrace();
		}catch(java.lang.OutOfMemoryError e3){
			k=-1;
			information="●您上传的文件太大！<br>";
			e3.printStackTrace();
		}
		if(k<=0)
			information+="<a href='javascript:window.history.go(-1)'>>> 返回重试</a><br>";
		else
			information+="<a href='uploadfile.jsp'>>> 继续上传</a><br>";
		information+="<a href='index.jsp'>>> 返回主页</a>";
		
		request.setAttribute("information", information);
		request.getRequestDispatcher("goods/addResult.jsp").forward(request, response);

}

	
	/**
	 * @添加商品从表中获得商品属性添加到数据库
	 **/
	/*public void addGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		goodsBean = new GoodsBean();
		goodsDao = new GoodsDao();
		int shop_id = shopkeeper.getShop_id();           //从登录者对象中获取shop_id(商店id)
		String goods_name = new String(request.getParameter("goods_name").getBytes("ISO8859_1"),"GB2312");
		String goods_type = new String(request.getParameter("goods_type").getBytes("ISO8859_1"),"GB2312");
		float goods_price = new Float(request.getParameter("goods_price"));
		String goods_picture = new String(request.getParameter("goods_picture").getBytes("ISO8859_1"),"GB2312");
		String goods_info = new String(request.getParameter("goods_info").getBytes("ISO8859_1"),"GB2312");
		String goods_maker = new String(request.getParameter("goods_maker").getBytes("ISO8859_1"),"GB2312");
		int goods_stock = Integer.parseInt(request.getParameter("goods_stock"));
		goodsBean.setShop_id(shop_id);
		goodsBean.setGoods_name(goods_name);
		goodsBean.setGoods_type(goods_type);
		goodsBean.setGoods_price(goods_price);
		goodsBean.setGoods_picture(goods_picture);
		goodsBean.setGoods_info(goods_info);
		goodsBean.setGoods_stock(goods_stock);
		goodsBean.setGoods_maker(goods_maker);
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		goodsBean.setGoods_time(df.format(new Date()));
		if(goodsDao.addGoods(goodsBean)){
			information = "添加商品成功";		
		}else{
			information = "添加商品失败";
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("goods/addResult.jsp").forward(request, response);
	}*/
/**
	 * @显示商品列表
	 **/
	public void showGoodsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");      //shop_id
		String url = null;
		//Object[] params = {type};
		List goodslist = new ArrayList();
		try {
			goodsDao = new GoodsDao();
			String currentPage=request.getParameter("currentP");    //获得当前页码
			String currentGroup=request.getParameter("currentG");    //获得当前组号
			System.out.println("当前页码"+currentPage);
			if(type==null){
				url = "GoodsServlet?method=2";
				goodslist = goodsDao.getPartGoods(currentPage,currentGroup,url,null);
			} else {
				url = "GoodsServlet?method=2&type="+type;
				goodslist = goodsDao.getPartGoods(currentPage,currentGroup,url,type);
			}
			//goodslist中是当前页3行商品的集合
			request.setAttribute("goodslist",goodslist);
			request.setAttribute("pageBar",goodsDao.getPageBar());   //保存	
			goodsDao.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(type==null){
			request.getRequestDispatcher("goods/goodList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("goods/shopGoodsList.jsp").forward(request, response);
		}
	}
	
	
	/**
	 *@功能：获得商品和所属商店的详细信息
	 **/
	public void goodsDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String flag = request.getParameter("flag");      //flag 判断是普通用户查看还是商家查看
		System.out.println("flag的值"+flag);
		goodsDao = new GoodsDao();
		goodsBean = new GoodsBean();
		goodsBean = goodsDao.getGoodsBean(goodsId);      //得到对应的商品对象
		goodsDao.closed();
		shopBean = new ShopBean(); 
		ShopDao shopDao = new ShopDao();
		shopBean = shopDao.queryShop(goodsBean.getShop_id());  //根据商品对象中的shop_id得到shop对象
		if (goodsBean!=null&&shopBean!=null) {
			request.setAttribute("goodsBean", goodsBean);
			request.setAttribute("shopBean", shopBean);
			if (flag==null) {                               //如果是普通用户查看
				request.getRequestDispatcher("goods/goodsDetail.jsp").forward(
						request, response);
			} else {                                       //如果是商家查看
				request.getRequestDispatcher("goods/goodsDetail2.jsp").forward(
						request, response);
			}
		}
	}
	
	
	/**
	 * @修改商品信息
	 **/
	public void alterGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = null;
		//从表中获取修改的数据
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
		float price = Float.parseFloat(request.getParameter("price"));
		String picture = request.getParameter("picture");
		int stock = Integer.parseInt(request.getParameter("stock"));
		String info = new String(request.getParameter("info").getBytes("ISO-8859-1"),"GB2312");
		String maker = new String(request.getParameter("maker").getBytes("ISO-8859-1"),"GB2312");
		String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"GB2312");	
		//添加到goodsBean对象中
		goodsBean.setId(goodsId);
		goodsBean.setGoods_name(name);
		goodsBean.setGoods_price(price);
		goodsBean.setGoods_picture(picture);
		goodsBean.setGoods_stock(stock);
		goodsBean.setGoods_info(info);
		goodsBean.setGoods_maker(maker);
		goodsBean.setGoods_type(type);
		if(!goodsDao.alterGoods(goodsBean)){
			information = "修改商品信息失败";
			System.out.println(information);
			
		}else{
			information = "修改商品信息成功";
			System.out.println(information);
		}
		request.setAttribute("information", information);
		this.goodsDetail(request, response);
	}
	
	/**
	 * @根据商品id获得商品信息
	 **/
	public void getGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("goodsId"));
		System.out.println(id);
		goodsDao = new GoodsDao();
		goodsBean = goodsDao.getGoodsBean(id);
		System.out.println("得到的商品id"+id);
		request.setAttribute("goodsBean", goodsBean);
		request.getRequestDispatcher("goods/alterGoods.jsp").forward(request, response);
	}
	
	/**
	 * @查询符合要求的商品
	 **/
	public void queryGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List goodslist = new ArrayList();
		String url = null;
		String type= null;
		String name = null;
		String price1 = null;
		String price2 = null;
		type = request.getParameter("type");
		//name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"GB2312");
		name = request.getParameter("name");
		price1 = request.getParameter("price1");
		price2 = request.getParameter("price2");
		System.out.println("type"+type);
		System.out.println("name"+name);
		System.out.println("price1"+price1);
		System.out.println("price2"+price2);;
		Object[] params = {type,price1,price2,shopkeeper.getShop_id()};
		try {
			String currentPage=request.getParameter("currentP");    //获得当前页码
			String currentGroup=request.getParameter("currentG");    //获得当前组号
			System.out.println("当前页码"+currentPage);
			goodsDao = new GoodsDao();
			url = "GoodsServlet?method=6";
			goodslist = goodsDao.queryGoods(currentPage,currentGroup,url,params,name);
			//goodslist中是当前页3行商品的集合
			request.setAttribute("goodslist",goodslist);
			request.setAttribute("pageBar",goodsDao.getPageBar());   //保存	
			System.out.println("pageBar        "+goodsDao.getPageBar().getPageLink());
			goodsDao.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("goods/shopGoodsList.jsp").forward(request, response);
	}
	
	/**
	 * @删除商品
	 **/
	public void deleteGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		int id = Integer.parseInt(request.getParameter("goodsId"));
		System.out.println(id);
		goodsDao = new GoodsDao();
		if(goodsDao.deleteGoods(id)){
			information = "删除成功";
		} else {
			information = "删除失败";
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	
	/**
	 * @已浏览商品
	 **/
	public void browserGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map ckmap=getcookie(request);
		if(ckmap.size()==4){
			List browsegoodslist=new ArrayList();
			int[] ids=StringHandler.changeToIntArray(((String)ckmap.get("ckid")).split("I"));
			String[] names=((String)ckmap.get("ckname")).split("I");
			String[] viewpics=((String)ckmap.get("ckviewpic")).split("I");
			String[] times=((String)ckmap.get("cktime")).split("I");
			
			if((ids.length==names.length)&&(ids.length==viewpics.length)&&(ids.length==times.length)){
				for(int i=0;i<ids.length;i++){
					Map browsesingle=new HashMap();
					browsesingle.put("browseid",ids[i]);
					browsesingle.put("browsename",names[i]);
					browsesingle.put("browseviewpic",viewpics[i]);
					browsesingle.put("browsetime",times[i]);
					
					browsegoodslist.add(browsesingle);
				}
				request.setAttribute("browsegoodslist", browsegoodslist);
			}			
		}
		RequestDispatcher rd=request.getRequestDispatcher("listBrowseGoods.jsp");
		rd.forward(request,response);
	}
	private Map getcookie(HttpServletRequest request){
		Map ckmap=new HashMap();
		String webname=request.getContextPath();
		webname=webname.substring(1);		
		Cookie[] coks=request.getCookies();	
		int i=0;
		for(i=0;i<coks.length;i++){
			Cookie icok=coks[i];
			if(icok.getName().equals(webname+".browsegoodsid"))
				ckmap.put("ckid",icok.getValue());
			else if(icok.getName().equals(webname+".browsegoodsname"))
				ckmap.put("ckname",StringHandler.cookieDecCode(icok.getValue()));
			else if(icok.getName().equals(webname+".browsegoodsviewpic"))
				ckmap.put("ckviewpic",icok.getValue());	
			else if(icok.getName().equals(webname+".browsegoodstime"))
				ckmap.put("cktime",icok.getValue());	
			
			if(ckmap.size()==4)
				break;
		}
		return ckmap;
	}
}	
