<%@page import="com.sxt.pojo.PageUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'productList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/css.css">
	<link rel="stylesheet" type="text/css" href="css/stylelist.css">
	<link rel="stylesheet" type="text/css" href="css/cengDemo.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
	<script type="text/javascript" src="js/roleList.js" ></script>

  </head>
 <!-- jqgrid层开始 -->
 <div class="mydiv"
	style="z-index:100; width: 300px; display none; height: 220px; left: 45%;"
	id="popDiv">
	<h4>
		<div style="width 100px; float: left">角色详细信息</div>
		<div style="float: right">
			<img style="CURSOR: hand" onclick=closeDiv() src="images/close.png" />
		</div>
	</h4>
	 	
	<div style="width: 70%; HEIGHT: 84%;margin-left:50px" >
	   	<table  id="list" style="width: 100%; table-LAYOUT: fixed; HEIGHT: 100%" class=ui-pg-table  border=0 cellspacing=0 cellpadding=0>
	      
	   	</table>
	</div>
 </div>
 <!-- 层结束 -->
<form action="role/list" name="fom" id="fom" method="post" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			  <td width="538">查看内容：角色名称：
				<input name="roleName" type="text" size="12" />
				<input name="Submit4" type="submit" class="right-button02" value="查 询" /></td>
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除所选角色" />
	              <input name="Submit2" type="button" class="right-button08" value="添加角色" onclick="addRole()"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="8" align="center" style="font-size:16px">角色详细列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="4%" align="center" height="30">选择</td>
                    <td width="10%">角色名称</td>
                    <td width="10%">权限</td>
					<td width="12%">操作</td>
                  </tr>
                  <c:forEach items="${pageUtil.pageList}" var="role">
                  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid" value="${roler.id }"/></td>
                    <td >${role.roleName }</td>
                    <td ><c:forEach items="${role.rightList }" var="right">${right.rightName } || </c:forEach>  </td>                
                    <td><a href="role/load/${role.id }">编辑|</a><a href="javascript:detailRole(${role.id })">查看|</a>
					<a href="javascript:deletefun(${role.id })">删除</a></td>
                  </tr>
				</c:forEach>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">${pageUtil.totalPage }</span> 页 | 第 <span class="right-text09">${pageUtil.currPage }</span> 页</td>
                <td width="49%" align="right">[<a href="role/list?currPage=1" class="right-font08">首页</a> | <c:if test="${pageUtil.currPage==1 }">上一页</c:if><c:if test="${pageUtil.currPage>1 }"><a href="role/list?currPage=${pageUtil.currPage-1 }" class="right-font08">上一页</a></c:if>  | <c:if test="${pageUtil.totalPage==pageUtil.currPage}">下一页</c:if> <c:if test="${pageUtil.currPage!=pageUtil.totalPage }"><a href="role/list?currPage=${pageUtil.currPage+1}" class="right-font08">下一页</a></c:if> | <a href="role/list?currPage=${pageUtil.totalPage }" class="right-font08">末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" id="jump" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="button" class="right-button06" value=""  onclick="tiaozhuan(${pageUtil.totalPage})" />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</td>
</tr>
</table>
</form>
</html>