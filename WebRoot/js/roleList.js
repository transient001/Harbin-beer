function deletefun(id){
	if(confirm("确定要删除吗?")){
		window.location.href="role/delete/"+id;
	}
}
function tiaozhuan(totalPage){
	var num=document.getElementById("jump").value;
	if(!isNaN(num)){
		if(num<1 || num>totalPage){
			alert("只能输入1-"+totalPage+"的数字");
		}else{
			
			window.location.href="role/list?currPage="+num;
		}						
	}else{
		alert("只能输入1-"+totalPage+"的数字");
	}
}
function addRole(){
	window.location.href="role/add"
}
function detailRole(id){
	$.ajax({
		type:"post",
		url:"role/detail/"+id,
		dataType:"json",
		success:function(d){
			$("#popDiv").show();
			$("#list").append("<tr><td>角色名称</td><td>"+d.roleName+"</td></tr>");
			$("#list").append("<tr><td>拥有权限:</td><td>["+d.rightList.length+"]条</td></tr>");
			for(var i=0;i<d.rightList.length;i++){
				$("#list").append("<tr><td>__权限"+(i+1)+"</td><td>"+d.rightList[i].rightName+"</td></tr>");				
			}		
		}
	});
}
function closeDiv(){
	$("#list").empty();
	$("#popDiv").hide();
}






















