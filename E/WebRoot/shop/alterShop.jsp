<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- EL表达式 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改商店信息</title>
    
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
			<td>店名</td>
			<td><input type="text" name="name" value="${requestScope.shopBean.name}" title="请输入修改的店名"/></td>
		</tr>
		<tr>
			<td>图片</td>
			<td><input type="file" name="logo" value="浏览"/></td>
		</tr>
		<tr>
			<td>经营类型</td>
			<td><input type="text" name="type" value="${requestScope.shopBean.type}" title="请输入修改的经营类型"/></td>
		</tr>
		<tr>
			<td>地址</td>	
			<td><input type="text" name="address" value="${requestScope.shopBean.address}" title="请输入修改的地址"/></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name="telephone" value="${requestScope.shopBean.telephone}" title="请输入修改的联系电话"/></td>
		</tr>
		<tr>
			<td>证书</td>
			<td><input type="text" name="card" value="${requestScope.shopBean.card}" title="请输入修改的证书"/></td>
		</tr>
		<tr>
			<td>简介</td>
			<td><input type="text" name="info" value="${requestScope.shopBean.info}" title="请输入修改的简介"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="修改"/></td>
		</tr>
	</table>
	</form>
  	</c:if> 
  	<c:if test="${empty sessionScope.shopkeeper }">
    	<a href='shop/login.jsp'>商户登录</a>
    	<a href='shop/register.jsp'>商户注册</a>
  	</c:if>  
  </body>
</html>
