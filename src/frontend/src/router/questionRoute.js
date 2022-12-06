//题库相关的路由
export default [
  {
    path: '/questionPage:questionId?',
    name: 'questionPage',
    component: () =>import('@/views/questionViews/questionPage'),
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/questionSelect',
    name: 'questionSelect',
    component:  () => import('@/views/questionViews/questionSelect') ,
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/questionVolume',
    name: 'questionVolume',
    component:()=>import('@/views/questionViews/questionVolume'),  
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
]