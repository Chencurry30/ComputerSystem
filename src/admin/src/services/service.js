import axios from 'axios'
//引入进度条、样式
import Vue from 'vue';
import router from '../router';
import nProgress from 'nprogress';
import "nprogress/nprogress.css"

const baseurl = process.env.VUE_APP_BASE_TARGET
const Service = axios.create({
    baseURL: baseurl,
    timeout: 10000,
    headers: {  //请求头
      'Content-Type': 'application/json;charset=UTF-8',
    }
})
//请求拦截器
Service.interceptors.request.use((config) => {
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
Service.interceptors.response.use((response) => {
    nProgress.done();
    if(response.data.code === 401){
      //如果token验证失败，跳转到登录页面 
      Vue.prototype.$message.error(response.data.message)
      sessionStorage.removeItem('token')
      router.push('/loginView')
      return Promise.resolve(response)
    }else{
      return response
    }
}, (error) => {
    return Promise.reject(error);
})


export default Service