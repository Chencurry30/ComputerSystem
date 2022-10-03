import servers from './Servers'

export const userLogin = (data) =>{
    const url = '/users/login'
    return servers.post(url,data);
}
export const userRegister = (data) =>{
  const url = '/users/register'
  return servers.post(url,data);
}