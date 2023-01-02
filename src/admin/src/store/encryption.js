//封装的相关函数
import {createUUID} from '../utils/uuid'
//封装获取公钥的相关函数
import {getPublicKey} from '../services/systemService'

const encryption = {
    namespaced:true,   //开启匿名空间
    state:{
      Algorithm:{
        uuId:'',          //公钥的id
        encryPtion:'',    //公钥的信息
      }
    },
    actions:{
      getPubKey(context){
        let UUID = {
          uuId:createUUID()
        }
        getPublicKey(UUID).then((res)=>{
          // console.log(res);
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
