import axios from 'axios'
import Vue from 'vue'
//引入进度条、样式
import nProgress from 'nprogress';
import "nprogress/nprogress.css"
nProgress.inc(0.2)
nProgress.configure({ easing: 'ease', speed: 800, showSpinner: false })
import router from '../router';
const baseurl = 'http://127.0.0.1:8989/api'
const service = axios.create({
  baseURL: baseurl,
  timeout: 5000,
  headers: {  //请求头
    'Content-Type': 'application/json;charset=UTF-8',
  }
})
//请求拦截器
service.interceptors.request.use((config) => {
  const token = sessionStorage.getItem('token')
  if (token !== null) {
    config.headers['token'] = token;
  }
  if (config.url !== 'friends/redSpot') {
    nProgress.start();
  }
  return config
}, error => {
  return Promise.reject(error);

});
//响应拦截器
service.interceptors.response.use((response) => {
  if (response.url !== 'friends/redSpot') {
    nProgress.done();
  }
  if (response.data.code === 401) {
    //如果token验证失败，跳转到登录页面
    Vue.prototype.$message.error(response.data.message)
    sessionStorage.removeItem('token')
    router.push('/loginView')
    return Promise.resolve(response)
  } else {
    return response
  }
}, (error) => {
  return Promise.reject(error);
})

export default service
