//系统本身的相关请求 
import servers from './service'
//登录
export const userLogin = (data) =>{
  const url = '/admin/users/login'
  return servers.post(url,data);
}
//获取秘钥
export const getPublicKey = (UUID) =>{
  const url = '/users/public'
  return servers.post(url,UUID)  
}
//退出登录
export const logoutAdmin = () =>{
  const url = `/admin/users/logout`
  return servers.post(url)
}
//获取首页中的相关数据
export const getHomeCount = () =>{
  const url = `/admin/home/counts`
  return servers.get(url)
} 