//题库相关的路由 

export default [
  {
    path: '/questionSelect',
    name: 'questionSelect',
    component: () => import('@/views/questionViews/questionSelect'),  //题目选择页面,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },
  {
    path: '/questionVolume',
    name: 'questionVolume',
    component: () => import('@/views/questionViews/questionVolume'),  //题目选择页面,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  }
]
