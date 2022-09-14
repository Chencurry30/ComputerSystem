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
import { Dialog, Button } from 'element-ui'
Vue.use(Dialog)
Vue.use(Button)

import VueRouter from 'vue-router'
Vue.use(VueRouter)    //引用插件

//引入bootstrap库 
import BootstrapVue from "bootstrap-vue";
Vue.use(BootstrapVue)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

//引入粒子背景 
import VueParticles from 'vue-particles'
Vue.use(VueParticles)




Vue.config.productionTip = false


new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
