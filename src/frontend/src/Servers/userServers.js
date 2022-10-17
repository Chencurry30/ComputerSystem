//个人用户的相关接口 
import servers from './Servers'
export const getUserInfo = (token) =>{
  const url = '/users'
  return servers.get(url,token);
}
export const changeUserInfo = (userinfo) =>{
  const url = '/users'
  return servers.put(url,userinfo);
}