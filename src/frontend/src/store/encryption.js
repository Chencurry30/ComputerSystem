//封装的相关函数
import {createUUID} from '../utils'
//封装获取公钥的相关函数
import {getPublicKey} from '../service/encryption'

const encryption = {
    namespaced:true,   //开启匿名空间
    state:{
      Algorithm:{
        uuid:'',          //公钥的id
        encryPtion:'',    //公钥的信息
      }
    },
    actions:{
      async getPubKey(context){
        let UUID = {
          uuId:createUUID()
        }
        await getPublicKey(UUID).then((res)=>{
          if(res.data.code === 200){
            UUID.encryPtion = res.data.data
            context.commit('GETPUBKEY',UUID)
          }
        })
      }

    },
    mutations:{
      GETPUBKEY(state,data){
        state.Algorithm = data
      }
    },
    //返回获得的公钥以及公钥的键值对
    getters:{
      getkeyInfo(state){
        return state.Algorithm
      }
    }
}

export default encryption
