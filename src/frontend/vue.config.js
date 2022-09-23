const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  devServer:{
    // Proxy:{
    //   '/api':{
    //     target:'http://localhost:8989',  //后端的接口
    //     //changeOrigin:true,
    //     changeOrigin:false,
    //     pathRewrite:{
    //       '^/api':'',
    //     }
    //   }
    // }
  } 
})
