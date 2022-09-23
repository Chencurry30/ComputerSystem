import Home from '@/views/Home'
import loginView from '@/views/loginView'
import registerView from '@/views/registerView' //注册页面
import webAboutIndex from '@/views/webAbout/webAboutIndex' //关于我们链接的组件
import webAboutContact from '@/views/webAbout/webAboutContact'  //联系我们的组件
import webAboutService from '@/views/webAbout/webAboutService'  //联系客服
const routes = [{
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
{
  path: '/webAboutIndex',
  name: 'webAboutIndex',
  component: webAboutIndex,
  meta: {
    showTopFotter: true
  }
},
{
  path: '/webAboutService',
  name: 'webAboutService',
  component: webAboutService,
  meta: {
    showTopFotter: true
  }
},
{
  path: '/webAboutContact',
  name: 'webAboutContact',
  component: webAboutContact,
  meta: {
    showTopFotter: true
  }
}
]
export default routes