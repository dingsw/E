<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>文件上传页面</title>
	</head>
	<body>
		<form action="InsertServlet" method="post" enctype="multipart/form-data">
			文件名称：<input type="text" name="uname"><br>
			上传的图片：<input type="file" name="pic"><br>
			<input type="submit" value="上传">
		</form>
	</body>
</html>