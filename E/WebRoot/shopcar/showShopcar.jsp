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
    
    <title>显示购物车</title>
    
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
	<center>
   	<table border="0" cellpadding="0" cellspacing="0">
		<tr><td><img src="images/top.jpg" width="790" height="149"></td></tr>
	</table>
    <table width="790" border="0" cellpadding="0" cellspacing="0" rules="none" background="images/car_bk.jpg">
    	<tr height="45"><td colspan="6" background="images/car_t.jpg"></td></tr>
    	
    	<tr height="40" style="font-size:12">
    		<th width="10%">序号</th>
    		<th align="left">商品名称</th>
    		<th width="15%">价格</th>
    		<th width="15%">数量</th>
    		<th width="15%">小计</th>
    		<th width="10%">删除</th>
    	</tr>
    	<c:set var="myshopcar" value="${requestScope.shopcarBean}"/>
    	<c:if test="${(empty myshopcar) or (empty myshopcar.shopcarBuyGoods)}">
    	<tr height="80"><td colspan="6" align="center">您还没有挑选商品到购物车中。</td></tr>
    	</c:if>
    	<c:if test="${(!empty myshopcar) and (!empty myshopcar.shopcarBuyGoods)}">
    	<form action="OrderServlet?method=1" name="updateform" method="post">
    	<c:forEach var="buygoods" varStatus="bvs" items="${myshopcar.shopcarBuyGoods }">
   		<c:if test="${!empty buygoods}">
    	<input type="hidden" name="goodsid" value="${buygoods.id}">
    	<input type="hidden" name="goodsStock" value="${buygoods.goods_stock}">
    	<input type="hidden" name="goodsPicture" value="${buygoods.goods_picture}">
    	<input type="hidden" name="shop_id" value="${buygoods.shop_id}">
    	<input type="hidden" name="goodsPrice" value="${buygoods.goods_price}">
    	<tr height="30">
    		<td align="center">${bvs.count}</td>
    		<td>${buygoods.goods_name}</td>
    		<td align="center">￥${buygoods.goods_price}</td>
    		<td align="center">
    		<input type="text" name="goodsNumber" value="${buygoods.goods_num}" size="6" style="text-align:center;border:1 solid"><br>
    		<font color="red">${requestScope.messages[bvs.index]}</font>
    		</td>
    		<td align="center">￥${buygoods.goodsMoney}</td>
    		<td align="center"><a href="ShopcarServlet?method=3&goodsId=${buygoods.id}">删除</a></td>
    	</tr>
    	<c:set var="totalmoney" value="${requestScope.totalmoney+buygoods.goodsMoney}" scope="request"/>
   		</c:if>
    	</c:forEach>
    	<input type="hidden" name="goodsprices" value="<%=String.format("%.2f",request.getAttribute("totalmoney"))%>">
    	<tr height="40"><td colspan="6"><hr width="99%" color="black"></td></tr>
    	<tr height="20"><td colspan="6" style="padding-left:30">总金额：<input type="text" name="goodsprices" value="<%=String.format("%.2f",request.getAttribute("totalmoney"))%>" style="border:0" disabled></td></tr>
    	<tr height="50" valign="bottom">
    		<td colspan="3" style="padding-left:30">
    			<input type="submit" name="alter" value="修改数量" onclick="javascript:this.form.action='ShopcarServlet?method=5';">
    			<a href="ShopcarServlet?method=4">清空购物车</a>
    		</td>
    		<td colspan="3" align="center">
    			<%
    				Object userBean=session.getAttribute("userBean");
    				if(userBean==null||!(userBean instanceof com.bean.UserBean))
    					out.print("您未登录，不能进行");
    				else
    					out.println("您已经登录，可以进行");
    			%>
    			<input type="submit" value="商品结算" onclick="javascript:this.form.action='OrderServlet?method=1'">
    		</td>
    	</tr>
    	</form>
    	</c:if>
    	<tr height="40"><td colspan="6" align="center"><a href="javascript:window.close()">关闭</a></td></tr>
    </table>
    <a href="listMain.jsp" target="_blank">首页</a>
    <table border="0" cellpadding="0" cellspacing="0">
		<tr><td><img src="images/end.jpg" width="790" height="104"></td></tr>
	</table>
    </center>
  </c:if> 
  <c:if test="${empty sessionScope.userBean }">
    <a href='login.jsp'>登录</a>
    <a href='register.jsp'>注册</a>
  </c:if>  
    
  </body>
</html>
