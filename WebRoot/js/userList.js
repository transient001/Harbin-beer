function tiaozhuan(totalPage){
	var num=document.getElementById("jump").value;
	if(!isNaN(num)){
		if(num<1 || num>totalPage){
			alert("只能输入1-"+totalPage+"的数字");
		}else{
			
			window.location.href="user/list?currPage="+num;
		}						
	}else{
		alert("只能输入1-"+totalPage+"的数字");
	}
}
function addUser(){
	window.location.href="user/add";
}
function deletefun(id){
	if(confirm("确定要删除吗?")){
		window.location.href="user/delete/"+id;
	}
}
function detailUser(id){
	$.ajax({
		type:"post",
		url:"user/detail/"+id,
		dataType:"json",
		success:function(d){
			$("#popDiv").show();
			$("#list").append("<tr><td>用户名称</td><td>"+d.userName+"</td></tr>");
			$("#list").append("<tr><td>真实姓名</td><td>"+d.realName+"</td></tr>");
			$("#list").append("<tr><td>用户性别</td><td>"+d.sex+"</td></tr>");
			$("#list").append("<tr><td>邮箱</td><td>"+d.email+"</td></tr>");	
			var date=new Date(d.hiredate);
			$("#list").append("<tr><td>入职时间</td><td>"+date.toLocaleDateString()+"</td></tr>");
			$("#list").append("<tr><td>职位</td><td>"+d.role.roleName+"</td></tr>");	
		}
	});
}
function closeDiv(){
	$("#list").empty();
	$("#popDiv").hide();
}















