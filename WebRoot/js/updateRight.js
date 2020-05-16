function update(){
	var id=$("#id").val();
	var rightName=$("#rightName").val();
	text = $("input:checkbox[name='childRight']:checked").map(function(index,elem) {
    	return $(elem).val();
    }).get().join(',');	

    window.location.href="right/updateRight?id="+id+"&rightName="+rightName+"&childIdArray="+text;
	
	
}