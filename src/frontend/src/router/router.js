import Home from "@/views/Home";
import loginView from "@/views/loginView";
import webAboutIndex from '@/views/webAbout/webAboutIndex' //关于我们链接的组件
import webAboutContact from '@/views/webAbout/webAboutContact'  //联系我们的组件
import webAboutService from "@/views/webAbout/webAboutService";  //联系客服
const routes = [{
  path: '/',
  redirect: Home,
},
{
  path: '/Home',
  name: 'Home',
  component: Home
},
{
  path: '/loginView',
  name: 'loginView',
  component: loginView
},
{
  path: '/webAboutIndex',
  name: 'webAboutIndex',
  component: webAboutIndex
},
{
  path: '/webAboutService',
  name: 'webAboutService',
  component: webAboutService,
},
{
  path: '/webAboutContact',
  name: 'webAboutContact',
  component: webAboutContact,
}
]
export default routes