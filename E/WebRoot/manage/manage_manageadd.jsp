<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>�ޱ����ĵ�</title>
</head>

<body>
<form name="userInfo" method="post" action="ManageServlet?method=manage_manageadd" onSubmit="return checkUserInfo(userInfo)">
	 <table width="442" height="257" border="0" align="center" cellpadding="1" cellspacing="1">
        <tr>
          <td width="128" height="30" align="right">�û�����</td>
          <td width="308"><input name="account" type="text" size="40" title="�������û���"></td>
        </tr>
        <tr>
          <td height="30" align="right">���룺</td>
          <td><input name="password" type="password" size="40" title="����������"></td>
        </tr>
        <tr>
          <td height="30">&nbsp;</td>
          <td><input type="submit" name="Submit" value="����">&nbsp;&nbsp;&nbsp;
            <input type="reset" name="Submit2" value="����">&nbsp;&nbsp;&nbsp;
            <input type="button" name="Submit3" value="����" onClick="javascript:window.location.href='manage_manageinfo.jsp'"></td>
        </tr>
        </table>
        </form>
</body>
</html>