<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��д��ַ</title>
    
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
    		<td>�ջ�������</td>
    		<td><input type="text" name="account" value="${sessionScope.userBean.account }" title="����д�ջ�������"/></td>
    	</tr>
    	<tr>
    		<td>�ͻ���ַ</td>
    		<td><input type="text" name="address" value="${sessionScope.userBean.address }" title="����д�ͻ���ַ"/></td>
    	</tr>
    	<tr>
    		<td>�ջ�����ϵ�绰</td>
    		<td><input type="text" name="telephone" value="${sessionScope.userBean.telephone }" title="����д��ϵ�绰"/></td>
    	</tr>
    	<tr>
    		<td>��ע</td>
    		<td><input type="text" name="remark" title="����д��ע"/></td>
    	</tr>
    	<tr>
    		<td>
    			<input type="submit" value="�ύ����">
				<input type="reset" value="����">
			</td>
    	</tr>
    	
    </table>
    </form>
  </body>
</html>
