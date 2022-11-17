//题库相关的路由 

const questionPage = () =>import('@/views/questionViews/questionPage')       //视频的首页
const questionSelect = () => import('@/views/questionViews/questionSelect')  //视频选择页面

export default [
  {
    path: '/questionPage:questionId?',
    name: 'questionPage',
    component: questionPage,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },
  {
    path: '/questionSelect',
    name: 'questionSelect',
    component: questionSelect,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },


]
