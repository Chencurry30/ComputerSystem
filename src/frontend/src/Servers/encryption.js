
import servers from './Servers'
//获取公钥的函数 
export const getPublicKey = (UUID) =>{
  const url = '/users/public'
  return servers.post(url,UUID)  
}