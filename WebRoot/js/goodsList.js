function deletefun(id){
	if(confirm("确定要删除吗?")){
		window.location.href="goods/delete/"+id;
	}
}
function tiaozhuan(totalPage){
	var num=document.getElementById("jump").value;
	if(!isNaN(num)){
		if(num<1 || num>totalPage){
			alert("只能输入1-"+totalPage+"的数字");
		}else{
			
			window.location.href="goods/list?currPage="+num;
		}						
	}else{
		alert("只能输入1-"+totalPage+"的数字");
	}
}
function addGoods(){
	window.location.href="goods/add";
}
function detailGoods(id){
	$.ajax({
		type:"post",
		url:"goods/detail/"+id,
		dataType:"json",
		success:function(d){
			$("#popDiv").show();
			$("#list").append("<tr><td>商品名称</td><td>"+d.goodsName+"</td></tr>");
			$("#list").append("<tr><td>商品分类</td><td>"+d.category.categoryName+"</td></tr>");
			$("#list").append("<tr><td>价格</td><td>"+d.price+"</td></tr>");
			$("#list").append("<tr><td>库存</td><td>"+d.totalNum+"</td></tr>");				
		}
	});
}
function closeDiv(){
	$("#list").empty();
	$("#popDiv").hide();
}























