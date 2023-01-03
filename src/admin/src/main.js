import Vue from 'vue'
// 引入element-ui
import ElementUI from 'element-ui';
// element-ui的css样式要单独引入
import 'element-ui/lib/theme-chalk/index.css';
//引入App
import App from './App.vue'
//引入VueRouter
import VueRouter from 'vue-router'
//引用路由器
import router from './router'
import './utils/localStorage'
import store from './store'
//引入视屏播放插件
import VideoPlayer from 'vue-video-player'
import 'video.js/dist/video-js.css'
import 'vue-video-player/src/custom-theme.css'
Vue.use(VideoPlayer)
//按钮权限
import '@/utils/btnPernission'
//引入Svg定义的Icon
import './icons' 


Vue.use(ElementUI);   // 这种方式引入了ElementUI中所有的组件
Vue.use(VueRouter)    //引用插件
new Vue({
  store,
  el: '#app',
  render: h => h(App),
  router: router
})