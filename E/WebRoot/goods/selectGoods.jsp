<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索商品</title>
    
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
    <form action="GoodsServlet?method=6" method="post">
    	<table>
    		<tr>
    			<td>商品类型</td>
    			<td><input type="text" name="type" value=""/></td>
    		</tr>
    		<tr>
    			<td>商品名称</td>
    			<td><input type="text" name="name" value=""/></td>
    		</tr>
    		<tr>
    			<td>商品价格</td>
    			<td><input type="text" name="price1" value=""/>-<input type="text" name="price2" value=""/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="查询"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
