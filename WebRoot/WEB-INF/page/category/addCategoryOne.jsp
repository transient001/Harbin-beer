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

  </head>
  
  <body class="ContentBody">
  	<form action="category/addUpdateLevelOne" method="post">
  		<c:if test="${!empty category.id }">
  			<input type="hidden" name="id" value="${category.id }" />
  		</c:if>
  		<div class="MainDiv">
  		<table width="99%" cellpadding="0" cellspacing="0" class="CContent" >
  			<tr>
   				<c:if test="${!empty category.id }">
   					<th class="tablestyle_title" >一级商品分类修改页面</th>
   				</c:if>
   				<c:if test="${empty category.id }">
   					<th class="tablestyle_title" >一级商品分类添加页面</th>
   				</c:if>   			
  				
  			</tr>
  			<tr>
  				<td class="CPanel">
  					<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
  						<tr><td align="left"></td></tr>
  						<tr>
  							<td width="100%">
  							   	<fieldset style="height:100%;">
   									<legend>
   										<c:if test="${!empty category.id }">
   											修改商品分类[一级]:
   										</c:if>
   										<c:if test="${empty category.id }">
   											添加商品分类[一级]:
   										</c:if>   									
   									</legend>
   									<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
   										<tr>
  											<td nowrap align="right" width="13%">商品分类名称:</td>
  											<td width="41%"><input type="text" name="categoryName" style="width:250px" size="40" value="${category.categoryName }" /></td>
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
  					<c:if test="${empty category.id }">
  						<input type="submit" name="Submit" value="保存" class="button"/>
  					</c:if>
  					<c:if test="${!empty category.id }">
  						<input type="submit" name="Submit" value="修改" class="button"/>
  					</c:if>
  					<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1)"/>
  				</td>
  			</tr>
  		
  		</table>
  		</div>
  	</form>
  </body>
</html>
