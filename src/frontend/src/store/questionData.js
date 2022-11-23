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

    //在questionSelect中的组卷功能调用 
    GETSETVOLUMEDATA(state,data){
      state.setVolumeData = data
    }


  },
  getters: {
    //返回题库的选择数据 
    getQuestionNav(state) {
      return state.questionNav
    },
    //返回题库的数据列表 
    getQuestionList(state){
      return state.questionDataList
    },
    getQuestionPage(state){
      let data = {
        pageNo:state.questionDataList.pageNum || 1,
        pagesize:state.questionDataList.pageSize || 0,
        total:state.questionDataList.total || 0,
        pageTotal:state.questionDataList.pages || 0
      }
      console.log(data);
      return data
    },
    //返回相关的组题数据 
    getSetvolumeData(state){
      return state.setVolumeData
    }
  }
}
export default questionData