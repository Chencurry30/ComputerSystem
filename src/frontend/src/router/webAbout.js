
const webAboutIndex = () => import('@/views/webAbout/webAboutIndex')      //关于我们的组件
const webAboutContact = () => import('@/views/webAbout/webAboutContact')  //联系我们的组件
const webAboutService = () => import('@/views/webAbout/webAboutService')  //联系客服

export default  [
  {
    path: '/webAboutIndex',
    
    name: 'webAboutIndex',
    component: webAboutIndex,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },
  {
    path: '/webAboutService',
    name: 'webAboutService',
    component: webAboutService,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  },
  {
    path: '/webAboutContact',
    name: 'webAboutContact',
    component: webAboutContact,
    meta: {                          
      showTop: true,
      showFotter:true
    },
  }
]
