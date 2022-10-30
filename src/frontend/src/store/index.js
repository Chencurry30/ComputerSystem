import Vue from 'vue'
import Vuex from 'vuex'
import encryption from './encryption'  //获取公钥的相关vuex
import remark from './remark'            //评论相关的仓库
import userInfo from './userInfo'     //用户信息相关的仓库
import videoData from './videoData'  //视屏数据相关的仓库
import schoolData from './schoolData'
Vue.use(Vuex)
export default new Vuex.Store({
    modules:{
        remark,
        userInfo,
        encryption,
        videoData,
        schoolData,
    }
})
