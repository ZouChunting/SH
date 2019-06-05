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
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
			<DIV id=logo><IMG src="images/logo.jpg" width="150px">
			<p style="width=100px;font-size=12px;color: red;font-weight: bold;">
			欢迎！${sessionScope.user.username}
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/house/initMy">进入我的发布页面</a>
			<a href="">注销</a>
			</p></DIV>
		</DIV>
		<DIV id=navbar class=wrap>
			<DL class="search clearfix">
				<FORM id=sform method=post action="${pageContext.request.contextPath}/house/searchHouse">
					<DT>
						<UL>
							<LI class=bold>房屋信息</LI>
							<LI>标题：<INPUT class=text type=text name="title"> <LABEL
								class=ui-blue><INPUT value=搜索房屋
									type="submit" name=search></LABEL>
							</LI>
						</UL>
					</DT>
					<DD>
						<UL>
							<LI class=first>价格</LI>
							<LI><SELECT name="price">
									<OPTION selected value="0-1000000">不限</OPTION>
									<OPTION value="0-100">100元以下</OPTION>
									<OPTION value="100-200">100元—200元</OPTION>
									<OPTION value="200-1000000">200元以上</OPTION>
							</SELECT></LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>房屋位置</LI>
							<LI><SELECT id=street name="street">
							         <OPTION selected value="0">不限</OPTION>
							        <c:forEach items="${streets}" var="streets">
									<OPTION value="${streets.id}">${streets.name}</OPTION>
									</c:forEach>
							</SELECT></LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>房型</LI>
							<LI><SELECT name="type">
							<OPTION selected value="0">不限</OPTION>
							<c:forEach items="${types}" var="types">
							<OPTION value="${types.id}">${types.name}</OPTION>
							</c:forEach>
							</SELECT></LI>
						</UL>
					</DD>
					<DD>
						<UL>
							<LI class=first>面积</LI>
							<LI><SELECT name="floorage">
									<OPTION selected value="0-1000000">不限</OPTION>
									<OPTION value="0-40">40以下</OPTION>
									<OPTION value="40-500">40-500</OPTION>
									<OPTION value="500-1000000">500以上</OPTION>
							</SELECT></LI>
						</UL>
					</DD>
				</FORM>
			</DL>
		</DIV>
		<DIV class="main wrap">
	<TABLE class=house-list>
	  <TBODY>
	 	 <c:forEach items="${houses}" var="houses">
			<TR>			
				<TD class=house-thumb><SPAN><A href="${pageContext.request.contextPath}/house/showHouseDetail?id=${houses.id}"
						target="_blank"><img src="${pageContext.request.contextPath}${houses.img}"
							width="100" height="75" alt=""></A></SPAN>
				</TD>
				<TD>
					<DL>
						<DT>
							<A href="${pageContext.request.contextPath}/house/showHouseDetail?id=${houses.id}" target="_blank">${houses.title}</A>
						</DT>
						<DD>
							${houses.getStreet().getName()},${houses.floorage}平米<BR>联系方式：${houses.getUser().getTelephone()}
						</DD>
					</DL>
				</TD>
			    	 <TD class=house-type>${houses.price}/月</TD>
			    	 <TD class=house-price>${houses.getType().getName()}</TD>				
			</TR>
			</c:forEach>		
		</TBODY>
	</TABLE>
	<DIV class=pager>
	<UL>
	  <LI><a href="${pageContext.request.contextPath}/house/initIndex?pageno=1">首页</a></LI>
	  
	  <c:if test="${page.pageno!=1}">
	  	<LI><a href="${pageContext.request.contextPath}/house/initIndex?pageno=${page.pageno-1 }">上一页</a></LI>
  	  </c:if>
  	  <c:if test="${page.pageno==1}">
  	  	<LI class="disabled"><a href="javascript:void(0);">上一页</a></LI>
  	  </c:if>
  	  
  	  <c:forEach var="i" begin="1" end="${page.countpage}">
  		<!-- 判断该页码是否当前页 -->	
	  	  <c:if test="${page.pageno==i}">
	  	  	<li class="active"><a href="javascript:void(0);">${i}</a></li>
	  	  </c:if>
	  	  <c:if test="${page.pageno!=i}">
	  	  	<li><a href="${pageContext.request.contextPath}/house/initIndex?pageno=${i}">${i}</a></li>
	  	  </c:if>
	  </c:forEach>
	  
	  <c:if test="${page.pageno!=page.countpage}">
	  	<LI><a href="${pageContext.request.contextPath}/house/initIndex?pageno=${page.pageno+1 }">下一页</a></LI>
	  </c:if>
	  <c:if test="${page.pageno==page.countpage}">
	  	<LI class="disabled"><a href="javascript:void(0);">下一页</a></LI>
	  </c:if>
	  
	  <LI><a href="${pageContext.request.contextPath}/house/initIndex?pageno=${page.countpage }">末页</a></LI>
	 </UL>
	 <SPAN class=total>${page.countnumber }/条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      ${page.pageno }/${page.countpage }
	  </SPAN> </DIV></DIV>
	<DIV id=footer class=wrap>
	<DL>
	  <DT>58租房 © 2017 刘大老板 苏ICP证6666666666号</DT>
	  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
  </body>
</html>
