const user = {
    namespaced:true,   //开启匿名空间
    state:{
        menuList:[] 
    },
    actions:{

    },
    mutations:{

    },
    //返回获得的公钥以及公钥的键值对
    getters:{
        getmenuList(state){
            return state.menuList.children
        }
    }
}

export default user
