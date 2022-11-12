//评论和回复的相关信息同行
const remark = {
    namespaced:true,   //开启匿名空间
    state:{
        backOtherInfo:{},  //点击回复时储存的当前人的相关信息
        remarkList: [
            {
              id:123123123,   //循环的key值的ID值
              father:{          
              id: 1232,
              image: "1231231231232.123",
              nickname: "高山",
              time: "2022-6-30",
              content: "你的评论对我很有帮助，感谢你的发言",
              resourcename: "回复我的",
              },
              
              children:[
                {
                  id: 1232123,  //循环的keyID值,
                  userId:1232,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                },
                {
                  id: 12312,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                },
                {
                  id: 123122,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                },
                {
                  id: 12312298,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                },
                {
                  id: 12323122,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                }
              ]
            },
            {
              id:1231231,   //循环的key值的ID值
              father:{          
              id: 1232,
              image: "1231231231232.123",
              nickname: "高山",
              time: "2022-6-30",
              content: "你的评论对我很有帮助，感谢你的发言",
              resourcename: "回复我的",
              },
              children:[
                {
                  id: 1232123213123,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                },
                {
                  id: 12312123,
                  image: "1231231231232.123",
                  nickname: "高山",
                  time: "2022-6-30",
                  content: "你的评论对我很有帮助，感谢你的发言",
                  resourcename: "回复我的",
                }
              ]
            }      
        ],
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
        },
        //返回的是接口返回的评论的数据 
        getRemarkList(state){ 
            return state.remarkList || {};
        }
    }
}
export default remark