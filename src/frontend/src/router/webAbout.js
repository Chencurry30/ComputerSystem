export default  [
  {
    path: '/webAboutIndex',
    
    name: 'webAboutIndex',
    component: () => import('@/views/webAbout/webAboutIndex'),
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/webAboutService',
    name: 'webAboutService',
    component: () => import('@/views/webAbout/webAboutService'),
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/webAboutContact',
    name: 'webAboutContact',
    component:() => import('@/views/webAbout/webAboutContact') ,
    meta: {                          
      showTop: true,
      showFotter:true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  }
]
