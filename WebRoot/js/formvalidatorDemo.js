$(function () {
    try {
        $.formValidator.initConfig({
            formid: "formTable",
            errorfocus: false,
            submitonce: true,
            tipstyle: "both",
            onerror: function () { // 验证不通过时的回调函数
                alert("红色提示处输入非法，请根据提示修改！");
            }
        });
        //验证字符串(必填)
        $("#name").formValidator({ // 验证：模块名称
            onshow: "（必填）",
            onfocus: "（必填）不超过50个字符",
            oncorrect: "（正确）"
        }).inputValidator({
            min: 1,
            max: 50,
            onerrormin: "（错误）不能为空",
            onerrormax: "（错误）不超过50个字符，汉字算两个字符"
        });

        //验证字符串(选填)
        $("#name").formValidator({ // 验证：模块名称
            onshow: "（选填）",
            onfocus: "（选填）不超过50个字符",
            oncorrect: "（正确）",
            empty: true
        }).inputValidator({
            min: 1,
            max: 50,
            onerrormin: "（错误）不能为空",
            onerrormax: "（错误）不超过50个字符，汉字算两个字符"
        });

        //验证时间
        $("#addDate").formValidator({ // 验证：发送时间
            onshow: "（必填）",
            onfocus: "（必填）请选择操作时间",
            oncorrect: "（正确）"
        }).functionValidator({
            fun: function (val, elem) {
                if (!/^\d{4}-\d{2}-\d{2}[ ]\d{2}:\d{2}$/.test(val)) {
                    return "（错误）请选择操作时间";
                }
                return true;
            }
        });

        //ajax验证
        $("#account").formValidator({ // 验证：模块名称
            onshow: "（必填）",
            onfocus: "（必填）不超过50个字符",
            oncorrect: "（正确）"
        }).inputValidator({
            min: 1,
            max: 50,
            onerrormin: "（错误）不能为空",
            onerrormax: "（错误）不超过50个字符，汉字算两个字符"
        }).ajaxValidator({
            type: "post",
            url: "EnterpriseManage!ajaxValidatorUserAccount.action",
            success: function (data) {
                if (data == "0") {
                    return true;
                } else if (data == "1") {
                    return false;
                }
            },
            onerror: "该账号已被占用，请更换！"
        });

        //密码及重复密码验证
        $("#password").formValidator({ // 验证：模块名称
            onshow: "（必填）",
            onfocus: "（必填）不超过11个字符",
            oncorrect: "（正确）"
        }).inputValidator({
            min: 1,
            max: 50,
            onerrormin: "（错误）不能为空",
            onerrormax: "（错误）不超过11个字符，汉字算两个字符"
        });

        $("#passwordRepeat").formValidator({
            onshow: "（必填）",
            onfocus: "（必填）2次密码必须一致",
            oncorrect: "（正确）"
        }).compareValidator({
            desid: "password",
            operateor: "=",
            onerror: "（错误）2次密码不一致,请确认"
        });

        //图片格式验证
        $("#tcCodeLogo").formValidator({
            onshow: "（选填）",
            onfocus: "（选填）请上传图片文件",
            oncorrect: "（正确）",
            empty: true
        }).regexValidator({
            regexp: regexEnum.picture,
            onerror: "只能上传图片文件"
        });

        //数值验证
        $("#nameNum").formValidator({ // 验证：模块名称
            onshow: "（必填）",
            onfocus: "（必填）值1到50",
            oncorrect: "（正确）"
        }).inputValidator({
            min: 1,
            max: 50,
            type: "value",
            onerrormin: "（错误）不能为空",
            onerrormax: "（错误）值1到50"
        });
        //电话验证
        $("#linkPhone").formValidator({
            onshow: "（选填）",
            onfocus: "（选填）",
            oncorrect: "（正确）",
            empty: true
        }).regexValidator({
            regexp: "^(\\d{3,4}-?\\d{7,8}|(13|15|18)\\d{9})$",
            onerror: "（错误）电话号码格式不正确，请检查"
        });

        //EMail验证
        $("#linkEmail").formValidator({
            onshow: "（选填）",
            onfocus: "（选填）请选择正确EMail格式",
            oncorrect: "（正确）",
            empty: true
        }).regexValidator({
            regexp: regexEnum.email,
            onerror: "（错误）Email格式不正确，请检查"
        });

        //select验证
        $("#testSelect").formValidator({
            onshow: "（必填）",
            onfocus: "（必填）请选择选项",
            oncorrect: "（正确）"
        }).inputValidator({
            min: 0,  //开始索引
            onerror: "你是不是忘记选择学历了!"
        });

        //隐藏时，默认验证通过
        $("#smsProductName").formValidator({ // 验证
            onshow: "（必填）",
            onfocus: "（必填）不超过50个字符，汉字算两个字符",
            oncorrect: "（正确）"
        }).functionValidator({
            fun: function (val, elem) {
                if ($("#smsProductName").is(":hidden")) {
                    return true;
                }
                if (!/^\S{1,50}$/.test(val)) {
                    return "（错误）不超过50个字符，汉字算两个字符";
                }
                return true;
            }
        });
        //多选选择框的验证方式 略有点复杂了
        $(":checkbox[name='productType']").formValidator({
            onshow: "（至少选择一个）",
            onfocus: "（至少选择一个）",
            oncorrect: "（正确）"
        }).functionValidator({
            fun: function (val, elem) {
                var objs = $(":checkbox[name='productType']");
                for (var i = 0; i < objs.length; i++) {
                    if ($(objs[i]).attr("checked") == true) {
                        $('#productTypeTip').removeClass();
                        $('#productTypeTip').addClass("onSuccess");
                        $('#productTypeTip').html();
                        $('#productTypeTip').html("<nobr>正确</nobr>");
                        return true;
                    }
                }
                $('#productTypeTip').removeClass();
                $('#productTypeTip').addClass("onError");
                $('#productTypeTip').html();
                $('#productTypeTip').html("<nobr>（至少选择一项）</nobr>");
                return false;
            }
        });
    } catch (e) {
        alert(e);
    }
});





$(function() {
	// 验证表单元素
	$.formValidator.initConfig({
		formid : "addUser_form1"
	});

	$("#userCode").formValidator({
		onshow : "请输入用户编码",
		onfocus : "请输入用户编码",
		oncorrect : "用户编码输入正确"
	}).inputValidator({
		min : 1,
		onerror : "用户编码不能为空！"
	}).inputValidator({
		max : 50,
		onerror : "数字字母下划线组成！"
	}).regexValidator({
		regexp:"^\\w+$",
		onerror : "用户编码格式不正确"
     });
//     .ajaxValidator({
//        type: "get",
//        url: "../user"+$("#userCode").val()+"/checkUserCode",
//        data:{ json: "John",t:Math.random()}, 
//        success: function (data) {
//            if (data == "0") {
//                return true;
//            } else if (data == "1") {
//                return false;
//            }
//        },
//        onerror:"此用户编码已存在"
//    })

	$("#userName").formValidator({
		onshow : "请输入用户姓名",
		onfocus : "请输入用户姓名",
		oncorrect : "用户姓名正确"
	}).inputValidator({
		min : 1,
		onerror : "姓名不能为空！"
	}).inputValidator({
		max : 50,
		onerror : "用户姓名长度25字符内！"
	})
	
	$("#password").formValidator({
		onshow:"请输入密码",
		onfocus:"请输入密码",
		oncorrect:"输入密码正确"
	 }).inputValidator({
			min : 1,
			onerror : "密码不能为空！"
		}).inputValidator({
			max : 50,
			onerror : "密码长度8字符内！"
		});
	
	$("#surePassword").formValidator({
		onshow:"请再次输入密码",
		onfocus:"请再次输入密码",
		oncorrect:"确认密码正确"
	   }).inputValidator({
			min : 1,
			onerror : "确认密码不能为空！"
		}).inputValidator({
			max : 50,
			onerror : "确认密码长度8字符内！"
		}).compareValidator({
			desid:"password",
			onerror:"确认密码和密码不相同",
			oncorrect:"确认密码输入正确"
		});
	$("#birthday").formValidator({
		onshow:"请选择出生日期",
		onfocus:"请选择出生日期",
		oncorrect:"选择出生日期正确"
	 }).inputValidator({
			min : 1,
			onerror : "出生日期不能为空！"
		});
	
	$("#phone").formValidator({
		onshow:"请输入手机号码",
		onfocus:"请输入手机号码",
		oncorrect:"输入手机号码正确"
	 }).regexValidator({
			regexp:"^(13|15|18)[0-9]{9}$",
			onerror : "手机号格式不正确"
	});
	
	$("#address").formValidator({
		onshow : "请输入地址",
		onfocus : "请输入地址",
		oncorrect : "地址输入正确"
	}).inputValidator({
		min : 1,
		onerror : "地址不能为空！"
	}).inputValidator({
		max : 50,
		onerror : "地址长度100汉字内！"
	});
	
	$("#role").formValidator({
		onshow : "请选择角色",
		onfocus : "请选择角色",
		oncorrect : "角色选择正确"
	}).inputValidator({
		min : 1,
		onerror : "请选择角色！"
	});
});