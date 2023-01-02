
export const fnAddDynamicMenuRoutes  = (menuList = [], routes = []) => {
  // 用于保存存在子路由的路由数据
  let route = []
   // 用于保存存在子路由的路由数据
   let  temp= []
  // 遍历数据
  for (let i = 0; i < menuList.length; i++) {
    // 存在子路由，则递归遍历，并返回数据作为 children 保存
    if (menuList[i].children && menuList[i].children.length > 0) {
      // 获取路由的基本格式
      route = getRoute(menuList[i])
      // 递归处理子路由数据，并返回，将其作为路由的 children 保存
      route.children = fnAddDynamicMenuRoutes(menuList[i].children)
      // 保存存在子路由的路由
      routes.push(route)
    } else {
      // 保存普通路由
      temp.push(getRoute(menuList[i]))
    }
  }
  // 返回路由结果
  return routes.concat(temp)
}
function getRoute (item) {
  // 路由基本格式
  let route = {
    // 路由的路径
    path: item.path,
    // 路由名
    name: item.name,
    // 路由所在组件
    // component: (resolve) => require([`@/view`], resolve),
    // 路由的子路由
    children: []
  }
  // 返回 route
  return route
}

export const Routes = (menuList=[],routes=[]) =>{
  for(let i=0;i<menuList.length;i++){
    var fatherPath = menuList[i].path
    for(let j=0;j<menuList[i].children.length;j++){
      let paths = `${fatherPath}${menuList[i].children[j].path}`
      let item = {
        name:menuList[i].children[j].name,
        path:menuList[i].children[j].path,
        component: loadView(paths)
      }
      routes.push(item)
    }
  }
}
export const loadView =(viewPath) =>{
  // 用字符串模板实现动态 import 从而实现路由懒加载
  return () => import(`../views${viewPath}`)
 }