$().ready(function() {
	validateRule();
	$("#distpicker").distpicker({
		province: '福建省',
		city: '厦门市',
		district: '思明区'
	});
	
});
$("[type=submit]").click(function () {
	save();
});

function load(id){
// 获得分类列表
	$.ajax({
		cache : true,
		type : "get",
		url : "/dept/list",
		async : true,
		success : function(data) {
			//console.log(data);
			console.log(id);
			var list = $("#deptParentid");
			for (var i =0;i< data.length;i++){
				if(id == data[i].deptId && id>0 ){
					list.append('<option value="'+data[i].deptId+'" selected="selected" >'+data[i].deptName+'</option>');
					list.attr("disabled","disabled");
					break;
				}
				list.append('<option value="'+data[i].deptId+'">'+data[i].deptName+'</option>');
			}

		}
	});
}

function save() {
	var address = $('.data-province').val()+" "+$('.data-city').val()+" "+$('.data-district').val();
	$('#deptAddress').val(address);
	$("#deptParentid").removeAttrs("disabled");
	$.ajax({
		cache : true,
		type : "POST",
		url : "/dept/save",
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
			deptAddress : {
				required : true
			},
		},
		messages : {		
			deptAddress : {
				required : icon+"请输入：所在地址 "
			},

		}
	})
}