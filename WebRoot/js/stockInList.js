function addStockIn(){
	//跳转到servlet
	window.location.href="stockIn/add";
}
function deletefun(id){
	if(confirm("您确定要删除吗?")){
		window.location.href="stockIn/delete/"+id;
	}
}
function tiaozhuan(totalPage){
	var num=document.getElementById("jump").value;
	if(!isNaN(num)){
		if(num<1 || num>totalPage){
			alert("只能输入1-"+totalPage+"的数字");
		}else{
			
			window.location.href="stockIn/list?currPage="+num;
		}						
	}else{
		alert("只能输入1-"+totalPage+"的数字");
	}
}
function detailStockIn(id){
	$.ajax({
		type:"post",
		url:"stockIn/detail/"+id,
		dataType:"json",
		success:function(d){
			$("#popDiv").show();
			$("#list").append("<tr><td>入库单名称</td><td>"+d.stockInName+"</td></tr>");
			var date=new Date(d.stockInDate);
			$("#list").append("<tr><td>入库时间</td><td>"+date.toLocaleDateString()+"</td></tr>");			
			$("#list").append("<tr><td>入库数量</td><td>"+d.stockInNum+"</td></tr>");
			$("#list").append("<tr><td>商品名称</td><td>"+d.goods.goodsName+"</td></tr>");				
			$("#list").append("<tr><td>供应商名称</td><td>"+d.supplier.supplierName+"</td></tr>");				
			$("#list").append("<tr><td>填写人</td><td>"+d.user.realName+"</td></tr>");				
			if(d.status=="1"){
				$("#list").append("<tr><td>状态：</td><td>草稿</td></tr>");
			}else if(d.status=="2"){
				$("#list").append("<tr><td>状态：</td><td>通过</td></tr>");
			}else if(d.status=="3"){
				$("#list").append("<tr><td>状态：</td><td>删除</td></tr>");
			}else if(d.status=="4"){
				$("#list").append("<tr><td>状态：</td><td>驳回</td></tr>");
			}else if(d.status=="5"){
				$("#list").append("<tr><td>状态：</td><td>完成</td></tr>");
			}
		}
		
	})
	
}
function closeDiv(){
	$("#list").empty();
	$("#popDiv").hide();
}
