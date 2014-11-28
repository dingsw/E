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
    
    <title>�޸��̵���Ϣ</title>
    
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
	<form action="ShopServlet?method=3" method="post" >
	<table>
		<tr>
			<td>����</td>
			<td><input type="text" name="name" value="${requestScope.shopBean.name}" title="�������޸ĵĵ���"/></td>
		</tr>
		<tr>
			<td>ͼƬ</td>
			<td><input type="file" name="logo" value="���"/></td>
		</tr>
		<tr>
			<td>��Ӫ����</td>
			<td><input type="text" name="type" value="${requestScope.shopBean.type}" title="�������޸ĵľ�Ӫ����"/></td>
		</tr>
		<tr>
			<td>��ַ</td>	
			<td><input type="text" name="address" value="${requestScope.shopBean.address}" title="�������޸ĵĵ�ַ"/></td>
		</tr>
		<tr>
			<td>��ϵ�绰</td>
			<td><input type="text" name="telephone" value="${requestScope.shopBean.telephone}" title="�������޸ĵ���ϵ�绰"/></td>
		</tr>
		<tr>
			<td>֤��</td>
			<td><input type="text" name="card" value="${requestScope.shopBean.card}" title="�������޸ĵ�֤��"/></td>
		</tr>
		<tr>
			<td>���</td>
			<td><input type="text" name="info" value="${requestScope.shopBean.info}" title="�������޸ĵļ��"/></td>
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
