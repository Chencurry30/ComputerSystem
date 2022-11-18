//用户的相关存储信息
import {getVideoNavType,getVideoList,getVideoInfo} from '../service/videoService'
const videoData = {
    namespaced:true,   //开启匿名空间
    state:{
        videoNavType:{},   //视频的选择列表
        videoDataList:{},  //视屏对应的数据列表
        videoInfo:{}       //视屏资源对应的基本信息 
    },
    actions:{
      //获取视屏的选择列表的信息
      getNavType(context){
        getVideoNavType().then((res)=>{
          if(res.data.code === 200){
            let data = res.data.data;
            context.commit('GETNAVTYPE',data);
          }
        })
      },
      //根据选择列表获取视屏列表
      getVideoData(context,{first,second,thild,pageNum}){
        getVideoList({first,second,thild,pageNum}).then((res)=>{
          if(res.data.code === 200){
            let data = res.data.data
            context.commit('GETVIDEOLIST',data)
          }
        })
      },
      //获取对应视屏的相关信息 
      getInfo(context,videoId){
        getVideoInfo(videoId).then((res)=>{
          console.log(res);
          if(res.data.code === 200){
            let data = res.data.data
            context.commit('GETINFO',data)
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
      },
      GETINFO(state,data){
        state.videoInfo = data
      }
    },
    getters:{
      //返回选择列表的全部信息
      getVideoNavType(state){
        return state.videoNavType
      },
      //返回对应的视屏数据列表 
      getVideoDataList(state){
        return state.videoDataList.list
      },
      //返回与分页相关的数据 
      getVideoPage(state){
        let data = {
          pageNo:state.videoDataList.pageNum || 1,
          pagesize:state.videoDataList.pageSize || 0,
          total:state.videoDataList.total || 0,
          pageTotal:state.videoDataList.pages || 0
        }
        return data
      },
      //返回视屏的基本信息 
      getVideoInfo(state){
        return state.videoInfo || {}
      }
    }
}
export default videoData
