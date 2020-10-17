// 加载框
Loading = {
    show: function () {
        $.blockUI({
            message: '<img src="/static/images/loading.gif" />',
            css: {
                zIndex: "10011",
                padding: "10px",
                left: "50%",
                width: "80px",
                marginLeft: "-40px",
            }
        });
    },
    hide: function () {
        // 本地查询速度太快，loading显示一瞬间，故意做个延迟
      /*  setTimeout(function () {
            $.unblockUI();
        }, 500)*/
        $.unblockUI();
    }
};
/*
Loading = {
    show:function(){
        $.blockUI({ message: '<h1><img src="/static/images/loading.gif"> 加载中...</h1>' });
    },
    hide:function(){

        setTimeout(function () {
            $.unblockUI();
        },2000)

    }
};*/
