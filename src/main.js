import Vue from 'vue'
import App from './App.vue'
import store from './store';
import router from './router';

import VueRouter from 'vue-router'
Vue.use(VueRouter)    //引用插件


Vue.config.productionTip = false

//引入Tailwindcss
import "tailwindcss/tailwind.css"

new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
