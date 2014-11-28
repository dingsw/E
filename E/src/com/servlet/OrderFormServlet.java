package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderFormDao;
import com.bean.OrderBean;
import com.bean.UserBean;

public class OrderFormServlet extends HttpServlet {
	private OrderFormDao dao        = null;
	private String method       = ""  ;
	private String order_state  = ""  ;
	private String order_id     = ""  ;
	private UserBean userInfo   = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = request.getParameter("method");
		
		if (method.equals("Orderdelete")) {// 订单删除操作
			this.Orderdelete(request, response);
		}
		if (method.equals("order_queryObject_success")) {// 完成订单显示操作
			this.order_queryObject_success(request, response);
		}
		if (method.equals("order_queryObject_notfinal")) {// 未完成订单显示操作
			this.order_queryObject_notfinal(request, response);
		}
		if (method.equals("order_queryObject_cancel")) {// 取消订单显示操作
			this.order_queryObject_cancel(request, response);
		}
		
	}
	// 取消订单显示操作
	private void order_queryObject_cancel(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dao =new OrderFormDao();
		userInfo =(UserBean)request.getSession().getAttribute("userBean");
		int user_id =userInfo.getId();
		String account = userInfo.getAccount();
		if(account!=null){
			List<OrderBean> list = dao.order_queryObject(user_id);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("shopcar/order_cancel.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("shopcar/order_cancel.jsp").forward(request,
					response);
		}
	}
	// 未完成订单显示操作
	private void order_queryObject_notfinal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dao =new OrderFormDao();
		userInfo =(UserBean)request.getSession().getAttribute("userBean");
		int user_id =userInfo.getId();
		String account = userInfo.getAccount();
		if(account!=null){
			List<OrderBean> list = dao.order_queryObject(user_id);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("shopcar/order_notfinal.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("shopcar/order_notfinal.jsp").forward(request,
					response);
		}
		
	}
	// 完成订单显示操作
	private void order_queryObject_success(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dao =new OrderFormDao();
		userInfo =(UserBean)request.getSession().getAttribute("userBean");
		int user_id =userInfo.getId();
		String account = userInfo.getAccount();
		if(account!=null){
			List<OrderBean> list = dao.order_queryObject(user_id);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("shopcar/order_success.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("shopcar/order_success.jsp").forward(request,
					response);
		}
    }
	// 订单删除操作
	private void Orderdelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao = new OrderFormDao();
		String result = "查找信息失败";
		userInfo =(UserBean)request.getSession().getAttribute("userBean");
		int id =userInfo.getId();
		order_id     = request.getParameter("order_id");
		order_state  = request.getParameter("order_state");
		String account = userInfo.getAccount();
		if(account!=null){
			if (dao.order_delete(order_id,order_state)) {
				result = "";
			} else {
				result = "您输入用户名重复<br>注册失败!";
			}
		}
			if (result.equals("")) {
				List<OrderBean> list = dao.order_queryObject(id);
				request.setAttribute("list", list);
				int s = Integer.valueOf(order_state).intValue();
				if(s== 2){
					this.order_queryObject_success(request,response);
				}
				if(s==1){
					this.order_queryObject_notfinal(request,response);
				} 
				if(s==0){
					this.order_queryObject_cancel(request,response);
				}
				
			} else {
				request.setAttribute("result", result);
				request.getRequestDispatcher("order_success.jsp").forward(request,response);
			}
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doGet(request, response);
}

	
}
