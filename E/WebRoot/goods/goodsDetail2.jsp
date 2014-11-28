<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详细信息</title>
    
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
  商品信息
    ${requestScope.goodsBean.goods_name }
    ${requestScope.goodsBean.goods_type }
    ${requestScope.goodsBean.goods_price }
    ${requestScope.goodsBean.goods_picture}
    ${requestScope.goodsBean.goods_stock }
    ${requestScope.goodsBean.goods_info }
    ${requestScope.goodsBean.goods_maker }
    ${requestScope.goodsBean.goods_sales }
    ${requestScope.goodsBean.goods_time }
    ${requestScope.goodsBean.shop_id }
   
    <a href="GoodsServlet?method=5&goodsId=${requestScope.goodsBean.id }">修改商品信息</a>
    <a href="GoodsServlet?method=7&goodsId=${requestScope.goodsBean.id }">删除商品</a>
  </body>
</html>
