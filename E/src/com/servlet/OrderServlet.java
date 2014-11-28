package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderBean;
import com.bean.UserBean;
import com.dao.GoodsDao;
import com.dao.OrderDao;
import com.dao.ShopcarDao;
import com.tools.OrderNumber;
import com.tools.StringHandler;

public class OrderServlet extends HttpServlet {
	private int method;
	private UserBean userBean = null;
	private Integer user_id = null;
	private OrderDao orderDao = null;
	private OrderBean orderBean = null;
	private String a[] = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userBean = new UserBean();	
		userBean = (UserBean)request.getSession().getAttribute("userBean");  //查询当前用户
		user_id = userBean.getId();     //得到所属用户的ID
		if(userBean==null){
			PrintWriter out = response.getWriter();
			out.println("<script>alert('您还未登录，请登录！');window.location.href='login.jsp'</script>");
		} else {
			method = Integer.parseInt(request.getParameter("method"));
			if(method==1){
				this.saveInfo(request, response);       //保存信息
			}
			if(method==2){
				this.creatOrder(request, response);
			}
		}
	}
	
		
	/** @功能：保存信息 */
	private void saveInfo(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String[] goodsNumber = request.getParameterValues("goodsNumber");          //获得每种商品填写的购买数量
		String[] goodsId = request.getParameterValues("goodsid");         //获得每种商品的id
		String[] shop_id = request.getParameterValues("shop_id");         //获得每种商品的商店id
		String[] goodsPicture = request.getParameterValues("goodsPicture");   //获得每种商品的图片地址
		String[] goodsPrice = request.getParameterValues("goodsPrice");
		String totalprice = request.getParameter("goodsprices");
	//	String buygoodsids = StringHandler.ArrayToString(goodsId);
	//	String buygoodsnum = StringHandler.ArrayToString(goodsNumber);	
	//	System.out.println(buygoodsnum);
	//	System.out.println(buygoodsids);
		String goodsIds = StringHandler.ArrayToString(goodsId);
		String goodsNumbers = StringHandler.ArrayToString(goodsNumber);	
		String shop_ids = StringHandler.ArrayToString(shop_id);
		String goodsPictures = StringHandler.ArrayToString(goodsPicture);
		String goodsPrices = StringHandler.ArrayToString(goodsPrice);
		System.out.println(goodsNumbers);
		System.out.println(goodsIds);
		System.out.println(shop_ids);
		System.out.println(goodsPictures);
		System.out.println(goodsPrices);
		System.out.println(totalprice);
		request.setAttribute("goodsNumber", goodsNumbers);
		request.setAttribute("goodsId", goodsIds);
		request.setAttribute("shop_id", shop_ids);
		request.setAttribute("goodsPicture", goodsPictures);
		request.setAttribute("goodsPrices", goodsPrices);
		request.setAttribute("totalprice", totalprice);
		RequestDispatcher rd=request.getRequestDispatcher("order/orderAddress.jsp");
		rd.forward(request,response);
	}
	
	private void creatOrder(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String goodsId = (String)request.getParameter("goodsId");
		String goodsNumber = (String)request.getParameter("goodsNumber");
		String shopid = (String)request.getParameter("shopid");
		String goodsPrice = (String)request.getParameter("goodsPrices");
		String goodsPicture = (String)request.getParameter("goodsPicture");
		String totalprice = request.getParameter("totalprice");
		String account = new String(request.getParameter("account").getBytes("ISO-8859-1"), "gb2312");
		String address = new String(request.getParameter("address").getBytes("ISO-8859-1"), "gb2312");
		String telephone = request.getParameter("telephone");
		String remark = new String(request.getParameter("remark").getBytes("ISO-8859-1"), "gb2312");
		String time = StringHandler.timeTostr(new Date());
		System.out.println(goodsNumber);
		System.out.println(goodsId);
		System.out.println(shopid);
		System.out.println(goodsPicture);
		/*List goodsIds = StringHandler.StringToList(goodsId);
		List goodsNumbers = StringHandler.StringToList(goodsNumber);
		List shopids = StringHandler.StringToList(shopid);
		List goodsPictures = StringHandler.StringToList(goodsPicture);*/
		String[] goodsIds = goodsId.split(",");
		String[] goodsNumbers = goodsNumber.split(",");
		String[] shopids = shopid.split(",");
		String[] goodsPictures = goodsPicture.split(",");
		String[] goodsPrices = goodsPrice.split(",");
		OrderNumber numbers = new OrderNumber();
		String number = numbers.getOrderNum();
		String state = "2";
		for(int i=0;i<goodsIds.length;i++){
			orderDao = new OrderDao();
			Object[] params = {number,user_id,shopids[i],goodsIds[i],goodsPrices[i],goodsNumbers[i],goodsPictures[i],state,totalprice,time,account,address,telephone,remark};
			orderDao.addOrder(params);
		}
		String information = "添加订单";
		request.setAttribute("information", information);
		RequestDispatcher rd=request.getRequestDispatcher("information.jsp");
		rd.forward(request,response);
		/*for(int i=0;i<goodsIds.length;i++){
			int m = 0;
			a = new String[10];
			a[0] = goodsIds[i];
			System.out.println("第i个a[0]"+a[m]);
			for(int j=i+1;j<goodsIds.length;j++){
				System.out.println("商店号i"+shopids[i]);
				System.out.println("商店号j"+shopids[j]);
				if(shopids[i]==shopids[j]){
					m++;
					a[m] = goodsIds[j];
					System.out.println(a[m]);
					shopids[j]=shopids[j+1];
					goodsIds[j]=goodsIds[j+1];
				}
			}
			System.out.println(i+"个商店");
		}*/
/*		Iterator iter = goodsIds.iterator();
		while(iter.hasNext()){
			String a = (String)iter.next();
		}
			Iterator<Enemy> iterEnemy = this.nowBG.getAllEnemy().iterator();
			while (iterEnemy.hasNext()) {
				Enemy e = iterEnemy.next();
				g2.drawImage(e.getShowImage(), e.getX(), e.getY(), this);
			}
			*/
	}
	
	

/**	
	private void createorderform(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String buygoodsids = request.getParameter("buygoodsids");
		if(buygoodsids!=null&&!buygoodsids.equals("")){

				String forward = "";	
				String buygoodsnum = request.getParameter("buygoodsnum");		
				String account = request.getParameter("account");
				String address = request.getParameter("address");
				String telephone = request.getParameter("telephone");
				float totalprice = Float.parseFloat(request.getParameter("goodsprices"));
				String time=StringHandler.timeTostr(new Date());
				String status="1";			
				request.setAttribute("goodsprices",goodsprices);
				request.setAttribute("totalprices",totalprices);
				
				Object[] params={order_number,user_id,account,address,postalcode,linkphone,shipment,shipmenttime,payment,networkpayment,totalprices,time,status,buygoodsids,buygoodsnum};
				orderDao = new OrderDao();
				int i= orderDao.addOrder(params);
				if(i<=0){
					forward="/message.jsp";
					String message="<li>生成订单失败！</li>";
					message+="<a href='javascript:window.history.go(-1)'>返回</a>";
					request.setAttribute("message",message);
				}
				else{
					forward="/showOrderform.jsp";
					int orderformnumber=orderDao.getOrderformNumber(user_id, time);
					List buygoodslist = orderDao.getBuyGoodsToOrderform(orderformnumber);
					
					orderBean = new OrderBean();
					orderBean.setOrderformNumber(orderformnumber);
					orderBean.setOrderformWhoid(user_id);
					orderBean.setOrderformGetter(account);
					orderBean.setOrderformAddress(address);
					orderBean.setOrderformPostalcode(postalcode);
					orderBean.setOrderformLinkphone(linkphone);
					orderBean.setOrderformShipment(shipment);
					orderBean.setOrderformShipmenttime(shipmenttime);
					orderBean.setOrderformPayment(payment);
					orderBean.setOrderformNetworkpayment(networkpayment);
					orderBean.setOrderformTotalprices(totalprices);
					orderBean.setOrderformTime(time);
					orderBean.setOrderformStatus(status);
					orderBean.setOrderformBuyGoods(buygoodslist);
					request.setAttribute("orderform", orderform);
					
					// 修改商品库存量			
					String[] goodsids=buygoodsids.split(",");
					String[] goodsnum=buygoodsnum.split(",");
					GoodsDao goodsDao=new GoodsDao();
					for(int k=0;k<goodsids.length;k++)
						goodsDao.updateStoreNum(Integer.parseInt(goodsnum[k]),Integer.parseInt(goodsids[k]));
					goodsDao.closed();		
				}
				orderDao.closed();
				
				RequestDispatcher rd=request.getRequestDispatcher(forward);
				rd.forward(request,response);	
		}
		else{
			System.out.println("没有购买商品，不能生成订单！");
			RequestDispatcher rd=request.getRequestDispatcher("information.jsp");
			rd.forward(request,response);
		}
		
	}
	
*/	
	private boolean createorderform_validateBuyNum(HttpServletRequest request){
		boolean mark = true;
		String ids = request.getParameter("buygoodsids");
		String nums = request.getParameter("buygoodsnum");
		System.out.println(ids);
		System.out.println(nums);
		String[] goodsIds = ids.split(",");
		String[] buyNums = nums.split(",");
		System.out.println(goodsIds[1]);
		System.out.println(buyNums[0]);
		HashMap messages=new HashMap();
		GoodsDao goodsDao=new GoodsDao();
		for(int i=0;i<goodsIds.length;i++){
			int int_buyNum = Integer.parseInt(buyNums[i]);
			int int_goodsStoreNums = goodsDao.getGoodsBean(Integer.parseInt(goodsIds[i])).getGoods_stock(); 
			if(int_buyNum>int_goodsStoreNums){
				mark = false;
				messages.put(i,"⊥库存不足！");
			}
		}
		request.setAttribute("messages",messages);
		return mark;
	}
	

}
