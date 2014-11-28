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
		userBean = (UserBean)request.getSession().getAttribute("userBean");  //��ѯ��ǰ�û�
		user_id = userBean.getId();     //�õ������û���ID
		if(userBean==null){
			PrintWriter out = response.getWriter();
			out.println("<script>alert('����δ��¼�����¼��');window.location.href='login.jsp'</script>");
		} else {
			method = Integer.parseInt(request.getParameter("method"));
			if(method==1){
				this.addToShopcar(request, response);        //�����Ʒ�����ﳵ
			}
			if(method==2){
				this.showShopcar(request, response);         //��ʾ���ﳵ
			}
			if(method==3){
				this.deleteGoods(request, response);          //ɾ����Ʒ
			}
			if(method==4){
				this.clearShopcar(request, response);         //��չ��ﳵ
			} 
			if(method==5){
				this.alterGoodsNumber(request, response);      //�޸�����
			}
			if(method==6){
				this.showBuyGoods(request, response);
			}
		}
	}
	/**
	 * @���� �����Ʒ�����ﳵ
	 */
	public void addToShopcar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));     //�õ�Ҫ��ӵ����ﳵ����Ʒ��ID
		String message = null;          //��ʾ��Ϣ
		if(goodsId==null){
			message="<li>��ƷIDֵ����</li>";
			message+="<a href='window.history.go(-1)'>����</a>";
		}
		else{	
			try {					
				shopcarDao=new ShopcarDao();
				shopcarDao.isExistShopcar(user_id);      //�������򴴽����ﳵ
				int i=-1;
				Object[] params={user_id,goodsId};
				if(shopcarDao.isExistGoods(params))				//����Ѿ������˸���Ʒ
					i=shopcarDao.addBuyNum(params);			//������Ʒ��������+1������Ӱ���¼��					
				else{										//û�й������Ʒ
					params=new Object[]{user_id,goodsId,1};
					i=shopcarDao.addGoods(params);			//��Ӹ���Ʒ�����ﳵ(tb_shopcar���ݱ�)��	������Ӱ���¼��		
				}
				shopcarDao.closed();
				if(i<=0)
					message="<li>�����Ʒ�����ﳵʧ�ܣ�</li><br>";
				else
					message="<li>�����Ʒ�����ﳵ�ɹ���</li><br>";
				message+="<a href='javascript:window.history.go(-1)'>����</a>";
				message+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				message+="<a href='ShopcarServlet?method=2'>�鿴���ﳵ<a/>";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}			
		request.setAttribute("information",message);
		RequestDispatcher rd=request.getRequestDispatcher("/information.jsp");
		rd.forward(request,response);	         //������Ϣ��ʾҳ��
	}
	/**
	 * @���� ��ʾ��Ʒ
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
	 * @���� ɾ����Ʒ
	 */
	public void deleteGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
		if(user_id!=null&&!user_id.equals("")&&goodsId!=null){
			shopcarDao=new ShopcarDao();
			int i=shopcarDao.deleteGoods(user_id,goodsId);
			if(i<=0)
				request.setAttribute("message","��ɾ����Ʒʧ�ܣ�");
			else
				request.setAttribute("message","��ɾ����Ʒ�ɹ���");
			shopcarDao.closed();
		}
		showShopcar(request,response);   
	}
	/**
	 * @���� ��չ��ﳵ
	 */
	public void clearShopcar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		shopcarDao=new ShopcarDao();
		int i = shopcarDao.clear(user_id);
		if(i<=0)
			request.setAttribute("message","����չ��ﳵʧ�ܣ�");
		else
			request.setAttribute("message","����չ��ﳵ�ɹ���");
		shopcarDao.closed();
		RequestDispatcher rd = request.getRequestDispatcher("shopcar/showShopcar.jsp");
		rd.forward(request,response);
	}
	/**
	 * @���� �޸���Ʒ����
	 */
	public void alterGoodsNumber(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String[] goodsStock=request.getParameterValues("goodsStock");   //���ÿ����Ʒ�Ŀ����
		String[] goodsNumber = request.getParameterValues("goodsNumber");          //���ÿ����Ʒ��д�Ĺ�������
		String[] goodsId = request.getParameterValues("goodsid");         //���ÿ����Ʒ��id
		if(goodsId!=null&&goodsId.length!=0&&user_id!=null){
			Map messages = new HashMap();
			Object[] params = new Object[3];
			shopcarDao = new ShopcarDao();
			for(int i=0;i<goodsId.length;i++){        //���ﳵ����Ʒ����������goodsIds.length��
				int int_goodsNumber = Integer.parseInt(goodsNumber[i]);
				int int_goodsStock = Integer.parseInt(goodsStock[i]); 
				int int_goodsId = Integer.parseInt(goodsId[i]);
				if(int_goodsNumber>int_goodsStock){
					messages.put(i,"�Ϳ�治�㣡");
				}
				else if(int_goodsNumber<=0)        //��������<=0ʱ��ɾ������Ʒ
					shopcarDao.deleteGoods(user_id, int_goodsId);
				else{
					params[0] = int_goodsNumber;
					params[1] = user_id;
					params[2] = goodsId[i];
					shopcarDao.updateGoodsNum(params);
					messages.put(i,"���޸ĳɹ���");
				}
			}
			request.setAttribute("messages",messages);
			shopcarDao.closed();
		}else{
			System.out.println("ShopcarServlet��alterGoodsNumber����");
		}
		this.showShopcar(request, response);
	}
	
	/**
	 * @���� �鿴�Ѿ����˵���Ʒ
	 */
	public void showBuyGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		OrderDao orderDao = new OrderDao(); 
	}

}
