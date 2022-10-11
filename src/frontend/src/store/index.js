import Vue from 'vue'
import Vuex from 'vuex'

import remark from './remark'

Vue.use(Vuex)

export default new Vuex.Store({
    modules:{
        remark,
    }
})