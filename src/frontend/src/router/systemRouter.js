import Home from '@/views/baseViews/Home'
export default [{
  path: '/',
  redirect: Home,
},
{
  path: '/Home',
  name: 'Home',
  component: Home,
  meta: {                          //配置相关的参数，保证页面是否展示头部和底部
    showTop: true,
    showFotter:true,
    //跳转到404页面后是出现头部
    showNotFound:true,
  },
},
{
  path: '/loginView',
  name: 'loginView',
  component: () => import('@/views/baseViews/loginView') ,
  meta: {
    showTop: false,
    showFotter:false,
    //跳转到404页面后是出现头部
    showNotFound:true,
  },
},
{
  path: '/registerView',
  name: 'registerView',
  component: () => import('@/views/baseViews/registerView') ,
  meta: {
    showTop: true,
    showFotter:true,
    //跳转到404页面后是出现头部
    showNotFound:true,
  },
},
  //通配匹配符跳转到404
  {
    path:'*',
    name:'notFound',
    component:()=>  import('@/views/baseViews/notFound.vue'),
    meta: {
      showTop: false,
      // showFotter:,
      //跳转到404页面后是出现头部
      showNotFound:false,
    },
  }
]
