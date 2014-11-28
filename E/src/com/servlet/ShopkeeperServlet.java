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
			this.login(request,response);           //登录
		}
		if(method==2){
			this.register(request, response);        //注册
		}  
		if(method==3){
			this.findPassword1(request, response);   //找回密码1
		}
		if(method==4){
			this.findPassword2(request, response);   //找回密码2
		}
		if(method==5){
			this.loginOut(request, response);       //注销登录
		}
		if(method==6){
			this.alterShopkeeper(request, response);   //修改个人信息
		}
		if(method==7){
			this.alterPassword(request, response);   //修改密码
		}
		if(method==8){
			this.alterQuestion(request, response);   //修改验证问题
		}
		if(method==9){
			this.alterQuestion2(request, response);   //修改验证问题2
		}
	}
	
	/**
	 *  @登录传参
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
		//判断帐号密码中是否有非法字符串
		if (encrypt.isValidInput(account) && encrypt.isValidInput(password)) {
			account = new String(account.getBytes("ISO-8859-1"), "gb2312");
			password = encrypt.encodeMD5(password); //密码加密
		} else {
			information = "您输入的用户或密码存在非法字符串";
		}
		if (information.equals("")) {
			if (rand.equalsIgnoreCase(code)) {
				shopkeeper = shopkeeperDao.queryShopKeeper(account);
				if (null != shopkeeper) {
					if (shopkeeper.getPassword().equals(password)) {
						request.getSession().setAttribute("shopkeeper",
								shopkeeper);
					} else {
						information = "您输入的密码不正确";
					}
				} else {
					information = "您输入的用户名不存在！";
				}
			} else {
				information = "您输入的验证码不正确！";
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
	 *  @注册传参
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
			account = new String(account.getBytes("ISO-8859-1"), "gb2312"); //消除汉字乱码
			password = encrypt.encodeMD5(password); //将密码加密
		} else {
			information = "您输入的用户或密码存在非法字符串";
		}
		if (information.equals("")) {
			if (rand.equalsIgnoreCase(code)) {
				shopkeeper.setAccount(account);
				shopkeeper.setPassword(password);
				shopkeeper.setEmail(request.getParameter("email"));
				shopkeeper.setTelephone(request.getParameter("telephone"));
				//格式转换（汉字），数据库中不会写入乱码
				shopkeeper.setSex(new String(request.getParameter("sex")
						.getBytes("ISO-8859-1"), "gb2312"));
				shopkeeper.setQuestion(new String(request.getParameter(
						"question").getBytes("ISO-8859-1"), "gb2312"));
				shopkeeper.setAnswer(new String(request
						.getParameter("answer").getBytes("ISO-8859-1"),
						"gb2312"));
				if (!shopkeeperDao.addShopkeeper(shopkeeper)) {
					information = "您输入的用户名已经存在！";
				}
			} else {
				information = "您输入的验证码不正确！";
			}
			if (information.equals("")) {
				information = "您注册成功！";
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
	 *  @注销传参
	 */
	public void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("homePage.jsp").forward(request, response);
	}
	
	/**
	 *  @找回密码1传参
	 */
	public void findPassword1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	/**
	 *  @找回密码2传参
	 */
	public void findPassword2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	/**
	 *  @修改信息
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
			information = "个人信息修改成功";
			shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getId()); //得到修改后的shopkeeper
			request.getSession().setAttribute("shopkeeper",shopkeeper);  //将修改后的shopkeeper放入session中	
		} else {
			information = "个人修改失败";
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	
	/**
	 *  @修改密码
	 */
	public void alterPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String information = "";
		shopkeeper = new ShopKeeper();
		shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		if ( encrypt.isValidInput(oldPassword)&&encrypt.isValidInput(newPassword)) {       //判断是否有非法字符
			oldPassword = encrypt.encodeMD5(oldPassword); //密码加密
			newPassword = encrypt.encodeMD5(newPassword); //密码加密
		} else {
			information = "您输入的密码存在非法字符串";
		}
		if (information.equals("")) {
		//	shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getAccount());
			if (null != shopkeeper) {
				if (shopkeeper.getPassword().equals(oldPassword)) {
					shopkeeperDao.alterPassword(shopkeeper.getId(), newPassword);
					shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getId()); //得到修改后的shopkeeper
					request.getSession().setAttribute("shopkeeper",shopkeeper);  //将修改后的shopkeeper放入session中
					information = "密码修改成功";
				} else {
					information = "您输入的原密码不正确";
				}
			} 
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
	
	/**
	 *  @修改验证问题
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
			information = "您输入的答案不正确";
			request.setAttribute("information", information);
			request.getRequestDispatcher("information.jsp").forward(request, response);
		}	
	}
	
	/**
	 *  @修改验证问题2
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
			shopkeeper = shopkeeperDao.queryShopKeeper(shopkeeper.getId());  //得到修改后的shopkeeper
			request.getSession().setAttribute("shopkeeper",shopkeeper);   //将修改后的shopkeeper放入session中
			information = "修改成功";
		} else {
			information = "您输入的答案不正确";
		}
		request.setAttribute("information", information);
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}
}
