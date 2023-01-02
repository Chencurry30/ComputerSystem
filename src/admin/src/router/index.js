import Vue from 'vue'
import VueRouter from 'vue-router';
Vue.use(VueRouter)
import staticRoute from './static-route'
import { fnAddDynamicMenuRoutes, Routes } from './permission'
//创建暴露路由
const router = new VueRouter({
  routes : staticRoute,
  mode: 'history',   /*hash*/ /*不显示路由中的#*/
})
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const originalReplace = VueRouter.prototype.replace
VueRouter.prototype.replace = function replace(location) {
  return originalReplace.call(this, location).catch(err => err)
}

let isToken = true
router.beforeEach(async (to, from, next) => {
  if(to.name !== 'loginView' && !sessionStorage.getItem('token') && !sessionStorage.getItem('menulist')) 
  next({name:'loginView'})
  else next()
  if(!sessionStorage.getItem('menulist')){
    // console.log(123);
  }
  //定义isToken为true和vuex不为空时添加路由
  else if(isToken && sessionStorage.getItem('menulist').length !== 0) {
    isToken = false //将isToken赋为 false ，否则会一直循环，崩溃
    const menuList = JSON.parse((sessionStorage.getItem('menulist')))
    //分析出路由权限，淘汰掉按钮权限 
    let childrenRoutes
    fnAddDynamicMenuRoutes(menuList, childrenRoutes)
    let routelist = staticRoute[3].children
    Routes(menuList,routelist)
    routelist = routelist.filter((item,index)=>index>1)
    routelist.forEach((item) => {
      router.addRoute('indexBox',item)
    })
    next({
      ...to, // next({ ...to })的目的,是保证路由添加完了再进入页面 (可以理解为重进一次)
      replace: true, // 重进一次, 不保留重复历史
    })
  } else {
    if (to.name == null) {
      next("/404")
    } else {
      if (to.meta.title) { //判断是否有标题
        document.title = to.meta.title //给相应页面添加标题
      }
      next()
    }
  }
})

export default router
