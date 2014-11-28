package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ShopKeeper;
import com.dao.ShopkeeperDao;
import com.tools.Encrypt;

public class ShopkeeperServlet extends HttpServlet {
		
	private int method;
	private Encrypt encrypt;
	private ShopKeeper shopkeeper;
	private ShopkeeperDao shopkeeperDao;
//	private HttpSession session = null;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		method = Integer.parseInt(request.getParameter("method"));
		if(method==1){
			this.login(request,response);           //��¼
		}
		if(method==2){
			this.register(request, response);        //ע��
		}  
		if(method==3){
			this.findPassword1(request, response);   //�һ�����1
		}
		if(method==4){
			this.findPassword2(request, response);   //�һ�����2
		}
		if(method==5){
			this.loginOut(request, response);       //ע����¼
		}
		if(method==6){
			this.alterShopkeeper(request, response);   //�޸ĸ�����Ϣ
		}
		if(method==7){
			this.alterPassword(request, response);   //�޸�����
		}
		if(method==8){
			this.alterQuestion(request, response);   //�޸���֤����
		}
		if(method==9){
			this.alterQuestion2(request, response);   //�޸���֤����2
		}
	}
	
	/**
	 *  @��¼����
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String information = "";
		shopkeeperDao = new ShopkeeperDao();
		String rand = (String) request.getSession().getAttribute("rand");
		String code = (String) request.getParameter("code");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//�ж��ʺ��������Ƿ��зǷ��ַ���
		if (encrypt.isValidInput(account) && encrypt.isValidInput(password)) {
			account = new String(account.getBytes("ISO-8859-1"), "gb2312");
			password = encrypt.encodeMD5(password); //�������
		} else {
			information = "��������û���������ڷǷ��ַ���";
		}
		if (information.equals("")) {
			if (rand.equalsIgnoreCase(code)) {
				shopkeeper = shopkeeperDao.queryShopKeeper(account);
				if (null != shopkeeper) {
					if (shopkeeper.getPassword().equals(password)) {
						request.getSession().setAttribute("shopkeeper",
								shopkeeper);
					} else {
						information = "����������벻��ȷ";
					}
				} else {
					information = "��������û��������ڣ�";
				}
			} else {
				information = "���������֤�벻��ȷ��";
			}
		}
		if (information.equals("")) {
			out.println(information);
			request.setAttribute("information", information);
			request.getRequestDispatcher("shop/shopMain.jsp").forward(request, response);
		} else {
			out.print("<script>alert('"+ information + "');window.history.go(-1);</script>");
		}
	}
	
	
	/**
	 *  @ע�ᴫ��
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		shopkeeper = new ShopKeeper();
		shopkeeperDao = new ShopkeeperDao();
		String rand = (String) request.getSession().getAttribute("rand");
		String code = (String) request.getParameter("code");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (encrypt.isValidInput(account) && encrypt.isValidInput(password)) {
			account = new String(account.getBytes("ISO-8859-1"), "gb2312"); //������������
			password = encrypt.encodeMD5(password); //���������
		} else {
			information = "��������û���������ڷǷ��ַ���";
		}
		if (information.equals("")) {
			if (rand.equalsIgnoreCase(code)) {
				shopkeeper.setAccount(account);
				shopkeeper.setPassword(password);
				shopkeeper.setEmail(request.getParameter("email"));
				shopkeeper.setTelephone(request.getParameter("telephone"));
				//��ʽת�������֣������ݿ��в���д������
				shopkeeper.setSex(new String(request.getParameter("sex")
						.getBytes("ISO-8859-1"), "gb2312"));
				shopkeeper.setQuestion(new String(request.getParameter(
						"question").getBytes("ISO-8859-1"), "gb2312"));
				shopkeeper.setAnswer(new String(request
						.getParameter("answer").getBytes("ISO-8859-1"),
						"gb2312"));
				if (!shopkeeperDao.addShopkeeper(shopkeeper)) {
					information = "��������û����Ѿ����ڣ�";
				}
			} else {
				information = "���������֤�벻��ȷ��";
			}
			if (information.equals("")) {
				information = "��ע��ɹ���";
				request.setAttribute("information", information);
				request.getRequestDispatcher("shop/register.jsp").forward(request, response);
			} else {
				out.print("<script>alert('"+ information + "');window.history.go(-1);</script>");
			}
		} else {
			out.print("<script>alert('" + information+ "');window.history.go(-1);</script>");
		}
	}
	
	
	/**
	 *  @ע������
	 */
	public void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("homePage.jsp").forward(request, response);
	}
	
	/**
	 *  @�һ�����1����
	 */
	public void findPassword1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	/**
	 *  @�һ�����2����
	 */
	public void findPassword2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	/**
	 *  @�޸���Ϣ
	 */
	public void alterShopkeeper(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		int id = shopkeeper.getId();    
		String information = "";
		shopkeeper = new ShopKeeper();
		shopkeeperDao = new ShopkeeperDao();
		String account = request.getParameter("account");
		account = new String(account.getBytes("ISO-8859-1"), "gb2312");
		String sex = request.getParameter("sex");
		sex = new String(sex.getBytes("ISO-8859-1"), "gb2312");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		shopkeeper.setId(id);
		shopkeeper.setAccount(account);
		shopkeeper.setEmail(email);
		shopkeeper.setSex(sex);
		shopkeeper.setTelephone(telephone);
		if (shopkeeperDao.alterShopKeeper(shopkeeper)) {
			information = "������Ϣ�޸ĳɹ�";
			shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getId()); //�õ��޸ĺ��shopkeeper
			request.getSession().setAttribute("shopkeeper",shopkeeper);  //���޸ĺ��shopkeeper����session��	
		} else {
			information = "�����޸�ʧ��";
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	
	/**
	 *  @�޸�����
	 */
	public void alterPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		if ( encrypt.isValidInput(oldPassword)&&encrypt.isValidInput(newPassword)) {       //�ж��Ƿ��зǷ��ַ�
			oldPassword = encrypt.encodeMD5(oldPassword); //�������
			newPassword = encrypt.encodeMD5(newPassword); //�������
		} else {
			information = "�������������ڷǷ��ַ���";
		}
		if (information.equals("")) {
		//	shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getAccount());
			if (null != shopkeeper) {
				if (shopkeeper.getPassword().equals(oldPassword)) {
					shopkeeperDao.alterPassword(shopkeeper.getId(), newPassword);
					shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getId()); //�õ��޸ĺ��shopkeeper
					request.getSession().setAttribute("shopkeeper",shopkeeper);  //���޸ĺ��shopkeeper����session��
					information = "�����޸ĳɹ�";
				} else {
					information = "�������ԭ���벻��ȷ";
				}
			} 
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	
	/**
	 *  @�޸���֤����
	 */
	public void alterQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		String answer = request.getParameter("answer");
		answer = new String(answer.getBytes("ISO-8859-1"), "gb2312");
		if (answer.equals(shopkeeper.getAnswer())) {
			request.getRequestDispatcher("shop/alterQuestion2.jsp").forward(request, response);
		} else {
			information = "������Ĵ𰸲���ȷ";
			request.setAttribute("information", information);
			request.getRequestDispatcher("information.jsp").forward(request, response);
		}	
	}
	
	/**
	 *  @�޸���֤����2
	 */
	public void alterQuestion2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		String question = request.getParameter("question");
		question = new String(question.getBytes("ISO-8859-1"), "gb2312");
		String answer = request.getParameter("answer");
		answer = new String(answer.getBytes("ISO-8859-1"), "gb2312");
		if(shopkeeperDao.alterQuestion(question, answer, shopkeeper.getId())){
			shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getId());  //�õ��޸ĺ��shopkeeper
			request.getSession().setAttribute("shopkeeper",shopkeeper);   //���޸ĺ��shopkeeper����session��
			information = "�޸ĳɹ�";
		} else {
			information = "������Ĵ𰸲���ȷ";
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
}
