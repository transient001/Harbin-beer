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
  	<script type="text/javascript" src="js/addStockIn.js"></script>	
  </head>
  
  <body class="ContentBody">
  	<form action="stockIn/addUpdate" method="post" id="stockInForm">
  		<c:if test="${!empty stockIn.id }">
  			<input type="hidden" name="id" value="${stockIn.id}" />
  		</c:if>		
  		<div class="MainDiv">
  		<table width="99%" cellpadding="0" cellspacing="0" class="CContent" >
  			<tr>
  				<c:if test="${empty stockIn.id }">
  				<th class="tablestyle_title" >入库单添加页面</th>
  				</c:if>
  				<c:if test="${!empty stockIn.id }">
  				<th class="tablestyle_title" >入库单修改页面</th>
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
   									<c:if test="${empty stockIn.id }">添加入库单</c:if>
   									<c:if test="${!empty stockIn.id}">修改入库单</c:if>
   									</legend>
   									<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
   										<tr>
  											<td nowrap align="right" width="13%">入库单名称:</td>
  											<td width="41%">
  												<input type="text" name="stockInName" id="stockInName" style="width:250px" size="40" value="${stockIn.stockInName}" />
  												<span id="stockInNameTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">选择供应商:</td>
  											<td width="41%">
  												<select name="supplierId" id="supplierId">
  													<option value="0">--请选择--</option>
  													<c:forEach items="${supplierList }" var="supplier">
  														<option value="${supplier.id }" <c:if test="${supplier.id==stockIn.supplierId }">selected="selected"</c:if>>${supplier.supplierName }</option>
  													</c:forEach>
  												</select>
  												<span id="supplierIdTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">选择商品:</td>
  											<td width="41%">
  												<select name="goodsId" id="goodsId">
  													<option value="0">--请选择--</option>
  													<c:forEach items="${goodsList }" var="g">
  														<option value="${g.id }" <c:if test="${g.id==stockIn.goodsId}">selected="selected"</c:if>>${g.goodsName }</option>
  													</c:forEach>
  												</select>
  												<span id="goodsIdTip"></span>
  											</td>
  										</tr>
  										<tr>
  											<td nowrap align="right" width="13%">入库单数量:
  												<input type="hidden" name="userId" value="${userLogin.id }" />
  											</td>
  											<td width="41%">
  												<input class="text" name="stockInNum" id="stockInNum" style="width:250px" type="text" size="40" value="${stockIn.stockInNum }" />
  												<span id="stockInNumTip"></span>
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
  					<c:if test="${empty stockIn.id }">
  						<input type="submit" name="Submit" value="保存" class="button"/>
  					</c:if>
  					<c:if test="${!empty stockIn.id }">
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
