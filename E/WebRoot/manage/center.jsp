 <%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
-->
</style>
	</head>

	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout: fixed;">
			<tr>
				<td>
					<iframe name="I3" height="100%" width="100%" border="0"
						frameborder="0" src="middle.jsp">
						浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
					</iframe>
				</td>
				<td width="6" bgcolor="#1873aa" style="width: 6px;">
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>
