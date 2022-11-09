
import service from './services'
//获取公钥的函数 
export const getPublicKey = (UUID) =>{
  const url = '/users/public'
  return service.post(url,UUID)  
}