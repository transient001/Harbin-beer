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
  	<!-- <script type="text/javascript" src="js/addSupplier.js"></script> -->	
  </head>
  
  <body class="ContentBody">
  	<form action="supplier/addUpdate" method="post" id="supplierForm">
  		<c:if test="${!empty sp.id }">
  			<input type="hidden" name="id" value="${sp.id }" >
  		</c:if>
  		<div class="MainDiv">
  		<table width="99%" cellpadding="0" cellspacing="0" class="CContent" >
  			<tr>
  				<c:if test="${empty sp.id }">
  				<th class="tablestyle_title" >供应商添加页面</th>
  				</c:if>
  				<c:if test="${!empty sp.id }">
  				<th class="tablestyle_title" >供应商修改页面</th>
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
   									<c:if test="${empty sp.id }">添加供应商</c:if>
   									<c:if test="${!empty sp.id}">修改供应商</c:if>
   									</legend>
   									<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
   										<tr>
  											<td nowrap align="right" width="13%">供应商名称:</td>
  											<td width="41%"><input type="text" name="supplierName" id="supplierName" style="width:250px" size="40" value="${sp.supplierName }" />
  												<span id="supplierNameTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">地址:</td>
  											<td width="41%"><input type="text" name="address" id="address" style="width:250px" type="text" size="40" value="${sp.address }" />
  												<span id="addressTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">座机:</td>
  											<td width="41%"><input type="text" name="mobile" id="mobile" style="width:250px" size="40" value="${sp.mobile }" />
  												<span id="mobileTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">联系人:</td>
  											<td width="41%"><input class="text" name="userName" id="userName" style="width:250px" type="text" size="40" value="${sp.userName }" />
  											<span id="addressTip"></span><span id="userNameTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">联系电话:</td>
  											<td width="41%"><input class="text" name="phone" id="phone" style="width:250px" type="text" size="40" value="${sp.phone }" />
  											<span id="phoneTip"></span>
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
  					<c:if test="${empty sp.id }">
  						<input type="submit" name="Submit" value="保存" class="button"/>
  					</c:if>
  					<c:if test="${!empty sp.id }">
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
