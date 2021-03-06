var prefix = '/dept';
$(function() {
	load();

});

var load = function () {
	$('#exampleTable')
		.bootstrapTreeTable(
			{
				id: 'deptId',
				code: 'deptId',
				parentCode: 'deptParentid',
				type: "GET", // 请求数据的ajax类型
				url: prefix + '/list', // 请求数据的ajax的url
				expandColumn: '1',// 在哪一列上面显示展开按钮
				striped: true, // 是否各行渐变色
				bordered: true, // 是否显示边框
				expandAll: false, // 是否全部展开
				columns : [
					{
						title: '编号',
						field: 'deptId',
						visible: false,
						align: 'center',
						valign: 'center',
						width: '15%'
					},
					{
						title: '部门名称',
						field: 'deptName',
						visible: false,
						align: 'center',
						valign: 'center',
						width: '30%'
					},
					{
						title: '所在地址',
						field: 'deptAddress',
						visible: false,
						align: 'center',
						valign: 'center',
						width: '30%'
					},
					{
						title: '操作',
						field: 'id',
						align: 'center',
						valign: 'center',
						formatter: function (item, index) {
							var e = '<a class="btn btn-primary btn-sm '
								+ s_edit_h
								+ '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ item.deptId
								+ '\')"><i class="fa fa-edit"></i></a> ';
							var p = '<a class="btn btn-primary btn-sm '
								+ s_add_h
								+ '" href="#" mce_href="#" title="添加下级" onclick="addthis(\''
								+ item.deptId
								+ '\')"><i class="fa fa-plus"></i></a> ';
							var d = '<a class="btn btn-warning btn-sm '
								+ s_remove_h
								+ '" href="#" title="删除"  mce_href="#" onclick="remove(\''
								+ item.deptId
								+ '\')"><i class="fa fa-remove"></i></a> ';
							return e + d + p;
						}
					}]
			});
}
function searching(){
	if($('#exampleTable').bootstrapTreeTable('getOptions').pageNumber != 1){
		$('#exampleTable').bootstrapTreeTable('refreshOptions', {
			pageNumber: 1
		});
	}else{
		$('#exampleTable').bootstrapTreeTable('refresh');
	}
}
function reLoad() {
	load();
}

function addthis(deptId) {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '365px' ],
		content : '/DeptAddThis?deptId='+deptId
	});
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '365px' ],
		content : '/DeptAdd' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '365px' ],
		content : '/DeptEdit?deptId=' + id // iframe的url
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
				'deptId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					searching();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	layer.confirm("请点击指定部门                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       的删除按钮'");
}