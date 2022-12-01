//个人用户的相关接口
import service from './services'
export const getUserInfo = (token) =>{
  const url = '/users'
  return service.get(url,token);
}
//改变用户的个人信息
export const changeUserInfo = (userinfo) =>{
  const url = '/users'
  return service.put(url,userinfo);
}
//上传用户头像
export const uploadUserPicture = (picture) =>{
  const url =`/oss/policy/user/${picture}`
  return service.get(url)
}
//上传动态图片
export const uploaddynamicPicture = (picture) =>{
  const url =`/oss/policy/dynamic/${picture}`
  return service.get(url)
}

//返回用户的收藏视屏的列表
export const userVideoCollect = (pageNum,userId) =>{
  const url = `videos/collect/${pageNum}-${userId}`
  return service.get(url)
}


//获取其他用户信息
export const getuserMsg = (userId) =>{
  const url = `/users/${userId}`
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

//查询所有动态
export const getallDynamics = (page) =>{
  const url = `/dynamics/pages/${page}`
  return service.get(url)
}
