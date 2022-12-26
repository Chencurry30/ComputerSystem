
export default [
  {
    path: '/personPage',
    name: 'personPage',
    component: () => import('@/views/personView/personPage'),
    meta: {
      showTop: true,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/personSecurity',
    name: 'personSecurity',
    component: () => import('@/views/personView/personSecurity'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },

  {
    path: '/myComment',
    name: 'myComment',
    component: () => import('@/views/personView/myComment'),  //我的提问,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/collectionVideo',
    name: 'collectionVideo',
    component: () => import('@/views/personView/collectionVideo'),   //点赞视屏,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/otherPerson/:userId?',
    name: 'otherPerson',
    component: () => import('@/views/personView/otherPerson'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: true,
      showFotter: false,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/myDynamics',
    name: 'myDynamics',
    component: () => import('@/views/personView/myDynamics'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  //用户聊天 
  {
    path: '/userChat',
    name: 'userChat',
    component: () => import('@/views/personView/userChat'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
  {
    path: '/userAddFriend',
    name: 'userAddFriend',
    component: () => import('@/views/personView/userAddFriend'),
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: false,
      showFotter: true,
      //跳转到404页面后是出现头部
      showNotFound:true,
    },
  },
]
