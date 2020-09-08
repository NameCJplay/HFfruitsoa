$().ready(function() {
	validateRule();


});
function load(id){
// 获得分类列表
	$.ajax({
		cache : true,
		type : "get",
		url : "/classify/list",
		async : true,
		success : function(data) {
			//console.log(data);
			console.log(id);
			var list = $("#classifyParentid");
			for (var i =0;i< data.length;i++){
				if(id == data[i].classifyId && id>0 ){
					list.append('<option value="'+data[i].classifyId+'" selected="selected" >'+data[i].classifyName+'</option>');
					list.attr("disabled","disabled");
					break;
				}
				list.append('<option value="'+data[i].classifyId+'">'+data[i].classifyName+'</option>');
			}

		}
	});
}


$("[type=submit]").click(function () {
	save();
});
function save() {
	$("#classifyParentid").removeAttrs("disabled");
	$.ajax({
		cache : true,
		type : "POST",
		url : "/classify/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
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
			classifyName : {
				required : true
			},
		},
		messages : {
			classifyName : {
				required : icon+"请输入：分类名称 "
			},

		}
	})
}