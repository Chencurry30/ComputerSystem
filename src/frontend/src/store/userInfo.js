//用户的相关存储信息
import {getUserInfo,changeUserInfo} from '../Servers/userServers'
const userInfo = {
    namespaced:true,   //开启匿名空间
    state:{
        userInfo:{},
    },
    actions:{
      //获取个人相关信息
      getUserInfo(context){
        getUserInfo().then((res)=>{
          console.log(res);
          if(res.data.code === 200){
            let info = res.data.data;
            context.commit('GETUSERINFO',info);
          }
        })
      },
      changeUserInfo(context,data){
        changeUserInfo(data).then((res)=>{
          console.log(res);
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
      },
      CHANGEUSERINFO(state,info){
        state.userInfo = info
      }

    },
    getters:{
      //返回用户的部分信息供头部使用
      getUserImg(state){
        //个人页面中上部分对应的内容
        let userImg = {}
        userImg.nickname = state.userInfo.nickname || {}
        userImg.image = state.userInfo.nickname || {}
        userImg.message = state.userInfo.message || {}
        return userImg
      },

      //返回用户的全部信息
      getUserInfo(state){
        return state.userInfo
      }
    }
}
export default userInfo
