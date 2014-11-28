<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
    
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
    			<td>名称</td>
    			<td><input name="goods_name" type="text" title="请输入名称"/></td>
    		</tr>
    		<tr>
    			<td>类型</td>
    			<td><input name="goods_type" type="text" title="请输入类型"/></td>
    		</tr>
    		<tr>
    			<td>价格</td>
    			<td><input name="goods_price" type="text" title="请输入价格"/></td>
    		</tr>
    		<tr>
    			<td>图片</td>
    			<td><input type="file" name="goods_picture" value="浏览" title="请选择图片"/></td>
    		</tr>
    		<tr>
    			<td>库存</td>
    			<td><input name="goods_stock" type="text" title="请输入库存 "/></td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td><input name="goods_info" type="text" title="请输入描述"/></td>
    		</tr>
    		<tr>
    			<td>制造商</td>
    			<td><input name="goods_maker" type="text" title="请输入制造商"/></td>
    		</tr>
    		<tr>
				<td height="25" colspan="2" align="center">
					<input type="submit" value="添加">
					<input type="reset" value="重置">
				</td>
			</tr>
    	</table>
    </form>
  </body>
</html>
