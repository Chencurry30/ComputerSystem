//用户的相关存储信息
import {getUserInfo} from '../Servers/userServers'
const userInfo = {
    namespaced:true,   //开启匿名空间
    state:{
        userInfo:{},
    },
    actions:{
      //获取个人相关信息 
      getUserInfo(context,token){
        getUserInfo(token).then((res)=>{
          if(res.data.code === 200){
            let info = res.data.data;
            context.commit('GETUSERINFO',info);
          }
        })
      }
    },
    mutations:{
      GETUSERINFO(state,info){
        state.userInfo = info
      }
    },
    getters:{
    }
}
export default userInfo