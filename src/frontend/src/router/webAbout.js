import webAboutIndex from '@/views/webAbout/webAboutIndex' //关于我们链接的组件
import webAboutContact from '@/views/webAbout/webAboutContact'  //联系我们的组件
import webAboutService from '@/views/webAbout/webAboutService'  //联系客服

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
