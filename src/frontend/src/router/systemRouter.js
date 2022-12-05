import Home from '@/views/baseViews/Home'

const loginView = () => import('@/views/baseViews/loginView')       //登录页面
const registerView = () => import('@/views/baseViews/registerView')  //注册页面
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
  component: loginView,
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
  component: registerView,
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
