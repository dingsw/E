<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>无标题文档</title>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
.STYLE6 {font-size: 18px}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：【取消的订单】</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
         <tr>
         	<td bgcolor="#FFFFFF" colspan="10" valign="middle">
         		<div>
         		<br/>
        	   <blockquote>
         		     <fieldset style="height:100%;">
				<legend><b>取消的订单</b></legend><br/>
				<form name="orderInfo" method="post"  onSubmit="return checkUpdate(orderInfo)">
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                      
					  <tr>
					    <td width="20%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">宝贝</span></div></td>
                        <td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">单价（元）</span></div></td>
                        <td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">数量</span></div></td>
                        <td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">实付款 </span></div></td>
                        <td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">交易状态 </span></div></td>
					    <td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">交易操作 </span></div></td>
					    <td width="12%" height="22" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">其他操作 </span></div></td>
					    </tr>
					    <c:forEach items='${requestScope["list"]}' var="gb">
				        <c:if test="${!empty gb}">
				        <c:if test="${ gb.flag==1 }">
				        <c:if test="${ gb.order_state==0 }">
					   <tr>
					    <td><input type="text" name="account" value="${gb.goods_id}" /></td>
					    <td><input type="text" name="account" value="${gb.goods_price}" /></td>
					    <td><input type="text" name="account" value="${gb.goods_number}" /></td>
					    <td><input type="text" name="account" value="${gb.totalprice}" /></td>
					    <td><input type="text" name="account" value="${gb.order_state}" /></td>
					    <td><input type="text" name="account" value="" /></td>  
					    <td height="34" align="left"><a href="OrderFormServlet?method=Orderdelete&order_id=${gb.id}&order_state=${gb.order_state}" >删除</a></td></tr>
					    </c:if>
					    </c:if>
					    </c:if>
				        </c:forEach>
					  </table>
				</form>
			 <br />
				</fieldset>
       		     </blockquote>
         		</div>         	</td>
         </tr>
        </table></td>
        <td width="8" background="images/tab_15.gif"></td>
      </tr>
    </table></td>
  </tr>
<tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td valign="bottom" style="width:100%;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;</td>
            </tr>
        </table></td>
		<td width="12" height="35"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
  </table></td>
  </tr>
</table>
</body>
</html>