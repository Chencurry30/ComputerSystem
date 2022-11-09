import axios from 'axios'
import Vue from 'vue'
//引入进度条、样式
import nProgress from 'nprogress';
import "nprogress/nprogress.css"
import router from '../router';
const baseurl = '/api'
const service = axios.create({
    baseURL: baseurl,
    timeout: 3000,
    headers: {  //请求头
      'Content-Type': 'application/json;charset=UTF-8',
    }
})
//请求拦截器
service.interceptors.request.use((config) => {
  const token = sessionStorage.getItem('token')
    if(token !== null){
      config.headers['token'] = token;  
    }
    nProgress.start();
    return config
}, error => {
    return Promise.reject(error);

});
//响应拦截器
service.interceptors.response.use((response) => {
    nProgress.done();
    if(response.data.code === 403){
      //如果token验证失败，跳转到登录页面 
      Vue.prototype.$message.error(response.data.message)
      router.push('/loginView')
    }
    return response
}, (error) => {
    return Promise.reject(error);
})

export default service