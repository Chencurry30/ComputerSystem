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