import axios from 'axios'

const baseurl = '/api'
const Servers = axios.create({
    baseURL: baseurl,
    timeout: 3000,
    headers: {  //请求头
        'Content-Type': 'application/json;charset=UTF-8',
    }
})

Servers.interceptors.request.use((config) => {
    return config
}, error => {
    return Promise.reject(error);

});

Servers.interceptors.response.use((response) => {
    return response
}, (error) => {
    return Promise.reject(error);
})


export default Servers