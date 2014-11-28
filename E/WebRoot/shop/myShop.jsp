<%@ page language="java" import="java.util.*,com.bean.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- JSTL��ǩ�� -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ҵ�����</title>
    
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
    	 System.out.println("ûע��");
    %>  
  	<form name="form" method="post" action="ShopServlet?method=1" onSubmit="return checkEmpty(form)">
  		<table>
  			<tr>
  				<td>����</td>
  				<td> <input name="name" type="text" title="���������" /> </td>
  			</tr>
  			<tr>
  				<td>ͼƬ</td>
  				<td><input type="file" name="logo" value="���"/></td>
  			</tr>
  			<tr>
  				<td>��Ӫ����</td>
  				<td> <input name="type" type="text" title="�����뾭Ӫ����" /> </td>
  			</tr>
  			<tr>
  				<td>��ַ</td>
  				<td> <input name="address" type="text" title="�������ַ" /> </td>
  			</tr>
  			<tr>
  				<td>��ϵ�绰</td>
  				<td> <input name="telephone" type="text" title="��������ϵ�绰" /> </td>
  			</tr>
  			<tr>
  				<td>֤��</td>
  				<td> <input name="card" type="text" title="������֤��" /> </td>
  			</tr>
  			<tr>
  				<td>���</td>
  				<td> <input name="info" type="text" title="��������" /> </td>
  			</tr>
  			<tr>
  				<td> <input type="submit" value="ȷ��" /> </td>
  				<td> <input type="reset" value="����" /> </td>
  			</tr>
  		</table> 
  	</form>
    <%
    }
    if(shopkeeper.getShop_id() != 0){
    	if((ShopBean)request.getAttribute("shopBean")==null){
    		response.sendRedirect("ShopServlet?method=2"); 
    		}
    	System.out.println("ע��");
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
