<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- EL表达式 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function refreshValidate(){
   	    document.getElementById("ValidateCode").src="ValidateCodeServlet?"+Math.random();
   	}

	function checkEmpty(form){
		for(i=0;i<form.length;i++){
			if(form.elements[i].value==""){
				alert(form.elements[i].title);
				return false;
			}
		}
	}
	</script>

  </head>
  
  <body>
<c:if test="${empty sessionScope.shopkeeper }">
	<form name="form" method="post" action="ShopkeeperServlet?method=1" onSubmit="return checkEmpty(form)">
		<table width="231" border="0" align="center">
			<tr>
				<td width="53" height="25">登录名：</td>
				<td width="168" height="25"><input type="text" name="account" title="请输入登录用户名"></td>
			</tr>
			<tr>
				<td height="25">密&nbsp;&nbsp;码：</td>
				<td height="25"><input type="password" name="password" title="请输入登录密码"></td>
			</tr>
			<tr>
            	<td height="30" align="right">验证码：</td>
            	<td colspan="2"><img border=0 id="ValidateCode" src="ValidateCodeServlet" alt="无法显示"></td>
        	</tr>
        	<tr>
            	<td height="30" align="right">&nbsp; </td>
            	<td colspan="2"><a href="javascript:refreshValidate();">重新获得验证码</a></td>
        	</tr> 
        	<tr>
            	<td height="30" align="right">输入校验码：</td>
            	<td colspan="2"><input name="code" type="text" title="请输入验证码">&nbsp;*</td>
        	</tr>
			<tr>
				<td height="25" colspan="2" align="center">
					<input type="submit" value="登录">
					<input type="reset" value="重置">
				</td>
			</tr>
			<tr>
				<td height="15" colspan="2" align="center">
					<a href="shop/register.jsp" class="a2">没有注册？点此处注册</a>
					<br>
					<br>
					<a href="findPassword1.jsp" class="a2">如果密码丢失？请找回密码</a>
				</td>
			</tr>
		</table>
	</form> 
	
	<div align="center">
		${requestScope.information}
		<br>
		<br>
	</div>
</c:if>
	
<c:if test="${!empty sessionScope.shopkeeper }">
	<table width="230" border="0" align="center">
		<tr>
			<td height="20">用&nbsp;户&nbsp;名：</td>
			<td>  ${sessionScope.shopkeeper.account}  </td>
		</tr>
		<tr>
			<td height="20">联系邮箱：</td>
			<td>  ${sessionScope.shopkeeper.email}  </td>
		</tr>
		<tr>
			<td height="20">  &nbsp;  </td>
			<td>  <a href="ShopkeeperServlet?method=5" class="a2">注销</a>  </td>
		</tr>
	</table>
</c:if>
<a href="login.jsp">用户登录</a>
  </body>
</html>
