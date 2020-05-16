<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addSupplier.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/updateRight.js"></script>
  </head>
  
  <body class="ContentBody">
  		<input type="hidden" name="id" id="id" value="${right.id }" />
  		<div class="MainDiv">
  		<table width="99%" cellpadding="0" cellspacing="0" class="CContent" >
  			<tr>
   				<th class="tablestyle_title" >权限修改页面</th>
  			</tr>
  			<tr>
  				<td class="CPanel">
  					<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
  						<tr><td align="left"></td></tr>
  						<tr>
  							<td width="100%">
  							   	<fieldset style="height:100%;">
   									<legend>
   										修改权限: 									
   									</legend>
   									<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
   										<tr>
  											<td nowrap align="right" width="13%">权限名称:</td>
  											<td width="41%"><input type="text" name="rightName" id="rightName" style="width:150px" size="40" value="${right.rightName }" /></td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">拥有的子权限:</td>
  											<td>
  												<c:forEach items="${childList }" var="child">
  													<input type="checkbox" name="childRight" value="${child.id }" checked="checked" />${child.rightName }
  												</c:forEach>
  											</td>
  										</tr>
   									</table><br/>
   								</fieldset>
  							</td>
  						</tr>
  					</table>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2" align="center" height="50px">
  					<input type="button" name="Submit" value="修改" class="button" onclick="update()"/>
  					<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1)"/>
  				</td>
  			</tr>
  		
  		</table>
  		</div>
  </body>
</html>
