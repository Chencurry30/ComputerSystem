import Vue from 'vue'
import App from './App.vue'

import store from './store/index';
import router from './router/index';

Vue.use(store)
Vue.use(router)

Vue.config.productionTip = false

//引入Tailwindcss
import "tailwindcss/tailwind.css"

new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
