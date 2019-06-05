<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'release.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<LINK rel=stylesheet type=text/css href="css/style.css">
	
	<script type="text/javascript">
	function getStreet(){
		alert("111");
		var district_id=$("#district_id").val();
		var content="";
		$.post(
			"${pageContext.request.contextPath}/house/selectStreetByDistrict",
			{"district_id":district_id},
			function(data){
				for(var i=0;i<data.length;i++){
					content+="<option selected value='"+data[i].id+"'>"+data[i].name+"</option>";
				}
				$("#streetId").html(content);
			},
			"json"
		);
	}
	</script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.jpg" width="150px">		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT>新房屋信息发布</DT>
				<DD class=past>填写房屋信息</DD>
			</DL>
			<DIV class=box>
				<FORM id=add_action method=post name=add.action action=${pageContext.request.contextPath}/House/release.action enctype="multipart/form-data">
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<tr>
									<input type="hidden" name="userId" value=1>
								</tr>
								<TR>
									<TD class=field>标 题：</TD>
									<TD><INPUT id=add_action_title class=text type=text	name="title"></TD>
								</TR>
								<TR>
									<TD class=field>户 型：</TD>
									<TD><SELECT class=text name="typeId">
									<c:forEach items="${types}" var="type">
									<OPTION	selected value="${type.id}">${type.name}</OPTION>
									</c:forEach>
									</SELECT></TD>
								</TR>
								<TR>
									<TD class=field>面 积：</TD>
									<TD><INPUT id=add_action_floorage class=text type=text	name="floorage"></TD>
								</TR>
								<TR>
									<TD class=field>价 格：</TD>
									<TD><INPUT id=add_action_price class=text type=text	name="price"></TD>
								</TR>
								<TR>
									<TD class=field>房产证日期：</TD>
									<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd" var="ItemsDay" />
									<TD><INPUT class=text type=text name="date"></TD>
								</TR>
								<TR>
									<TD class=field>位 置：</TD>
									<TD>区：<SELECT class=text name="district_id" id="district_id" onChange="getStreet()">
									<option selected value=''>--请选择--</option>
									<c:forEach items="${districts}" var="districts">
									<OPTION  value="${districts.id}">${districts.name}</OPTION>
									</c:forEach>
									</SELECT> 街：<SELECT class=text name="streetId" id="streetId">
									<option selected value=''>--请选择--</option>
									
									</SELECT>
									</TD>
								</TR>
								<!-- <TR>
									<TD class=field>联系方式：</TD>
									<TD><INPUT id=add_action_contact class=text type=text name=contact></TD>
								</TR>-->
                                <TR>
									<TD class=field>房屋图片：</TD>
									<TD><INPUT type=file name="multipartFile" ></TD>
								</TR> 
								<TR>
									<TD class=field>详细信息：</TD>
									<TD><TEXTAREA name="description"></TEXTAREA></TD>
								</TR>
                                                                
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT  value=立即发布	type="submit" style="background:skyblue">
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
	<DL>
	  <DT>58租房 © 2017 刘大老板 苏ICP证6666666666号</DT>
	  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
  </body>
</html>
