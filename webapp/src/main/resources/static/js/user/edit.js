$().ready(function() {
	validateRule();

});

$("[type=submit]").click(function () {
	update();
});

function load(id) {
	$.ajax({
		cache: true,
		type: "get",
		url: "../user/edit",
		data: {userId: id},
		datatype: "json",
		async: false,
		success: function (data) {
			//console.log(data);
			$("#userId").val(data.userId);
			$("#userName").val(data.userName);
			$("#userPwd").val(data.userPwd);
			$("#userMobile").val(data.userMobile);
			$("#userEmail").val(data.userEmail);
			$("#userImage").attr("src","/user/getPicture?userId="+data.userId);
			// $("#userImg").val(data.userImg);
			$("#userBirth").val(data.userBirth);
			if(data.userSex=='女' && data.userSex!=null){
				$("#userSex").append('<option value="男">男</option>');
				$("#userSex").append('<option selected="selected" value="女">女</option>');
			}else{
				$("#userSex").append('<option selected="selected" value="男">男</option>');
				$("#userSex").append('<option value="女">女</option>');

			}
			if(data.userStatus == 0){
				$("#userStatus").append('<option value="1">正常</option>');
				$("#userStatus").append('<option selected="selected" value="0">禁用</option>');
			}else{
				$("#userStatus").append('<option selected="selected" value="1">正常</option>');
				$("#userStatus").append('<option value="0">禁用</option>');
			}
			if(data.userRole == 1){
				$("#userRole").append('<option selected="selected" value="1">普通用户</option>');
				$("#userRole").append('<option value="2">管理员</option>');
			}else{
				$("#userRole").append('<option value="1">普通用户</option>');
				$("#userRole").append('<option selected="selected" value="2">管理员</option>');
			}
			for (var i=0;i<data.deptlist.length;i++){
				if(data.deptlist[i].deptId==data.userDeptId){
					$("#userDeptId").append('<option selected="selected" value="'+data.deptlist[i].deptId+'">'+data.deptlist[i].deptName+'</option>');
				}else{
					$("#userDeptId").append('<option value="'+data.deptlist[i].deptId+'">'+data.deptlist[i].deptName+'</option>');
				}
			}
		}
	})
}
function update() {
	var hidd = $("#userImages").attr("hidden");
	if(hidd == "hidden"){
		$("#userImgs").remove()
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/user/update",
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
$("#userImgs").change(function () {
	var objurl = getObjectURL(this.files[0]);
	function getObjectURL(file)
	{
		var url = "";
		if(window.createObjectURL!=undefined)
		{
			$("#userImage").removeAttr("hidden");
			$("#userImages").attr("hidden","hidden");
			url = window.createObjectURL(file);
		}
		else if(window.URL!=undefined || window.URL!=null)
		{
			$("#userImage").removeAttr("hidden");
			$("#userImages").attr("hidden","hidden");
			url = window.URL.createObjectURL(file);
		}
		else if (window.webkitURL != undefined || window.webkitURL!=null)
		{
			$("#userImage").removeAttr("hidden");
			$("#userImages").attr("hidden","hidden");
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	$("#userImages").attr("src", objurl);
	$("#userImages").removeAttr("hidden");
	$("#userImage").attr("hidden","hidden");

});
function preview() {
	window.open($("#userImage").attr("src"));
}
function preview2() {
	window.open($("#userImages").attr("src"));
}
function imgbutton(){
	// $("#userImage").attr("hidden","hidden");
	$("#userImgs").click();
}