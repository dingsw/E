<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- EL���ʽ -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸���Ʒ��Ϣ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <c:if test="${!empty sessionScope.shopkeeper }">
	<form action="GoodsServlet?method=4&flag=1" method="post" >
	<input type="hidden" name="goodsId" value="${requestScope.goodsBean.id}"/>
	<table>
		<tr>
			<td>��Ʒ����</td>
			<td><input type="text" name="name" value="${requestScope.goodsBean.goods_name}" title="��������Ʒ������"/></td>
		</tr>
		<tr>
			<td>�۸�</td>
			<td><input type="text" name="price" value="${requestScope.goodsBean.goods_price}" title="�������޸ĵļ۸�"/></td>
		</tr>
		<tr>
			<td>ͼƬ</td>
			<td><input type="text" name="picture" value="${requestScope.goodsBean.goods_picture}" title="�������޸ĵ�ͼƬ"/></td>
		</tr>
		<tr>
			<td>�����</td>	
			<td><input type="text" name="stock" value="${requestScope.goodsBean.goods_stock}" title="�������޸ĵĿ����"/></td>
		</tr>
		<tr>
			<td>���</td>
			<td><input type="text" name="info" value="${requestScope.goodsBean.goods_info}" title="�������޸ĵļ��"/></td>
		</tr>
		<tr>
			<td>������</td>
			<td><input type="text" name="maker" value="${requestScope.goodsBean.goods_maker}" title="�������޸ĵ�������"/></td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="type" value="${requestScope.goodsBean.goods_type}" title="�������޸ĵ�����"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="�޸�"/></td>
		</tr>
	</table>
	</form>
  	</c:if> 
  	<c:if test="${empty sessionScope.shopkeeper }">
    	<a href='shop/login.jsp'>�̻���¼</a>
    	<a href='shop/register.jsp'>�̻�ע��</a>
  	</c:if>  
  </body>
</html>
