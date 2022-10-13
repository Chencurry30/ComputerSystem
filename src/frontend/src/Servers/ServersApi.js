import servers from './Servers'
//登录
export const userLogin = (data) =>{
    const url = '/users/login'
    return servers.post(url,data);
}
//注册
export const userRegister = (data) =>{
    const url = '/users/register'
    return servers.post(url,data);
}
//获取验证码
export const retrievePassword = (phone) =>{
    const url = '/users/sms'
    return servers.post(url,phone);
}