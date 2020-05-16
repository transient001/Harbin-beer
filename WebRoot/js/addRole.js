function save(){
	var roleName=$("#roleName").val();
	/*alert(roleName);*/
	text = $("input:checkbox[name='rightId']:checked").map(function(index,elem) {
    	return $(elem).val();
    }).get().join(',');
    	/*alert("选中的checkbox的值为："+text);*/
    window.location.href="role/addRole?roleName="+roleName+"&rightIdArray="+text;

}

function update(){
	var id=$("#id").val();
	var roleName=$("#roleName").val();
	text = $("input:checkbox[name='rightId']:checked").map(function(index,elem) {
    	return $(elem).val();
    }).get().join(',');	
    window.location.href="role/updateRole?id="+id+"&roleName="+roleName+"&rightIdArray="+text;	
}