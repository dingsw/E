<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>所有商品列表</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
		function autosize(){
			var tag=parent.document.getElementById("listgoods");
			tag.height=document.body.scrollHeight;	
		}
	</script>
  </head>  
  <body onload="autosize()">
  	<center>	
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
							<a href="GoodsServlet?method=3&goodsId=${onegoods.id}" target="_blank">
							<img src="upload/${onegoods.goods_picture}" width="90" height="75" style="border:0" title="单击查看商品详细信息" onclick="addbrowsegoods()">
							</a><br>
						   	</div>	
							商品名称：${onegoods.goods_name}<br>
							商品价格：${onegoods.goods_price}<br>	
							<a href="GoodsServlet?method=3&goodsId=${onegoods.id}" target="_blank">查看详细信息</a>
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
	</center>
  </body>
</html>