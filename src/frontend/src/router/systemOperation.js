import Home from '@/views/Home'
import loginView from '@/views/loginView'
import registerView from '@/views/registerView' //注册页面

export default [{
  path: '/',
  redirect: Home,
},
{
  path: '/Home',
  name: 'Home',
  component: Home,
  meta: {                          //配置相关的参数，保证页面是否展示头部和底部
    showTopFotter: true
  }
},
{
  path: '/loginView',
  name: 'loginView',
  component: loginView,
  meta: {
    showTopFotter: false
  }
},
{
  path: '/registerView',
  name: 'registerView',
  component: registerView,
  meta: {
    showTopFotter: false
  }
},
]