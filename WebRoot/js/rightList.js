function deletefun(id){
	if(confirm("确定要删除吗?")){
		window.location.href="right/delete/"+id;
	}
}
function tiaozhuan(totalPage){
	var num=document.getElementById("jump").value;
	if(!isNaN(num)){
		if(num<1 || num>totalPage){
			alert("只能输入1-"+totalPage+"的数字");
		}else{
			
			window.location.href="right/fenye?currPage="+num;
		}						
	}else{
		alert("只能输入1-"+totalPage+"的数字");
	}
}
function addRight(){
	window.location.href="right/add";
}
function detailRight(id){
	$.ajax({
		type:"post",
		url:"right/detail/"+id,
		dataType:"json",
		success:function(d){
			$("#popDiv").show();
			$("#list").append("<tr><td>权限名称</td><td>"+d.rightName+"</td></tr>");
			$("#list").append("<tr><td>拥有的子权限:</td><td>["+d.childRight.length+"]条</td></tr>");
			for(var i=0;i<d.childRight.length;i++){
				$("#list").append("<tr><td>__权限"+(i+1)+"</td><td>"+d.childRight[i].rightName+"</td></tr>");				
			}		
		}
	});
}
function closeDiv(){
	$("#list").empty();
	$("#popDiv").hide();
}