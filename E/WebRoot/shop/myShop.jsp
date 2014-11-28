<%@ page language="java" import="java.util.*,com.bean.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- JSTL标签库 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的商铺</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
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
  	 <%
    ShopKeeper shopkeeper = null;
    shopkeeper = new ShopKeeper();
    shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
    System.out.println("aa"+shopkeeper.getShop_id());
    if(shopkeeper.getShop_id()==0){
    	 System.out.println("没注册");
    %>  
  	<form name="form" method="post" action="ShopServlet?method=1" onSubmit="return checkEmpty(form)">
  		<table>
  			<tr>
  				<td>店名</td>
  				<td> <input name="name" type="text" title="请输入店名" /> </td>
  			</tr>
  			<tr>
  				<td>图片</td>
  				<td><input type="file" name="logo" value="浏览"/></td>
  			</tr>
  			<tr>
  				<td>经营类型</td>
  				<td> <input name="type" type="text" title="请输入经营类型" /> </td>
  			</tr>
  			<tr>
  				<td>地址</td>
  				<td> <input name="address" type="text" title="请输入地址" /> </td>
  			</tr>
  			<tr>
  				<td>联系电话</td>
  				<td> <input name="telephone" type="text" title="请输入联系电话" /> </td>
  			</tr>
  			<tr>
  				<td>证书</td>
  				<td> <input name="card" type="text" title="请输入证书" /> </td>
  			</tr>
  			<tr>
  				<td>简介</td>
  				<td> <input name="info" type="text" title="请输入简介" /> </td>
  			</tr>
  			<tr>
  				<td> <input type="submit" value="确定" /> </td>
  				<td> <input type="reset" value="重置" /> </td>
  			</tr>
  		</table> 
  	</form>
    <%
    }
    if(shopkeeper.getShop_id() != 0){
    	if((ShopBean)request.getAttribute("shopBean")==null){
    		response.sendRedirect("ShopServlet?method=2"); 
    		}
    	System.out.println("注册");
    %>
	<table>
		<tr>
			<td>${requestScope.shopBean.name}</td>
		</tr>
		<tr>
			<td><img src="upload/${requestScope.shopBean.logo}" width="90" height="75" style="border:0">${requestScope.shopBean.logo}</td>
		</tr>
		<tr>
			<td>${requestScope.shopBean.type}</td>
		</tr>
		<tr>
			<td>${requestScope.shopBean.address}</td>
		</tr>
		<tr>
			<td>${requestScope.shopBean.telephone}</td>
		</tr>
		<tr>
			<td>${requestScope.shopBean.card}</td>
		</tr>
		<tr>
			<td>${requestScope.shopBean.info}</td>
		</tr>
	</table>
	<%} %>
	
  </body>
</html>
