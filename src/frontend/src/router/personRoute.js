
export default [
  {
    path: '/personPage',
    name: 'personPage',
    component: () => import('@/views/personView/personPage'),
    meta: {
      showTop: true,
      showFotter: true
    },
  },
  {
    path: '/personSecurity',
    name: 'personSecurity',
    component: () => import('@/views/personView/personSecurity'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true
    },
  },

  {
    path: '/myComment',
    name: 'myComment',
    component: () => import('@/views/personView/myComment'),  //我的提问,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true
    },
  },
  {
    path: '/teacherReply',
    name: 'teacherReply',
    component: () => import('@/views/personView/teacherReply'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true
    },
  },

  {
    path: '/thumbVideo',
    name: 'thumbVideo',
    component: () => import('@/views/personView/thumbVideo'),   //点赞视屏,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true
    },
  },
  {
    path: '/otherPerson/:userId?',
    name: 'otherPerson',
    component: () => import('@/views/personView/otherPerson'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: true,
      showFotter: false
    },
  }
]
