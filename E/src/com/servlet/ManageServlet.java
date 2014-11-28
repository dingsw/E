package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDao;
import com.dao.ManageDao;
import com.bean.Manage;
import com.bean.ShopBean;
import com.bean.UserBean;
import com.bean.ShopKeeper;

public class ManageServlet extends HttpServlet {
	private String method = "";
	private String id     = ""  ;
	private Manage manage = null;
	private ManageDao dao = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = request.getParameter("method");
		if (method.equals("manage_manageCheck")) {// ����Ա��¼
			this.manage_manageCheck(request, response);
		}
		if (method.equals("manage_userinfo")) {// �û���Ϣ��ѯ����(�û�list)
			this.manage_userinfo(request, response);
		}
		if (method.equals("manage_shopkeeperdelete")) {// �̼���Ϣɾ������
			this.manage_shopkeeperdelete(request, response);
		}
		if (method.equals("manage_userdelete")) {// �û���Ϣɾ������
			this.manage_userdelete(request, response);
		}
		if (method.equals("manage_shopdelete")) {// �̵�ɾ������
			this.manage_shopdelete(request, response);
		}
		if (method.equals("manage_managedelete")) {// ����Աɾ������
			this.manage_managedelete(request, response);
		}
		if (method.equals("manage_shopkeeper")) {// �̼���Ϣ��ѯ����
			this.manage_shopkeeper(request, response);
		}
		if (method.equals("manage_shop")) {// �̵���Ϣ��ѯ����
			this.manage_shop(request, response);
		}
		if (method.equals("manage_manageinfo")) {// ����Ա��Ϣ��ѯ����
			this.manage_manageinfo(request, response);
		}
		if (method.equals("manage_manageadd")) {// ����Ա��Ӳ���
			this.manage_manageadd(request, response);
		}

	}
	//����Ա��¼
	private void manage_manageCheck(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dao = new ManageDao();
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("text/html");
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		String account= request.getParameter("account");
		String password = request.getParameter("password");
		String result = "";
		Manage manageInfo =dao.manage_queryObject(account);
			if(flag == 0){
				if (manageInfo == null) 
					result = "��������û���������<br>�û���¼ʧ�ܣ�";
				    
				  else {
					if (!password.equals(manageInfo.getPassword())) {
						result = "���������������<br>�û���¼ʧ�ܣ�";
						
						}
					}
			} 
		if (result.equals("")) {
			if(flag == 0){
				request.getSession().setAttribute("manageInfo", manageInfo);
				request.getRequestDispatcher("main.jsp")
				.forward(request, response);
				}
		} else {
			request.setAttribute("result", result);
			request.getRequestDispatcher("login.jsp")
			.forward(request, response);
		}

	}
	//����Ա���
	private void manage_manageadd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dao = new ManageDao();
		manage = new Manage();
		manage.setAccount(request.getParameter("account"));
		manage.setPassword(request.getParameter("password"));
		dao.Manage_manageadd(manage);
		this.manage_manageinfo(request, response);
			
	}
	// ����Ա��Ϣ��ѯ����
	private void manage_manageinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	    dao =new ManageDao();
		List<Manage> list = dao.Manage_managequeryObject();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("manage_manageinfo.jsp")
				.forward(request, response);
		
	}
	// �̵���Ϣ��ѯ����
	private void manage_shop(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	    dao =new ManageDao();
		List<ShopBean> list = dao.Manage_shopqueryObject();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("manage_shop.jsp")
				.forward(request, response);
	
    }
	// �̼���Ϣ��ѯ����
	private void manage_shopkeeper(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		List list = new ArrayList();
		try {
			dao =new ManageDao();
			String currentPage=request.getParameter("currentP");    //��õ�ǰҳ��
			String currentGroup=request.getParameter("currentG");    //��õ�ǰ���
			System.out.println("��ǰҳ��"+currentPage);
				url = "ManageServlet?method=manage_userinfo";
				list = dao.getPartGoods(currentPage,currentGroup,url);
			//userlist���ǵ�ǰҳ3����Ʒ�ļ���
			request.setAttribute("list",list);
			request.setAttribute("pageBar",dao.getPageBar());   //����	
			dao.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			request.getRequestDispatcher("manage_shopkeeper.jsp")
					.forward(request, response);
		
	}
	// �û���Ϣ��ѯ����
	private  void manage_userinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String url = null;
			List list = new ArrayList();
			try {
				dao =new ManageDao();
				String currentPage=request.getParameter("currentP");    //��õ�ǰҳ��
				String currentGroup=request.getParameter("currentG");    //��õ�ǰ���
				System.out.println("��ǰҳ��"+currentPage);
					url = "ManageServlet?method=manage_userinfo";
					list = dao.getPartGoods(currentPage,currentGroup,url);
				//userlist���ǵ�ǰҳ3����Ʒ�ļ���
				request.setAttribute("list",list);
				request.setAttribute("pageBar",dao.getPageBar());   //����	
				dao.closed();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("manage_userinfo.jsp")
			.forward(request, response);
	}
	// �̼���Ϣɾ������
	private void manage_shopkeeperdelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		dao = new ManageDao();
		id  = request.getParameter("id");
		dao.manage_shopkeeperdelete(id);
		this.manage_shopkeeper(request, response);
		
		
	}
	// �û���Ϣɾ������
	private void manage_userdelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		dao = new ManageDao();
		id  = request.getParameter("id");
		dao.manage_userdelete(id);
		System.out.println(id);
		this.manage_userinfo(request, response);
		
	}
	// �̵�ɾ������
	private void manage_shopdelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		dao = new ManageDao();
		id  = request.getParameter("id");
		dao.manage_shopdelete(id);
		this.manage_shop(request, response);
		
	}
	private void manage_managedelete(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {
		
		dao = new ManageDao();
		id  = request.getParameter("id");
		dao.manage_managedelete(id);
		this.manage_manageinfo(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
