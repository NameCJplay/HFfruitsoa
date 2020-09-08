$().ready(function() {
	validateRule();
});

$("[type=submit]").click(function () {
	update();
});
function update() {
	var address = $('.data-province').val()+" "+$('.data-city').val()+" "+$('.data-district').val();
	$('#deptAddress').val(address);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/dept/update",
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
function load(id) {
	$.ajax({
		cache: true,
		type: "get",
		url: "/dept/edit?deptId="+id,
		datatype: "json",
		async: false,
		success: function (data) {
			console.log(data);
			$("#deptId").val(data.deptId);
			if(data.deptParentid == 0){
				$("#maxParent").attr('selected','selected');
			}
			for (var i=0;i<data.deptlist.length;i++){
				if(data.deptlist[i].deptParentid==data.deptId){
					continue;
				}else if(data.deptlist[i].deptId==data.deptId){
					continue;
				}else if(data.deptlist[i].deptId==data.deptParentid){
					$("#deptParentid").append('<option selected="selected" value="'+data.deptlist[i].deptId+'">'+data.deptlist[i].deptName+'</option>');
				}else{
					$("#deptParentid").append('<option value="'+data.deptlist[i].deptId+'">'+data.deptlist[i].deptName+'</option>');
				}
			}
			$("#deptName").val(data.deptName);
			var address =data.deptAddress.split(" ");
			$("#distpicker").distpicker({
				province: address[0],
				city: address[1],
				district: address[2]
			});

			$("#deptAddress").val(data.deptAddress);
		}
	})
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