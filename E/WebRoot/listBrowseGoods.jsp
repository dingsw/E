<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
		function autosize(){
			var tag=parent.document.getElementById("listbrowsegoods");
			tag.height=document.body.scrollHeight;
		}
	</script>
  </head>  
  <body onload="autosize()" style="margin-top:0">aaa
  	<center>	
	<table border="0" cellspacing="0" cellpadding="0" background="images/left_bk.jpg">
		<tr><td colspan="2"><img src="images/left_m.jpg"></td></tr>
		<c:set var="allbrowsegoods" value="${requestScope.browsegoodslist}"/>
		<c:if test="${!empty allbrowsegoods}">
		<c:forEach var="onebrowsegoods" items="${allbrowsegoods}">
		<tr height="25"><td colspan="2" style="padding-left:15">${onebrowsegoods["browsename"]}</td>
		<tr height="60">
			<td style="padding-left:15" align="center" width="20"><a href="viewgoods?goodId=${onebrowsegoods['browseid']}" target="_blank"><img src="images/goods/${onebrowsegoods['browseviewpic']}" width="50" height="45" style="border:1 solid;border-color:black" title="�����鿴��Ʒ��ϸ��Ϣ"></a></td>
			<td style="padding-left:15;color:gray" valign="bottom">���ʱ�䣺<br>${onebrowsegoods["browsetime"]}</td>
		</tr>
		<tr><td colspan="2"><hr color="black"></td></tr>
		</c:forEach>
		<tr><td align="right" colspan="2"><a href="clearbrowse">������������Ʒ</a>&nbsp;&nbsp;</td></tr>
		</c:if>
	</table>			
	</center>
 </body>
</html>