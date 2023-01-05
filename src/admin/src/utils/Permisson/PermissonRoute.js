//对后端返回的路由进行规范操作
//获取规范化后的路由 
export const getNormPermissionRouteList = (routerList) => {
  let NormRoute = []
  for (let i = 0; i < routerList.length; i++) {
    console.log(123);
    for (let j = 0; j < routerList[i].children.length; j++) {
      NormRoute.push(routerList[i].children[j])
    }
  }
  return NormRoute
}

