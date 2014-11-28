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
    
    <title>商户个人主页</title>
    
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
    <table width="230" border="0" align="center">
		<tr>
			<td>  欢迎${sessionScope.shopkeeper.account}登录  </td>
			<td>  <a href="UserServlet?method=5&type=2">注销</a>  </td>
		</tr>
	</table>
	  <a href="ShopServlet?method=2">我的商铺</a> 
  </c:if> 
  <c:if test="${empty sessionScope.shopkeeper }">
    <a href='shop/login.jsp'>商户登录</a>
    <a href='shop/register.jsp'>商户注册</a>
  </c:if>  
  </body>
</html>
