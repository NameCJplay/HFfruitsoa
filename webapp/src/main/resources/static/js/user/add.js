$().ready(function() {
	validateRule();
	
	
});


$("[type=submit]").click(function () {
	save();
});


function load() {
// 获得分类列表
	$.ajax({
		cache : true,
		type : "get",
		url : "/dept/list",
		async : true,
		success : function(data) {
			// console.log(data);
			var list = $("#userDeptId");
			for (var i =0;i< data.length;i++){
				list.append('<option value="'+data[i].deptId+'">'+data[i].deptName+'</option>');
			}

		}
	});
}
function save() {
	var hidd = $("#userImage").attr("hidden");
	if(hidd == "hidden"){
		$("#userImgs").remove()
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/user/save",
		data : new FormData($('#signupForm')[0]),// 你的formid
		async : false,
		contentType: false,
		processData: false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
	    ignore : [],
		rules : {
			userName : {
				required : true
			},
			userPwd : {
				required : true
			},
		},
		messages : {		
			userName : {
				required : icon+"请输入：用户名 "
			},
			userPwd : {
				required : icon+"请输入：密码 "
			},

		}
	})
}
$("#userImgs").click(function () {
	$("#userImage").attr("hidden","hidden");
});
$("#userImgs").change(function () {
	var objurl = getObjectURL(this.files[0]);
	function getObjectURL(file)
	{
		var url = "";
		if(window.createObjectURL!=undefined)
		{
			url = window.createObjectURL(file);
		}
		else if(window.URL!=undefined)
		{
			url = window.URL.createObjectURL(file);
		}
		else if (window.webkitURL != undefined)
		{
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	$("#userImage").removeAttr("hidden");
	$("#userImage").attr("src", objurl);
});
function preview() {
	window.open($("#userImage").attr("src"));
}