<%@ page language="java" import="java.util.*,com.bean.*" pageEncoding="GBK"%>
<jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload"/>
<html>
	<head>
		<title>图片上传</title>
	</head>
	<body>
	<%
	ShopKeeper shopkeeper = null;
    shopkeeper = new ShopKeeper();
    shopkeeper = (ShopKeeper)request.getSession().getAttribute("shopkeeper");
    String id = String.valueOf(shopkeeper.getId());
    System.out.println(id);
		request.setCharacterEncoding("GBK");
		smartupload.initialize(pageContext);	// 初始化上传
		smartupload.setTotalMaxFileSize(10000000);
		smartupload.upload();					// 准备上传
		String name = id+"_"+smartupload.getRequest().getParameter("uname");
		name = name + "." + smartupload.getFiles().getFile(0).getFileExt();
		String fileName = this.getServletContext().getRealPath("/") + "upload/" + name;
		try{
			smartupload.getFiles().getFile(0).saveAs(fileName);
			out.println("图片上传成功成功");
		}
		catch(Exception e){
			out.println(e.toString());
		}
	%>

	</body>
</html>
