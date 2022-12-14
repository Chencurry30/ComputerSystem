import Vue from 'vue'
import VueRouter from 'vue-router'

//系统操作以及相关路由
import systemRouter from './systemRouter'
//老师的路由管理
import teacherRoute from "./teacherRoute"
import webAbout from './webAbout'
//个人中心的相关路由
import personRoute from "./personRoute";
//视屏页面的相关路由
import videoRouter from './videoRouter'
//院校页面的相关路由
import schoolRouter from './schoolRouter'
//题库页面的相关路由
import questionRoute from './questionRoute'
//帮助中心的相关路由
import helpRoute from './helpRoute'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

const originalReplace = VueRouter.prototype.replace
VueRouter.prototype.replace = function replace (location) {
  return originalReplace.call(this, location).catch(err => err)
}


Vue.use(VueRouter)

const router = new VueRouter({
    mode:'history',
    base: process.env.BASE_URL,
    routes: [
      ...systemRouter,
      ...teacherRoute,
      ...webAbout,
      ...personRoute,
      ...videoRouter,
      ...schoolRouter,
      ...questionRoute,
      ...helpRoute
    ],
  })

//路由守卫
// router.beforeEach((to,from,next) => {
//   const token = localStorage.getItem('token')
//   if(to.name !== 'loginView' && !token && to.name !== 'registerView') next({name:'loginView'})
//   else next()
// })

router.afterEach(() => {
    window.scrollTo(0,0);
    // chrome
    document.body.scrollTop = 0
    // firefox
    document.documentElement.scrollTop = 0
    // safari
    window.pageYOffset = 0
});

export default router
