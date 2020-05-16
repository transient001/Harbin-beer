function deletefun(id){
	if(confirm("确定要删除吗?")){
		window.location.href="category/delete/"+id;
	}
}
function tiaozhuan(totalPage){
	var num=document.getElementById("jump").value;
	if(!isNaN(num)){
		if(num<1 || num>totalPage){
			alert("只能输入1-"+totalPage+"的数字");
		}else{
			
			window.location.href="category/list?currPage="+num;
		}						
	}else{
		alert("只能输入1-"+totalPage+"的数字");
	}
}
function addCategoryOne(){
	window.location.href="category/add";
}
function addCategoryTwo(){
	window.location.href="category/addTwo";
}
function detailCategory(id){
	$.ajax({
		type:"post",
		url:"category/detail/"+id,
		dataType:"json",
		success:function(d){
			$("#popDiv").show();
			$("#list").append("<tr><td>一级分类名称:</td><td>"+d[0].categoryName+"</td></tr>");
			for(var i=0;i<d.length;i++){
				$("#list").append("<tr><td>__子分类"+(i+1)+":</td><td>"+d[i].category.categoryName+"</td></tr>");	
			}

		}
	});
}
function closeDiv(){
	$("#list").empty();
	$("#popDiv").hide();
}	
	
