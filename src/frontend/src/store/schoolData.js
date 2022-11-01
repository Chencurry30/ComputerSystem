//院校相关的存储信息
import {getSchoolNavType} from '../Servers/schoolService'
const schoolData = {
    namespaced:true,   //开启匿名空间
    state:{
        schoolNavType:{},  //院校的选择列表
    },
    actions:{
      //获取视屏的选择相关信息
      getNavType(context){
        getSchoolNavType().then((res)=>{
          console.log(res);
          if(res.data.code === 200){
            console.log('我是院校获取的相关模块');
            let data = res.data.data;
            context.commit('GETNAVTYPE',data);
          }
        })
      },
    },
    mutations:{
      GETNAVTYPE(state,data){
        state.schoolNavType = data
      },

    },
    getters:{
      //返回用户的全部信息
      getschoolNavType(state){
        return state.schoolNavType
      }
    }
}
export default schoolData
