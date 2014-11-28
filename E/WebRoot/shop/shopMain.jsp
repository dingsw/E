<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="java.util.List"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>校园E点通-会员中心</title>
</head>
<body onLoad="clockon(bgclock);">
<jsp:include page="shopTop.jsp" flush="true"></jsp:include>
<table width="813" height="456" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" bgcolor="EBEBED"  width="195">
    <jsp:include page="shopMiddle.jsp" flush="true"></jsp:include>
    </td>
  </tr>
</table>
<jsp:include page="../down.jsp" flush="true"></jsp:include>
</body>
</html>
