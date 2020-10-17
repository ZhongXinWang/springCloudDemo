module.exports = {
    // 公共路径(必须有的)
    publicPath: "./",
    //静态资源文件名称
    assetsDir: "static",
    lintOnSave: false,
    //启动项目在8080端口自动打开
    devServer: {
        open: true,
        port: 8080
    },
    //去掉console
    configureWebpack: (config) => {
        // 判断为生产模式下，因为开发模式我们是想保存console的
        if (process.env.NODE_ENV === "production") {
            config.optimization.minimizer.map((arg) => {
                const option = arg.options.terserOptions.compress;
                option.drop_console = true; // 打开开关
                return arg;
            });
        }
    },
};