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
  	<script type="text/javascript" src="js/addUser.js"></script>	
  </head>
  
  <body class="ContentBody">
  	<form action="user/addUpdate" method="post" id="userForm">
  	<c:if test="${!empty user.id }">
  		<input type="hidden" name="id" value="${user.id}" />
  	</c:if>	
  		<div class="MainDiv">
  		<table width="99%" cellpadding="0" cellspacing="0" class="CContent" >
  			<tr>
  				<c:if test="${empty user.id }">
  				<th class="tablestyle_title" >用户添加页面</th>
  				</c:if>
  				<c:if test="${!empty user.id }">
  				<th class="tablestyle_title" >用户修改页面</th>
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
   									<c:if test="${empty user.id }">添加用户</c:if>
   									<c:if test="${!empty user.id}">修改用户</c:if>
   									</legend>
   									<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
   										<tr>
  											<td nowrap align="right" width="13%">用户名称:</td>
  											<td width="41%"><input type="text" name="userName" id="userName" style="width:250px" size="40" value="${user.userName }" />
  												<span id="userNameTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">真实姓名:</td>
  											<td width="41%"><input type="text" name="realName" id="realName" style="width:250px" type="text" size="40" value="${user.realName }" />
  												<span id="realNameTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">密码:</td>
  											<td width="41%"><input type="text" name="password" id="password" style="width:250px" type="password" size="40" value="${user.password }" />
  												<span id="passwordTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">性别:</td>
  											<td width="41%">
  												<select id="sex" name="sex">
  													<option <c:if test="${user.sex=='男' }">selected="selected"</c:if> value="男">男</option>
  													<option <c:if test="${user.sex=='女' }">selected="selected"</c:if> value="女">女</option>
  												</select>
  											<span id="sexTip"></span><span id="sexTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">邮件:</td>
  											<td width="41%"><input class="text" name="email" id="email" style="width:250px" type="text" size="40" value="${user.email }" />
  											<span id="emailTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">职位:</td>
  											<td width="41%">
  												<select name="roleId" id="roleId" >
  													<option value="0">--请选择--</option>
  													<c:forEach items="${roleList }" var="role">
  												'		<option <c:if test="${user.roleId==role.id }">selected="selected"</c:if> value="${role.id }">${role.roleName }</option>													
  													</c:forEach>
  												</select>
  											<span id="role_idTip"></span>
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
  					<c:if test="${empty user.id }">
  						<input type="submit" name="Submit" value="保存" class="button"/>
  					</c:if>
  					<c:if test="${!empty user.id }">
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
