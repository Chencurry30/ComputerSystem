import Vue from 'vue'
import App from './App.vue'
import store from './store';
import router from './router';


import {Dialog,Button} from 'element-ui'
Vue.use(Dialog)
Vue.use(Button)


import VueRouter from 'vue-router'
Vue.use(VueRouter)    //引用插件


Vue.config.productionTip = false


new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
