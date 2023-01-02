import Vue from 'vue'
import Vuex from 'vuex'
import tab from './tab'
import user from './user'//引入用户信息
import encryption from './encryption'  //获取公钥的相关vuex
import router from './router' 
Vue.use(Vuex)

export default new Vuex.Store({
    modules:{
        // remark,
        // userInfo,
        encryption,
        tab,
        user,
        router
    }
})
