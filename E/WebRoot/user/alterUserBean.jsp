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
    
    <title>�޸��û���Ϣ</title>
    
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
			<td>����</td>
			<td><input type="text" name="account" value="${sessionScope.userBean.account}" title="�������޸ĵ��û���"/></td>
		</tr>
		<tr>
			<td>�Ա�:</td>
			<c:set var="sex">${sessionScope.userBean.sex}</c:set>
		    <td> 
		    	<c:if test="${sex=='��'}">
		            <input type="radio" checked="checked" value='��' name="sex"/>��
		            <input type="radio" value='��' name="sex"/>Ů
	            </c:if>
	            <c:if test="${sex=='Ů'}">
		            <input type="radio"  value='��' name="sex"/>��
		            <input type="radio"  checked="checked" value='��' name="sex"/>Ů
	            </c:if>
		    </td>
		</tr>
		<tr>
			<td>����</td>
			<td><input type="text" name="email" value="${sessionScope.userBean.email}" title="�������޸ĵ�����"/></td>
		</tr>
		<tr>
			<td>��ϵ�绰</td>
			<td><input type="text" name="telephone" value="${sessionScope.userBean.telephone}" title="�������޸ĵ���ϵ�绰"/></td>
		</tr>
		<tr>
			<td>��ַ</td>
			<td><input type="text" name="address" value="${sessionScope.userBean.address}" title="�������޸ĵĵ�ַ"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="����"/></td>
		</tr>
	</table>
	</form> 
  	</c:if> 
  	<c:if test="${empty sessionScope.userBean }">
    	<a href='login.jsp'>�̻���¼</a>
  	</c:if>  
  </body>
</html>
