<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸��û�����</title>
    
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
		window.alert("�������û���¼���룡");
		return false;
	}
	if(form.newPassword.value==""){
		window.alert("�������û���¼���룡");
		return false;
	}
	if(form.newPassword.value.length < 3){
		window.alert("�û���¼���������3λ����");
		return false;
	} 
    if(form.newPassword2.value==""){
        window.alert("���ٴ������û���¼���룡");
        return false;
    }
    if(form.newPassword.value!=form.newPassword2.value){
        window.alert("��������������벻һ�£�");
        return false;
    }
    
    
}
</script>
  </head>
  
  <body>
    <form name="form" method="post" action="UserServlet?method=7" onSubmit="return checkForm(form)">
    	<table>
    		<tr>
    			<td>����������룺</td>
    			<td><input type="password" name="oldPassword"/></td>
    		</tr>
    		<tr>
    			<td>�����������룺</td>
    			<td><input type="password" name="newPassword"/></td>
    		</tr>
    		<tr>
    			<td>��ȷ�������룺</td>
    			<td><input type="password" name="newPassword2"/></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="����"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
