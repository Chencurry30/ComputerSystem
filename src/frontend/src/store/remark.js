//评论和回复的相关信息信息
import { getVideoRemark } from '../service/videoService'
const remark = {
  namespaced: true,   //开启匿名空间
  state: {
    backOtherInfo:{},
    remarkList: [],
  },
  actions: {

    //获取点击回复时存储其他用户的信息
    getotherinfo(context, otherinfo) {
      context.commit('GETOTHERINFO', otherinfo);
    },


    //获取视屏评论的信息
    getVideoRemark(context, videoId) {
      getVideoRemark(videoId).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          let data = res.data.data
          context.commit('GETVIDEOREMARK', data)
        }
      })
    },
    
  },
  mutations: {
    //处理组件的信息
    GETOTHERINFO(state, otherinfo) {
      state.backOtherInfo = otherinfo
    },

    GETVIDEOREMARK(state, data) {
      console.log(data.length);
      state.remarkList = data
    }

  },
  getters: {

    //返回点击回复时存储的用户的信息 
    getOtherInfo(state) {
      return state.backOtherInfo || {};
    },

    //返回的是这个视屏评论的信息列表 
    getRemarkList(state) {
      return state.remarkList
    }
  }
}
export default remark