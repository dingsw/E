<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>无标题文档</title>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
         <tr>
         	<td bgcolor="#FFFFFF" colspan="10" valign="middle">
         		<div>
         		<br/>
        	   <blockquote>
         		     <fieldset style="height:100%;">
				<legend><b>用户信息</b></legend><br/>
				<form name="manage_userInfo" method="post"  >
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    <c:forEach items='${requestScope.list}' var="gb">
				        <c:if test="${!empty gb}">
					   <tr>
					    <td><input type="text" name="account" value="${gb.id}" /></td>
					    <td><input type="text" name="account" value="${gb.account}" /></td>
					    <td><input type="text" name="account" value="${gb.password}" /></td>
					    <td><input type="text" name="account" value="${gb.sex}" /></td>
					    <td><input type="text" name="account" value="${gb.email}" /></td>
					    <td><input type="text" name="account" value="${gb.telephone}" /></td>  
					    <td><input type="text" name="account" value="${gb.address}" /></td>
					    <td><input type="text" name="account" value="${gb.question}" /></td>
					    <td><input type="text" name="account" value="${gb.answer}" /></td>
					    <td height="34" align="left"><a href="ManageServlet?method=manage_userdelete&id=${gb.id}" >删除</a></td>
					    </tr>
					    </c:if>
				        </c:forEach>
				        <tr><td colspan="4">${requestScope.pageBar.pageLink}</td></tr>
					  </table>
				</form>
			 <br />
				</fieldset>
       		     </blockquote>
         		</div>         	</td>
         </tr>
        </table>
</body>
</html>
