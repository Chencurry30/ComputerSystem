import servers from './service'
//获取角色列表 
export const getRoleList = () =>{
  const url = '/admin/roles'
  return servers.get(url)
}
//添加角色 
export const addRole = (data) =>{
  const url = '/admin/roles'
  return servers.post(url,data)
}

//查看一个角色的权限 
export const lookRole = (RoleId) =>{
  const url = `/admin/roles/menu/${RoleId}`
  return servers.get(url)
}

//获取所有权限树形结构
export const getTree = () =>{
  const url = `/admin/menus/tree`
  return servers.get(url)
}

//保存修改后的角色权限
export const saveTree = (data) =>{
  const url = '/admin/roles/menu'
  return servers.put(url,data,)
}

//删除一个角色
export const roleDelete = (roleId) =>{
  const url = `/admin/roles/${roleId}`
  return servers.delete(url)
}
//获取分页的相关数据
export const getuserListApi = (params) =>{
  const url = `/admin/users/pages/${params}`
  return servers.get(url)
} 
//更新用户角色
export const renewRole = (data) =>{
  const url = '/admin/users/role'
  return servers.put(url,data)
}
//删除用户（根据id进行删除）
export const userDelete = (userId) =>{
  const url = `/admin/users/${userId}`
  return servers.delete(url)
}
//添加一个用户
export const addUser = (data) =>{
  const url = `/admin/users`
  return servers.post(url,data)
}
//获取日志列表
export const getLoglist = (params) =>{
  const url = `/admin/logs/pages/${params}`
  return servers.get(url)
} 


//删除日子（根据id进行删除）
export const logDelete = (userId) =>{
  const url = `/admin/logs/${userId}`
  return servers.delete(url)
}

//批量删除
export const logsDelete = (data) =>{
  const url = `/admin/logs`
  return servers.post(url,data)
}

//查找指定用户校色（根据id进行删除）
export const userRole = (userId) =>{
  const url = `/admin/users/role/${userId}`
  return servers.get(url)
}
