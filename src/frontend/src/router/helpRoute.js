//帮助中心的相关路由
export default [

  {
    path: '/helpCenter',
    name: 'helpCenter',
    component: () => import('@/views/helpView/helpCenter'),
    meta: {
      showTop: true,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound: true,
    },
  },
  {
    path: '/securityView',
    name: 'securityView',
    component: () => import('@/views/helpView/securityView'),
    meta: {
      showTop: true,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound: true,
    },
  },
  {
    path: '/uploadView',
    name: 'uploadView',
    component: () => import('@/views/helpView/uploadView'),
    meta: {
      showTop: true,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound: true,
    },
  },
  {
    path: '/userhelpView',
    name: 'userhelpView',
    component: () => import('@/views/helpView/userhelpView'),
    meta: {
      showTop: true,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound: true,
    },
  },
]