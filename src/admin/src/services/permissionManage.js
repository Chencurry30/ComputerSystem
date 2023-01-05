import service from "./service";


//添加一级,二级菜单 
export const addMenu = (menuData) =>{
  const url = `/admin/menus/children`
  return service.post(url,menuData)
}

//添加顶级菜单 
export const addTopMenu = (menuData) =>{
  const url = `admin/menus/one`
  return service.post(url,menuData)
}
//删除菜单或按钮权限 
export const deleteMenu = (menuId) =>{
  const url = `/admin/menus/${menuId}`
  return service.delete(url)
}
//获取菜单或权限的信息
export const getMenuInformation = (menuId) =>{
  const url = `/admin/menus/${menuId}`
  return service.get(url)
} 
//更新菜单或权限的信息
export const updateMenuInformation = (menuData) =>{
  const url = '/admin/menus'
  return service.put(url,menuData)
} 

