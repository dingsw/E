<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�����Ʒ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">
	function checkForm(form){
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
    <form name="form" method="post" action="file/InsertServlet" onSubmit="return checkForm(form)" enctype="multipart/form-data">
    	<table>
    		<tr>
    			<td>����</td>
    			<td><input name="goods_name" type="text" title="����������"/></td>
    		</tr>
    		<tr>
    			<td>����</td>
    			<td><input name="goods_type" type="text" title="����������"/></td>
    		</tr>
    		<tr>
    			<td>�۸�</td>
    			<td><input name="goods_price" type="text" title="������۸�"/></td>
    		</tr>
    		<tr>
    			<td>ͼƬ</td>
    			<td><input type="file" name="goods_picture" value="���" title="��ѡ��ͼƬ"/></td>
    		</tr>
    		<tr>
    			<td>���</td>
    			<td><input name="goods_stock" type="text" title="�������� "/></td>
    		</tr>
    		<tr>
    			<td>����</td>
    			<td><input name="goods_info" type="text" title="����������"/></td>
    		</tr>
    		<tr>
    			<td>������</td>
    			<td><input name="goods_maker" type="text" title="������������"/></td>
    		</tr>
    		<tr>
				<td height="25" colspan="2" align="center">
					<input type="submit" value="���">
					<input type="reset" value="����">
				</td>
			</tr>
    	</table>
    </form>
  </body>
</html>
