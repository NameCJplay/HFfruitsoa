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
		url : "/classify/list",
		async : true,
		success : function(data) {
			//console.log(data);
			var list = $("#fruitsClassifyId");
			for (var i =0;i< data.length;i++){
				list.append('<option value="'+data[i].classifyId+'">'+data[i].classifyName+'</option>');
			}

		}
	});
}

// $.validator.setDefaults({
// 	submitHandler : function() {
// 		save();
// 	}
// });
function save() {
	var hidd = $("#fruitsImage").attr("hidden");
	if(hidd == "hidden"){
		$("#fruitsImgs").remove()
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/fruits/save",
		data : new FormData($('#signupForm')[0]),// 你的formid
		datatype :"json",
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
			fruitsName : {
				required : true
			},
			fruitsCprice : {
				required : true
				  ,number:true
			},
			fruitsPrice : {
				required : true
				  ,number:true
			},
			fruitsUnit : {
				required : true
			},
			fruitsStock : {
				required : true
				  ,digits:true
			},
		},
		messages : {		
			fruitsName : {
				required : icon+"请输入：名称 "
			},
			fruitsCprice : {
				required : icon+"请输入：成本价 "
			},
			fruitsPrice : {
				required : icon+"请输入：单价 "
			},
			fruitsUnit : {
				required : icon+"请输入：单位 "
			},
			fruitsStock : {
				required : icon+"请输入：库存 "
			},

		}
	})
}
$("#fruitsImgs").click(function () {
	$("#fruitsImage").attr("hidden","hidden");
});
$("#fruitsImgs").change(function () {
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
	$("#fruitsImage").removeAttr("hidden");
	$("#fruitsImage").attr("src", objurl);

});
function preview() {
	window.open($("#fruitsImage").attr("src"));
}