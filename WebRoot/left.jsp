<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/css.css">
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="images/ico06.gif";}//图片ico06为蓝色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="images/ico04.gif";
	}
}

</SCRIPT>
  </head>
<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02">${userLogin.realName}</span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="user/exit" target="_top" class="left-font01">退出</a>]&nbsp;[<a href="user/updatePdTiaozhuan" target="mainFrame" class="left-font01">修改密码</a>]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>
		


		<!--  进销存系统开始    -->
		<c:forEach items="${rights}" var="rg">
			<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
	          <tr>
	            <td height="29">
					<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="8%"><img name="img8" id="img${rg.id }" src="images/ico04.gif" width="8" height="11" /></td>
							<td width="92%">
									<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('${rg.id}');" >${rg.rightName }</a></td>
						</tr>
					</table>
				</td>
	          </tr>		  
	        </TABLE>
				<table id="subtree${rg.id }" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
						cellspacing="0" class="left-table02">
	        <c:forEach items="${rg.childRight }" var="childRight">
						<tr>
						  <td width="9%" height="20" ><img id="xiaotu20" src="images/ico06.gif" width="8" height="12" /></td>
						  <td width="91%"><a href="${childRight.rightUrl }" target="mainFrame" class="left-font03" >${childRight.rightName}</a></td>
						</tr>
	        </c:forEach>
						
		      </table>
      </c:forEach>
    </TD>
   </tr>
 </table>
