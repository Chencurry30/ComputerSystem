import Vue from 'vue'
import App from './App.vue'
import store from './store';
import router from './router';

// 导入组件库
import ElementUI from 'element-ui';
// 导入组件相关样式
import 'element-ui/lib/theme-chalk/index.css';
// 配置 Vue 插件
Vue.use(ElementUI);

import VueRouter from 'vue-router'
Vue.use(VueRouter)    //引用插件

//引入bootstrap库 
import BootstrapVue from 'bootstrap-vue';
Vue.use(BootstrapVue)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

//引入视屏播放插件
import VideoPlayer from 'vue-video-player'
import 'video.js/dist/video-js.css'
import 'vue-video-player/src/custom-theme.css'

Vue.use(VideoPlayer) 



//全局注册qs序列化object对象(this.$qs运用) 
import qs from 'qs';
Vue.prototype.$qs = qs

 // 导入swiper样式
 import "swiper/css/swiper.css"

Vue.config.productionTip = false
new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
