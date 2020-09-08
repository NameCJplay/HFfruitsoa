var prefix = "/notifyFile"

function load(id){
	$("#fileNotifyId").val(id);
	$("#Saved").children().remove();
	$.ajax({
		cache: true,
		type: "get",
		url: prefix+'/getby?fileNotifyId=' + id,
		datatype: "json",
		async: false,
		success: function (data) {
			for (var i=0;i < data.length;i++){
				$("#Saved").append('<p style="margin-top: 25px">' +
					'<i style="font-size: 30px" class="mdi mdi-emoticon-happy" title="已保存"></i>' +
					'<span id="'+data[i].fileId+'" onclick="preview(\''+data[i].fileFilename+'\')" class="label label-success" style="padding:10px;font-size: 20px;cursor: pointer"' +
					' title="点击预览">'+data[i].fileName +'</span>' +
					'<button class="btn btn-w-md btn-round btn-secondary" type="button"  onclick="remove('+data[i].fileId+')">删除</button>' +
				'</p>');
			}

		}
	})
}

function add() {
	$("#hfFiles").click();
}
$("#hfFiles").change(function () {
	var filename = $(this)[0].files;
	$('#unsave').children().remove();
	for (var i = 0;i<filename.length;i++){
		$('#unsave').append('<p style="margin-top: 25px">\n' +
			'<i style="font-size: 30px"  class="mdi mdi-emoticon-sad" title="未保存"></i>\n' +
			'<span class="label label-danger" style="padding:10px;font-size: 20px;cursor: pointer" title="保存后预览">\n' +
			filename[i].name +
			'</span>\n' +
			'</p>');
	}
});




function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/notifyFile/save",
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

		},
		error:function (error) {
			layer.msg("文件最大不过5M");
		}
	});
}



function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'fileId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					$("#"+id).parent("p").remove();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}
//预览
function preview(fileName) {
	var kkpath = "http://127.0.0.1:8012/NotifyFIle/";
	var url = kkpath+fileName; //要预览文件的访问地址
	if(url != null )window.open('http://127.0.0.1:8012/onlinePreview?url='+encodeURIComponent(url));
}
