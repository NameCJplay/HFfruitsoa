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
		url: "/classify/edit?classifyId="+id,
		datatype: "json",
		async: false,
		success: function (data) {
			//console.log(data);
			$("#classifyId").val(data.classifyId);
			if(data.classifyParentid == 0){
				$("#maxParent").attr('selected','selected');
			}
			for (var i=0;i<data.classlist.length;i++){
				if(data.classlist[i].classifyParentid==data.classifyId || data.classlist[i].classifyId==data.classifyId){
					continue;
				}else if(data.classlist[i].classifyId==data.classifyParentid){
					$("#classifyParentid").append('<option selected="selected" value="'+data.classlist[i].classifyId+'">'+data.classlist[i].classifyName+'</option>');
				}else{
					$("#classifyParentid").append('<option value="'+data.classlist[i].classifyId+'">'+data.classlist[i].classifyName+'</option>');
				}
			}
			$("#classifyName").val(data.classifyName);
		}
	})
}

function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/classify/update",
		data : $('#signupForm').serialize(),
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name);
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