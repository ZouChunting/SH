<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myhouses.jsp' starting page</title>
    
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
<DIV id=logo><IMG src="images/logo.jpg" width="150px"></DIV>
<DIV class=search><LABEL class="ui-green searchs"><a href="${pageContext.request.contextPath}/house/initRelease"><INPUT  value="发布房屋" type=button name=search></a></LABEL> 
<LABEL class=ui-green><INPUT  value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
		<DIV id=houseArea>
			<TABLE class=house-list>
				<TBODY>
				<c:forEach items="${houses}" var="houses">
					<TR>
						<TD class=house-thumb><SPAN><A href="${pageContext.request.contextPath}/house/showHouseDetail?id=${houses.id}"
								target="_blank"><img src="images/ho.jpg"
									width="100" height="75" alt=""></A></SPAN></TD>
						<TD>
							<DL>
								<DT>
									<A href="${pageContext.request.contextPath}/house/showHouseDetail?id=${houses.id}" target="_blank">${houses.title}</A>
								</DT>
								<DD>
									${houses.getStreet().getDistrict().getName()}${houses.getStreet().getName()},${houses.floorage}平米<BR>联系方式：${houses.getUser().getTelephone()}
									20000/月
								</DD>
							</DL>
						</TD>
						<TD class=house-type><LABEL class=ui-green><a href=""><INPUT value="修    改" type=button name=search></a></LABEL></TD>
						<TD class=house-price><LABEL class=ui-green><a href=""><INPUT
								value="删    除" type=button name=search></a></LABEL></TD>
					</TR>
                   </c:forEach> 
				</TBODY>
			</TABLE>
		</DIV>
		<DIV class=pager>
			<UL>
			  <c:forEach var="i" begin="1" end="${requestScope.page.countpage}">
		  		<!-- 判断该页码是否当前页 -->	
			  	  <c:if test="${page.pageno==i}">
			  	  	<li class="active"><a href="javascript:void(0);">${i}</a></li>
			  	  </c:if>
			  	  <c:if test="${page.pageno!=i}">
			  	  	<li><a href="${pageContext.request.contextPath}/house/initMy?pageno=${i}">${i}</a></li>
			  	  </c:if>
			  </c:forEach>
			</UL>
			<SPAN class=total>${page.pageno }/${page.countpage }页</SPAN>
		</DIV>
	</DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>58租房 © 2017 刘大老板 苏ICP证666666666号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
  </body>
</html>
