<template>
        <div>
            <p>
                <button v-on:click="add()" class="btn btn-white btn-default btn-round">
                    <i class="ace-icon fa fa-pencil"></i>
                    新增
                </button>
                <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
                    <i class="ace-icon fa fa-refresh"></i>
                    刷新
                </button>
            </p>
            <pagination  ref="pagination" v-bind:list="list"/>
            <table id="simple-table" class="table  table-bordered table-hover">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <tr v-for="item in chapters">
                    <td>{{item.name}}</td>
                    <td>{{item.courseId}}</td>
                    <td>
                        <div class="hidden-sm hidden-xs btn-group">

                            <button class="btn btn-xs btn-info" v-on:click="edit(item)">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                            </button>
                            <button class="btn btn-xs btn-danger" v-on:click="del(item.id)">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>
                        </div>
                        <div class="hidden-md hidden-lg">
                            <div class="inline pos-rel">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li>
                                        <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">新增</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label for="inputName" class="col-sm-2 control-label">名称<span class="red">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputName" name="name" placeholder="名称" v-model="chapter.name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputCurseId" class="col-sm-2 control-label">课程Id<span class="red">*</span></label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputCurseId" name="courseId" placeholder="课程Id" v-model="chapter.courseId">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" v-on:click="save()">保存</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</template>
<script>
    // 导入分页组件
    import Pagination from "../../components/pagination";
    export default {
        name:"chapter",
        components:{Pagination},
        data:function(){
            return{
                chapter:{},
                chapters:[]
            }
        },
        mounted() {
            let _this = this;
            _this.list(1)
        },
        methods:{
            // 新增
            add(){
                //弹出前清空对象
                let _this = this;
                _this.chapter = {};
                $('#myModalLabel').html('新增大章');
                $('#myModal').modal('show');
            },
            edit(chapter){
                let _this = this;
                _this.chapter = $.extend({},chapter);
                $('#myModalLabel').html('编辑大章');
                $('#myModal').modal('show');
            },
            //保存
            save(){
                let _this = this;
                // 保存校验
                if (!Validator.require(_this.chapter.name, "名称")
                    || !Validator.length(_this.chapter.courseId, "课程ID", 1, 8)) {
                    return;
                }
                Loading.show();
                _this.$ajax.post(process.env.VUE_APP_SERVER+"/business/admin/chapter/save", _this.chapter
                    ).then(function(resp) {
                        Loading.hide();
                        if(resp.data.isSuccess){
                            _this.list(1);
                            $('#myModal').modal('hide');
                            Toast.success("保存成功")
                        }else{
                            Toast.error(resp.data.msg);
                        }
                })
            },
            //删除
            del(id){
                let _this = this;
                Confirm.show("删除后不可恢复!",function () {
                    Loading.show();
                    _this.$ajax.delete(process.env.VUE_APP_SERVER+"/business/admin/chapter/delete/"+id)
                        .then(function(resp) {
                            Loading.hide();
                            if(resp.data.isSuccess){
                                _this.list(1);
                                Toast.success("删除成功")
                            }else{
                                Toast.error(resp.data.msg);
                            }
                        })
                });
            },
            list(pageNum){
                let _this = this;
                Loading.show();
                //  请求的是网关地址
                _this.$ajax.post(process.env.VUE_APP_SERVER+"/business/admin/chapter/list",
                    {
                        pageNum: pageNum,
                        //  获取子组件的参数
                        pageSize: _this.$refs.pagination.size
                    }).then(function(resp) {
                    Loading.hide();
                    if(resp.data != ''){
                        _this.chapters = resp.data.content.list;
                        // 调用子组件方法重新渲染参数
                        _this.$refs.pagination.render(pageNum,resp.data.content.total);
                    }else{
                        console.log("没有返回数据");
                    }
                })
            }
        }
    }
</script>