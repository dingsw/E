<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<script>
var he=document.body.clientHeight-105
document.write("<div id=tt style=height:"+he+";overflow:hidden>")
</script>
<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="28" background="../images/main_40.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="19%">&nbsp;</td>
          <td width="81%" height="20"><span class="STYLE1">商户中心</span></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td valign="top">
    <table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" background="../images/main_47.gif" id="imgmenu3" class="menu_title" 
                onMouseOver="this.className='menu_title2';" onClick="showsubmenu(3)" 
                onMouseOut="this.className='menu_title';" style="cursor:hand">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="18%">&nbsp;</td>
                      <td width="82%" class="STYLE1">用户信息管理</td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td background="../images/main_51.gif" id="submenu3"><div class="sec_menu" >
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="showShopkeeper.jsp" style="text-decoration:none" target="I2">查看个人资料</a> </span></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td height="23"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="alterShopkeeper.jsp" style="text-decoration:none" target="I2">修改个人资料</a></span></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td height="23"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="alterQuestion.jsp" style="text-decoration:none" target="I2">安全设置</a> </span></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td height="23"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="alterPassword.jsp" style="text-decoration:none" target="I2">修改密码</a></span></td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr>
                        <td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
                      </tr>
                    </table>
                  </div></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" background="../images/main_47.gif" id="imgmenu5" class="menu_title" 
                onMouseOver="this.className='menu_title2';" onClick="showsubmenu(5)" 
                onMouseOut="this.className='menu_title';" style="cursor:hand">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="18%">&nbsp;</td>
                      <td width="82%" class="STYLE1">我的商店</td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td background="../images/main_51.gif" id="submenu5"><div class="sec_menu" >
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="../ShopServlet?method=2" style="text-decoration:none" target="I2">查看店铺信息</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="../ShopServlet?method=2&flag=1" style="text-decoration:none" target="I2">修改店铺信息</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr>
                        <td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
                      </tr>
                    </table>
                  </div></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" background="../images/main_47.gif" id="imgmenu5" class="menu_title" 
                onMouseOver="this.className='menu_title2';" onClick="showsubmenu(5)" 
                onMouseOut="this.className='menu_title';" style="cursor:hand">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="18%">&nbsp;</td>
                      <td width="82%" class="STYLE1">我的商品</td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td background="../images/main_51.gif" id="submenu5"><div class="sec_menu" >
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="../GoodsServlet?method=2&type=${sessionScope.shopkeeper.shop_id}" style="text-decoration:none" target="I2">商品列表</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="../goods/selectGoods.jsp" style="text-decoration:none" target="I2">查找商品</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="../goods/addGoods.jsp" style="text-decoration:none" target="I2">添加商品</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr>
                        <td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
                      </tr>
                    </table>
                  </div></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" background="../images/main_47.gif" id="imgmenu5" class="menu_title" 
                onMouseOver="this.className='menu_title2';" onClick="showsubmenu(5)" 
                onMouseOut="this.className='menu_title';" style="cursor:hand">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="18%">&nbsp;</td>
                      <td width="82%" class="STYLE1">订单管理</td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td background="../images/main_51.gif" id="submenu5"><div class="sec_menu" >
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="#" style="text-decoration:none" target="I2">查看订单</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr>
                              <td width="16%" height="25"><div align="center"><img src="../images/left.gif" width="10" height="10" /></div></td>
                              <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td height="20" style="cursor:hand" 
                                    onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
                                    onmouseout="this.style.borderStyle='none'"><span class="STYLE3"> 
                                    <a href="../ShopServlet?method=2&flag=1" style="text-decoration:none" target="I2">修改店铺信息</a> </span> </td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                      <tr>
                        <td height="5"><img src="../images/main_52.gif" width="151" height="5" /></td>
                      </tr>
                    </table>
                  </div></td>
              </tr>
            </table></td>
        </tr>
      </table>
      </td>
  </tr>
  <tr>
    <td height="18" background="../images/main_58.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="18" valign="bottom"><div align="center" class="STYLE3" style="font-color:white">东北石油大学</div></td>
        </tr>
      </table></td>
  </tr>
</table>
<script>

function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="images/main_47.gif";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="images/main_48.gif";
}
}

</script>
