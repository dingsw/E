<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.tools.*,java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'df.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

 <%	
 String sql = "select * from lob";
 ConnDB conn = new ConnDB();

 ResultSet rs = conn.executeQuery(sql);
 while(rs.next()){
	 out.println("g");
 }
 %>
  
  </body>
</html>
