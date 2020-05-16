<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/userList.js"></script>
  </head>
  
  <body style="background-color: #E6F5FF">
  	<form action="user/updatePassword" method="post">
  		<input type="hidden" name="id" id="id" value="${userLogin.id }" />
  		<table  style="margin-left: 300px; margin-top: 130px">
  			<tr>
  				<td><span>用户:       ${userLogin.realName }</span></td>
  			</tr>
  			<tr>
  				<td>
  					请输入新的密码:<input type="text" name="newPassword" />
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type="submit" name="submit" id="submit" value="修改" />
  				</td>
  			</tr>  			 			
  		</table>
  	</form>
    <span></span>
  </body>
</html>
