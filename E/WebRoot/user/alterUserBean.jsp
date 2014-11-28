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
    
    <title>修改用户信息</title>
    
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
    <c:if test="${!empty sessionScope.userBean }">
	<form action="UserServlet?method=6" method="post" >
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="account" value="${sessionScope.userBean.account}" title="请输入修改的用户名"/></td>
		</tr>
		<tr>
			<td>性别:</td>
			<c:set var="sex">${sessionScope.userBean.sex}</c:set>
		    <td> 
		    	<c:if test="${sex=='男'}">
		            <input type="radio" checked="checked" value='男' name="sex"/>男
		            <input type="radio" value='男' name="sex"/>女
	            </c:if>
	            <c:if test="${sex=='女'}">
		            <input type="radio"  value='男' name="sex"/>男
		            <input type="radio"  checked="checked" value='男' name="sex"/>女
	            </c:if>
		    </td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email" value="${sessionScope.userBean.email}" title="请输入修改的邮箱"/></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name="telephone" value="${sessionScope.userBean.telephone}" title="请输入修改的联系电话"/></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="address" value="${sessionScope.userBean.address}" title="请输入修改的地址"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="保存"/></td>
		</tr>
	</table>
	</form> 
  	</c:if> 
  	<c:if test="${empty sessionScope.userBean }">
    	<a href='login.jsp'>商户登录</a>
  	</c:if>  
  </body>
</html>
