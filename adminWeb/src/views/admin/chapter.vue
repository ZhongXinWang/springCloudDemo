<template>
        <div>
            <p>
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
                            <button class="btn btn-xs btn-success">
                                <i class="ace-icon fa fa-check bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-info">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-danger">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-warning">
                                <i class="ace-icon fa fa-flag bigger-120"></i>
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
                chapters:[]
            }
        },
        mounted() {
            let _this = this;
            _this.list(1)
        },
        methods:{
            list(pageNum){
                let _this = this;
                //  请求的是网关地址
                _this.$ajax.post("http://127.0.0.1:9000/business/admin/chapter/list",
                    {
                        pageNum: pageNum,
                        //  获取子组件的参数
                        pageSize: _this.$refs.pagination.size
                    }).then(function(resp) {
                    _this.chapters = resp.data.list;
                    // 调用子组件方法重新渲染参数
                    _this.$refs.pagination.render(pageNum,resp.data.total);
                })
            }
        }
    }
</script>