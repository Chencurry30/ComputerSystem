import Vue from 'vue'
import VueRouter from 'vue-router';

//这下面是集中管理路由的文件 
import routers from './routers'

Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routers,
    scrollBehavior(to, from, savedPosition) {
      return {
        y: 0
      };
    },
  
  })
export default router