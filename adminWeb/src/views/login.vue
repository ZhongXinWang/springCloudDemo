<template>
 <div class="main-container">
 			<div class="main-content">
 				<div class="row">
 					<div class="col-sm-10 col-sm-offset-1">
 						<div class="login-container">
 							<div class="center">
 								<h1>
 									<i class="ace-icon fa fa-leaf green"></i>
 									<span class="red">控台管理</span>
 								</h1>
 								<h4 class="blue" id="id-company-text">&copy;Winston.Wang</h4>
 							</div>

 							<div class="space-6"></div>

 							<div class="position-relative">
 								<div id="login-box" class="login-box visible widget-box no-border">
 									<div class="widget-body">
 										<div class="widget-main">
 											<h4 class="header blue lighter bigger">
 												<i class="ace-icon fa fa-coffee green"></i>
 												填写用户名密码
 											</h4>

 											<div class="space-6"></div>

 											<form>
 												<fieldset>
 													<label class="block clearfix">
 														<span class="block input-icon input-icon-right">
 															<input type="text" class="form-control" placeholder="用户名" />
 															<i class="ace-icon fa fa-user"></i>
 														</span>
 													</label>

 													<label class="block clearfix">
 														<span class="block input-icon input-icon-right">
 															<input type="password" class="form-control" placeholder="密码" />
 															<i class="ace-icon fa fa-lock"></i>
 														</span>
 													</label>

 													<div class="space"></div>

 													<div class="clearfix">
 														<label class="inline">
 															<input type="checkbox" class="ace" />
 															<span class="lbl">记住我</span>
 														</label>

 														<button type="button"
																class="width-35 pull-right btn btn-sm btn-primary"
																v-on:click="login()">
															<!--绑定事件-->
 															<i class="ace-icon fa fa-key"></i>
 															<span class="bigger-110">登录</span>
 														</button>
 													</div>

 													<div class="space-4"></div>
 												</fieldset>
 											</form>
 										</div><!-- /.widget-main -->
 									</div><!-- /.widget-body -->
 								</div><!-- /.login-box -->
 							</div><!-- /.position-relative -->
 						</div>
 					</div><!-- /.col -->
 				</div><!-- /.row -->
 			</div><!-- /.main-content -->
 		</div><!-- /.main-container -->
</template>
<script>

    // 对外默认提供的接口
    export default {
        name: "login",
		mounted() {
			$("body").removeAttr("no-skin");
			$("body").attr("class", "login-layout light-login");
		},
		// 事件执行方法
		methods:{
			login(){
				let _this = this;
				// 跳转到首页
				_this.$router.push("/admin/welcome")
			}
		}
	}
</script>