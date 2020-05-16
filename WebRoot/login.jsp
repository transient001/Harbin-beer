<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>进销存管理系统</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<!-- 验证框架 -->
<link href="css/validator.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/formValidator.js"></script>
<script type="text/javascript" src="js/formValidatorRegex.js"></script>
<!-- <script type="text/javascript" src="js/login.js"></script> -->
</head>

<body>
<form action="user/login" method="post" id="login_form">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="images/top02.gif"></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
         
        <td width="20%" height="35" class="login-text02">用户名称：<br /></td>
        <td width="80%"><input name="userName" type="text" size="15" id="userName"/><span id="userNameTip"></span></td>
      </tr>
      <tr>
        <td width="20%" height="35" class="login-text02">密　码：<br /></td>
        <td width="80%"><input name="password" type="password" size="15" id="password"/>
    	<span id="passwordTip"></span>
        </td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit" class="right-button01" value="确认登陆" />
          <input name="Submit232" type="reset" class="right-button02" value="重 置" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
