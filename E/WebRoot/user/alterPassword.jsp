<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function checkForm(form){  
	if(form.oldPassword.value==""){
		window.alert("请输入用户登录密码！");
		return false;
	}
	if(form.newPassword.value==""){
		window.alert("请输入用户登录密码！");
		return false;
	}
	if(form.newPassword.value.length < 3){
		window.alert("用户登录密码必须在3位以上");
		return false;
	} 
    if(form.newPassword2.value==""){
        window.alert("请再次输入用户登录密码！");
        return false;
    }
    if(form.newPassword.value!=form.newPassword2.value){
        window.alert("您输入的两次密码不一致！");
        return false;
    }
    
    
}
</script>
  </head>
  
  <body>
    <form name="form" method="post" action="UserServlet?method=7" onSubmit="return checkForm(form)">
    	<table>
    		<tr>
    			<td>请输入旧密码：</td>
    			<td><input type="password" name="oldPassword"/></td>
    		</tr>
    		<tr>
    			<td>请输入新密码：</td>
    			<td><input type="password" name="newPassword"/></td>
    		</tr>
    		<tr>
    			<td>请确认新密码：</td>
    			<td><input type="password" name="newPassword2"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="保存"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
