//评论和回复的相关信息同行
const remark = {
    namespaced:true,   //开启匿名空间
    state:{
        backOtherInfo:{}  //点击回复时储存的当前人的相关信息
    },
    actions:{
        getotherinfo(context,otherinfo){
            console.log(otherinfo);
            context.commit('GETOTHERINFO',otherinfo);
        }
    },
    mutations:{
        GETOTHERINFO(state,otherinfo){    //处理组件的信息
            state.backOtherInfo = otherinfo
        }
    },
    getters:{
        getOtherInfo(state){
            return state.backOtherInfo || {};
        }
    }
}
export default remark