<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    
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
		<DIV class=search>
			<FORM method=get>
				<INPUT class=text type=text name=keywords> 
				<LABEL class="ui-green searchs"><a href="list.html" target="_blank">搜索房屋</a></LABEL>
			</FORM>
		</DIV>
	</DIV>
	<DIV id=position class=wrap>当前位置：58租房网 - 浏览房源</DIV>
	<DIV id=view class="main wrap">
		<DIV class=intro>
			<DIV class=lefter>
				<H1>${house.title}</H1>
				<DIV class=subinfo>${house.date}</DIV>
				<DIV class=houseinfo>
					<P>户 型：<SPAN>${house.getType().getName()}</SPAN></P>
					<P>面 积：<SPAN>${house.floorage}m<SUP>2</SUP></SPAN></P>
					<P>位 置：<SPAN>${house.getStreet().getDistrict().getName()} ${house.getStreet().getName()}</SPAN></P>
					<P>联系方式：<SPAN>${house.getUser().getTelephone()}</SPAN></P>
				</DIV>
			</DIV>
			<DIV class=side>
				<P><A class=bold href="http://localhost:8080/House-2/#">58房地产经纪公司</A>
				</P>
				<P>资质证书：有</P>
				<P>内部编号:1000</P>
				<P>联 系 人：</P>
				<P>联系电话：<SPAN></SPAN></P>
				<P>手机号码：<SPAN>15123568974</SPAN></P>
			</DIV>
			<DIV class=clear></DIV>
			<DIV class=introduction>
				<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
				<DIV class=content>
					<P>${house.description}</P>
				</DIV>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>58租房 © 2017 刘大老板 苏ICP证66666666号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
  </body>
</html>
