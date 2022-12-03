//院校相关的存储信息
import {getSchoolNavType,getschoolList} from '../service/schoolService'
const schoolData = {
    namespaced:true,   //开启匿名空间
    state:{
        schoolNavType:{},  //院校的选择列表
        schoolDataList:{}  //院校的具体列表数据
    },
    actions:{
      //获取视屏的选择相关信息
      getNavType(context){
        getSchoolNavType().then((res)=>{
          if(res.data.code === 200){
            let data = res.data.data;
            context.commit('GETNAVTYPE',data);
          }
        })
      },
      //获取院校数据的列表
      getschoolData(context,{first,second,thild,pageNum}){
        getschoolList({first,second,thild,pageNum}).then((res)=>{
          if(res.data.code === 200){
            let data = res.data.data
            context.commit('GETSCHOOLDATA',data)
          }
        })
      }  
    },
    mutations:{
      GETNAVTYPE(state,data){
        state.schoolNavType = data
      },
      GETSCHOOLDATA(state,data){
        state.schoolDataList = data
      }

    },
    getters:{
      //返回院校的选择全部信息
      getSchoolNavType(state){
        return state.schoolNavType
      },
      //返回院校的列表信息 
      getSchoolDataList(state){
        return state.schoolDataList.list
      },
      //返回与分页相关的数据 
      getSchoolPage(state){
        let data = {}
        data.pageNo = state.schoolDataList.pageNum || 1,  //当前的页码数
        data.pagesize = state.schoolDataList.pageSize || 0, //每页所展示的相关条数
        data.total = state.schoolDataList.total || 0,     //总共的条数
        data.pageTotal = state.schoolDataList.pages||0   //总共的页数
        return data;
      }
    }
}
export default schoolData
