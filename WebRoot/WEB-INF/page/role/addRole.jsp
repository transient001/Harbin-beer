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
	<link rel="stylesheet" type="text/css" href="css/styleadd.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  	<!-- 表单验证js -->
  	<link rel="stylesheet" type="text/css" href="css/validator.css">
  	<script type="text/javascript" src="js/formValidator.js"></script>
  	<script type="text/javascript" src="js/formValidatorRegex.js"></script>
  	<script type="text/javascript" src="js/addRole.js"></script>	
  </head>
  
  <body class="ContentBody">
  	<form action="role/addUpdate" method="post" id="rightForm">
  	<c:if test="${!empty role.id }">
  		<input type="hidden" name="id" id="id" value="${role.id}" />
  	</c:if>	
  		<div class="MainDiv">
  		<table width="99%" cellpadding="0" cellspacing="0" class="CContent" >
  			<tr>
  				<c:if test="${empty role.id }">
  				<th class="tablestyle_title" >角色添加页面</th>
  				</c:if>
  				<c:if test="${!empty role.id }">
  				<th class="tablestyle_title" >角色修改页面</th>
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
   									<c:if test="${empty role.id }">添加角色</c:if>
   									<c:if test="${!empty role.id}">修改角色</c:if>
   									</legend>
   									<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
   										<tr>
  											<td nowrap align="right" width="13%">角色名称:</td>
  											<td width="41%"><input type="text" name="roleName" id="roleName" style="width:250px" size="40" value="${role.roleName }" />
  												<span id="roleNameTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">角色权限:</td>
  											<td width="41%">
  												<c:forEach items="${rightList }" var="r"><!-- 如果角色role.id不为空（修改）默认勾选该角色拥有的权限 -->
  													<input type="checkbox" name="rightId" value="${r.id }" <c:forEach items="${rights }" var="right"><c:if test="${!empty role.id and right.id==r.id }">checked="checked"</c:if></c:forEach> />${r.rightName }
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
  					<c:if test="${empty role.id }">
  						<input type="button" name="Submit" value="保存" class="button" onclick="save()"/>
  					</c:if>
  					<c:if test="${!empty role.id }">
  						<input type="button" name="Submit" value="修改" class="button" onclick="update()"/>
  					</c:if>
  					<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1)"/>
  				</td>
  			</tr>
  		
  		</table>
  		</div>
  	</form>
  </body>
</html>
