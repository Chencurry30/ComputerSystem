//用户的相关存储信息
import {getVideoNavType,getVideoList} from '../service/videoService'
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
          if(res.data.code === 200){
            let data = res.data.data;
            context.commit('GETNAVTYPE',data);
          }
        })
      },
      //获取视屏列表
      getVideoData(context,{first,second,thild,pageNum}){
        getVideoList({first,second,thild,pageNum}).then((res)=>{
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
        let data = {}
        data.pageNo = state.videoDataList.pageNum || 1,  //当前的页码数
        data.pagesize = state.videoDataList.pageSize || 0, //每页所展示的相关条数
        data.total = state.videoDataList.total || 0,     //总共的条数
        data.pageTotal = state.videoDataList.pages||0   //总共的页数
        return data
      }
    }
}
export default videoData
