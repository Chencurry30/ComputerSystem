import service from './services'
//登录
export const userLogin = (data) =>{
    const url = '/users/login'
    return service.post(url,data);
}
//注册
export const userRegister = (data) =>{
    const url = '/users/register'
    return service.post(url,data);
}
//获取验证码
export const retrievePassword = (phone) =>{
    const url = '/users/sms'
    return service.post(url,phone);
}

//忘记密码
export const forgetPassword = (data) =>{
  const url = `users/forget/password`
  return service.put(url,data)
}

//修改密码
export const modifyPassword = (data) =>{
  const url = `users/password`
  return service.put(url,data)
} 

//修改手机号
export const modifyPhone = (data) =>{
  const url = `users/phone`
  return service.put(url,data)
} 

//绑定手机号 
export const bindUserPhone = (data) =>{
  const url = '/users/bind'
  return service.put(url,data)
}