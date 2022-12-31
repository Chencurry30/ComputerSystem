//用来储存题库相关的数据
import { getTeachersList } from '../service/teacherService'
const teacherData = {
  namespaced: true,   //开启匿名空间
  state: {
    teacherDataList: {},          //老师的相关数据
  },
  actions: {
    getTeachersData(context,{teacherType,pageNum}){
      getTeachersList({teacherType,pageNum}).then((res)=>{
        if(res.data.code === 200){
          let data = res.data.data
          context.commit('GETTEACHERDATA',data)
        }
      })
    }
  },
  mutations: {
    GETTEACHERDATA(state,data){
      state.teacherDataList = data
    }
  },
  getters: {
    //返回老师的数据列表 
    getTeacherList(state) {
      return state.teacherDataList.list || []
    },

    getTeacherPage(state){
      let data = {
        pageNo:state.teacherDataList.pageNum || 1,
        pagesize:state.teacherDataList.pageSize || 0,
        total:state.teacherDataList.total || 0,
        pageTotal:state.teacherDataList.pages || 0
      }
      return data
    },
  }
}
export default teacherData