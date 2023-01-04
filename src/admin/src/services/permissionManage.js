import service from "./service";



export const addfirstMenu = (menuData) =>{
  const url = `/admin/menus/children`
  return service.post(url,menuData)
}

export const deleteMenu = (menuId) =>{
  const url = `/admin/menus/${menuId}`
  return service.delete(url)
}

