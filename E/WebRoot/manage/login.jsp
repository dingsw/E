 <%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	      <table width="195" height="27" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/4.jpg" width="195" height="47"></td>
        </tr>
      </table>  
	
	
	<form name="form2" method="post" action="ManageServlet?method=manage_manageCheck" onSubmit="return checkUserInfo(form2)">
	<table width="195" border="0" align="center" cellpadding="0" cellspacing="0" background="images/6.jpg">
	 <tr>
        <td width="75" height="25" align="center"><div align="right">类&nbsp;&nbsp;别：</div></td>
        <td width="120">
         <select size="1" name="flag" style="width:122 ">
                
                <option value="0" >系统管理员</option>
                
                <option value="1" >会员登录</option>
                
                <option value="2" >商家登录</option>
 
              </select>
        </td>
      </tr>
	  <tr>
        <td width="75" height="25" align="center"><div align="right">用户名：</div></td>
        <td width="120">
          <input type="text" name="account" size="15" title="请输入用户名！" >
        </td>
      </tr>
      <tr>
        <td height="25" align="center"><div align="right">密&nbsp;&nbsp;码：</div></td>
        <td><input type="password" name="password" title="请输入密码！" size="15"></td>
      </tr>
	      <tr>
        <td height="40" colspan="2">
          <div align="center">
  <input type="submit" name="Submit2" value="登录">
          </div></td>
      </tr>
	  	
    </table>
    </form> 	
	<center>
	    ${requestScope.result}
	</center>
	  
