//用户的相关存储信息
import {getVideoNavType,getVideoList} from '../Servers/videoService'
const videoData = {
    namespaced:true,   //开启匿名空间
    state:{
        videoNavType:{},  //视频的选择列表
        videoDataList:{}  //视屏对应的数据列表
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
      //获取视屏列表
      getVideoData(context,{first,second,thild}){
        getVideoList({first,second,thild}).then((res)=>{
          console.log(res);
          if(res.data.code === 200){
            let data = res.data.data
            context.commit('GETVIDEOLIST',data)
          }
        })
      } 
    },
    mutations:{
      GETNAVTYPE(state,data){
        state.videoNavType = data
      },
      GETVIDEOLIST(state,data){
        state.videoDataList = data
      }

    },
    getters:{
      //返回用户的全部信息
      getVideoNavType(state){
        return state.videoNavType
      },
      getVideoDataList(state){
        return state.videoDataList.list
      }
    }
}
export default videoData
