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
    
    <title>修改商品信息</title>
    
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
			<td>商品名字</td>
			<td><input type="text" name="name" value="${requestScope.goodsBean.goods_name}" title="请输入商品的名字"/></td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input type="text" name="price" value="${requestScope.goodsBean.goods_price}" title="请输入修改的价格"/></td>
		</tr>
		<tr>
			<td>图片</td>
			<td><input type="text" name="picture" value="${requestScope.goodsBean.goods_picture}" title="请输入修改的图片"/></td>
		</tr>
		<tr>
			<td>库存量</td>	
			<td><input type="text" name="stock" value="${requestScope.goodsBean.goods_stock}" title="请输入修改的库存量"/></td>
		</tr>
		<tr>
			<td>简介</td>
			<td><input type="text" name="info" value="${requestScope.goodsBean.goods_info}" title="请输入修改的简介"/></td>
		</tr>
		<tr>
			<td>制造商</td>
			<td><input type="text" name="maker" value="${requestScope.goodsBean.goods_maker}" title="请输入修改的制造商"/></td>
		</tr>
		<tr>
			<td>类型</td>
			<td><input type="text" name="type" value="${requestScope.goodsBean.goods_type}" title="请输入修改的类型"/></td>
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
