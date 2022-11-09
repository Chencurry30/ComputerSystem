const personPage = () => import('@/views/personView/personPage') //用户路由
const personInfo = () => import('@/views/personView/personCenter/personInfo')  //用户首页
const personSecurity = () => import('@/views/personView/personCenter/personSecurity') //用户安全
const messageReply = () => import('@/views/personView/personCenter/messageReply')  //我的评论
const commentsReply = () => import('@/views/personView/personCenter/commentsReply') // 我的评论回复
const myComment = () => import('@/views/personView/personCenter/myComment') //我的提问
const teacherReply = () => import('@/views/personView/personCenter/teacherReply') //老师回复
const otherReply = () => import('@/views/personView/personCenter/otherReply')   //其他回复
const thumbVideo = () => import('@/views/personView/personCenter/thumbVideo')  //点赞视屏
const otherPerson = () => import('@/views/personView/otherPerson')  //其他用户的个人信息

export default [
  {
    path: '/personPage',
    name: 'personPage',
    component: personPage,
    meta: {                          
      showTop: true,
      showFotter:true
    },
    children: [
      {
        path: 'personInfo',
        name: 'personInfo',
        component: personInfo,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      },
      {
        path: 'personSecurity',
        name: 'personSecurity',
        component: personSecurity,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      },
      {
        path: 'messageReply',
        name: 'messageReply',
        component: messageReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      },
      {
        path: 'commentsReply',
        name: 'commentsReply',
        component: commentsReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      }, 
      {
        path: 'myComment',
        name: 'myComment',
        component: myComment,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      }, 
      {
        path: 'teacherReply',
        name: 'teacherReply',
        component: teacherReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      }, 
      {
        path: 'otherReply',
        name: 'otherReply',
        component: otherReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      },
      {
        path: 'thumbVideo',
        name: 'thumbVideo',
        component: thumbVideo,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: false,
          showFotter:true
        },
      }
    ],
    redirect: personInfo,           //使用户第一次次加载是弹出右边的子路由
  },
  {
    path:'/otherPerson/:userId?',
    name:'otherPerson',
    component:otherPerson,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTop: true,
      showFotter:false
    },
  }
]
