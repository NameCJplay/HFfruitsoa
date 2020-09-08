$().ready(function() {
	validateRule();
});
$("[type=submit]").click(function () {
	update();
});
function update() {
	var hidd = $("#fruitsImages").attr("hidden");
	if(hidd == "hidden"){
		$("#fruitsImgs").remove()
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/fruits/update",
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
function load(id) {
	$.ajax({
		cache: true,
		type: "get",
		url: "../fruits/edit",
		data: {fruitsId: id},
		datatype: "json",
		async: false,
		success: function (data) {
			$("#fruitsId").val(data.fruitsId);
			for (var i=0;i<data.classlist.length;i++){
				if(data.classlist[i].classifyId==data.fruitsClassifyId){
					$("#fruitsClassifyId").append('<option selected="selected" value="'+data.classlist[i].classifyId+'">'+data.classlist[i].classifyName+'</option>');
				}else{
					$("#fruitsClassifyId").append('<option value="'+data.classlist[i].classifyId+'">'+data.classlist[i].classifyName+'</option>');
				}
			}
			$("#fruitsName").val(data.fruitsName);
			$("#fruitsCprice").val(data.fruitsCprice);
			$("#fruitsPrice").val(data.fruitsPrice);
			$("#fruitsUnit").val(data.fruitsUnit);
			$("#fruitsStock").val(data.fruitsStock);
			if(data.fruitsImg!=null)$("#fruitsImage").attr("src","/fruits/getPicture?fruitsId="+data.fruitsId);
			$("#fruitsCreateDate").val(data.fruitsCreateDate);
			$("#fruitsMaturityDate").val(data.fruitsMaturityDate);
			$("#fruitsSupplier").val(data.fruitsSupplier);
			$("#fruitsHot option[value='" + data.fruitsHot + "']").attr("selected", "selected");
			$("#fruitsStatus option[value='" + data.fruitsStatus + "']").attr("selected", "selected");
		}
	})
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

$("#fruitsImgs").change(function () {
	var objurl = getObjectURL(this.files[0]);
	function getObjectURL(file)
	{
		var url = "";
		if(window.createObjectURL!=undefined)
		{
			$("#fruitsImage").removeAttr("hidden");
			$("#fruitsImages").attr("hidden","hidden");
			url = window.createObjectURL(file);
		}
		else if(window.URL!=undefined)
		{
			$("#fruitsImage").removeAttr("hidden");
			$("#fruitsImages").attr("hidden","hidden");
			url = window.URL.createObjectURL(file);
		}
		else if (window.webkitURL != undefined)
		{
			$("#fruitsImage").removeAttr("hidden");
			$("#fruitsImages").attr("hidden","hidden");
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	$("#fruitsImages").attr("src", objurl);
	$("#fruitsImages").removeAttr("hidden");
	$("#fruitsImage").attr("hidden","hidden");
});
function preview() {
	window.open($("#fruitsImage").attr("src"));
}
function preview2() {
	window.open($("#fruitsImages").attr("src"));
}
function imgbutton(){
	$("#fruitsImgs").click();
}