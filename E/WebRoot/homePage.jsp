<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- JSTL表达式 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
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
    <table width="230" border="0" align="center">
		<tr>
			<td>  欢迎${sessionScope.userBean.account}登录  </td>
			<td>  <a href="user/userMain.jsp">个人中心</a>  </td>
			<td>  <a href="UserServlet?method=5&type=1">注销</a>  </td>
		</tr>
	</table>
  </c:if> 
  <c:if test="${empty sessionScope.userBean }">
    <a href='login.jsp'>登录</a>
    <a href='register.jsp'>注册</a>
  </c:if>  
  <table width="790" border="0" cellpadding="0" cellspacing="0" bgcolor="white">
		<tr>
			<td align="center" width="190" height="49" valign="top">111<a href="#" target="_blank"><img border="0" src="images/left_lookcar.jpg" width="190"></a></td>
			<td align="center" width="600" valign="top" rowspan="2" bgcolor="white">
				222<iframe id="listgoods" src="GoodsServlet?method=2" width="100%" frameborder="0" scrolling="no"></iframe>
			</td>
		</tr>
		<tr>
			<td height="600" valign="top" background="images/left_bk.jpg">
				333<iframe id="listbrowsegoods" src="#" width="190" height="383" frameborder="0" scrolling="auto"></iframe>
			</td>
		</tr>
	</table>
</html>
