<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸���֤����</title>
    
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
	if(form.answer.value==""){
		window.alert("��������ʾ�𰸣�");
		return false;
	}
    if(form.answer.value!=${sessionScope.userBean.answer}){
        window.alert("������Ĵ𰸲���ȷ��");
        return false;
    }   
}
</script>
  </head>
  
  <body>
    <form name="form" method="post" action="UserServlet?method=8" onSubmit="return checkForm(form)">
    	<table>
    		<tr>
                <td height="30" align="right">������ʾ���⣺</td>
                <td colspan="2">
                    ${sessionScope.userBean.question }</td>
            </tr>
            <tr>
                <td height="30" align="right">��ʾ����𰸣�</td>
                <td colspan="2">
                    <input name="answer" type="text" size="60"> </td>
            </tr>
            <tr>
            	<td><input type="submit" value="ȷ��"/></td>
            </tr>
    	</table>
    </form>
  </body>
</html>