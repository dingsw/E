<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û�ע��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link href="css/style.css" type="text/css" rel="stylesheet">
	-->
	
	
<script language="javascript">

	function checkemail(email){
	 var str=email;
	  //��JavaScript�У�������ʽֻ��ʹ��"/"��ͷ�ͽ���������ʹ��˫����
	 var Expression=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/; 
	 var objExp=new RegExp(Expression);
	 if(objExp.test(str)==true){
	  return true;
	 }else{
	  return false;
	 }
	}
	
	function checkForm(form){   
		if(form.account.value==""){
			window.alert("�������û���¼�ǳ�!");     
	        return false;
	    }  
	    if(form.account.value.length < 5 ||form.account.value.length > 20){
	        window.alert("�û���¼�ǳƱ�����5-20֮�䣡");     
	        return false;
	    } 
		if(form.password.value==""){
			window.alert("�������û���¼���룡");
			return false;
		}
		if(form.password.value.length < 3){
			window.alert("�û���¼���������3λ����");
			return false;
		} 
	    if(form.repassword.value==""){
	        window.alert("�������û���¼�ظ����룡");
	        return false;
	    }
	    if(form.repassword.value!=form.password.value){
	        window.alert("��������������붼����ȷ��");
	        return false;
	    }
	    if(form.email.value==""){
	      	window.alert("������email��ַ");
	      	return false;
	    }
	    if(!checkemail(form.email.value)){
	     	window.alert("�������email��ַ��ʽ����ȷ");
	     	return false;
	    }
	    if(form.code.value==""){
	      	window.alert("������У����");
	      	return false;
	    } 
	    if(form.telephone.value==""){
	      	window.alert("��������ϵ�绰");
	      	return false;
		}
	    if(form.address.value==""){
	      	window.alert("�������ַ");
	      	return false;
	    } 
	}
	
	function refreshValidate(){
   	    document.getElementById("ValidateCode").src="ValidateCodeServlet?"+Math.random();
   	}
</script>

  </head> 
  <body>
  <a href="shop/register.jsp">�̻�ע��</a>
    <table width="765" height="120" border="0" align="center" cellpadding="0" cellspacing="0" background="images/re_top.jpg">
          <tr>
            <td width="520">&nbsp;</td>
            <td width="245" valign="top"><table width="214" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="252" height="43" valign="bottom"><a href="#" class="a2">��Ϊ��ҳ</a> / <a href="#" class="a2">�����ղ�</a> / <a href="#" class="a2">��ϵ����</a></td>
              </tr>
            </table></td>
          </tr>
        </table>
        <table width="765" border="0" align="center" cellpadding="0" cellspacing="0" background="images/re_center.jpg">
          <tr>
            <td width="538" height="93" align="center">
			
			   <form name="form" method="post" action="UserServlet?method=2" onSubmit="return checkForm(form)">
                <table width="509" height="290" border="0" align="center">
                <tr>
                    <td width="105" height="30" align="right">�û���¼�ǳƣ�</td>
                    <td colspan="2">
                        <input name="account" type="text">&nbsp;*</td>
                </tr>
                <tr>
                    <td width="105" height="30" align="right">&nbsp;</td>
                    <td colspan="2">5-20λ��ĸ�����ֻ��ַ���ϣ�����ĸ����Ϊ��ĸ��</td>
                </tr>
                <tr>
                    <td height="30" align="right">&nbsp;</td>
                    <td colspan="2">Ϊ�������ʻ���ȫ��ǿ�ҽ����������ʹ���ַ�+����+�����ַ���ʽ����������ĳ��ȴ���3λ��</td>
                </tr>
                
                
                <tr>
                    <td height="30" align="right">���룺</td>
                    <td colspan="2">
                        <input name="password" type="password">
                    &nbsp;*</td>
                </tr>
                <tr>
                    <td height="30" align="right">�ظ��������룺</td>
                    <td colspan="2">
                        <input name="repassword" type="password">
                    &nbsp;*</td>
                </tr>
                <tr>
	            	<td height="30" align="right"><strong><em>��&nbsp;&nbsp;&nbsp;&nbsp;��</em></strong></td>
	            	<td width="220px"><input name="sex" type="radio" value="��" checked> ��&nbsp;&nbsp;&nbsp;
	              		<input name="sex" type="radio" value="Ů"> Ů </td>
		        </tr>
		        <tr>
				  	<td width="120px"><strong><em>��ϵ�绰��</em></strong></td>
				  	<td width="220px"><input name="telephone" type="text" size="25"> *
				  	</td>
				</tr>
				<tr>
				  	<td width="120px"><strong><em>��ַ��</em></strong></td>
				  	<td width="220px"><input name="address" type="text" size="25"> *
				  	</td>
				</tr>
                <tr>
                    <td height="30" align="right">&nbsp;</td>
                    <td colspan="2">
                        ע�⣺�����������յ����幤���Ҽ�����ġ�<br>
                    �û�ע�����Ҫ����ſ���ʹ�ã�������ֻ�ᷢ����ע�������С�			   </td>
                </tr>
                 <tr>    
                <td height="30" align="right">Email��ַ��</td>
                <td colspan="2"><input name="email" type="text"  size="40">&nbsp;*</td>
                  </tr>
            
            
            <tr>
                <td height="30" colspan="3" align="center">��������ѡ�ֻҪ���κ�һ��û�����룬�㽫������ʹ��ͨ������������������Ĺ��ܡ�</td>
            </tr>
            <tr>
                <td height="30" align="right">&nbsp;</td>
                <td colspan="2" valign="bottom">�û������һ����ǵ����룡</td>
            </tr> 
            
            <tr>
                <td height="30" align="right">������ʾ���⣺</td>
                <td colspan="2">
                    <input name="question" type="text" id="question" size="60">                </td>
            </tr>
            <tr>
                <td height="30" align="right">&nbsp;</td>
                <td colspan="2" valign="bottom">�û������һ����ǵ����룡</td>
            </tr> 
            <tr>
                <td height="30" align="right">��ʾ����𰸣�</td>
                <td colspan="2">
                    <input name="answer" type="text" id="answer" size="60"> </td>
            </tr>
            <tr>
                <td height="30" align="right">У���룺</td>
                <td colspan="2">  
                    <img border=0 id="ValidateCode" src="ValidateCodeServlet" alt="�޷���ʾ"></td>
            </tr>
            <tr>
                <td height="30" align="right">&nbsp; </td>
                <td colspan="2"><a href="javascript:refreshValidate();">���»����֤��</a></td>
            </tr> 
            <tr>
                <td height="30" align="right">����У���룺</td>
                <td colspan="2">
                    <input name="code" type="text">&nbsp;*</td>
            </tr>
            <tr>
                <td height="30">&nbsp;</td>
              <td width="307"><input type="submit" name="Submit" value=" ע �� �� �� ">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
              <td width="83">&nbsp; <a href="login.jsp" class="a2">���ص�¼</a></td>
            </tr>
            <tr>
                <td height="30">&nbsp;</td>
                <td colspan="2">${requestScope.information}</td>
            </tr>
        </table>
        </form>
        
			
			
			
			
			
			
			
			
			
			
			
			</td>
          </tr>
    </table>
        <table width="765" height="90" border="0" align="center" cellpadding="0" cellspacing="0" background="images/re_down.jpg">
          <tr>
            <td align="center">	<font color="#666666">
			�����������ߣ�0431-84972266 &nbsp;���棺0431-84972266 &nbsp;��ҵ���䣺mingrisoft@mingrisoft.com<br><br>
            Copyright&reg; &nbsp;2008 &nbsp;<a href="http://www.mingrisoft.com" class="a2">http://www.mingrisoft.com</a> &nbsp;All Right Reserved!			</font>	</td>
          </tr>
        </table>
  </body>
</html>
