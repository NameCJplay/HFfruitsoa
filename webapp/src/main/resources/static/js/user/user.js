var prefix = "/user"
$(function() {
	load();

});




function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,

						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 5, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						search : true, // 是否显示搜索框
						showColumns : true, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						formatLoadingMessage: function () {
							return "请稍等，正在加载中...";
						},
						formatNoMatches: function () {  //没有匹配的结果
							$('#exampleTable').bootstrapTable('removeAll');
							return '无符合条件的记录';
						},
						onLoadError: function (data) {//连接不上错误
							$('#exampleTable').bootstrapTable('removeAll');
							alert("数据异常，请重新登录");
							$('#exampleTable').bootstrapTable('destroy');
							return '请重新登录';
						},
						onLoadSuccess:function(data){//返回数据结构不对的，一般是后台出错了							
	                      if(data.hasOwnProperty("total") && data.hasOwnProperty("rows")){                              
                          }else{
                        	  $('#exampleTable').bootstrapTable('destroy');
                        	  return 'error';
                          }							
						},
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
								sort: params.sort=='idext'?'id':params.sort,
								order: params.order,
								userId:$('#userId').val()==''?undefined:$('#userId').val(),
								userName:$('#userName').val()==''?undefined:$('#userName').val(),
								userPwd:$('#userPwd').val()==''?undefined:$('#userPwd').val(),
								userMobile:$('#userMobile').val()==''?undefined:$('#userMobile').val(),
								userEmail:$('#userEmail').val()==''?undefined:$('#userEmail').val(),
								userImg:$('#userImg').val()==''?undefined:$('#userImg').val(),
								userSex:$('#userSex').val()==''?undefined:$('#userSex').val(),
								userBirth:$('#userBirth').val()==''?undefined:$('#userBirth').val(),
								userCreate:$('#userCreate').val()==''?undefined:$('#userCreate').val(),
								userModified:$('#userModified').val()==''?undefined:$('#userModified').val(),
								userStatus:$('#userStatus').val()==''?undefined:$('#userStatus').val(),
								userRole:$('#userRole').val()==''?undefined:$('#userRole').val(),
								userDeptId:$('#userDeptId').val()==''?undefined:$('#userDeptId').val(),
							};
						},
						columns : [
								{
									checkbox : true
								},
								{
								    field : 'user_id', 
									title : '账号',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userId;
										//paraMap_js[id];
									}
								},
								{
								    field : 'user_name', 
									title : '用户名',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userName;
										//paraMap_js[id];
									}
								},
								{
								    field : 'user_mobile', 
									title : '手机号',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userMobile;
										//paraMap_js[id];
									}
								},
								{
								    field : 'user_email', 
									title : '邮箱',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userEmail;
										//paraMap_js[id];
									}
								},
								{
								    field : 'user_img', 
									title : '头像',
									sortable: true,
									formatter : function(value, row, index) {
										return '<a href="#"  onclick=preview("' + row.userImg + '"); style="color: plum;"title="点击预览">'+row.userImg+'</a>';

								    }
								},
								{
								    field : 'user_sex', 
									title : '性别',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userSex;
										//paraMap_js[id];
									}
								},
								{
								    field : 'user_create', 
									title : '创建时间',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userCreate;
									}
								},
								{
								    field : 'user_modified', 
									title : '上一次修改时间',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userModified;
									}
								},
								{
								    field : 'user_status', 
									title : '状态',
									sortable: true,
									formatter : function(value, row, index) {
										if(row.userStatus == 0){
											return '禁用'
										}else{
											return '正常';
										}
									}
								},
								{
								    field : 'user_role', 
									title : '权限',
									sortable: true,
									formatter : function(value, row, index) {
								    	if(row.userRole == 2){
								    		return '管理员'
										}else{
											return '用户';
										}
									}
								},
								{
								    field : 'user_dept_id', 
									title : '部门',
									sortable: true,
									formatter : function(value, row, index) {
										return row.userDeptName;
									}
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.userId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.userId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function searching(){
	if($('#exampleTable').bootstrapTable('getOptions').pageNumber != 1){
		$('#exampleTable').bootstrapTable('refreshOptions', {
			pageNumber: 1
		});
	}else{
		$('#exampleTable').bootstrapTable('refresh');
	}
//	reLoad();
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/UserAdd' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/UserEdit?userId=' + id // iframe的url
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
				'userId' : id
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
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['userId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					searching();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}

//预览
function preview(url) {
	var kkpath = "http://127.0.0.1:8012/UserImage/";
	window.open('http://127.0.0.1:8012/onlinePreview?url='+encodeURIComponent(kkpath+url));
}