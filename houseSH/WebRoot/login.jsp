<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<LINK rel=stylesheet type=text/css href="css/style.css">

  </head>
  
  <body>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.jpg" width="150px">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DIV class=box>
				<H4>用户登录</H4>
				<FORM id=user method=post action="${pageContext.request.contextPath}/user/login" >
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR><TD colSpan=2></TD></TR>
								<TR><TD class=field>用 户 名：</TD>
									<TD><input type="text" name="username"  size="50" ></TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD><input type="password" name="password" size="50"></TD>
								</TR></TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT  value=登录 type="submit" style="color:skyblue; border: 1px skyblue solid;"> 
							<INPUT  value=注册 type=button style="color:skyblue; border: 1px skyblue solid;">
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>58租房 © 2017 刘升东老板 ICP证666666号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>   
  </body>
</html>
