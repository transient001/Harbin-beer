function addSupplier(){
	window.location.href="supplier/add";
}
function deletefun(id){
	if(confirm("您确定要删除吗?")){
		window.location.href="supplier/delete/"+id;
	}
}
  function detailSupplier(id){
	  $.ajax({
		 type:"post",
		 url:"supplier/detail/"+id,
		 dataType:"json",
		 success:function(d){
			 $("#popDiv").show();
			 $("#list").append("<tr><td>供应商名称：</td><td>"+d.supplierName+"</td></tr>");
			 $("#list").append("<tr><td>供应商地址：</td><td>"+d.address+"</td></tr>");
			 $("#list").append("<tr><td>公司电话：</td><td>"+d.mobile+"</td></tr>");
			 $("#list").append("<tr><td>联系人姓名：</td><td>"+d.userName+"</td></tr>");
			 $("#list").append("<tr><td>联系人电话：</td><td>"+d.phone+"</td></tr>");
			 if(d.status=='1'){
				 $("#list").append("<tr><td>状态：</td><td>合作</td></tr>");
			 }else{
				 $("#list").append("<tr><td>状态：</td><td>已取消</td></tr>");
			 }
		 }
	  });
  }
  function closeDiv(){
	  $("#list").empty();
	  $("#popDiv").hide();
  }
  
  function tiaozhuan(totalPage){
		var num=document.getElementById("jump").value;
		if(!isNaN(num)){
			if(num<1 || num>totalPage){
				alert("只能输入1-"+totalPage+"的数字");
			}else{
				
				window.location.href="supplier/list?currPage="+num;
			}						
		}else{
			alert("只能输入1-"+totalPage+"的数字");
		}
	}  