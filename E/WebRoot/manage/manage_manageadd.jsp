<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>无标题文档</title>
</head>

<body>
<form name="userInfo" method="post" action="ManageServlet?method=manage_manageadd" onSubmit="return checkUserInfo(userInfo)">
	 <table width="442" height="257" border="0" align="center" cellpadding="1" cellspacing="1">
        <tr>
          <td width="128" height="30" align="right">用户名：</td>
          <td width="308"><input name="account" type="text" size="40" title="请输入用户名"></td>
        </tr>
        <tr>
          <td height="30" align="right">密码：</td>
          <td><input name="password" type="password" size="40" title="请输入密码"></td>
        </tr>
        <tr>
          <td height="30">&nbsp;</td>
          <td><input type="submit" name="Submit" value="保存">&nbsp;&nbsp;&nbsp;
            <input type="reset" name="Submit2" value="重置">&nbsp;&nbsp;&nbsp;
            <input type="button" name="Submit3" value="返回" onClick="javascript:window.location.href='manage_manageinfo.jsp'"></td>
        </tr>
        </table>
        </form>
</body>
</html>