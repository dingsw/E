<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>������Ʒ�б�</title>
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
				<%--�õ�goodslist���ϣ�3��Ԫ�أ�ÿ��Ԫ����4����Ʒ���󣬾����ά���飩������Ϊallgoodslist--%>
				<c:set var="allgoodslist" value="${requestScope.goodslist}"/>
				<c:if test="${empty allgoodslist}">û����Ʒ</c:if>
				<c:if test="${!empty allgoodslist}">
				<table width="99%" border="0" cellspacing="5" cellpadding="5">
					<%-- ����allgoodslist���ϣ�����Ԫ������Ϊonegoodslist����4����Ʒ����--%>
					<c:forEach var="onegoodslist" items="${allgoodslist}">
					<tr>
						<%--���� onegoodslist���ϣ���4��Ԫ�أ���������ÿ��Ԫ����һ����Ʒ������ʱ����Ϊonegoods--%>
						<c:forEach var="onegoods" items="${onegoodslist}">
						<td>
							<c:if test="${!empty onegoods}">
							<div style="background:url(images/goods/goodsbk.jpg);width:123;height:126;padding-left:12;padding-top:20">
							<a href="GoodsServlet?method=3&goodsId=${onegoods.id}" target="_blank">
							<img src="upload/${onegoods.goods_picture}" width="90" height="75" style="border:0" title="�����鿴��Ʒ��ϸ��Ϣ" onclick="addbrowsegoods()">
							</a><br>
						   	</div>	
							��Ʒ���ƣ�${onegoods.goods_name}<br>
							��Ʒ�۸�${onegoods.goods_price}<br>	
							<a href="GoodsServlet?method=3&goodsId=${onegoods.id}" target="_blank">�鿴��ϸ��Ϣ</a>
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