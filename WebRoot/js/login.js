$(function() {
	var username=$("#userName").val()
	// 验证表单元素
	$.formValidator.initConfig({
		formid : "login_form"
	});

	$("#userName").formValidator({
		onshow : "输入用户名",
		onfocus : "输入用户名",
		oncorrect : "用户名输入正确"
	}).inputValidator({
		min : 1,
		onerror : "用户名不能为空！"
	}).regexValidator({
		regexp:"^[A-Za-z]+$",
		onerror : "用户名只能为字母"
    }).ajaxValidator({
        type: "post",
        url: "user/ajaxCheckUserName",
        data:"username="+username,
        success: function (data) {
        	if(data=="1"){
        		return true;
        	}else{
        		return false;
        	}
        },
        onerror: "此用户不可用",
    });
	
   
});