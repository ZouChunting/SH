<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%request.setCharacterEncoding("utf-8");%>     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="css/register.css" />
    <script type="text/javascript" src="js/register.js"></script>

  </head>
  
  <body>
    <div id="main">
       <form id="registerForm" action="${pageContext.request.contextPath}/user/register" method="post" name="myform" onsubmit="return checkForm()">
         <table>
           <tr>
              <td width="150px" align="right">通行证用户名：</td>
              <td><input name="username" type="text" id="userName"  onfocus="focusShow('userName','只能以数字、字母开头或结尾，且长度为4-18')" onblur="checkUserName()"  class="inputs userWidth"  /></td>
              <td><div id="userNameId"></div></td>
           </tr>
           <tr>
              <td align="right">登录密码：</td>
              <td><input name="password" type="password" id="pwd" class="inputs" onfocus="focusShow('pwd','密码应为6-16个字符')" onblur="checkPwd()"/></td> 
              <td><div id="pwdId"></div></td>  
           </tr>              
           <tr>
              <td align="right">重复登录密码：</td>
              <td><input type="password" id="repwd" class="inputs" onfocus="focusShow('repwd','请再次输入密码')" onblur="checkRepwd()"/></td> 
              <td> <div id="repwdId"></div></td>  
           </tr>
           <tr>
              <td align="right">性别：</td>
              <td><input name="sex" type="radio" value="男" checked="checked" id="sex"/><span>男</span> <input name="sex" type="radio" value="女"  id="sex"/><span>女</span> </td> 
              <td></td>  
           </tr>
           <tr>
              <td align="right" >真实姓名：</td>
              <td><input name="name" type="text" id="zsName" class="inputs"  onfocus="focusShow('zsName','请输入真实姓名以便验证')" onblur="checkzsName()"/></td> 
              <td><div id="zsNameId"></div></td>  
           </tr>
           <tr>
              <td align="right">关联手机号：</td>
              <td><input name="telephone" type="text" id="tel" class="inputs" onfocus="focusShow('tel','手机号码以13,15,18开头手机号码由11位数字组成')" onblur="checkTel()"/></td> 
              <td><div id="telId"></div></td>  
           </tr>
           <tr>
              <td align="right">保密邮箱：</td>
              <td><input name="email" type="text" id="email" class="inputs" onfocus="focusShow('email','请输入您常用的电子邮箱，邮箱应包含@和.符号')" onblur="checkEmail()"/></td> 
              <td><div id="emailId"></div></td>  
           </tr>
           <tr>
              <td></td>
              <td><input name="dosubmit" type="submit" value="注册"  id="submitBtn"  /></td> 
              <td></td>  
           </tr>
         </table>
       </form>
	</div>
  </body>
</html>
