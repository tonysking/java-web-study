<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input id="search" type="text" class="form-control" placeholder="Search" onkeyup="searchWord(this)">
						<div id="showDiv" style="display:none;position:absolute;z-index:1000;background:#fff;width:174px;border:1px solid #ccc;">
							
						</div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<!-- 完成异步搜索功能 -->
				<script type="text/javascript">
				
					function overFn(obj){
						$(obj).css("background","#DBEAF9");
					}
					function outFn(obj){
						$(obj).css("background","#fff");
					}
					function clickFn(obj){
						$("#search").val($(obj).html());
						//$("#showDiv").css("display","none");#
					}
				
					
					function searchWord(obj){
						//1.获得输入框的内容
						//alert(obj.value);
						var word = $(obj).val();
						var content = "";
						//2.根据输入框的内容去数据库模糊查询---List<Product>
						$.post(
							"${pageContext.request.contextPath}/searchWord",
							{"word":word},
							function(data){
								//3.将返回的商品名称显示在showDiv
								//[{"pid":"1","pname":"小米 4c 标准版","market_price":1399.0,"shop_price":1299.0,"pimage":"products/1/c_0001.jpg","pdate":"2015-11-02","is_hot":1,"pdesc":"小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待","pflag":0,"cid":"1"},{"pid":"20","pname":"小米 红米2A 增强版 白色","market_price":649.0,"shop_price":549.0,"pimage":"products/1/c_0019.jpg","pdate":"2015-11-02","is_hot":0,"pdesc":"新增至2GB 内存+16GB容量！4G双卡双待，联芯 4 核 1.5GHz 处理器！","pflag":0,"cid":"1"},{"pid":"49","pname":"小米（MI）7.9英寸平板","market_price":1399.0,"shop_price":1299.0,"pimage":"products/1/c_0049.jpg","pdate":"2015-11-02","is_hot":0,"pdesc":"WIFI 64GB（NVIDIA Tegra K1 2.2GHz 2G 64G 2048*1536视网膜屏 800W）白色","pflag":0,"cid":"2"}]
								//["小米 4c 标准版","小米 红米2A 增强版 白色","小米（MI）7.9英寸平板"]
								
								if(data.length>0){
									for(var i=0; i<data.length; i++){
										//content+="<div>"+data[i].pname+"</div>";
										content+="<div style='padding:3px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"+data[i]+"</div>";
										
									}
									$("#showDiv").html(content);
									$("#showDiv").css("display","block");
								}
							},
							"json"
						);
						
					}
				</script>
			</div>
		</div>
	</nav>
</div>