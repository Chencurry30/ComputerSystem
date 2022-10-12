import personPage from '@/views/personView/personPage';
import personInfo from '@/views/personView/personCenter/personInfo'
import personSecurity from '@/views/personView/personCenter/personSecurity'  //用户安全
import messageReply from '@/views/personView/personCenter/messageReply'     //我的评论
import commentsReply from '@/views/personView/personCenter/commentsReply'     //我的评论回复
import myComment from '@/views/personView/personCenter/myComment'     //我的提问
import teacherReply from '@/views/personView/personCenter/teacherReply'     //老师回复
import otherReply from '@/views/personView/personCenter/otherReply'     //其他回复
import thumbVideo from '@/views/personView/personCenter/thumbVideo'  //点赞视屏
import otherPerson from '@/views/personView/otherPerson';
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
          showTop: true,
          showFotter:true
        },
      },
      {
        path: 'personSecurity',
        name: 'personSecurity',
        component: personSecurity,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
          showFotter:true
        },
      },
      {
        path: 'messageReply',
        name: 'messageReply',
        component: messageReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
          showFotter:true
        },
      },
      {
        path: 'commentsReply',
        name: 'commentsReply',
        component: commentsReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
          showFotter:true
        },
      }, 
      {
        path: 'myComment',
        name: 'myComment',
        component: myComment,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
          showFotter:true
        },
      }, 
      {
        path: 'teacherReply',
        name: 'teacherReply',
        component: teacherReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
          showFotter:true
        },
      }, 
      {
        path: 'otherReply',
        name: 'otherReply',
        component: otherReply,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
          showFotter:true
        },
      },
      {
        path: 'thumbVideo',
        name: 'thumbVideo',
        component: thumbVideo,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTop: true,
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
