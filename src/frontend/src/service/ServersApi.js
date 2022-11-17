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