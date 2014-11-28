<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html ><!-- InstanceBegin template="/Templates/moban.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>校园E点通</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<link href="css/index.css" rel="stylesheet" type="text/css" />

<style type="text/css">
*{margin:0; padding:0;}
img{border:none; vertical-align:top;}
.grid{
	width:150px;
	margin-top: 50px;
	margin-right: auto;
	margin-bottom: 50px;
	margin-left: auto;
}
.grid a{
	float:left;
	list-style:none;
	width:120px;
	display:block;
	border:1px solid #630d6e;
	margin-bottom:-1px;
	margin-right:-1px;
	cursor:pointer;
	background-color: #630d6e;
}
.grid a:hover{padding:2px; position:relative; margin:-6px -6px -6px -6px;}
</style>

<!-- InstanceEndEditable -->
<link href="css/moban.css" rel="stylesheet" type="text/css" />

<style>
*{margin:0;padding:0}
li{list-style:none}
.list{height:40px;background:#520a5e;padding-left:223px; margin-top: 10px;text-align:center; }
.list li{float:left;position:relative;}
.list li a{float:left;width:100px;height:40px;line-height:40px; text-align:center;color:#ffffff;text-decoration:none; font-family:"微软雅黑";}
.list li a:hover,.red{background:#ffffff!important;color:#520a5e!important;}
.STYLE2 {font-size: 12px}
</style>
</head>

<body>
<table width="100%">
  <tr >
    <td height="80" align="left" valign="top">
	  <div id="head">
	    <a href="#"><img src="images/logo.png" alt="logo" border="0" /></a>
	   <div class="sousuo">
				<form id="form1" name="form1" method="post" >
					<label>
			        <input name="搜索框" type="text" class="kuang" />
				    </label>
				    <label>
			        <input name="Submit" type="submit" class="sousuoanniu" />
		            </label>
				</form>	
	    </div>
		 
		 <div class="denglu">您好！欢迎来到校园E点通！<a href="dddd.html"><img src="images/denglu.jpg" alt="登陆" border="0" /></a>&nbsp;<a href="#"><img src="images/zhuce.jpg" border="0" /></a></div>
		 
      </div>
    </td>
  </tr>
  <tr height="200">
    <td align="left" valign="top">
	<div id="daohang" >
		<ul class="list">
		 <li><a href="index.html">首页</a></li>
		 <li><img src="images/xixian.jpg" /></li>
		 <li><a href="food.html" >美食 </a></li>
		 <li><img src="images/xixian.jpg" /></li>
		 <li><a href="ktv.html">KTV</a></li>
		 <li><img src="images/xixian.jpg" /></li>
		 <li><a href="movie.html">电影</a></li>
		 <li><img src="images/xixian.jpg" /></li>
		 <li><a href="hotel.html">宾馆</a></li>
		 <li><img src="images/xixian.jpg" /></li>
		 <li><a href="travel.html">旅游</a></li>
		 <li><img src="images/xixian.jpg" /></li>
	    </ul>
   </div></td>
  </tr>
  <!-- InstanceBeginEditable name="main" --> 
  <tr height="900">
   <td height="303" align="left" valign="top">
	 <p><meta content="text/html; charset=utf-8" http-equiv="Content-Type" /><style type="text/css"> 
			* { margin:0; padding:0;} 
			ul, li { list-style:none;} 
			body{ 
			text-align:left; 
			} 
			#play{ 
			width:600px; 
			height:200px; 
			position:absolute; 
			left:55%; /*离右距离*/
			top:48%;  /*离上距离*/
			margin:-155px 0 0 -205px; 
			overflow:hidden; 
			
			} 
			#playimg{ 
			width:610px; 
			height:200px; 
			position:absolute; 
			} 
			#playimg li{ 
			height:200px; 
			overflow:hidden; 
			} 
			#playimg img{ 
			width:610px; 
			height:200px; 
			} 
			#playbtn{ 
			position:absolute; 
			left:0; 
			bottom:5px; 
			} 
			#playbtn li{ 
			display:inline; 
			background:#eee; 
			padding:2px 5px; 
			margin:0 3px; 
			cursor:pointer; 
			} 
			#playbtn .current{ 
			background:#f0f; 
			} </style>
		</p>
<script type="text/javascript"> 
function $(id){return document.getElementById(id)} 
function moveElement(elementID,final_x,final_y,interval) {//这个方法在DOM艺术那个书上讲的很清楚 
if (!document.getElementById) return false; 
if (!document.getElementById(elementID)) return false; 
var elem = document.getElementById(elementID); 
if (elem.movement) { 
clearTimeout(elem.movement); 
} 
if (!elem.style.left) { 
elem.style.left = "0px"; 
} 
if (!elem.style.top) { 
elem.style.top = "0px"; 
} 
var xpos = parseInt(elem.style.left); 
var ypos = parseInt(elem.style.top); 
if (xpos == final_x && ypos == final_y) { 
return true; 
} 
if (xpos < final_x) { 
var dist = Math.ceil((final_x - xpos)/10); 
xpos = xpos + dist; 
} 
if (xpos > final_x) { 
var dist = Math.ceil((xpos - final_x)/10); 
xpos = xpos - dist; 
} 
if (ypos < final_y) { 
var dist = Math.ceil((final_y - ypos)/10); 
ypos = ypos + dist; 
} 
if (ypos > final_y) { 
var dist = Math.ceil((ypos - final_y)/10); 
ypos = ypos - dist; 
} 
elem.style.left = xpos + "px"; 
elem.style.top = ypos + "px"; 
var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")"; 
elem.movement = setTimeout(repeat,interval); 
} 
function imgChange(num){//切换图片焦点 
if(!$('play')) return false; 
var piclist=$('playimg').getElementsByTagName('img'); 
var imgheight=piclist[0].offsetHeight; 
var moveY=-(imgheight*num); 
moveElement('playimg',0,moveY,5); 
} 
function classToggle(arr,n){//切换按钮样式 
for(var i=0;i<arr.length;i++){ 
arr[i].className=''; 
} 
arr[n].className='current'; 
} 
function btnChange(btns){//鼠标移动播放 
if(!$(btns)) return false; 
$('play').onmouseover = function(){autokey = false}; 
$('play').onmouseout = function(){autokey = true}; 
var arr=$(btns).getElementsByTagName('li'); 
for(var i=0;i<arr.length;i++){ 
arr[i].index=i;//设置索引号 
arr[i].onmouseover=function(){ 
//var num=index(this,arr); 
classToggle(arr,this.index); 
imgChange(this.index); 
} 
} 
} 
function autoChange(btns){ 
if(!$(btns)) return false; 
if(!autokey) return false; 
var arr=$(btns).getElementsByTagName('li'); 
for(var i=0;i<arr.length;i++){ 
if(arr[i].className=='current'){ 
var n=i+1; 
} 
} 
if(n>=arr.length) n=0; 
classToggle(arr,n); 
imgChange(n); 
} 
var autokey = true; 
setInterval("autoChange('playbtn')",3000); 
window.onload=function(){ 
btnChange('playbtn'); 
} 
</script>
       <style>
ul,li{ margin:0px; padding:0px; list-style:none;}
.div_a{ width:250px; padding-right: 0px;  }
.div_a li{ width:250px; height:30px; left:20px; border-bottom:2px solid #630d6e;/*线的颜色*/ cursor:pointer; text-align:left; line-height:30px;/*前行高*/ font-size:18px; color:#000000;/*字的颜色*/}

.div_a1{ width:600px;/*后行宽*/ height:350px;/*后行高*/  position:relative; background:url(images/kuang.jpg); top:-40px; left:295px; z-index:990; display:none;}
.div_a li:hover .div_a1{ display:block;}
</style>
      <div class="daohang1">
	        		  <div class="div_a">
		<ul>
		  <li>&nbsp;&nbsp;<img src="images/zidian.png"/><a href="#">川菜</a>/<a href="#">粤菜</a>/<a href="#">湘菜</a><div class="div_a1">这是里面的内容这是里面的内容这是里面的内容</div> </li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">内蒙菜</a>/<a href="#">东北菜</a><div class="div_a1">这是里面的内容这是里面的内容这是里面的内容</div></li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">新疆菜</a>/<a href="#">粤菜</a>/<a href="#">湘菜</a><div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div></li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">东北菜</a>/<a href="#">西北菜</a>/<a href="#">内蒙菜</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li>
		   <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">湖北菜</a>/<a href="#">西北菜</a><div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li> 
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">火锅</a>/<a href="#">干锅</a><div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div></li>
		   <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">香锅</a> /<a href="#">火锅</a><div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">烧烤</a>/<a href="#">烤鱼</a>/<a href="#">海鲜</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">自助餐</a>/<a href="#">西餐</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div></li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">韩国料理</a>/<a href="#">日本料理</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">早餐</a>/<a href="#">夜宵</a><div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li>
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">韩国料理</a>/<a href="#">日本料理</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div></li>   
		  <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">甜点</a>/<a href="#">咖啡店</a>/<a href="#">蛋糕店</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div> </li>
         
          <li>&nbsp;&nbsp;<img src="images/dian.png" /><a href="#">创意餐厅</a>/<a href="#">其他</a> <div class="div_a1">这的内容这是里<br>是内容这是<a href="#">内容</a><br>是内容这是<a href="#">内容</a>面的内容这是里面的内容</div></li>
		</ul>
		</div>

	  </div>
	  <div id="play">
							<ul id="playimg">
								<li><img  alt="" src="images/guang1.jpg" /></li>
								<li><img  alt="" src="images/guang2.jpg" /></li>
								<li><img  alt="" src="images/guang3.jpg" /></li>
								<li><img  alt="" src="images/guang4.jpg" /></li>
							</ul>
							<ul id="playbtn">
								<li class="current">1</li>
								<li>2</li>
								<li>3</li>
								<li>4</li>
							</ul>
	 </div>
				
     <div class="guanggao2" ><table>
		  <tr  class="grid">
			<td><a href="#"><img src="images/5.jpg" height="109" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
		  </tr>
		  <tr>
			 <td><img src="images/dian1.png" />&nbsp;大庆电视塔：4人经典套餐</td>
			 <td><img src="images/dian1.png" />&nbsp;明月花园火锅：8-10人套餐</td>
			 <td><img src="images/dian1.png" />&nbsp;玛加朵食品店：经典蔓越莓蛋糕一个</td>
			 <td><img src="images/dian1.png" />&nbsp;领航烧烤坊：4-6人套餐一份</td>
			 <td><img src="images/dian1.png" />&nbsp;玛加朵食品店：秋意浓蛋糕一个</td>
		  </tr>
		  <tr  class="grid">
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
			<td><a href="#"><img src="images/5.jpg" border="0" class="xiaotu" /></a></td>
		  </tr>
		  <tr>
			 <td><img src="images/dian1.png" />&nbsp;大庆电视塔：4人经典套餐</td>
			 <td><img src="images/dian1.png" />&nbsp;明月花园火锅：8-10人套餐</td>
			 <td><img src="images/dian1.png" />&nbsp;玛加朵食品店：经典蔓越莓蛋糕一个</td>
			 <td><img src="images/dian1.png" />&nbsp;领航烧烤坊：4-6人套餐一份</td>
			 <td><img src="images/dian1.png" />&nbsp;玛加朵食品店：秋意浓蛋糕一个</td>
		  </tr>
		</table>
     </div>


     <div class="daohang2">
	 <table width="100%">
         <tr>
              <td height="49" colspan="5" align="left" valign="top"><img src="images/ktv.png" width="186" height="39" class="ming" /><a href="ktv1.html" target="ktv"><img src="images/shangwu.png" width="88" height="30" border="0" class="ming" /></a><a href="ktv2.html" target="ktv"><img src="images/xiawu.png" width="88" height="30" border="0" class="ming" /></a><a href="ktv1.html" target="ktv"><img src="images/bufenshiduan.png" width="88" height="30" border="0" class="ming" /></a><a href="ktv2.html" target="ktv"><img src="images/dabao.png" width="88" height="30" border="0" class="ming"/></a><a href="ktv1.html" target="ktv"><img src="images/zhongbao.png" width="88" height="30" border="0" class="ming"/></a><a href="ktv2.html" target="ktv"><img src="images/xiaobao.png" width="75" height="30" border="0" class="ming"/></a>			  </td>
         </tr>
         <tr>
			 <td width="23%" height="323" rowspan="4" align="left" valign="top"><table width="100%">
               <tr>
                 <td height="75" bgcolor="#333366">&nbsp;</td>
               </tr>
               <tr>
                 <td height="95" bgcolor="#CCFF66">&nbsp;</td>
               </tr>
               <tr>
                 <td height="144" bgcolor="#FF66CC">&nbsp;</td>
               </tr>
             </table></td>
			 
		    <td width="77%" align="left" valign="top"><iframe src="ktv1.html" width="700" height="320" name="ktv" frameborder="0" scrolling="no"> </iframe></td> 
         </tr>
     </table>
     </div>
	 <div class="daohang3">
	 <table width="100%">
         <tr>
              <td height="49" colspan="5" align="left" valign="top"><a href="ktv1.html" target="movie"><img src="images/dianying.png" width="200" height="39" class="ming" /></a><a href="ktv2.html" target="movie"><img src="images/aiqingpian.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="movie"><img src="images/dongmanpian.png" width="88" height="30" class="ming"/></a></a><a href="ktv2.html" target="movie"><img src="images/jingsongpian.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="movie"><img src="images/guzhuangpian.png" width="88" height="30" class="ming"/></a>	<a href="ktv2.html" target="movie"><img src="images/kongbupian.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="movie"><img src="images/qita.png" width="88" height="30" class="ming"/></a></td>
         </tr>
         <tr>
			 <td width="23%" height="323" rowspan="4" align="left" valign="top"><table width="100%">
               <tr>
                 <td height="63" bgcolor="#009966">&nbsp;</td>
               </tr>
               <tr>
                 <td height="73" bgcolor="#99CC66">&nbsp;</td>
               </tr>
               <tr>
                 <td height="87" bgcolor="#33CC00">&nbsp;</td>
               </tr>
               <tr>
                 <td height="87" bgcolor="#FFCC33">&nbsp;</td>
               </tr>
             </table></td>
			 
		    <td width="77%" align="left" valign="top"><iframe src="ktv1.html" width="700" height="320" name="movie" frameborder="0" scrolling="no"> </iframe>
	        </td> 
         </tr>
     </table>
     </div>
	 <div class="daohang4">
	 <table width="100%">
         <tr>
              <td height="49" colspan="5" align="left" valign="top"><img src="images/jiudian.png" width="200" height="39" class="ming" /><a href="ktv1.html" target="hotel"><img src="images/yixing.png" width="88" height="30" class="ming"/></a><a href="ktv2.html" target="hotel"><img src="images/erxing.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="hotel"><img src="images/sanxing.png" width="88" height="30" class="ming"/></a><a href="ktv2.html" target="hotel"><img src="images/sixing.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="hotel"><img src="images/wuxing.png" width="88" height="30" class="ming"/></a><a href="ktv2.html" target="hotel"><img src="images/qita.png" width="88" height="30" class="ming"/></a>             </td>
         </tr>
         <tr>
			 <td width="23%" height="320" rowspan="4" align="left" valign="top"><table width="100%">
               <tr>
                 <td height="90" align="left" valign="top" bgcolor="#000000">&nbsp;</td>
               </tr>
               <tr>
                 <td height="98" align="left" valign="top" bgcolor="#00FF99">&nbsp;</td>
               </tr>
               <tr>
                 <td height="120" align="left" valign="top" bgcolor="#33CCCC">&nbsp;</td>
               </tr>
             </table></td>
			 
		    <td width="77%" align="left" valign="top"><iframe src="ktv1.html" width="700" height="320" name="hotel" frameborder="0" scrolling="no"> </iframe></td> 
			 
         </tr>
     </table>
     </div>
	 <div class="daohang5">
	 <table width="100%">
         <tr>
               <td height="49" colspan="5" align="left" valign="top"><img src="images/lvyou.png" width="200" height="39" class="ming" /><a href="ktv2.html" target="travel"><img src="images/lvyou_ziranhguanjing.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="travel"><img src="images/lvyou_shengtailvyou.png" width="88" height="30" class="ming"/></a><a href="ktv2.html" target="travel"><img src="images/lvyou_minsufengqing.png" width="88" height="30" class="ming"/></a><a href="ktv1.html" target="travel"><img src="images/lvyou_chuantongyinshi.png" width="88" height="30" class="ming"/></a><a href="ktv2.html" target="travel"><img src="images/lvyou_renwenguanjing.png" width="88" height="30" class="ming"/></a>	<a href="ktv1.html" target="travel"><img src="images/qita.png" width="88" height="30" class="ming"/></a></td>
         </tr>
         <tr>
			 <td width="23%" height="323" rowspan="4" align="left" valign="top"><table width="100%">
               <tr>
                 <td height="162" bgcolor="#0033CC">&nbsp;</td>
               </tr>
               <tr>
                 <td height="152" bgcolor="#297062">&nbsp;</td>
               </tr>
             </table></td>
			 
		    <td width="77%" align="left" valign="top"><iframe src="ktv1.html" width="700" height="320" name="travel" frameborder="0" scrolling="no"> </iframe></td> 
         </tr>
     </table>
     </div>
	 
  </tr>
 
  <!-- InstanceEndEditable -->
  <tr>
    <td><div class="di">
      <div align="center"><span class="STYLE2">版权所有 翻版必究</span><br>
	                      <span class="STYLE2">联系电话 123456789</span></div>
    </div></td>
  </tr>
 
</table>

</body>
<!-- InstanceEnd --></html>
