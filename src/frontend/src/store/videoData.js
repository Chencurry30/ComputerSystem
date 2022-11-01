//用户的相关存储信息
import {getVideoNavType} from '../Servers/videoService'
const videoData = {
    namespaced:true,   //开启匿名空间
    state:{
        videoNavType:{},  //视频的选择列表
    },
    actions:{
      //获取视屏的选择相关信息
      getNavType(context){
        getVideoNavType().then((res)=>{
          console.log(res);
          if(res.data.code === 200){
            let data = res.data.data;
            context.commit('GETNAVTYPE',data);
          }
        })
      },
    },
    mutations:{
      GETNAVTYPE(state,data){
        state.videoNavType = data
      },

    },
    getters:{
      //返回用户的全部信息
      getVdieoNavType(state){
        return state.videoNavType
      }
    }
}
export default videoData
