const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:true,
  devServer: {
    // host: 'localhost',
    // port: 8080,//项目运行的端口号
    // open: true,//自动启动浏览器
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:9090/api',// 要跨域的接口根目录
        changeOrigin: true, // 是否开启跨域
        pathRewrite: {
          '^/api': ''
        },

      },
    }
  }
})
