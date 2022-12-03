
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
    path: '/collectionVideo',
    name: 'collectionVideo',
    component: () => import('@/views/personView/collectionVideo'),   //点赞视屏,
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
  },
  {
    path: '/myDynamics',
    name: 'myDynamics',
    component: () => import('@/views/personView/myDynamics'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true
    },
  },
]
