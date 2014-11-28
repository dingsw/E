<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>填写地址</title>
    
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
    <form action="OrderServlet?method=2" method="post" >
    <input type="text" name="goodsId" value="${requestScope.goodsId}">
    <input type="text" name="goodsNumber" value="${requestScope.goodsNumber}">
    <input type="text" name="goodsPicture" value="${requestScope.goodsPicture}">
    <input type="text" name="shopid" value="${requestScope.shop_id}">
    <input type="text" name="goodsPrices" value="${requestScope.goodsPrices}">
    <input type="text" name="totalprice" value="${requestScope.totalprice}">
    <table>
    	<tr>
    		<td>收货人姓名</td>
    		<td><input type="text" name="account" value="${sessionScope.userBean.account }" title="请填写收货人姓名"/></td>
    	</tr>
    	<tr>
    		<td>送货地址</td>
    		<td><input type="text" name="address" value="${sessionScope.userBean.address }" title="请填写送货地址"/></td>
    	</tr>
    	<tr>
    		<td>收货人联系电话</td>
    		<td><input type="text" name="telephone" value="${sessionScope.userBean.telephone }" title="请填写联系电话"/></td>
    	</tr>
    	<tr>
    		<td>备注</td>
    		<td><input type="text" name="remark" title="请填写备注"/></td>
    	</tr>
    	<tr>
    		<td>
    			<input type="submit" value="提交订单">
				<input type="reset" value="重置">
			</td>
    	</tr>
    	
    </table>
    </form>
  </body>
</html>
