//个人用户的相关接口
import service from './services'
export const getUserInfo = (token) =>{
  const url = '/users'
  return service.get(url,token);
}
export const changeUserInfo = (userinfo) =>{
  const url = '/users'
  return service.put(url,userinfo);
}

//上传用户头像
export const uploadUserPicture = (picture) =>{
  const url =`/oss/policy/user/${picture}`
  return service.get(url)
}

//发送我的动态
export const setDynamics = (data) =>{
  const url = `/dynamics`
  return service.post(url,data)
}

//查询我的动态
export const getDynamics = (id) =>{
  const url = `/dynamics/${id}`
  return service.get(url)
}

//删除我的动态
export const deleteDynamics = (id) => {
  const url = `/dynamics/${id}`
  return service.delete(url)
}

//查询所有我的动态
export const getallDynamics = () =>{
  const url = `/dynamics`
  return service.get(url)
}

//获取其他用户信息
export const getuserMsg = (userId) =>{
  const url = `/users/${userId}`
  return service.get(url)
}

//获取收藏信息
export const getCollect = (userId) =>{
  const url = `/videos/collect/${userId}`
  return service.get(url)
}
