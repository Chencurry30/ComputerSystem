import axios from 'axios'
//引入进度条、样式
import nProgress from 'nprogress';
import "nprogress/nprogress.css"
const baseurl = '/api'
const Servers = axios.create({
    baseURL: baseurl,
    timeout: 3000,
    headers: {  //请求头
      'Content-Type': 'application/json;charset=UTF-8',
    }
})
//请求拦截器
Servers.interceptors.request.use((config) => {
  const token = localStorage.getItem('token')
    if(token !== null){
      config.headers['token'] = token;  
    }
    nProgress.start();
    return config
}, error => {
    return Promise.reject(error);

});
//响应拦截器
Servers.interceptors.response.use((response) => {
    nProgress.done();
    return response
}, (error) => {
    return Promise.reject(error);
})


export default Servers