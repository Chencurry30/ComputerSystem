const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  runtimeCompiler: true,

  //如果是开发环境,开启eslint识别 
  lintOnSave: process.env.NODE_ENV === 'development',

  dev: {
    host: '192.168.13.20',
    port: 8080,
  }

})

const path = require('path')
module.exports = {
  chainWebpack: config => {
    // svg图标加载
    config.module
      .rule('svg')
      .exclude.add(path.join(__dirname, 'src/icons/svg'))
      .end()

    config.module
      .rule('icons')// 定义一个名叫 icons 的规则
      .test(/\.svg$/)// 设置 icons 的匹配正则
      .include.add(path.join(__dirname, 'src/icons/svg'))// 设置当前规则的作用目录，只在当前目录下才执行当前规则
      .end()
      .use('svg-sprite')// 指定一个名叫 svg-sprite 的 loader 配置
      .loader('svg-sprite-loader')// 该配置使用 svg-sprite-loader 作为处理 loader
      .options({// 该 svg-sprite-loader 的配置
        symbolId: 'icon-[name]'
      })
      .end()
  }
}