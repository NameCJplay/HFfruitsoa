
	$(function () {
		total();
		load();
		$(".glyphicon-usd").remove();
		function load(){
			ConvertHot(1);
			$.ajax({
				cache : true,
				type : "get",
				url : "/classify/list?classifyParentid=0",
				async : false,
				success : function(data) {
					var navs = $("#navs");
					for (var i =0;i< data.length;i++){
						navs.append('<li data-toggle="tab" class="nav-item" disabled=""><a href="#" onclick="ConvertClass('+data[i].classifyId+')" class="category" aria-expanded="true">'+data[i].classifyName+'</a></li>');
					}
					$('.nav-item').click(function () {
						$('.nav-item').removeAttr("disabled");
						$(this).attr("disabled","disabled")
					});
				}
			});
		}
		//结算
		$('#Settlement').click(function () {
			//开启加载层
			var index = layer.load(1, {
				shade: [0.1,'#fff'] //0.1透明度的白色背景
			});
			//禁止提交按钮
			$("#Settlement").attr("disabled","disabled");
			//收集商品信息
			var product = $('#mytable').children();
			if(product.length > 0){
				var list = {};
				var id = [];
				for (var i = 0;i<product.length;i++){
					var productall = $(product[i]).children();
					var spanall = $(product[i]).find('span');
					var detailsFruitsid = $($(product[i]).find('.check')).val();//商品编号
					var detailsFruitsname = $(productall[1]).html();//商品名
					var detailsPrice = $(spanall[1]).html();//单价
					var detailsCount = $($(product[i]).find('.num')).val();//数量
					var detailsGross = $($(product[i]).find('.onemoey')).html();//小计
					var detailsDcprice = $('.moey').html();//折扣后总价
					var detailsDiscount = $('#nowPir').html();//折扣
					var cs = {
						'detailsFruitsid':detailsFruitsid,
						'detailsFruitsname':detailsFruitsname,
						'detailsPrice':detailsPrice,
						'detailsCount':detailsCount,
						'detailsGross':detailsGross,
						'detailsDcprice':detailsDcprice,
						'detailsDiscount':detailsDiscount
					}
					id.push(detailsFruitsid);
					list[i]=cs;
				}
				//提交
				$.ajax({
					cache : true,
					type : "post",
					url : "/ordersDetails/pay",
					data: JSON.stringify(list),
					contentType: "application/json", //
					dataType: "html",
					async : false,
					success : function(data) {
						console.log(data)
						if (data!=null) {
							layer.msg("正在进入支付页面...");
							$('#pay').html(data);
						}else{
							layer.msg("交易失败 Q v Q ");
						}
					},error:function () {
						layer.msg("交易异常 Q v Q ");
					}

				});
			}else{
				layer.msg("请挑选喜欢的商品吧 ^ v ^");
			}
			//关闭加载层
			layer.close(index);
			//3秒后解开提交按钮
			setTimeout(function () {
				$("#Settlement").removeAttr("disabled");
				// location.reload();
			},1000)
		});




		//批量删除
		$('#delall').click(function(){
			var dele = layer.confirm('您确定要删除吗？', {
				btn: ['确定','取消'] //按钮
			}, function(){
				$('.check:checked').each(function() {
					let re = $(this).parents("tr");
					delacctive($(this).val());
					re.remove();
					total();
				});
				layer.close(dele);
			});
			$('#nowPir').html("");
			$('#nowPirStr').html('折扣');
		});



	//计算折扣
		$(".zhekou").click(function(){
			var zhekou = $($(this).children()[0]).html();
			if(zhekou>0){
				$('#nowPir').html(zhekou/10);
				$('#nowPirStr').html(zhekou+'折');
			}else{
				$('#nowPir').html('');
				$('#nowPirStr').html('折扣');
			}

			total(zhekou/10);
		});

	//加减框
		$(".num").click(function(){
			var vae = $(this).val();
			var count2 = $(this).next().val();
			if(vae<=0){
				alert('亲，真的不能再少了');
				$(this).val(1);
			}else if(Number(count2)<vae){
				alert('亲，超过咱们库存了哦');
				$(this).val(count2);
			}
			total();
		})
		$(".num").blur(function(){
			var vae = $(this).val();
			var count2 = $(this).next().val();
			if(vae<=0){
				layer.msg('亲，真的不能再少了');
				$(this).val(1);
			}else if(Number(count2)<vae){
				layer.msg('亲，超过咱们库存了哦');
				$(this).val(count2);
			}
			total();
		})


	//全选框
	$('#checkall').change(function(){
			var isChecked = $(this).prop('checked');//监听头选项点击事件,若当前头选项选中则checked属性变为true并赋值给isChecked
			$('.check').prop('checked',isChecked);//将所有子选项选中属性设为true，即全部选中
		});
		//单选框
		$('.check').change(function(){

			var allcount = $('.check').length;//子选项数量
			var checkCount = $('.check:checked').length;//选中的子选项数量
			var isAllChecked = allcount === checkCount;//当子选项数量和选中的子选项数量相等时，赋值true
			$('#checkall').prop('checked',isAllChecked);//将true带入头选项选中属性

		})

		
});
	//计算
	 function total(zhekou){
		 var unit = $(".unit");
		 var num =$(".num");
		 var onemoey = $(".onemoey");
		  var i = 0;
		 $(".onemoey").each(function(){
			 var our = Number($(unit[i]).html())*$(num[i]).val();
			 our = (Math.floor(our*100))/100
			 $(this).html(our);
			 i++;
		 });
		 var all = Number(0);
		 $(".onemoey").each(function(){
		 	var one = $(this).html();
		 	all += Number(one);
		 }); 
		 if(zhekou!=null && zhekou>0)all = all*zhekou;
		 all = (Math.floor(all*100))/100
		 $(".moey").html(all);


	 }
	 //个人中心
	 function open(){
		if( $('#andmin').hasClass('open')){
			 $('#andmin').removeClass('open');
		}else{
			$('#andmin').addClass('open');
		}
	 }
	 //删除橙色框框
	 function delacctive(id){
		 $('.acctive').each(function(){
			 var spa = $(this).find('span');
			 if($(spa[0]).html()==id){
				 $(this).removeClass('acctive');
			 }
		 });
		 $('#nowPir').html("");
		 $('#nowPirStr').html('折扣');
	 }

	function ConvertClass(classid){
		$.ajax({
			cache : true,
			type : "get",
			url : "/fruits/GetFruClassfiy",
			data : { classid: classid},// hot
			async : false,
			success : function(data) {
				if (data != null) {
					//console.log(data);
					$(".allfruits").remove();
					for (var i = 0; i < data.length; i++) {
						var check = $(".check");
						if (check.length > 0) {
							if(cheEActive(data[i].fruitsId)){
								$("#products").append(
									'<div class="col-sm-6 col-md-3 allfruits acctive"><div class="thumbnail">' +
									'<img src="/fruits/getPicture?fruitsId=' + data[i].fruitsId + '" data-holder-rendered="true" style="height: 200px; width: 100%;border: 1px solid #9F9F9F;display: block;">' +
									'<div class="caption"  style="overflow: hidden"><!--这是id》》--><span hidden="hidden">' + data[i].fruitsId + '</span>' +
									'<!--这是name--><h3><span>' + data[i].fruitsName + '</span></h3><br/>' +
									'<p>价格</p><span>' + data[i].fruitsPrice + '</span>元/<span class="unit">' + data[i].fruitsUnit + '</span><p>库存</p><span>' + data[i].fruitsStock + '</span><span>' + data[i].fruitsUnit + '</span></div></div></div>');

							}else{
								$("#products").append(
									'<div class="col-sm-6 col-md-3 allfruits"><div class="thumbnail">' +
									'<img src="/fruits/getPicture?fruitsId=' + data[i].fruitsId + '" data-holder-rendered="true" style="height: 200px; width: 100%;border: 1px solid #9F9F9F;display: block;">' +
									'<div class="caption"  style="overflow: hidden"><!--这是id》》--><span hidden="hidden">' + data[i].fruitsId + '</span>' +
									'<!--这是name--><h3><span>' + data[i].fruitsName + '</span></h3><br/>' +
									'<p>价格</p><span>' + data[i].fruitsPrice + '</span>元/<span class="unit">' + data[i].fruitsUnit + '</span><p>库存</p><span>' + data[i].fruitsStock + '</span><span>' + data[i].fruitsUnit + '</span></div></div></div>');
							}
						}else{
							$("#products").append(
								'<div class="col-sm-6 col-md-3 allfruits"><div class="thumbnail">' +
								'<img src="/fruits/getPicture?fruitsId=' + data[i].fruitsId + '" data-holder-rendered="true" style="height: 200px; width: 100%;border: 1px solid #9F9F9F;display: block;">' +
								'<div class="caption"  style="overflow: hidden"><!--这是id》》--><span hidden="hidden">' + data[i].fruitsId + '</span>' +
								'<!--这是name--><h3><span>' + data[i].fruitsName + '</span></h3><br/>' +
								'<p>价格</p><span>' + data[i].fruitsPrice + '</span>元/<span class="unit">' + data[i].fruitsUnit + '</span><p>库存</p><span>' + data[i].fruitsStock + '</span><span>' + data[i].fruitsUnit + '</span></div></div></div>');
						}
					}
					$("#products").children().click(function(){
						if($(this).hasClass('acctive')){
							var id = $(this).find('span')[0];
							var valu = $(id).html();
							$("#"+valu).parents('tr').remove();
							$(this).removeClass('acctive');
							total();
						}else{
							if(Number($($(this).find("span")[4]).html())>0){
								$(this).addClass('acctive');
								var id = $(this).find('span')[0];
								var name = $(this).find('span')[1];
								var price = $(this).find('span')[2];
								var unit = $(this).find('span')[3];
								var count = $(this).find('span')[4];
								$('#mytable').append('<tr><td><label class="lyear-checkbox checkbox-primary">'+
									'<input type="checkbox" id="'+$(id).html()+'" value="'+$(id).html()+'" class="check"><span></span></label></td>'+
									'<td>'+$(name).html()+'</td><td ><span class="unit">'+$(price).html()+'</span><span>/'+$(unit).html()+'</span></td>'+
									'<td><input class="form-control num" type="number" placeholder="" value="1"><input class="count" type="hidden" value="'+$(count).html()+'" /></td>'+
									'<td><span class="onemoey"></span>元</td>'+
									'<td><div class="btn-group">'+
									'<a class="btn btn-xs btn-default" href="#!" title="" data-toggle="tooltip" data-original-title="编辑"><i class="mdi mdi-pencil"></i></a>'+
									'<a class="btn btn-xs btn-default"  href="#!" title="" data-toggle="tooltip" data-original-title="删除"><i class="mdi mdi-window-close del" ></i></a>'+
									'</div></td></tr>');
								//单选框
								$('.check').change(function(){

									var allcount = $('.check').length;//子选项数量
									var checkCount = $('.check:checked').length;//选中的子选项数量
									var isAllChecked = allcount === checkCount;//当子选项数量和选中的子选项数量相等时，赋值true
									$('#checkall').prop('checked',isAllChecked);//将true带入头选项选中属性

								})
								//加减框
								$(".num").each(function(){
									$(this).click(function(){
										var vae = $(this).val();
										var count2 = $(this).next().val();
										if(vae<=0){
											layer.msg('亲，真的不能再少了');
											$(this).val(1);
										}else if(Number(count2)<vae){
											layer.msg('亲，超过咱们库存了哦');
											$(this).val(count2);
										}
										total();
									})
									$(this).blur(function(){
										var vae = $(this).val();
										var count2 = $(this).next().val();
										if(vae<=0){
											layer.msg('亲，真的不能再少了');
											$(this).val(1);
										}else if(Number(count2)<vae){
											layer.msg('亲，超过咱们库存了哦');
											$(this).val(count2);
										}
										total();
									})


								});
								//删除
								$(".del").click(function () {
										let re = $(this).parents("tr"); //找到要删除的行
										var id = re.find(".check");
										var vare =  $(id).val();
										delacctive(vare);
										re.remove();
									$('#nowPir').html("");
									$('#nowPirStr').html('折扣');
										total();
								});
								//
								total();

							}else{
								layer.msg('这个商品库存不足了哦!');
							}

						}
					});
				}
			}})

	}
	function cheEActive(id) {
		var check = $(".check");
		for (var j = 0; j < check.length; j++) {
			if($(check[j]).val() == id){
				return true
			}else if(j == check.length && $(check[j]).val() != id){
				return false
		}
		}
	}

	function ConvertHot(hotid) {
		$.ajax({
			cache : true,
			type : "get",
			url : "/fruits/GetFruClassfiy",
			data : {hotid: hotid},// hot
			async : false,
			success : function(data) {
				if (data != null) {
					//console.log(data);
					$(".allfruits").remove();
					for (var i = 0; i < data.length; i++) {
						var check = $(".check");
						if (check.length > 0) {
							if(cheEActive(data[i].fruitsId)){
								$("#products").append(
									'<div class="col-sm-6 col-md-3 allfruits acctive"><div class="thumbnail">' +
									'<img src="/fruits/getPicture?fruitsId=' + data[i].fruitsId + '" data-holder-rendered="true" style="height: 200px; width: 100%;border: 1px solid #9F9F9F;display: block;">' +
									'<div class="caption"  style="overflow: hidden"><!--这是id》》--><span hidden="hidden">' + data[i].fruitsId + '</span>' +
									'<!--这是name--><h3><span>' + data[i].fruitsName + '</span></h3><br/>' +
									'<p>价格</p><span>' + data[i].fruitsPrice + '</span>元/<span class="unit">' + data[i].fruitsUnit + '</span><p>库存</p><span>' + data[i].fruitsStock + '</span><span>' + data[i].fruitsUnit + '</span></div></div></div>');

							}else{
								$("#products").append(
									'<div class="col-sm-6 col-md-3 allfruits"><div class="thumbnail">' +
									'<img src="/fruits/getPicture?fruitsId=' + data[i].fruitsId + '" data-holder-rendered="true" style="height: 200px; width: 100%;border: 1px solid #9F9F9F;display: block;">' +
									'<div class="caption"  style="overflow: hidden"><!--这是id》》--><span hidden="hidden">' + data[i].fruitsId + '</span>' +
									'<!--这是name--><h3><span>' + data[i].fruitsName + '</span></h3><br/>' +
									'<p>价格</p><span>' + data[i].fruitsPrice + '</span>元/<span class="unit">' + data[i].fruitsUnit + '</span><p>库存</p><span>' + data[i].fruitsStock + '</span><span>' + data[i].fruitsUnit + '</span></div></div></div>');
							}
						}else{
							$("#products").append(
								'<div class="col-sm-6 col-md-3 allfruits"><div class="thumbnail">' +
								'<img src="/fruits/getPicture?fruitsId=' + data[i].fruitsId + '" data-holder-rendered="true" style="height: 200px; width: 100%;border: 1px solid #9F9F9F;display: block;">' +
								'<div class="caption"  style="overflow: hidden"><!--这是id》》--><span hidden="hidden">' + data[i].fruitsId + '</span>' +
								'<!--这是name--><h3><span>' + data[i].fruitsName + '</span></h3><br/>' +
								'<p>价格</p><span>' + data[i].fruitsPrice + '</span>元/<span class="unit">' + data[i].fruitsUnit + '</span><p>库存</p><span>' + data[i].fruitsStock + '</span><span>' + data[i].fruitsUnit + '</span></div></div></div>');
						}
					}
					$("#products").children().click(function(){
						if($(this).hasClass('acctive')){
							var id = $(this).find('span')[0];
							var valu = $(id).html();
							$("#"+valu).parents('tr').remove();
							$(this).removeClass('acctive');
							total();
						}else{
							if(Number($($(this).find("span")[4]).html())>0){
								$(this).addClass('acctive');
								var id = $(this).find('span')[0];
								var name = $(this).find('span')[1];
								var price = $(this).find('span')[2];
								var unit = $(this).find('span')[3];
								var count = $(this).find('span')[4];
								$('#mytable').append('<tr><td><label class="lyear-checkbox checkbox-primary">'+
									'<input type="checkbox" id="'+$(id).html()+'" value="'+$(id).html()+'" class="check"><span></span></label></td>'+
									'<td>'+$(name).html()+'</td><td ><span class="unit">'+$(price).html()+'</span><span>/'+$(unit).html()+'</span></td>'+
									'<td><input class="form-control num" type="number" placeholder="" value="1"><input class="count" type="hidden" value="'+$(count).html()+'" /></td>'+
									'<td><span class="onemoey"></span>元</td>'+
									'<td><div class="btn-group">'+
									'<a class="btn btn-xs btn-default" href="#!" title="" data-toggle="tooltip" data-original-title="编辑"><i class="mdi mdi-pencil"></i></a>'+
									'<a class="btn btn-xs btn-default"  href="#!" title="" data-toggle="tooltip" data-original-title="删除"><i class="mdi mdi-window-close del" ></i></a>'+
									'</div></td></tr>');
								//单选框
								$('.check').change(function(){

									var allcount = $('.check').length;//子选项数量
									var checkCount = $('.check:checked').length;//选中的子选项数量
									var isAllChecked = allcount === checkCount;//当子选项数量和选中的子选项数量相等时，赋值true
									$('#checkall').prop('checked',isAllChecked);//将true带入头选项选中属性

								})
								//加减框
								$(".num").each(function(){
									$(this).click(function(){
										var vae = $(this).val();
										var count2 = $(this).next().val();
										if(vae<=0){
											layer.msg('亲，真的不能再少了');
											$(this).val(1);
										}else if(Number(count2)<vae){
											layer.msg('亲，超过咱们库存了哦');
											$(this).val(count2);
										}
										total();
									})
									$(this).blur(function(){
										var vae = $(this).val();
										var count2 = $(this).next().val();
										if(vae<=0){
											layer.msg('亲，真的不能再少了');
											$(this).val(1);
										}else if(Number(count2)<vae){
											layer.msg('亲，超过咱们库存了哦');
											$(this).val(count2);
										}
										total();
									})
								});
								//删除
								$(".del").click(function () {
										let re = $(this).parents("tr"); //找到要删除的行
										var id = re.find(".check");
										var vare =  $(id).val();
										delacctive(vare);
										re.remove();
									$('#nowPir').html("");
									$('#nowPirStr').html('折扣');
										total();
								});
								//
								total();

							}else{
								layer.msg('这个商品库存不足了哦!');
							}
						}
					});
				}
			},
			error:function (error) {
				layer.msg('数据异常,请联系管理员!');
			}
		});
	}



			
			


		