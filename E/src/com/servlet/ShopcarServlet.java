package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.GoodsDao;
import com.dao.OrderDao;
import com.dao.ShopcarDao;
import com.bean.ShopcarBean;


public class ShopcarServlet extends HttpServlet {

	private int method;
	private UserBean userBean;
	private Integer user_id = null;
	private ShopcarBean shopcarBean = null;
	private ShopcarDao shopcarDao = null;

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
				this.addToShopcar(request, response);        //添加商品到购物车
			}
			if(method==2){
				this.showShopcar(request, response);         //显示购物车
			}
			if(method==3){
				this.deleteGoods(request, response);          //删除商品
			}
			if(method==4){
				this.clearShopcar(request, response);         //清空购物车
			} 
			if(method==5){
				this.alterGoodsNumber(request, response);      //修改数量
			}
			if(method==6){
				this.showBuyGoods(request, response);
			}
		}
	}
	/**
	 * @功能 添加商品到购物车
	 */
	public void addToShopcar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));     //得到要添加到购物车的商品的ID
		String message = null;          //提示信息
		if(goodsId==null){
			message="<li>商品ID值错误！</li>";
			message+="<a href='window.history.go(-1)'>返回</a>";
		}
		else{	
			try {					
				shopcarDao=new ShopcarDao();
				shopcarDao.isExistShopcar(user_id);      //不存在则创建购物车
				int i=-1;
				Object[] params={user_id,goodsId};
				if(shopcarDao.isExistGoods(params))				//如果已经购买了该商品
					i=shopcarDao.addBuyNum(params);			//更新商品购买数量+1，返回影响记录数					
				else{										//没有购买该商品
					params=new Object[]{user_id,goodsId,1};
					i=shopcarDao.addGoods(params);			//添加该商品到购物车(tb_shopcar数据表)中	，返回影响记录数		
				}
				shopcarDao.closed();
				if(i<=0)
					message="<li>添加商品到购物车失败！</li><br>";
				else
					message="<li>添加商品到购物车成功！</li><br>";
				message+="<a href='javascript:window.history.go(-1)'>返回</a>";
				message+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				message+="<a href='ShopcarServlet?method=2'>查看购物车<a/>";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}			
		request.setAttribute("information",message);
		RequestDispatcher rd=request.getRequestDispatcher("/information.jsp");
		rd.forward(request,response);	         //返回信息提示页面
	}
	/**
	 * @功能 显示商品
	 */
	public void showShopcar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(user_id!=null&&!user_id.equals("")){
			shopcarDao = new ShopcarDao();
			shopcarBean = shopcarDao.getShopcar(user_id);
			request.setAttribute("shopcarBean",shopcarBean);
		}
		RequestDispatcher rd=request.getRequestDispatcher("shopcar/showShopcar.jsp");
		rd.forward(request,response);
	}
	/**
	 * @功能 删除商品
	 */
	public void deleteGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
		if(user_id!=null&&!user_id.equals("")&&goodsId!=null){
			shopcarDao=new ShopcarDao();
			int i=shopcarDao.deleteGoods(user_id,goodsId);
			if(i<=0)
				request.setAttribute("message","●删除商品失败！");
			else
				request.setAttribute("message","●删除商品成功！");
			shopcarDao.closed();
		}
		showShopcar(request,response);   
	}
	/**
	 * @功能 清空购物车
	 */
	public void clearShopcar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		shopcarDao=new ShopcarDao();
		int i = shopcarDao.clear(user_id);
		if(i<=0)
			request.setAttribute("message","●清空购物车失败！");
		else
			request.setAttribute("message","●清空购物车成功！");
		shopcarDao.closed();
		RequestDispatcher rd = request.getRequestDispatcher("shopcar/showShopcar.jsp");
		rd.forward(request,response);
	}
	/**
	 * @功能 修改商品数量
	 */
	public void alterGoodsNumber(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String[] goodsStock=request.getParameterValues("goodsStock");   //获得每种商品的库存量
		String[] goodsNumber = request.getParameterValues("goodsNumber");          //获得每种商品填写的购买数量
		String[] goodsId = request.getParameterValues("goodsid");         //获得每种商品的id
		if(goodsId!=null&&goodsId.length!=0&&user_id!=null){
			Map messages = new HashMap();
			Object[] params = new Object[3];
			shopcarDao = new ShopcarDao();
			for(int i=0;i<goodsId.length;i++){        //购物车中商品的种类数（goodsIds.length）
				int int_goodsNumber = Integer.parseInt(goodsNumber[i]);
				int int_goodsStock = Integer.parseInt(goodsStock[i]); 
				int int_goodsId = Integer.parseInt(goodsId[i]);
				if(int_goodsNumber>int_goodsStock){
					messages.put(i,"⊥库存不足！");
				}
				else if(int_goodsNumber<=0)        //购买数量<=0时，删除此商品
					shopcarDao.deleteGoods(user_id, int_goodsId);
				else{
					params[0] = int_goodsNumber;
					params[1] = user_id;
					params[2] = goodsId[i];
					shopcarDao.updateGoodsNum(params);
					messages.put(i,"√修改成功！");
				}
			}
			request.setAttribute("messages",messages);
			shopcarDao.closed();
		}else{
			System.out.println("ShopcarServlet中alterGoodsNumber错误");
		}
		this.showShopcar(request, response);
	}
	
	/**
	 * @功能 查看已经买了的商品
	 */
	public void showBuyGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		OrderDao orderDao = new OrderDao(); 
	}

}
