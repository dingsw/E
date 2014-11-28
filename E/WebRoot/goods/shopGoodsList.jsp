<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>店铺商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function autosize(){
		var tag=parent.document.getElementById("listgoods");
		tag.height=document.body.scrollHeight;	
	}
</script>
  </head> 
   
  <body onload="autosize()">
    <table border="0" width="100%" style="word-break:break-all">
		<tr height="30">
			<td align="center" valign="top">
				<%--得到goodslist集合（3个元素，每个元素有4个商品对象，就像二维数组），命名为allgoodslist--%>
				<c:set var="allgoodslist" value="${requestScope.goodslist}"/>
				<c:if test="${empty allgoodslist}">没有商品</c:if>
				<c:if test="${!empty allgoodslist}">
				<table width="99%" border="0" cellspacing="5" cellpadding="5">
					<%-- 遍历allgoodslist集合，单个元素命名为onegoodslist（含4个商品对象）--%>
					<c:forEach var="onegoodslist" items="${allgoodslist}">
					<tr>
						<%--遍历 onegoodslist集合（含4个元素），集合中每个元素是一个商品对象，临时命名为onegoods--%>
						<c:forEach var="onegoods" items="${onegoodslist}">
						<td>
							<c:if test="${!empty onegoods}">
							<div style="background:url(images/goods/goodsbk.jpg);width:123;height:126;padding-left:12;padding-top:20">
							<a href="GoodsServlet?method=3&goodsId=${onegoods.id}&flag=1" >
							<img src="upload/${onegoods.goods_picture}" width="90" height="75" style="border:0" title="单击查看商品详细信息" onclick="addbrowsegoods()">
							</a><br>
						   	</div>	
							商品名称：${onegoods.goods_name}<br>
							商品价格：${onegoods.goods_price}<br>	
							<a href="GoodsServlet?method=3&goodsId=${onegoods.id}&flag=1">查看详细信息</a>
							</c:if>	
						</td>
						</c:forEach>
					</tr>
					<tr>
						<td colspan="4"><hr color="black"></td>
					</tr>
					</c:forEach>
					<tr><td colspan="4">${requestScope.pageBar.pageLink}</td></tr>
				</table>
				</c:if>			
			</td>
		</tr>		
	</table>
  </body>
</html>
