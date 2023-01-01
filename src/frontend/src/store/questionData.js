//用来储存题库相关的数据
import { getQuestionDataList, getQuestionNav } from '../service/questionService'
const questionData = {
  namespaced: true,   //开启匿名空间
  state: {
    questionNav: {},
    questionDataList: {},
    setVolumeData:{}            //组卷的相关数据
  },
  actions: {
    //获取题库的选择列表 
    getQuestionNavSelect(context) {
      getQuestionNav().then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          let data = res.data.data
          context.commit('GETQUESTIONNAVSELECT', data)
        }
      })
    },
    //获取题库的数据列表
    getQuestionData(context, { typeId, difficultId, classifyId, sourceId, yearId, pageNum }) {
      getQuestionDataList({ typeId, difficultId, classifyId, sourceId, yearId, pageNum }).then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          let data = res.data.data
          context.commit('GETQUESTIONDATA', data)
        }else if(res.data.code === 417){
          let data = []
          context.commit('GETQUESTIONDATA', data)
        }
      })
    }

  },
  mutations: {
    GETQUESTIONNAVSELECT(state, data) {
      state.questionNav = data
    },
    GETQUESTIONDATA(state, data) {
      state.questionDataList = data
    },
  },
  getters: {
    //返回题库的选择数据 
    getQuestionNav(state) {
      return state.questionNav
    },
    //返回题库的数据列表 
    getQuestionList(state){
      return state.questionDataList.list || []
    },
    getQuestionPage(state){
      let data = {
        pageNo:state.questionDataList.pageNum || 1,
        pagesize:state.questionDataList.pageSize || 0,
        total:state.questionDataList.total || 0,
        pageTotal:state.questionDataList.pages || 0
      }
      return data
    },
  }
}
export default questionData