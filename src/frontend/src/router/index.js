import Vue from 'vue'
import VueRouter from 'vue-router';

//系统操作以及相关路由 
import systemOperation from './systemOperation'
//老师的路由管理
import teacherRoute from "./teacherRoute";
import webAbout from './webAbout';
//个人中心的相关路由
import personRoute from "./personRoute"; 



const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const originalReplace = VueRouter.prototype.replace
VueRouter.prototype.replace = function replace(location) {
  return originalReplace.call(this, location).catch(err => err)
}


Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    ...systemOperation,
    ...teacherRoute,
    ...webAbout,
    ...personRoute,
  ],
  linkActiveClass:'link-active'
  
  // scrollBehavior(to, from, savedPosition) {
  //   return {
  //     y: 0
  //   };
  // },
})
export default router