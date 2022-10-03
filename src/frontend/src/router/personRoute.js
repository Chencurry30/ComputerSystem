import personPage from '@/views/personView/personPage';
import personInfo from '@/views/personView/personCenter/personInfo'
import personSecurity from '@/views/personView/personCenter/personSecurity'
import messageReply from '@/views/personView/personCenter/messageReply'
export default [
  {
    path: '/personPage',
    name: 'personPage',
    component: personPage,
    meta: {                          //配置相关的参数，保证页面是否展示头部和底部
      showTopFotter: true
    },
    children:[
      {
        path:'personInfo',
        name:'personInfo',
        component:personInfo,
        meta: {                          //配置相关的参数，保证页面是否展示头部和底部
          showTopFotter: true
        },
      },
      {
        path:'personSecurity',
        name:'personSecurity',
        component:personSecurity,
        meta:{
          showTopFotter: true
        }
      },
      {
        path:'messageReply',
        name:'messageReply',
        component:messageReply,
        meta:{
          showTopFotter: true
        }
      }
    ],
    redirect:personInfo,           //使用户第一次次加载是弹出右边的子路由
  },
]
